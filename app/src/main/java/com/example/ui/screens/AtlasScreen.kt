package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CapitalTier
import com.example.data.Domain
import com.example.data.OpportunityRepository
import com.example.ui.components.FilterChipGold
import com.example.ui.components.LuxuryHeader
import com.example.ui.theme.*
import com.example.viewmodel.MoneyverseViewModel

@Composable
fun AtlasScreen(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedDomain by viewModel.selectedDomain.collectAsState()
    val selectedCapitalTier by viewModel.selectedCapitalTier.collectAsState()
    val selectedOpportunity by viewModel.selectedOpportunity.collectAsState()

    val filteredOpportunities = remember(searchQuery, selectedDomain, selectedCapitalTier) {
        OpportunityRepository.allOpportunities.filter { opp ->
            val matchesSearch = searchQuery.isBlank() ||
                    opp.title.contains(searchQuery, ignoreCase = true) ||
                    opp.summary.contains(searchQuery, ignoreCase = true) ||
                    opp.coreProblem.contains(searchQuery, ignoreCase = true) ||
                    opp.targetCustomer.contains(searchQuery, ignoreCase = true)

            val matchesDomain = selectedDomain == null || opp.domain == selectedDomain
            val matchesCapital = selectedCapitalTier == null || opp.capitalTier == selectedCapitalTier

            matchesSearch && matchesDomain && matchesCapital
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("atlas_screen_list"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            LuxuryHeader(
                title = "OPPORTUNITY ATLAS",
                subtitle = "50+ Concrete Economic Pathways Across 10 Domains (Output B)"
            )
        }

        // Search Input Field
        item {
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.updateSearchQuery(it) },
                    placeholder = {
                        Text("Search by industry, problem, or customer...", color = TextDisabled)
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = ImperialGoldPrimary)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotBlank()) {
                            IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear", tint = TextMediumEmphasis)
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("atlas_search_input"),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = ImperialGoldPrimary,
                        unfocusedBorderColor = LuxuryCardBorderSubtle,
                        focusedContainerColor = LuxurySurface,
                        unfocusedContainerColor = LuxurySurface,
                        focusedTextColor = TextHighEmphasis,
                        unfocusedTextColor = TextHighEmphasis
                    ),
                    singleLine = true
                )
            }
        }

        // Domain Filter Row
        item {
            Column(modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)) {
                Text(
                    text = "FILTER BY DIRECTIVE DOMAIN",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextLowEmphasis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        FilterChipGold(
                            label = "All Domains",
                            selected = selectedDomain == null,
                            onClick = { viewModel.selectDomain(null) }
                        )
                    }
                    items(Domain.values()) { domain ->
                        FilterChipGold(
                            label = domain.displayName,
                            selected = selectedDomain == domain,
                            onClick = { viewModel.selectDomain(if (selectedDomain == domain) null else domain) }
                        )
                    }
                }
            }
        }

        // Capital Tier Filter Row
        item {
            Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
                Text(
                    text = "FILTER BY CAPITAL REQUIREMENT",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextLowEmphasis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        FilterChipGold(
                            label = "All Capital Tiers",
                            selected = selectedCapitalTier == null,
                            onClick = { viewModel.selectCapitalTier(null) }
                        )
                    }
                    items(CapitalTier.values()) { tier ->
                        FilterChipGold(
                            label = tier.label,
                            selected = selectedCapitalTier == tier,
                            onClick = { viewModel.selectCapitalTier(if (selectedCapitalTier == tier) null else tier) }
                        )
                    }
                }
            }
        }

        // Results Summary Count
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SHOWING ${filteredOpportunities.size} OF ${OpportunityRepository.allOpportunities.size} PATHWAYS",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = EmeraldWealth,
                    letterSpacing = 0.5.sp
                )
                if (selectedDomain != null || selectedCapitalTier != null || searchQuery.isNotBlank()) {
                    TextButton(
                        onClick = {
                            viewModel.selectDomain(null)
                            viewModel.selectCapitalTier(null)
                            viewModel.updateSearchQuery("")
                        },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("Reset Filters", color = ImperialGoldPrimary, style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }

        // List of filtered opportunities
        items(filteredOpportunities) { opp ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                OpportunityRankedCard(
                    opportunity = opp,
                    onClick = { viewModel.selectOpportunity(opp) }
                )
            }
        }
    }

    // Detail Dialog
    if (selectedOpportunity != null) {
        OpportunityDetailDialog(
            opportunity = selectedOpportunity!!,
            onDismiss = { viewModel.selectOpportunity(null) }
        )
    }
}
