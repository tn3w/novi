package com.tn3w.novi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

private data class NavItem(
    val label: String,
    val filled: ImageVector,
    val outlined: ImageVector,
)

private val navItems = listOf(
    NavItem("Home", Icons.Filled.Home, Icons.Outlined.Home),
    NavItem("Discover", Icons.Filled.Explore, Icons.Outlined.Explore),
    NavItem("Search", Icons.Filled.Search, Icons.Outlined.Search),
    NavItem("Library", Icons.Filled.LibraryMusic, Icons.Outlined.LibraryMusic),
    NavItem("Me", Icons.Filled.Person, Icons.Outlined.Person),
)

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val background = MaterialTheme.colorScheme.background

    Column(modifier = modifier.fillMaxWidth()) {
        FadeGradient(background)

        NavigationBar(
            containerColor = background,
            tonalElevation = 0.dp,
        ) {
            navItems.forEachIndexed { index, item ->
                val selected = selectedIndex == index
                NavigationBarItem(
                    selected = selected,
                    onClick = { onSelect(index) },
                    icon = {
                        Icon(
                            imageVector = if (selected) item.filled else item.outlined,
                            contentDescription = item.label,
                        )
                    },
                    label = { Text(item.label) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                        indicatorColor = Color.Transparent,
                    ),
                )
            }
        }
    }
}

@Composable
private fun FadeGradient(background: Color) {
    val gradient = Brush.verticalGradient(listOf(Color.Transparent, background))
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(gradient),
    )
}
