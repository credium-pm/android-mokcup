package com.credium.loandetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.goBack
import kotlinx.android.synthetic.main.fragment_unlock_loan.*


class UnlockLoanFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_unlock_loan, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButton.setOnClickListener {
            goBack()
        }
    }
}