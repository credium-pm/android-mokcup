package com.credium.importloans

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.replaceFragment

class ImportingLoansFragment : Fragment() {

    private lateinit var viewModel: ImportLoansViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_importing_loans, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(ImportLoansViewModel::class.java)
        viewModel.importedLoansInfo.observe(this, Observer { info ->
            info?.let {
                replaceFragment(LoansImportedFragment())
            }
        })
        viewModel.startImportingLoans()
    }
}
