package com.netforge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.netforge.app.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF16161D)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "NetForge — connecting",
                        color = Color(0xFF7C5CFF),
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }
    }
}
