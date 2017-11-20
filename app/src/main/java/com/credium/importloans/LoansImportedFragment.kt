package com.credium.importloans

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.getInt
import com.credium.util.show
import kotlinx.android.synthetic.main.fragment_imported_loans_info.*


class LoansImportedFragment : Fragment() {

    private lateinit var viewModel: ImportLoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_imported_loans_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(ImportLoansViewModel::class.java)

        val loansInfo = viewModel.importedLoansInfo.value!!

        numberImportedLoansText.text = getString(R.string.loans_imported_template, loansInfo.loanCount.toString())
        totalAmountText.text = getString(R.string.loans_imported_total_value_template, loansInfo.totalAmount.toString(), loansInfo.currency)

        animateText()

        backButton.setOnClickListener {
            viewModel.clearLoans()
            activity?.onBackPressed()
        }
        doneButton.setOnClickListener {
            viewModel.saveLoans()
            activity?.apply {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    private fun animateText() {
        numberImportedLoansText.animate().alpha(1f).apply {
            duration = 600
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    numberImportedLoansText.show()
                }
            })
        }
        totalAmountText.animate().alpha(1f).apply {
            startDelay = 600
            duration = 600
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    totalAmountText.show()
                }
            })
        }

    }
}