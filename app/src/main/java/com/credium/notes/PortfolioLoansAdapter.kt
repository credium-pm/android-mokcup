package com.credium.notes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.credium.R
import com.credium.data.Note
import com.credium.util.loanAmountText
import com.credium.util.loanMonthsLeftDescription
import com.credium.util.loanPerMonthDescription
import com.credium.views.RiskInfoView


class PortfolioLoansAdapter(
        private val unlockedLoans: List<Note>
) : RecyclerView.Adapter<PortfolioLoansAdapter.PortfolioLoanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PortfolioLoanViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_dashboard_portfolio_loan, parent, false)
        return PortfolioLoanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioLoanViewHolder?, position: Int) {
        holder?.bind(unlockedLoans[position])
    }

    override fun getItemCount(): Int = unlockedLoans.size

    inner class PortfolioLoanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val amountText = itemView.findViewById<TextView>(R.id.amountText)
        private val perMonthText = itemView.findViewById<TextView>(R.id.amountPerMonthText)
        private val monthsLeftText = itemView.findViewById<TextView>(R.id.monthsLeftText)
        private val riskInfoView = itemView.findViewById<RiskInfoView>(R.id.riskInfoView)

        fun bind(note: Note) {
            val context = itemView.context
            amountText.text = context.loanAmountText(note.loan)
            perMonthText.text = context.loanPerMonthDescription(note.loan)
            monthsLeftText.text = context.loanMonthsLeftDescription(note.loan)
            riskInfoView.apr = note.apr
            riskInfoView.riskScorePercentage = note.riskPercentage
            riskInfoView.score = note.riskScore
        }
    }
}
