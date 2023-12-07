package com.assignment.netclan.ui.refine_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.assignment.netclan.ui.composable.BottomAppbar
import com.assignment.netclan.ui.composable.HomeAppbar
import com.assignment.netclan.ui.home.BottomNav
import com.assignment.netclan.ui.home.BottomNav.Refine
import com.assignment.netclan.ui.theme.darkBlue



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefineScreen(bottomScreen: MutableState<BottomNav>) {

    Scaffold(
        bottomBar = { BottomAppbar(screen = bottomScreen) },
        containerColor = Color.White
    ) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            HomeAppbar(screen = Refine.name)

            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(20.dp)
            ) {

                DropDownMenu()

                Divider(color = Color.LightGray)

                BriefMessage()

                Divider(color = Color.LightGray)

                DistanceSlider()

                Divider(color = Color.LightGray)

                SelectPurpose()
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions =
        listOf("SOS - Emergency ! Need Assistance ! HELP", "option 2", "option 3", "option 4")
    var selectedText by remember { mutableStateOf("") }


    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(bottom = 20.dp)) {

        Text(
            text = "Select Your Status",
            fontSize = 12.sp,
            color = darkBlue,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            textStyle = TextStyle(darkBlue, 11.sp),
            placeholder = { Text(text = "Select Your Status", fontSize = 12.sp, color = darkBlue) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            shape = RoundedCornerShape(15.dp),
            trailingIcon = {
                Icon(
                    icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded },
                    tint = darkBlue
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                },
                    text = { Text(text = label) }
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BriefMessage() {

    Column(
        Modifier
            .padding(bottom = 20.dp, top = 20.dp)
            .fillMaxWidth()
    ) {

        var text by remember {
            mutableStateOf("")
        }

        Text(
            text = "Broadcast Brief Message ",
            fontSize = 12.sp,
            color = darkBlue,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = text,
            onValueChange = {
                if(text.length<250) {
                    text = it
                }
            },
            textStyle = TextStyle(darkBlue, 11.sp),
            placeholder = { Text(text = "Enter Brief Message", fontSize = 12.sp) },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
        )
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${text.length}/250",
                textAlign = TextAlign.Right,
                color = darkBlue,
                fontSize = 9.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistanceSlider() {
    var soundVolume by remember { mutableStateOf(0.5f) }
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 20.dp)
    ) {
        Column {

            Text(
                text = "Select Nearby Distance",
                fontSize = 12.sp,
                color = darkBlue,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Slider(
                value = soundVolume,
                onValueChange = { soundVolume = it },
                enabled = true,
                valueRange = 0.5f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = darkBlue,
                    activeTrackColor = darkBlue,
                    inactiveTrackColor = Color.LightGray,
                    disabledActiveTrackColor = Color.White
                ),
                thumb = {
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        thumbSize = DpSize(18.dp, 18.dp),
                        colors = SliderDefaults.colors(darkBlue)
                    )
                },
            )
            Row {
                Text(
                    text = "500 m",
                    fontSize = 9.sp,
                    textAlign = TextAlign.Left,
                    color = darkBlue
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = soundVolume.toInt().toString(),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = darkBlue
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "100 Km",
                    fontSize = 9.sp,
                    textAlign = TextAlign.Right,
                    color = darkBlue
                )
            }
        }
    }
}


@Composable
fun SelectPurpose() {

    val purposes = listOf(
        "Coffee", "Friendship", "Dating", "Business",
        "Movies", "Matrimony", "Hobbies", "Dining"
    )

    Box( modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp, top = 20.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(purposes.size) {

                var selected by remember {
                    mutableStateOf(false)
                }

                val buttonColor = if (selected) darkBlue else Color.White
                val textColor = if (selected) Color.White else darkBlue

                val customButtonColors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor, // Set the desired background color
                    contentColor = textColor // Set the desired content (text) color
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(14.dp))
                    OutlinedButton(
                        onClick = { selected = !selected },
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp)
                            .padding(end = 10.dp),
                        colors = customButtonColors
                    ) {
                        Text(
                            text = purposes[it],
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

