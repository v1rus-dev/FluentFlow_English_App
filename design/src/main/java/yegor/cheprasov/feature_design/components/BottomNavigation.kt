package yegor.cheprasov.feature_design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AssignmentInd
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppBottomNavigation(onClick: (BottomNavItem) -> Unit) {
    val items = listOf(
        BottomNavItem.Topics,
        BottomNavItem.Words,
        BottomNavItem.Profile
    )
    var selectedItem by remember { mutableStateOf(items.first()) }
    Column {
        Divider()
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.LightGray
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    selected = item == selectedItem,
                    icon = { Icon(imageVector = item.icon, contentDescription = null) },
                    selectedContentColor = Color(0xFFBD6EEB),
                    unselectedContentColor = Color.LightGray,
                    label = { Text(text = item.label) },
                    onClick = {
                        if (item != selectedItem) {
                            onClick(item)
                            selectedItem = item
                        }
                    })
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavigation() {
    AppBottomNavigation(onClick = {})
}

sealed class BottomNavItem(val label: String, val icon: ImageVector) {
    object Topics : BottomNavItem("Темы", Icons.Outlined.AssignmentInd)
    object Words : BottomNavItem("Слова", Icons.Outlined.Comment)
    object Profile : BottomNavItem("Профиль", Icons.Outlined.Person)
}