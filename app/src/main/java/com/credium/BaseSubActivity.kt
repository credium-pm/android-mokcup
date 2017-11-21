package com.credium

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.credium.util.showHomeUpNavigation


open class BaseSubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHomeUpNavigation()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}