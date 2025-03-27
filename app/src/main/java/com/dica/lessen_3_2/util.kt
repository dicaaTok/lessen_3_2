package com.dica.lessen_3_2

import android.app.Dialog
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout

fun Dialog.setupDialog(layoutResId: Int ){
    setContentView(layoutResId)
    window!!.setLayout(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    setCancelable(false)
}