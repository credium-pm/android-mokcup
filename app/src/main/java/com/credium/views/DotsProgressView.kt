package com.credium.views


import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class DotsProgressView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val MIN_RADIUS = 8f
        private const val MAX_RADIUS = 20f
        private const val DEFAULT_DURATION = 800L
    }

    private var currentRadius: Float = MIN_RADIUS

    private val scaleUpAnimation = ValueAnimator.ofFloat(MIN_RADIUS, MAX_RADIUS).apply {
        duration = DEFAULT_DURATION
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener { value ->
            currentRadius = value.animatedValue as Float
            if (currentRadius == MAX_RADIUS)
                scaleDown()
            else
                invalidate()
        }
    }

    private val scaleDownAnimation = ValueAnimator.ofFloat(MAX_RADIUS, MIN_RADIUS).apply {
        duration = DEFAULT_DURATION
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener { value ->
            currentRadius = value.animatedValue as Float
            if (currentRadius == MIN_RADIUS)
                scaleUp()
            invalidate()
        }
    }

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.parseColor("#A9B4C1")
    }

    init {
        scaleUpAnimation.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d(this::class.java.canonicalName, "Current radius: $currentRadius")
        val centerY = measuredHeight / 2f
        canvas?.drawCircle(measuredWidth / 3f, centerY, currentRadius, paint)
        canvas?.drawCircle(measuredWidth / 2f, centerY, currentRadius, paint)
        canvas?.drawCircle(measuredWidth - measuredWidth / 3f, centerY, currentRadius, paint)
    }

    private fun scaleDown() {
        scaleDownAnimation.start()
    }

    private fun scaleUp() {
        scaleUpAnimation.start()
    }
}

