package com.keepcoding.flavorfeast.utils

fun String.firstUpperCase(): String {
    return this.replaceFirstChar { 
        it.uppercase()
    }
}