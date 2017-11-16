package com.credium.loans

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.bindView


class LoansFragment : Fragment() {

    private val loanList by bindView<RecyclerView>(R.id.loanList)
    private lateinit var loansViewModel: LoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_loans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loansViewModel = ViewModelProviders.of(this).get(LoansViewModel::class.java)
        loanList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        loanList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        loansViewModel.loansLiveData.observe(this, Observer { loans ->
            loans?.let {
                loanList.adapter = LoansAdapter(loans)
            }
        })
        loansViewModel.onReady()
    }
}
