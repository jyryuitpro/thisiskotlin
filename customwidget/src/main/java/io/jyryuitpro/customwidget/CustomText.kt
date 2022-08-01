package io.jyryuitpro.customwidget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomText : AppCompatTextView {

    constructor(context: Context) : super(context) { }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val attrList = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
        val size = attrList.indexCount

        for (i in 0 until size) {
            val attr = attrList.getIndex(i)

            when(attr) {
                R.styleable.CustomText_delimeter -> {
                    attrList.getString(attr)?.let {
                        process(it)
                    }
                }
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { }

    fun process(DL: String) {
        if (text.length == 8) {
            val first4 = text.substring(0, 4)
            val mid2 = text.substring(4, 6)
            val last2 = text.substring(6)

//            text = "$first4$delimeter$mid2$delimeter$last2$delimeter"
            text = first4 + DL + mid2 + DL + last2
        }
    }
}