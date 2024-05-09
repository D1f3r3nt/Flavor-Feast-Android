package com.keepcoding.flavorfeast.model

data class SingleAreaUI(
    val area: String
)

data class SingleAreaRemote(
    val strArea: String
)

fun SingleAreaRemote.toUI(): SingleAreaUI {
    return SingleAreaUI(this.strArea)
}

fun List<SingleAreaRemote>.toUI(): List<SingleAreaUI> {
    return this.map { it.toUI() }
}