package com.keepcoding.flavorfeast.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.flavorfeast.data.RepositoryInterface
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.enums.BadRequestException
import com.keepcoding.flavorfeast.model.enums.ErrorState
import com.keepcoding.flavorfeast.model.enums.IdleState
import com.keepcoding.flavorfeast.model.enums.LoadingState
import com.keepcoding.flavorfeast.model.enums.NoDataException
import com.keepcoding.flavorfeast.model.enums.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RepositoryInterface
) : ViewModel() {

    private val _randomState = MutableStateFlow<ViewState>(IdleState())
    private val _randomMeal = MutableStateFlow<MealUI?>(null)
    private val _categoriesState = MutableStateFlow<ViewState>(IdleState())
    private val _categories = MutableStateFlow<List<CategoryUI>>(emptyList())
    private val _areasState = MutableStateFlow<ViewState>(IdleState())
    private val _areas = MutableStateFlow<List<SingleAreaUI>>(emptyList())
    private val _ingredientsState = MutableStateFlow<ViewState>(IdleState())
    private val _ingredients = MutableStateFlow<List<IngredientsUI>>(emptyList())
    
    val randomState: StateFlow<ViewState> = _randomState
    val randomMeal: StateFlow<MealUI?> = _randomMeal
    val categoriesState: StateFlow<ViewState> = _categoriesState
    val categories: StateFlow<List<CategoryUI>> = _categories
    val areasState: StateFlow<ViewState> = _areasState
    val areas: StateFlow<List<SingleAreaUI>> = _areas
    val ingredientsState: StateFlow<ViewState> = _ingredientsState
    val ingredients: StateFlow<List<IngredientsUI>> = _ingredients
    
    init {
        getAllCategories()
        getAllAreas()
    }
    
    fun getRandomMeal() {
        viewModelScope.launch { 
            _randomState.value = LoadingState()
            
            val result = repository.getRandomMeal()
            
            try {
                val meal: MealUI = result.getOrThrow()

                _randomMeal.value = meal
                _randomState.value = IdleState()
            } catch (_: BadRequestException) {
                _randomState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _randomState.value = ErrorState("No data in the response")
            } catch (_ : Exception) {
                _randomState.value = ErrorState("Something went wrong")
            }
            
        }
    }

    fun getAllCategories() {
        viewModelScope.launch {
            _categoriesState.value = LoadingState()

            val result = repository.getAllCategories()

            try {
                val categories: List<CategoryUI> = result.getOrThrow()

                _categories.value = categories
                _categoriesState.value = IdleState()
            } catch (_: BadRequestException) {
                _categoriesState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _categoriesState.value = ErrorState("No data in the response")
            } catch (_ : Exception) {
                _categoriesState.value = ErrorState("Something went wrong")
            }

        }
    }

    fun getAllAreas() {
        viewModelScope.launch {
            _areasState.value = LoadingState()

            val result = repository.getAllAreas()

            try {
                val areas: List<SingleAreaUI> = result.getOrThrow()

                _areas.value = areas
                _areasState.value = IdleState()
            } catch (_: BadRequestException) {
                _areasState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _areasState.value = ErrorState("No data in the response")
            } catch (_ : Exception) {
                _areasState.value = ErrorState("Something went wrong")
            }
            
        }
    }

    fun getAllIngredients() {
        viewModelScope.launch {
            _ingredientsState.value = LoadingState()

            val result = repository.getAllIngredients()

            try {
                val ingredients: List<IngredientsUI> = result.getOrThrow()

                _ingredients.value = ingredients
                _ingredientsState.value = IdleState()
            } catch (_: BadRequestException) {
                _ingredientsState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _ingredientsState.value = ErrorState("No data in the response")
            } catch (_ : Exception) {
                _ingredientsState.value = ErrorState("Something went wrong")
            }
            
        }
    }
}