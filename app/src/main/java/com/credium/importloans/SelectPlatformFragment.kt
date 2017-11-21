package com.credium.importloans

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
import com.credium.util.*
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_select_platform.*


class SelectPlatformFragment : Fragment() {

    companion object {
        private const val RC_PERMISSION_CAMERA = 0
        private const val RC_CAMERA_RESULT = 1

        private const val TAKE_PICTURE = 1
        private const val USE_QR_READER = 2
    }

    private var barCodeReadApproach: Int = TAKE_PICTURE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_select_platform, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lendingClubButton.select()

        lendingClubButton.onClickListener = {
            prosperButton.clearSelection()
            avantButton.clearSelection()
            barCodeReadApproach = TAKE_PICTURE
        }

        prosperButton.onClickListener = {
            lendingClubButton.clearSelection()
            avantButton.clearSelection()
            barCodeReadApproach = USE_QR_READER
        }

        avantButton.onClickListener = {
            lendingClubButton.clearSelection()
            prosperButton.clearSelection()
            barCodeReadApproach = TAKE_PICTURE
        }

        backButton.setOnClickListener {
            goBack()
        }

        nextButton.setOnClickListener {
            val callOnGranted = if (barCodeReadApproach == TAKE_PICTURE)
                this::openCamera
            else
                this::openQrReader
            activity?.requestPermissionsIfNeeded(RC_PERMISSION_CAMERA, permissions = Manifest.permission.CAMERA,
                    onGranted = callOnGranted)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            RC_PERMISSION_CAMERA -> {
                val callOnGranted = if (barCodeReadApproach == TAKE_PICTURE)
                    this::openCamera
                else
                    this::openQrReader
                activity?.processPermissionResults(permissions, grantResults,
                        onGranted = callOnGranted,
                        onDenied = this::showPermissionError)
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (barCodeReadApproach == TAKE_PICTURE && requestCode == RC_CAMERA_RESULT && resultCode == Activity.RESULT_OK) {
            replaceFragment(ImportingLoansFragment(), addToBackStack = true)
        } else if (barCodeReadApproach == USE_QR_READER) {
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)?.let { result ->
                if (result.contents != null)
                    replaceFragment(ImportingLoansFragment(), addToBackStack = true)
            }
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openCamera() {
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), RC_CAMERA_RESULT)
    }

    private fun openQrReader() {
        IntentIntegrator.forSupportFragment(this).apply {
            setPrompt(getString(R.string.scan_barcode_prompt))
            setBarcodeImageEnabled(true)
            setOrientationLocked(true)
            setBeepEnabled(false)
            captureActivity = CaptureActivityPortrait::class.java
            initiateScan()
        }
    }

    private fun showPermissionError(isShowHint: Boolean) {
        activity?.showToast(R.string.enable_camera_permission)
    }
}
