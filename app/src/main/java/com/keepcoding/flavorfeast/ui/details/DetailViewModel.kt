package com.keepcoding.flavorfeast.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.flavorfeast.data.RepositoryInterface
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.enums.BadRequestException
import com.keepcoding.flavorfeast.model.enums.ErrorState
import com.keepcoding.flavorfeast.model.enums.IdleState
import com.keepcoding.flavorfeast.model.enums.NoDataException
import com.keepcoding.flavorfeast.model.enums.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: RepositoryInterface
) : ViewModel() {

    private val _idMeal = MutableStateFlow<String?>(null)
    private val _meal = MutableStateFlow<MealUI?>(null)
    private val _mealState = MutableStateFlow<ViewState>(IdleState())

    val idMeal: StateFlow<String?> = _idMeal
    val meal: StateFlow<MealUI?> = _meal
    val mealState: StateFlow<ViewState> = _mealState

    fun setArgs(id: String) {
        _idMeal.value = id

        getDataFromID()
    }

    private fun getDataFromID() {
        viewModelScope.launch {
            val result = repository.getById(_idMeal.value ?: "")

            try {
                val meal: MealUI = result.getOrThrow()

                _meal.value = meal
                _mealState.value = IdleState()
            } catch (_: BadRequestException) {
                _mealState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _mealState.value = ErrorState("No data in the response")
            } catch (_: Exception) {
                _mealState.value = ErrorState("Something went wrong")
            }
        }
    }
}