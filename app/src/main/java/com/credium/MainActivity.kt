package com.credium

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.credium.loans.LoansFragment
import com.credium.settings.SettingsActivity
import com.credium.util.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.navSettings)
                startActivity(Intent(this, SettingsActivity::class.java))
            else {
                val (fragment, titleStringResource) = when (item.itemId) {
                    R.id.navDashboard -> Fragment() to R.string.dashboard
                    R.id.navPortfolio -> Fragment() to R.string.portfolio
                    R.id.navMarket -> Fragment() to R.string.market
                    R.id.navLoans -> LoansFragment() to R.string.loans
                    else -> throw RuntimeException("No handler for item id: ${item.itemId}")
                }
                replaceFragment(R.id.containerFrame, fragment)
                this.title = getString(titleStringResource)
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            true
        }
        navigationView.menu.performIdentifierAction(R.id.navLoans, 0)
        navigationView.setCheckedItem(R.id.navLoans)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}
