package com.keepcoding.flavorfeast.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(colorResource(R.color.green)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = text,
            fontSize = 17.sp,
            color = colorResource(R.color.white_green),
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}