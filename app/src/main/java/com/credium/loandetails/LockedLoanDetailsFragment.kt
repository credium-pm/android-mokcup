package com.credium.loandetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.*
import kotlinx.android.synthetic.main.fragment_locked_loan_details.*
import kotlinx.android.synthetic.main.layout_loan_details.*


class LockedLoanDetailsFragment : Fragment() {

    companion object {
        private const val ARG_LOAN_ID = "arg_loan_id"

        fun newInstance(loanId: Int): Fragment {
            return LockedLoanDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_LOAN_ID, loanId)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_locked_loan_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(R.string.loan)

        val viewModel = ViewModelProviders.of(activity!!).get(LoanDetailsViewModel::class.java)

        getInt(ARG_LOAN_ID)?.let { id ->
            viewModel.loadLoan(id)?.let { loan ->
                loanAmountTitleText.text = context?.loanAmountText(loan)
                val descriptionText = "${context?.loanPerMonthDescription(loan)}, ${context?.loanMonthsLeftDescription(loan)}"
                loanAmountDescriptionText.text = descriptionText
                loanStatusView.isLocked = loan.isLocked
            }
        }

    }
}
