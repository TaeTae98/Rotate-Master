package com.taetae98.rotatemaster.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taetae98.rotatemaster.ui.navigation.MainNavigation
import com.taetae98.rotatemaster.ui.theme.RotateMasterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotateMasterTheme {
                MainNavigation()
            }
        }
    }
}