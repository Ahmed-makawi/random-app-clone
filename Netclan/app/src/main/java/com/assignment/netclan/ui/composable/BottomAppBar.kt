package com.assignment.netclan.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.netclan.ui.home.BottomNav
import com.assignment.netclan.ui.theme.darkBlue


@Composable
fun BottomAppbar(screen: MutableState<BottomNav>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .border(0.1.dp, Color.LightGray, RectangleShape)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNav.values().forEach { nav ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = nav.icon),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .size(36.dp)
                        .padding(6.dp)
                        .clickable {
                            screen.value = nav
                        },
                    colorFilter = if (screen.value == nav) {
                        ColorFilter.tint(darkBlue)
                    } else {
                        ColorFilter.tint(Color.LightGray)
                    }
                )

                Text(
                    text = nav.name,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color =  if (screen.value == nav) { darkBlue } else {Color.LightGray}
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}