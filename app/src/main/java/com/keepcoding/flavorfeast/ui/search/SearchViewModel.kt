package com.keepcoding.flavorfeast.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.flavorfeast.data.RepositoryInterface
import com.keepcoding.flavorfeast.model.MealUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: RepositoryInterface,
) : ViewModel() {

    private val _searchText = MutableStateFlow<String>("")
    private val _meals = MutableStateFlow<List<MealUI>>(emptyList())

    val searchText: StateFlow<String> = _searchText
    val meals: StateFlow<List<MealUI>> = _meals

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        
        if (text.isNotBlank()) {
            getByName()
        } else {
            _meals.value = emptyList()
        }
    }

    private fun getByName() {
        viewModelScope.launch {
            val result = repository.getByName(_searchText.value)

            try {
                val meals: List<MealUI> = result.getOrThrow()

                _meals.value = meals
            } catch (_: Exception) {
                _meals.value = emptyList()
            }
        }
    }
}