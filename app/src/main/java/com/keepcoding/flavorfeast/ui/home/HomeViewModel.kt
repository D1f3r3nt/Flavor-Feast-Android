package com.keepcoding.flavorfeast.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.flavorfeast.data.RepositoryInterface
import com.keepcoding.flavorfeast.model.MealUI
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
    val randomState: StateFlow<ViewState> = _randomState
    val randomMeal: StateFlow<MealUI?> = _randomMeal
    
    fun getRandomMeal() {
        viewModelScope.launch { 
            _randomState.value = LoadingState()
            
            val result = repository.getRandomMeal()
            
            try {
                val meal: MealUI = result.getOrThrow()

                _randomMeal.value = meal
                
            } catch (_: BadRequestException) {
                _randomState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _randomState.value = ErrorState("No data in the response")
            } catch (_ : Exception) {
                _randomState.value = ErrorState("Something went wrong")
            }
            
            _randomState.value = IdleState()
        }
    }
}