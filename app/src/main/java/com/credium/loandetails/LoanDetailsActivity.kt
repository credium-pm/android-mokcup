package com.credium.loandetails

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.credium.BaseSubActivity
import com.credium.util.replaceFragment


class LoanDetailsActivity : BaseSubActivity() {

    companion object {
        private const val EXTRA_LOAN_ID = "extra_loan_id"

        fun start(context: Context, loanId: Int) {
            val intent = Intent(context, LoanDetailsActivity::class.java).apply {
                putExtra(EXTRA_LOAN_ID, loanId)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(LoanDetailsViewModel::class.java)

        if (savedInstanceState == null) {
            val selectedLoanId = intent.extras.getInt(EXTRA_LOAN_ID)
            viewModel.loadLoan(selectedLoanId)?.let { loan ->
                if (loan.isLocked)
                    replaceFragment(LockedLoanDetailsFragment.newInstance(loan.id), animateReplace = false)
                else
                    replaceFragment(UnlockedLoanFragment.newInstance(loan.id), animateReplace = false)
            }
        }
    }
}
