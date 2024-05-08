package com.keepcoding.flavorfeast.model

data class MealUI(
    val id: String,
    val name: String,
    val instructions: String,
    val category: String,
    val area: String,
    val image: String,
    val tags: List<String>,
    val video: String,
    val elements: List<ComponentUI>,
    val source: String,
)

data class ComponentUI(
    val ingredient: String,
    val measure: String,
)

data class MealRemote(
    val idMeal: String,
    val strMeal: String,
    val strDrinkAlternate: String?,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String?,
    val strYoutube: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient16: String?,
    val strIngredient17: String?,
    val strIngredient18: String?,
    val strIngredient19: String?,
    val strIngredient20: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure16: String?,
    val strMeasure17: String?,
    val strMeasure18: String?,
    val strMeasure19: String?,
    val strMeasure20: String?,
    val strSource: String,
    val strImageSource: String?,
    val strCreativeCommonsConfirmed: String?,
    val dateModified: String?,
)

fun MealRemote.toUI(): MealUI {
    
    val tags: MutableList<String> = mutableListOf()
    strTags?.let { 
        it.split(",").forEach { tag ->
            tags.add(tag)
        }
    } 
    
    val elements: List<ComponentUI> = listOf(
        ComponentUI(this.strIngredient1 ?: "", this.strMeasure1 ?: ""),
        ComponentUI(this.strIngredient2 ?: "", this.strMeasure2 ?: ""),
        ComponentUI(this.strIngredient3 ?: "", this.strMeasure3 ?: ""),
        ComponentUI(this.strIngredient4 ?: "", this.strMeasure4 ?: ""),
        ComponentUI(this.strIngredient5 ?: "", this.strMeasure5 ?: ""),
        ComponentUI(this.strIngredient6 ?: "", this.strMeasure6 ?: ""),
        ComponentUI(this.strIngredient7 ?: "", this.strMeasure7 ?: ""),
        ComponentUI(this.strIngredient8 ?: "", this.strMeasure8 ?: ""),
        ComponentUI(this.strIngredient9 ?: "", this.strMeasure9 ?: ""),
        ComponentUI(this.strIngredient10 ?: "", this.strMeasure10 ?: ""),
        ComponentUI(this.strIngredient11 ?: "", this.strMeasure11 ?: ""),
        ComponentUI(this.strIngredient12 ?: "", this.strMeasure12 ?: ""),
        ComponentUI(this.strIngredient13 ?: "", this.strMeasure13 ?: ""),
        ComponentUI(this.strIngredient14 ?: "", this.strMeasure14 ?: ""),
        ComponentUI(this.strIngredient15 ?: "", this.strMeasure15 ?: ""),
        ComponentUI(this.strIngredient16 ?: "", this.strMeasure16 ?: ""),
        ComponentUI(this.strIngredient17 ?: "", this.strMeasure17 ?: ""),
        ComponentUI(this.strIngredient18 ?: "", this.strMeasure18 ?: ""),
        ComponentUI(this.strIngredient19 ?: "", this.strMeasure19 ?: ""),
        ComponentUI(this.strIngredient20 ?: "", this.strMeasure20 ?: ""),
    )
    
    return MealUI(
        this.idMeal,
        this.strMeal,
        this.strInstructions,
        this.strCategory,
        this.strArea,
        this.strMealThumb,
        tags,
        this.strYoutube,
        elements,
        this.strSource
    )
}
