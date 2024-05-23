package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.enums.LoadingState
import com.keepcoding.flavorfeast.model.enums.ViewState
import com.keepcoding.flavorfeast.ui.home.HomeViewModel
import com.keepcoding.flavorfeast.ui.home.components.molecules.AreaSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.CategorySection
import com.keepcoding.flavorfeast.ui.home.components.molecules.IngredientsSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.RandomSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.SearchSection
import com.keepcoding.flavorfeast.utils.controlErrors

@Composable
fun Body_HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    
    val meals: List<MealUI> by viewModel.meals.collectAsState()
    val searchText: String by viewModel.searchText.collectAsState()

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 8.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        item {
            SearchSection(
                modifier = Modifier.padding(horizontal = 16.dp),
                value = searchText,
                onValueChange = viewModel::onSearchTextChange
            )
        }
        
        item {
            if (meals.isEmpty()) {
                Sections_HomeScreen(viewModel)
            } else {
                Search_HomeScreen(meals)
            }
        }
    }
}