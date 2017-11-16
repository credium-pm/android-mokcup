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
import com.credium.util.bindView


class LoansAdapter(private val loans: List<Loan>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        private val subText1 by bindView<TextView>(R.id.subText1)
        private val subText2 by bindView<TextView>(R.id.subText2)

        fun bind(loan: Loan) {
            // TODO: display loan
            val context = titleText.context
            val (iconRes, colorRes) = if (loan.isLocked)
                R.drawable.ic_circle_locked to R.color.lockedColor
            else
                R.drawable.is_circle_unlocked to R.color.unlockedColor
            iconImage.setImageDrawable(ContextCompat.getDrawable(context, iconRes))
            titleText.apply {
                text = "1000 USD"
                setTextColor(ContextCompat.getColor(context, colorRes))
            }
            subText1.text = "50 USD per month"
            subText2.text = "20 months left"
        }
    }
}