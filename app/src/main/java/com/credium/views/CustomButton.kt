package com.credium.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.credium.R


class CustomButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr), View.OnClickListener {

    private val contentFrame: FrameLayout
    private val resetColor: Int
    var onClickListener : () -> Unit = {}

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0)
        val iconImageResource = a.getResourceId(R.styleable.AppCompatImageView_android_src, 0)
        a.recycle()
        inflate(context, R.layout.view_custom_button, this)
        findViewById<ImageView>(R.id.iconImage).apply {
            setImageResource(iconImageResource)
        }
        contentFrame = findViewById(R.id.contentFrame)
        resetColor = ContextCompat.getColor(context, android.R.color.white)
        findViewById<CardView>(R.id.customButton).apply {
            setOnClickListener(this@CustomButton)
        }
    }

    fun select() {
        contentFrame.setBackgroundResource(R.drawable.shape_blue_border)
    }

    fun clearSelection() {
        contentFrame.setBackgroundColor(resetColor)
    }

    override fun onClick(view: View?) {
        select()
        onClickListener()
    }
}
