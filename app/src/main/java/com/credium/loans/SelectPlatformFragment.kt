package com.credium.loans

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import kotlinx.android.synthetic.main.fragment_select_platform.*


class SelectPlatformFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_select_platform, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lendingClubButton.select()

        lendingClubButton.onClickListener = {
            prosperButton.clearSelection()
            avantButton.clearSelection()
        }

        prosperButton.onClickListener = {
            lendingClubButton.clearSelection()
            avantButton.clearSelection()
        }

        avantButton.onClickListener = {
            lendingClubButton.clearSelection()
            prosperButton.clearSelection()
        }

        backButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}
