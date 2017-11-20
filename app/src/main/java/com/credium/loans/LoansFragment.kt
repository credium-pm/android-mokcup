package com.credium.loans

import android.app.Activity
import android.arch.lifecycle.Observer
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
import com.credium.importloans.ImportLoansWizardActivity
import com.credium.loandetails.LoanDetailsActivity
import com.credium.util.hide
import com.credium.util.show
import kotlinx.android.synthetic.main.fragment_loans.*


class LoansFragment : Fragment() {

    companion object {
        const val RC_IMPORT_LOANS = 0
    }

    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_loans, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fab.setOnClickListener {
            startActivityForResult(Intent(this@LoansFragment.context, ImportLoansWizardActivity::class.java), RC_IMPORT_LOANS)
        }
        loanList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        loansViewModel = ViewModelProviders.of(activity!!).get(LoansViewModel::class.java)
        loansViewModel.loansLiveData.observe(this, Observer {
            showLoans()
        })

        if (loansViewModel.loans.isEmpty())
            noDataText.show()
        else
            showLoans()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_IMPORT_LOANS && resultCode == Activity.RESULT_OK)
            loansViewModel.loadLoans()
        else
            super.onActivityResult(requestCode, resultCode, data)
    }

    private fun showLoans() {
        noDataText.hide()
        loanList.adapter = LoansAdapter(loansViewModel.loans, object : LoansAdapter.OnClickListener {
            override fun onClick(loan: Loan) {
                LoanDetailsActivity.start(context!!, loan.id)
            }
        })
    }
}
