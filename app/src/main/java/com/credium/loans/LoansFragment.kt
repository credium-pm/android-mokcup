package com.credium.loans

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.data.Loan
import com.credium.util.replaceFragment


class LoansFragment : Fragment() {

    private lateinit var loanList: RecyclerView
    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_loans, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loanList = view.findViewById(R.id.loanList)
        loansViewModel = ViewModelProviders.of(activity!!).get(LoansViewModel::class.java)
        loanList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        loanList.adapter = LoansAdapter(loansViewModel.loans, object : LoansAdapter.OnClickListener {
            override fun onClick(loan: Loan) {
                loansViewModel.selectedLoan = loan
                activity?.replaceFragment(R.id.containerFrame, LoanDetails(), addToBackStack = true)
            }
        })
    }
}
