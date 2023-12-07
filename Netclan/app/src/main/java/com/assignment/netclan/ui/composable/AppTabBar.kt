package com.assignment.netclan.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.netclan.ui.theme.darkBlue
import com.assignment.netclan.ui.theme.lighterBlue


@Composable
fun AppTabBar(
    modifier: Modifier = Modifier,
    children: @Composable (Modifier) -> Unit
) {
    Row(modifier){
        children(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun AppTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: ExploreTab,
    onTabSelected: (ExploreTab) -> Unit
) {
    TabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        indicator = { tabIndicator ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabIndicator[tabSelected.ordinal])
            )
        },
        divider = {},
        containerColor = lighterBlue
    ) {
        titles.forEachIndexed {index, title ->
            val selected = index == tabSelected.ordinal
            Tab(
                text = { Text(
                    text = title,
                    fontSize = 11.sp,
                    color = if (tabSelected.name == title) { Color.White } else {Color.White.copy(alpha = 0.5f)}
                )},
                selected = selected,
                onClick = { onTabSelected(ExploreTab.values()[index]) }
            )
        }
    }
}



enum class ExploreTab {
    INDIVIDUAL, PROFESSIONAL, MERCHANT
}
