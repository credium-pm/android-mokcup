package com.credium

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.credium.dashboard.DashboardFragment
import com.credium.loans.LoansFragment
import com.credium.notes.NotesFragment
import com.credium.settings.SettingsActivity
import com.credium.util.gone
import com.credium.util.replaceFragment
import com.credium.util.show
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
                if (item.itemId in listOf(R.id.navNotes, R.id.navDashboard)) tabs.show() else tabs.gone()

                val (fragment, titleStringResource) = when (item.itemId) {
                    R.id.navDashboard -> DashboardFragment() to R.string.dashboard
                    R.id.navNotes -> NotesFragment() to R.string.notes
                    R.id.navLoans -> LoansFragment() to R.string.loans
                    R.id.navResetMockup -> return@setNavigationItemSelectedListener true
                    else -> throw RuntimeException("No handler for item id: ${item.itemId}")
                }
                replaceFragment(fragment, R.id.containerFrame)
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
