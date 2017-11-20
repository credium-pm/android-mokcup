package com.credium.loans

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.debug


class LoanDetails : Fragment() {

    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_locked_loan_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loansViewModel = ViewModelProviders.of(activity!!).get(LoansViewModel::class.java)
        val loan = loansViewModel.selectedLoan
        debug("Selected loan: Loan(amount=${loan?.amount})")
    }
}
