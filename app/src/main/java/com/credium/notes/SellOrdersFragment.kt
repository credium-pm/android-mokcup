package com.credium.notes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.net.LoansService
import kotlinx.android.synthetic.main.fragment_notes_sell_orders.*


class SellOrdersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_notes_sell_orders, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sellOrdersNoteList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        sellOrdersNoteList.adapter = SellOrdersAdapter(LoansService.fetchSellOrderNotes())
    }
}
