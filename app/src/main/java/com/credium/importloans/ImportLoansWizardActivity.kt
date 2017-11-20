package com.credium.importloans

import android.os.Bundle
import com.credium.BaseSubActivity
import com.credium.util.replaceFragment


class ImportLoansWizardActivity : BaseSubActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            replaceFragment(SelectPlatformFragment(), animateReplace = false)
        }
    }
}
