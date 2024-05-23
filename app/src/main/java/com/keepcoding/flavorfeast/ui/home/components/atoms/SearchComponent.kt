package com.keepcoding.flavorfeast.ui.home.components.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    value: String, 
    onValueChange: (String) -> Unit,
    onFocus: (FocusState) -> Unit = {},
    placeholder: String? = null,
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            if (placeholder != null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = placeholder,
                        fontSize = 17.sp,
                        color = colorResource(R.color.grey),
                        maxLines = 1
                    )
                }
            }
        },
        shape = RoundedCornerShape(24.dp),
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth()
            .onFocusEvent(onFocus),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(R.color.white_grey),
            cursorColor = colorResource(R.color.black),
            unfocusedBorderColor = colorResource(R.color.white_grey),
            focusedBorderColor = colorResource(R.color.white_grey),
            focusedTrailingIconColor = colorResource(R.color.grey),
            unfocusedTrailingIconColor = colorResource(R.color.grey),
            focusedLeadingIconColor = colorResource(R.color.grey),
            unfocusedLeadingIconColor = colorResource(R.color.grey),
        ),
        textStyle = LocalTextStyle.current.copy(fontSize = 17.sp),
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = {
                    onValueChange("")
                }) {
                    Icon(imageVector = Icons.Outlined.Cancel, contentDescription = null)
                }
            }
        }
    )
}