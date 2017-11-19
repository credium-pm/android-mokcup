package com.credium.wizard

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.show
import kotlinx.android.synthetic.main.fragment_imported_loans_info.*


class LoansImportedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_imported_loans_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateText()

        backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        doneButton.setOnClickListener {
            activity?.apply {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    private fun animateText() {
        numberImportedLoansText.animate().alpha(1f).apply {
            duration = 600
            setListener(object: AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    numberImportedLoansText.show()
                }
            })
        }
        totalAmountText.animate().alpha(1f).apply {
            startDelay = 600
            duration = 600
            setListener(object: AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    totalAmountText.show()
                }
            })
        }

    }
}