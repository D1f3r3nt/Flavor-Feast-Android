package com.keepcoding.flavorfeast.model

data class SingleMealUI(
    val name: String,
    val image: String,
    val id: String,
)

data class SingleMealRemote(
    val strMeal: String,
    val strMealThumb: String,
    val idMeal: String,
)

fun SingleMealRemote.toUI(): SingleMealUI {
    return SingleMealUI(
        this.strMeal,
        this.strMealThumb,
        this.idMeal
    )
}

fun List<SingleMealRemote>.toUI(): List<SingleMealUI> {
    return this.map { it.toUI() }
}