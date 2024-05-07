package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.ui.home.components.atoms.FindRow

@Composable
fun ShowFind(elements: List<Any>) {
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {

        elements
            .take(3)
            .mapIndexed { index, it ->
                if (index > 0) {
                    Divider()
                }

                FindRow(
                    text = it as String,
                    modifier = Modifier.clip(
                        RoundedCornerShape(
                            topStart = if (index == 0) { 12.dp } else { 0.dp },
                            topEnd = if (index == 0) { 12.dp } else { 0.dp },
                            bottomStart = if (elements.getOrNull(index + 1) == null || index == 2) { 12.dp } else { 0.dp } ,
                            bottomEnd = if (elements.getOrNull(index + 1) == null || index == 2) { 12.dp } else { 0.dp },
                        )
                    ),
                    onClick = {
                        
                    }
                )
            }
    }
}