package com.keepcoding.flavorfeast.model

data class IngredientsUI(
    val id: String,
    val name: String,
    val description: String,
)

data class IngredientsRemote(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String?,
    val strType: String?,
)

fun IngredientsRemote.toUI(): IngredientsUI {
    return IngredientsUI(
        this.idIngredient,
        this.strIngredient,
        this.strDescription ?: ""
    )
}

fun List<IngredientsRemote>.toUI(): List<IngredientsUI> {
    return this.map { it.toUI() }
}