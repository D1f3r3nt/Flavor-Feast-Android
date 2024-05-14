package com.keepcoding.flavorfeast.ui.details.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R

@Composable
fun VideoSide(
    modifier: Modifier = Modifier,
    image: String,
    video: String,
) {   
    
    val uriHandler = LocalUriHandler.current
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                uriHandler.openUri(video)
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        
        Icon(
            imageVector = Icons.Default.PlayCircle, 
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            tint = colorResource(R.color.green)
        )
    }
}