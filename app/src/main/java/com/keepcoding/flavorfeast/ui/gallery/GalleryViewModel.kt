package com.keepcoding.flavorfeast.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.flavorfeast.data.RepositoryInterface
import com.keepcoding.flavorfeast.model.SingleMealUI
import com.keepcoding.flavorfeast.model.enums.BadRequestException
import com.keepcoding.flavorfeast.model.enums.ErrorState
import com.keepcoding.flavorfeast.model.enums.GalleryTypes
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
class GalleryViewModel @Inject constructor(
    private val repository: RepositoryInterface
) : ViewModel() {

    private val _type = MutableStateFlow<GalleryTypes?>(null)
    private val _nameType = MutableStateFlow<String?>(null)
    private val _meals = MutableStateFlow<List<SingleMealUI>>(emptyList())
    private val _mealsState = MutableStateFlow<ViewState>(IdleState())

    val type: StateFlow<GalleryTypes?> = _type
    val nameType: StateFlow<String?> = _nameType
    val meals: StateFlow<List<SingleMealUI>> = _meals
    val mealsState: StateFlow<ViewState> = _mealsState

    fun setArgs(type: GalleryTypes, name: String) {
        _type.value = type
        _nameType.value = name

        obtainData()
    }

    private fun obtainData() {
        viewModelScope.launch {
            _mealsState.value = LoadingState()

            val result = when (_type.value) {
                GalleryTypes.CATEGORY -> repository.getByCategory(_nameType.value ?: "")
                GalleryTypes.INGREDIENTS -> repository.getByIngredient(_nameType.value ?: "")
                GalleryTypes.AREA -> repository.getByArea(_nameType.value ?: "")
                null -> Result.failure(NoDataException())
            }

            try {
                val meals: List<SingleMealUI> = result.getOrThrow()

                _meals.value = meals
                _mealsState.value = IdleState()
            } catch (_: BadRequestException) {
                _mealsState.value = ErrorState("Error with the request")
            } catch (_: NoDataException) {
                _mealsState.value = ErrorState("No data in the response")
            } catch (_: Exception) {
                _mealsState.value = ErrorState("Something went wrong")
            }
        }
    }

}