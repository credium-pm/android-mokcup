package com.credium.loandetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.credium.R
import com.credium.util.debug
import com.credium.util.getInt
import com.credium.util.loanAmountText
import kotlinx.android.synthetic.main.fragment_sell_note.*


class SellNoteFragment : Fragment() {

    companion object {
        private const val ARG_LOAN_ID = "arg_loan_id"

        fun newInstance(loanId: Int): SellNoteFragment {
            return SellNoteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_LOAN_ID, loanId)
                }
            }
        }
    }

    private var currentAmount: Int = 0
    private var currentDiscount: Int = 0
    private var currentCash: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sell_note, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        amountSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val correctProgress = if (progress == 0) 1 else progress
                sellAmountText.text = correctProgress.toString()
                currentAmount = correctProgress
                if (fromUser)
                    updateFromAmountSeekBar()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })
        discountSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                discountCashView.discountText = "$progress%"
                currentDiscount = progress
                if (fromUser)
                    updateFromAmountSeekBar()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })

        val viewModel = ViewModelProviders.of(activity!!).get(LoanDetailsViewModel::class.java)

        getInt(SellNoteFragment.ARG_LOAN_ID)?.let { id ->
            viewModel.loadLoan(id)?.let { loan ->
                amountText.text = context?.loanAmountText(loan)
                amountSeekBar.apply {
                    max = loan.amount
                    progress = loan.amount / 4
                }
                discountSeekBar.apply {
                    max = 100
                    progress = 25
                }
                currentAmount = loan.amount / 4
                currentDiscount = 25
                updateFromAmountSeekBar()
            }
        }

        submitButton.setOnClickListener {
            viewModel.sellNoteForSelected(currentAmount, currentCash)
            activity?.finish()
        }
    }

    private fun updateFromAmountSeekBar() {
        currentCash = (currentAmount - (currentAmount / 100f * currentDiscount)).toInt()
        debug("*********************************************")
        debug("Amount = $currentAmount Discount = $currentDiscount Cash = $currentCash")
        debug("*********************************************")
        discountCashView.cashText = "$$currentCash"
        val percentage = "${(currentDiscount / 100f * 80 + 20).toInt()}%"
        percentageText.text = percentage
    }
}
