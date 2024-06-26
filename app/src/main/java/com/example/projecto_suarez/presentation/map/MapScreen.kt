package com.example.projecto_suarez.presentation.map

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projecto_suarez.domain.model.Article
import com.example.projecto_suarez.presentation.Dimens
import com.example.projecto_suarez.presentation.common.ScanCamara
import com.example.projecto_suarez.presentation.map.components.CanvasMap

@Composable
fun MapScreen(
    result: String,
    state: MapState,
    event: (MapEvent) -> Unit,
    navigateToDetails: (Article) -> Unit) {
    ScanCamara(
        onResult = { event(MapEvent.RedirectoToDetails(it, navigateToDetails))}
    )
    Column(
        modifier = Modifier
            .padding(
                top = Dimens.MediumPadding1,
                start = Dimens.MediumPadding1,
                end = Dimens.MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Text(result)
        Spacer(modifier = Modifier.height(8.dp))
        state.beacons?.forEach { beacon ->
            Text(text = beacon)
            Spacer(modifier = Modifier.height(4.dp))
        }
        CanvasMap(
            onTouchPaint = { event(MapEvent.RedirectoToDetails(it, navigateToDetails))}
        )

    }
}