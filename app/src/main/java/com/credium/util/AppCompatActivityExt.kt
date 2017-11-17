package com.credium.util

import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.replaceFragment(id: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .commit()
}

fun AppCompatActivity.setActionBarDrawable(drawable: Int) {
    supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable))
}
