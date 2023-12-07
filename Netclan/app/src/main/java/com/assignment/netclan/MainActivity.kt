package com.assignment.netclan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.assignment.netclan.ui.refine_screen.RefineScreen
import com.assignment.netclan.ui.home.BottomNav
import com.assignment.netclan.ui.home.ExploreScreen
import com.assignment.netclan.ui.home.MainViewModel
import com.assignment.netclan.ui.other_screens.Chat
import com.assignment.netclan.ui.other_screens.Contacts
import com.assignment.netclan.ui.other_screens.Network
import com.assignment.netclan.ui.theme.NetclanTheme


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetclanTheme {
                val screenState by remember { viewModel.screenState }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeComponent()
                }
            }
        }
    }
}



@Composable
fun HomeComponent() {
    val bottomScreen = remember { mutableStateOf(BottomNav.Explore) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (bottomScreen.value) {
                BottomNav.Explore -> ExploreScreen(bottomScreen)
                BottomNav.Network -> Network(bottomScreen = bottomScreen)
                BottomNav.Refine -> RefineScreen(bottomScreen = bottomScreen)
                BottomNav.Chat -> Chat(bottomScreen = bottomScreen)
                BottomNav.Contacts -> Contacts(bottomScreen = bottomScreen)
            }
        }
    }

    //BottomAppBar(screen)
}







