package com.credium.wizard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.credium.util.replaceFragment


class ImportLoansWizardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            replaceFragment(SelectPlatformFragment(), id = android.R.id.content)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
