package com.example.mapa
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapa.ui.theme.MapaTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(-16.398829,-71.5394782), 10f) //posición original ubicada en plaza de armas
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        val gallery1 = LatLng(-16.397658, -71.537468) // Centro Cultural Unsa
        val gallery2 = LatLng(-16.3964811,-71.539033) // Alianza Francesa Arequipa
        val gallery3 = LatLng(-16.4063731,-71.5249423) //EPIS

        Marker(
            state = com.google.maps.android.compose.MarkerState(position = gallery1),
            title = "Galería 1",
            snippet = "Información de la Galería 1"
        )
        Marker(
            state = com.google.maps.android.compose.MarkerState(position = gallery2),
            title = "Galería 2",
            snippet = "Información de la Galería 2"
        )
        Marker(
            state = com.google.maps.android.compose.MarkerState(position = gallery3),
            title = "Galería 3",
            snippet = "Información de la Galería 3"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    MapaTheme {
        MapScreen()
    }
}