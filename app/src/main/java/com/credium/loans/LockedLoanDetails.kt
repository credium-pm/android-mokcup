package com.credium.loans

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.loanAmountText
import com.credium.util.loanMonthsLeftDescription
import com.credium.util.loanPerMonthDescription
import kotlinx.android.synthetic.main.fragment_locked_loan_details.*


class LockedLoanDetails : Fragment() {

    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_locked_loan_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loansViewModel = ViewModelProviders.of(activity!!).get(LoansViewModel::class.java)
        loansViewModel.selectedLoan?.let { loan ->
            loanAmountTitleText.text = context?.loanAmountText(loan)
            val descriptionText = "${context?.loanPerMonthDescription(loan)}, ${context?.loanMonthsLeftDescription(loan)}"
            loanAmountDescriptionText.text = descriptionText
        }
    }
}
