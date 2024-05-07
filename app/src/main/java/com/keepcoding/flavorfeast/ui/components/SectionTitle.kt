package com.keepcoding.flavorfeast.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        color = colorResource(R.color.black_green),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}