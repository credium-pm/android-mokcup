package com.credium.loans

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.credium.R
import com.credium.data.Loan
import com.credium.data.UnlockedLoan
import com.credium.util.bindView
import com.credium.util.loanMonthsLeftDescription
import com.credium.util.loanPerMonthDescription


class LoansAdapter(
        private val loans: List<Loan>,
        val onClickListener: OnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOCKED = 0
        const val UNLOCKED = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (loans[position].isLocked)
            UNLOCKED
        else
            LOCKED
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return LoanViewHolder(itemView = inflater.inflate(R.layout.item_loan, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? LoanViewHolder)?.bind(loans[position])
    }

    override fun getItemCount(): Int = loans.size

    inner class LoanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconImage by bindView<ImageView>(R.id.iconImage)
        private val titleText by bindView<TextView>(R.id.titleText)
        private val text1 by bindView<TextView>(R.id.text1)
        private val text2 by bindView<TextView>(R.id.text2)
        private val text3 by bindView<TextView>(R.id.text3)

        init {
            itemView.setOnClickListener {
                onClickListener.onClick(loans[adapterPosition])
            }
        }

        fun bind(loan: Loan) {
            val context = titleText.context
            val drawableResource = if (loan.isLocked) R.drawable.ic_circle_locked else R.drawable.ic_circle_unlocked
            val stringResource = if (loan.isLocked) R.string.locked_loan_template_title else R.string.amount_and_currency_template

            iconImage.setImageDrawable(ContextCompat.getDrawable(context, drawableResource))
            titleText.text = context.getString(stringResource, loan.amount.toString(), loan.currency.label)
            text1.text = context.loanPerMonthDescription(loan)
            text2.text = context.loanMonthsLeftDescription(loan)
            if (loan is UnlockedLoan) {
                // TODO: set colors
                text3.text = context.resources.getString(
                        R.string.loan_pending,
                        loan.pendingAmount.toString(),
                        loan.currency.label,
                        loan.sellFor.toString(),
                        loan.currency.label
                )
            }
        }
    }

    interface OnClickListener {
        fun onClick(loan: Loan)
    }
}