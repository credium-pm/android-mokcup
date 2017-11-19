package com.credium.util

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.credium.R


fun AppCompatActivity.replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean = false) {
    val transaction = supportFragmentManager.beginTransaction()
            .replace(id, fragment)
    if (addToBackStack)
        transaction.addToBackStack(null)
    transaction.commit()
}

fun Activity.replaceFragment(fragment: Fragment, id: Int = R.id.containerFrame, addToBackStack: Boolean = false) {
    (this as? AppCompatActivity)?.replaceFragment(id, fragment, addToBackStack)
}

fun AppCompatActivity.setActionBarDrawable(drawable: Int) {
    supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable))
}

fun Activity.showToast(textResId: Int) {
    Toast.makeText(this, textResId, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(textResId: Int, vararg formatArgs: String) {
    val text = getString(textResId, *formatArgs)
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
