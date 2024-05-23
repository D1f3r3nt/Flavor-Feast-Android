package com.keepcoding.flavorfeast.utils

fun String.firstUpperCase(): String {
    return this.replaceFirstChar { 
        it.uppercase()
    }
}

fun String.formatWithSortCuts(): String {
    return this.replace("\t", "    ")
        .replace("\r", "\n")
}