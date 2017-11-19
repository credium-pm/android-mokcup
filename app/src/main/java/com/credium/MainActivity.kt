package com.credium

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.credium.loans.LoansFragment
import com.credium.loans.LoansViewModel
import com.credium.settings.SettingsActivity
import com.credium.util.replaceFragment
import com.credium.util.setActionBarDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var loansViewModel: LoansViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loansViewModel = ViewModelProviders.of(this).get(LoansViewModel::class.java)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setActionBarDrawable(R.drawable.bg_blue_gradient)

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
