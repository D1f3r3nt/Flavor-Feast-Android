package com.keepcoding.flavorfeast.ui.home.components.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchIngredient(
    value: String, 
    onValueChange: (String) -> Unit,
    onFocus: (FocusState) -> Unit = {}
) {
    
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text("Filter by Ingredients", fontSize = 17.sp)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(R.color.light_green),
            cursorColor = colorResource(R.color.black_green),
            unfocusedBorderColor = colorResource(R.color.green),
            focusedBorderColor = colorResource(R.color.black_green),
            focusedTrailingIconColor = colorResource(R.color.black_green),
            unfocusedTrailingIconColor = colorResource(R.color.black_green),
        ),
        textStyle = LocalTextStyle.current.copy(fontSize = 17.sp),
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent(onFocus),
        shape = RoundedCornerShape(24.dp),
        singleLine = true,
        maxLines = 1,
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { 
                    onValueChange("")
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            } else {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        }
    )
}