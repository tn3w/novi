package com.tn3w.novi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tn3w.novi.ui.components.BottomNavBar
import com.tn3w.novi.ui.components.NowPlayingBar
import com.tn3w.novi.ui.components.NowPlayingTrack
import com.tn3w.novi.ui.screens.HomeScreen
import com.tn3w.novi.ui.theme.NoviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoviTheme {
                var selectedIndex by remember { mutableIntStateOf(0) }

                val nowPlaying = NowPlayingTrack(
                    title = "Midnight Drive (feat. Luna Ray)",
                    artist = "Neon Pulse",
                    color = Color(0xFF1A3A5A),
                )

                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        HomeScreen()
                        BottomNavBar(
                            selectedIndex = selectedIndex,
                            onSelect = { selectedIndex = it },
                            modifier = Modifier.align(Alignment.BottomCenter),
                        )
                        NowPlayingBar(
                            track = nowPlaying,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .navigationBarsPadding()
                                .padding(bottom = 80.dp),
                        )
                    }
                }
            }
        }
    }
}
