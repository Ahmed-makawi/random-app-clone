package com.assignment.netclan.ui.other_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.assignment.netclan.ui.composable.BottomAppbar
import com.assignment.netclan.ui.composable.HomeAppbar
import com.assignment.netclan.ui.home.BottomNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chat(bottomScreen: MutableState<BottomNav>) {

    Scaffold(
        bottomBar = { BottomAppbar(screen = bottomScreen ) }
    ) {
        Column(Modifier.fillMaxSize()) {
            HomeAppbar(screen = BottomNav.Chat.name)

            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                Text(
                    text = "CHAT SCREEN",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )

            }
        }
    }
}