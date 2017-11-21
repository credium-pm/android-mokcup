package com.credium.loandetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.credium.R
import com.credium.util.*
import kotlinx.android.synthetic.main.fragment_unlock_loan.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


class UnlockLoanFragment : Fragment() {

    private var job: Job? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_unlock_loan, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(activity!!).get(LoanDetailsViewModel::class.java)

        val riskModels = listOf("Default risk model")
        riskSpinner.adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_list_item_1, riskModels)
        calculateRiskButton.setOnClickListener {
            job = launch(UI) {
                calculateRiskProgress.show()
                unlockButton.disable()

                delay(2500)

                calculateRiskProgress.hide()
                riskPercentageText.show()
                unlockButton.enable()
            }
        }
        backButton.setOnClickListener {
            goBack()
        }
        unlockButton.setOnClickListener {
            //replaceFragment(SellNotesFragment())
            viewModel.unlockSelected()
            activity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}
