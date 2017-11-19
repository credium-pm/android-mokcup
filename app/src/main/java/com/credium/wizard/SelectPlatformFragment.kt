package com.credium.wizard

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.credium.util.processPermissionResults
import com.credium.util.replaceFragment
import com.credium.util.requestPermissionsIfNeeded
import com.credium.util.showToast
import kotlinx.android.synthetic.main.fragment_select_platform.*


class SelectPlatformFragment : Fragment() {

    companion object {
        private const val RC_PERMISSION_CAMERA = 0
        private const val RC_CAMERA_RESULT = 1
    }

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

        nextButton.setOnClickListener {
            activity?.requestPermissionsIfNeeded(RC_PERMISSION_CAMERA, permissions = Manifest.permission.CAMERA,
                    onGranted = this::openCamera)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            RC_PERMISSION_CAMERA -> {
                activity?.processPermissionResults(permissions, grantResults,
                        onGranted = this::openCamera,
                        onDenied = this::showPermissionError)
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_CAMERA_RESULT && resultCode == Activity.RESULT_OK) {
            activity?.replaceFragment(ImportingLoansFragment(), id = android.R.id.content, addToBackStack = true)
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openCamera() {
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), RC_CAMERA_RESULT)
    }

    private fun showPermissionError(isShowHint: Boolean) {
        activity?.showToast(R.string.enable_camera_permission)
    }
}
