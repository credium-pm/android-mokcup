package com.credium.notes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.data.UnlockedLoan
import com.credium.views.NoteItemView


class SellOrdersAdapter(
        private val unlockedLoans: List<UnlockedLoan>
) : RecyclerView.Adapter<SellOrdersAdapter.SellOrdersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SellOrdersViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_note_sell_orders, parent, false)
        return SellOrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: SellOrdersViewHolder?, position: Int) {
        holder?.bind(unlockedLoans[position])
    }

    override fun getItemCount(): Int = unlockedLoans.size

    inner class SellOrdersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(loan: UnlockedLoan) {
            (itemView as? NoteItemView)?.let {
                it.loan = loan
                it.bottomValue1 = "${loan.currency.symbol}${loan.sellFor}"
                it.bottomValue2 = "${loan.discount}%"
                it.bottomValue3 = "${loan.daysOnMarket}"
            }
        }
    }
}
