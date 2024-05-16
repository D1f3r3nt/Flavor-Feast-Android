package com.keepcoding.flavorfeast.ui.search.components.molecules

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val focusRequester = FocusRequester()
    
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        shape = RoundedCornerShape(0.dp),
        singleLine = true,
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(fontSize = 17.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(R.color.white_green),
            cursorColor = colorResource(R.color.black_green),
            unfocusedBorderColor = colorResource(R.color.white_green),
            focusedBorderColor = colorResource(R.color.white_green),
            focusedTrailingIconColor = colorResource(R.color.black_green),
            unfocusedTrailingIconColor = colorResource(R.color.black_green),
        ),
        placeholder = {
            Text("Search by name", fontSize = 17.sp)
        },
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

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}