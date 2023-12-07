package com.assignment.netclan.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.netclan.R
import com.assignment.netclan.ui.theme.darkBlue

@Composable
fun HomeAppbar(screen: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(darkBlue)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_menu),
                    contentDescription = "menu",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = screen,
                    color = Color.White
                )

                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location),
                        contentDescription = "location",
                        modifier = Modifier.size(10.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "San Francisco, California",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.icon_notification_bell),
                contentDescription = "notification",
                tint = Color.White
            )
        }

    }
}