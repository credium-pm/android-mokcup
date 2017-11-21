package com.credium.loandetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.getInt
import com.credium.util.loanAmountText
import kotlinx.android.synthetic.main.fragment_unlocked_loan.*


class UnlockedLoanFragment : Fragment() {

    companion object {
        private const val ARG_LOAN_ID = "arg_loan_id"

        fun newInstance(loanId: Int): UnlockedLoanFragment {
            return UnlockedLoanFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_LOAN_ID, loanId)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_unlocked_loan, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(activity!!).get(LoanDetailsViewModel::class.java)

        getInt(UnlockedLoanFragment.ARG_LOAN_ID)?.let { id ->
            viewModel.loadLoan(id)?.let { loan ->
                amountText.text = context?.loanAmountText(loan)
            }
        }

        submitButton.setOnClickListener {
            viewModel.sellNoteForSelected(600, 450)
            activity?.finish()
        }
    }
}
