package com.keepcoding.flavorfeast.model

data class CategoryUI(
    val id: String,
    val name: String,
    val image: String,
    val description: String,
)

data class CategoryRemote(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

fun CategoryRemote.toUI(): CategoryUI {
    return CategoryUI(
        this.idCategory,
        this.strCategory,
        this.strCategoryThumb,
        this.strCategoryDescription
    )
}

fun List<CategoryRemote>.toUI(): List<CategoryUI> {
    return this.map { it.toUI() }
}