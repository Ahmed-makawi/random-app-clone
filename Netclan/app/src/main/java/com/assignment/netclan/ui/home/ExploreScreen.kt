package com.assignment.netclan.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.netclan.R
import com.assignment.netclan.data.DummyData
import com.assignment.netclan.data.dummyData
import com.assignment.netclan.ui.composable.AppTabBar
import com.assignment.netclan.ui.composable.AppTabs
import com.assignment.netclan.ui.composable.BottomAppbar
import com.assignment.netclan.ui.composable.ExploreTab
import com.assignment.netclan.ui.composable.HomeAppbar
import com.assignment.netclan.ui.home.BottomNav.Explore
import com.assignment.netclan.ui.theme.darkBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(bottomScreen: MutableState<BottomNav>) {

    var tabSelected by remember { mutableStateOf(ExploreTab.INDIVIDUAL) }

   Scaffold(
       bottomBar = { BottomAppbar(screen = bottomScreen )}
   ) {
       Column(Modifier.fillMaxSize()) {
           HomeAppbar(screen = Explore.name)
           HomeTabBar(
               tabSelected,
               onTabSelected = { tabSelected = it }
           )
           Column(
               Modifier
                   .fillMaxSize()
                   .background(Color.White)
                   .padding(20.dp)
           ) {

               when (tabSelected) {
                   ExploreTab.INDIVIDUAL -> IndividualTab()
                   ExploreTab.PROFESSIONAL -> ProfessionalTab()
                   ExploreTab.MERCHANT -> MerchantTab()

               }
               Spacer(modifier = Modifier.height(50.dp))
           }
       }
   }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndividualTab() {

    var searchValue by remember {
        mutableStateOf("")
    }

    Column {

        Row(verticalAlignment = Alignment.CenterVertically) {

            OutlinedTextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                shape = RoundedCornerShape(25.dp),
                placeholder = { Text(text = "Search", fontSize = 10.sp) },
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f),
                leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "") }

            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painterResource(id = R.drawable.icon_preferences),
                contentDescription = "",
                tint = darkBlue.copy(alpha = 0.6f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(Modifier.fillMaxSize()) {
            items(dummyData) { dummy ->
                CardItem(dummy)
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
fun MerchantTab() {

}

@Composable
fun ProfessionalTab() {

}



@Composable
fun HomeTabBar(
    tabSelected: ExploreTab,
    onTabSelected: (ExploreTab) -> Unit
) {
    AppTabBar { tabBarModifier ->
        AppTabs(
            modifier = tabBarModifier,
            titles = ExploreTab.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab ->
                onTabSelected(ExploreTab.values()[newTab.ordinal])
            }
        )
    }
}


@Composable
fun CardItem(dummyData: DummyData) {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        Modifier
            .fillMaxWidth()
            .height(230.dp)
            .shadow(5.dp, RoundedCornerShape(30.dp)),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(30.dp)
    ){
        Column(
            Modifier.padding(15.dp)
                .fillMaxWidth()
        ) {

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "+ INVITE",
                    color = darkBlue,
                    fontSize = 14.sp
                )

            }
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = dummyData.photo ),
                    contentDescription = "photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                        .clip(RoundedCornerShape(10.dp))
                    )
                Spacer(modifier = Modifier.width(5.dp))

                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = dummyData.name,
                        fontSize = 14.sp,
                        color = darkBlue,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = dummyData.location,
                        fontSize = 10.sp,
                        color = darkBlue.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    LinearProgressIndicator(
                        progress = 0.5f,
                        modifier = Modifier
                            .height(17.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        color = darkBlue.copy(alpha = 0.7f),
                        trackColor = Color.LightGray
                    )
                    Spacer(modifier = Modifier.height(17.dp))
                }
            }
            Text(
                text = dummyData.tags,
                fontSize = 11.sp,
                color = darkBlue,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dummyData.message,
                fontSize = 11.sp,
                color = darkBlue,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,

            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun IndividualTabPre() {
    IndividualTab()
}