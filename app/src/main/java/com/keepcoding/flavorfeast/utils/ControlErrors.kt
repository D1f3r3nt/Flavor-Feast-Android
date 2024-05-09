package com.keepcoding.flavorfeast.utils

import android.content.Context
import android.widget.Toast
import com.keepcoding.flavorfeast.model.enums.ErrorState
import com.keepcoding.flavorfeast.model.enums.ViewState

fun controlErrors(context: Context, vararg states: ViewState) {
    
    states.forEach { 
        if (it is ErrorState) {
            Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
        }
    }
    
}