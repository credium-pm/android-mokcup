package com.credium

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan
import com.credium.loans.LoansAdapter
import com.credium.util.bindView


class LoansFragment : Fragment() {

    // TODO: load from somewhere
    private val loans = listOf(
            Loan(DollarUsaCurrency, amount = 2000.0, months = 12, isLocked = false),
            Loan(DollarUsaCurrency, amount = 1000.0, months = 3, isLocked = false),
            Loan(DollarUsaCurrency, amount = 10000.0, months = 24, isLocked = true)
    )

    private val loanList by bindView<RecyclerView>(R.id.loanList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_loans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loanList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        loanList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        loanList.adapter = LoansAdapter(loans)
    }
}
