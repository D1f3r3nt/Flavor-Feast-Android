package com.keepcoding.flavorfeast.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 22.sp
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = colorResource(R.color.black),
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}