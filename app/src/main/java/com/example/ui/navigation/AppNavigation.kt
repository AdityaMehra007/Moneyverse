package com.example.ui.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.ui.screens.*
import com.example.ui.theme.*
import com.example.viewmodel.MoneyverseViewModel

enum class NavDestination(
    val title: String,
    val icon: ImageVector,
    val testTag: String
) {
    VERDICT("Verdict", Icons.Default.Shield, "nav_tab_verdict"),
    ATLAS("Atlas", Icons.Default.Explore, "nav_tab_atlas"),
    EMPIRE_LAB("Empire Lab", Icons.Default.Science, "nav_tab_empire_lab"),
    ECONOMICS("Economics", Icons.Default.AccountBalance, "nav_tab_economics"),
    WAR_ROOM("War Room", Icons.Default.Dashboard, "nav_tab_war_room")
}

@Composable
fun AppNavigation(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    var currentDestination by remember { mutableStateOf(NavDestination.VERDICT) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = LuxuryBackground,
        contentWindowInsets = WindowInsets.safeDrawing,
        bottomBar = {
            NavigationBar(
                containerColor = LuxurySurface,
                tonalElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .testTag("moneyverse_bottom_navigation")
            ) {
                NavDestination.values().forEach { destination ->
                    val isSelected = currentDestination == destination
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { currentDestination = destination },
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.title,
                                tint = if (isSelected) ImperialGoldPrimary else TextDisabled
                            )
                        },
                        label = {
                            Text(
                                text = destination.title,
                                style = MaterialTheme.typography.labelSmall,
                                color = if (isSelected) ImperialGoldPrimary else TextDisabled
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ImperialGoldPrimary,
                            selectedTextColor = ImperialGoldPrimary,
                            unselectedIconColor = TextDisabled,
                            unselectedTextColor = TextDisabled,
                            indicatorColor = LuxurySurfaceVariant
                        ),
                        modifier = Modifier
                            .testTag(destination.testTag)
                            .minimumInteractiveComponentSize()
                    )
                }
            }
        }
    ) { innerPadding ->
        Crossfade(
            targetState = currentDestination,
            label = "screen_transition",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { destination ->
            when (destination) {
                NavDestination.VERDICT -> VerdictScreen(viewModel = viewModel)
                NavDestination.ATLAS -> AtlasScreen(viewModel = viewModel)
                NavDestination.EMPIRE_LAB -> EmpireLabScreen(viewModel = viewModel)
                NavDestination.ECONOMICS -> EconomicsScreen(viewModel = viewModel)
                NavDestination.WAR_ROOM -> WarRoomScreen(viewModel = viewModel)
            }
        }
    }
}
