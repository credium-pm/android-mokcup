package com.credium.util

import android.support.v4.app.Fragment


var Fragment.title: String
    get() = activity?.title?.toString() ?: ""
    set(value) {
        activity?.title = value
    }

fun Fragment.setTitle(stringRes: Int) {
    activity?.title = context?.getString(stringRes)
}

fun Fragment.getInt(name: String): Int? = arguments?.getInt(name)

fun Fragment.replaceFragment(fragment: Fragment,
                             id: Int = android.R.id.content,
                             addToBackStack: Boolean = false,
                             animateReplace: Boolean = true) {
    activity?.replaceFragment(fragment, id, addToBackStack, animateReplace)
}

fun Fragment.goBack() {
    activity?.onBackPressed()
}
