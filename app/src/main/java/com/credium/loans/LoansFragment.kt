package com.credium.loans

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.data.Loan
import com.credium.util.hide
import com.credium.util.replaceFragment
import com.credium.util.show
import com.credium.wizard.ImportLoansWizardActivity
import kotlinx.android.synthetic.main.fragment_loans.*


class LoansFragment : Fragment() {

    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_loans, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loansViewModel = ViewModelProviders.of(activity!!).get(LoansViewModel::class.java)

        fab.setOnClickListener {
            startActivity(Intent(this@LoansFragment.context, ImportLoansWizardActivity::class.java))
        }
        loanList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        if (loansViewModel.loans.isEmpty())
            noDataText.show()
        else {
            noDataText.hide()
            loanList.adapter = LoansAdapter(loansViewModel.loans, object : LoansAdapter.OnClickListener {
                override fun onClick(loan: Loan) {
                    loansViewModel.selectedLoan = loan
                    activity?.replaceFragment(LoanDetails(), addToBackStack = true)
                }
            })
        }
    }
}
