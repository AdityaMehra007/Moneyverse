package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.data.OpportunityRepository
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.MoneyverseViewModel

@Composable
fun EconomicsScreen(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    val sim by viewModel.simulation.collectAsState()
    var selectedTierIndex by remember { mutableStateOf(0) }
    val capitalPlans = OpportunityRepository.capitalPlans

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("economics_screen_list"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            LuxuryHeader(
                title = "ECONOMICS & CAPITAL",
                subtitle = "Unit Economics Modeling & Capital Allocation Architecture (Directives 012 & 013)"
            )
        }

        // FINANCIAL TRENDS & MARKET INSIGHTS VISUALIZATION (D3 / RECHARTS ENGINE)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                FinancialDataVisualizer(
                    clientCount = sim.clientCount,
                    pricePerClient = sim.pricePerClientInr,
                    operatingProfit = sim.operatingProfit
                )
            }
        }

        // DIRECTIVE 012: DYNAMIC FINANCIAL MODELER
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                LuxuryGoldCard(
                    borderColor = ImperialGoldPrimary.copy(alpha = 0.5f),
                    backgroundColor = Color(0xFF0F1728)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "INTERACTIVE FINANCIAL MODELER",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = ImperialGoldPrimary,
                            letterSpacing = 1.sp
                        )
                        Icon(Icons.Default.Calculate, contentDescription = "Calculator", tint = ImperialGoldPrimary)
                    }

                    Text(
                        text = "Real-time P&L, gross margin & break-even calculation",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextLowEmphasis
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Scenario Presets
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                viewModel.updateClientCount(3)
                                viewModel.updatePricePerClient(15_000L)
                                viewModel.updateDirectCost(1_500L)
                                viewModel.updateCac(2_000L)
                                viewModel.updateFixedOverhead(5_000L)
                            },
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Conservative", fontSize = 11.sp)
                        }
                        OutlinedButton(
                            onClick = {
                                viewModel.updateClientCount(6)
                                viewModel.updatePricePerClient(25_000L)
                                viewModel.updateDirectCost(2_500L)
                                viewModel.updateCac(3_500L)
                                viewModel.updateFixedOverhead(8_000L)
                            },
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Base Case", fontSize = 11.sp, color = ImperialGoldPrimary)
                        }
                        OutlinedButton(
                            onClick = {
                                viewModel.updateClientCount(12)
                                viewModel.updatePricePerClient(40_000L)
                                viewModel.updateDirectCost(3_500L)
                                viewModel.updateCac(5_000L)
                                viewModel.updateFixedOverhead(25_000L)
                            },
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Upside (Scale)", fontSize = 11.sp, color = EmeraldWealth)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Interactive Sliders
                    Text(
                        text = "Active Clients / Retainers: ${sim.clientCount}",
                        style = MaterialTheme.typography.labelMedium,
                        color = TextHighEmphasis
                    )
                    Slider(
                        value = sim.clientCount.toFloat(),
                        onValueChange = { viewModel.updateClientCount(it.toInt()) },
                        valueRange = 1f..30f,
                        steps = 29,
                        colors = SliderDefaults.colors(
                            thumbColor = ImperialGoldPrimary,
                            activeTrackColor = ImperialGoldPrimary
                        ),
                        modifier = Modifier.testTag("slider_client_count")
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Average Monthly Fee per Client: ₹${sim.pricePerClientInr}",
                        style = MaterialTheme.typography.labelMedium,
                        color = TextHighEmphasis
                    )
                    Slider(
                        value = sim.pricePerClientInr.toFloat(),
                        onValueChange = { viewModel.updatePricePerClient(it.toLong()) },
                        valueRange = 5_000f..100_000f,
                        steps = 18,
                        colors = SliderDefaults.colors(
                            thumbColor = SapphireTech,
                            activeTrackColor = SapphireTech
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Dynamic Output Matrix
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatMetricBadge(
                            label = "Monthly Revenue",
                            value = "₹${sim.monthlyRevenue}",
                            subValue = "₹${sim.monthlyRevenue * 12}/year",
                            accentColor = ImperialGoldPrimary,
                            modifier = Modifier.weight(1f)
                        )
                        StatMetricBadge(
                            label = "Operating Profit",
                            value = "₹${sim.operatingProfit}",
                            subValue = "${String.format("%.1f", sim.grossMarginPercent)}% Gross Margin",
                            accentColor = if (sim.operatingProfit > 0) EmeraldWealth else CrimsonRisk,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatMetricBadge(
                            label = "Break-Even Clients",
                            value = if (sim.breakEvenClients > 0) "${sim.breakEvenClients} Clients" else "Negative Unit Economics",
                            subValue = "Covers ₹${sim.monthlyFixedOverheadInr} overhead",
                            accentColor = SapphireTech,
                            modifier = Modifier.weight(1f)
                        )
                        StatMetricBadge(
                            label = "GST & Tax Reserve",
                            value = "₹${(sim.monthlyRevenue * 0.18).toLong()}",
                            subValue = "18% GST Compliance Buffer",
                            accentColor = AmberCaution,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // DIRECTIVE 013: CAPITAL ALLOCATION SYSTEM (₹0 TO ₹10 LAKHS)
        item {
            Column(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                Text(
                    text = "CAPITAL ALLOCATION BLUEPRINTS (DIRECTIVE 013)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "Specific rules for allocating capital without risking essential security",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(capitalPlans.indices.toList()) { index ->
                        val plan = capitalPlans[index]
                        FilterChipGold(
                            label = plan.tier.label,
                            selected = selectedTierIndex == index,
                            onClick = { selectedTierIndex = index }
                        )
                    }
                }
            }
        }

        item {
            val plan = capitalPlans[selectedTierIndex]
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                LuxuryGoldCard(
                    borderColor = ImperialGoldPrimary.copy(alpha = 0.4f),
                    backgroundColor = LuxurySurfaceVariant
                ) {
                    Text(
                        text = "ALLOCATION ARCHITECTURE: ${plan.tier.label.uppercase()}",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = ImperialGoldPrimary
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "WHAT TO START IMMEDIATELY:",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = EmeraldWealth
                    )
                    plan.whatToStart.forEach { item ->
                        Text(text = "• $item", style = MaterialTheme.typography.bodySmall, color = TextHighEmphasis)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "WHAT TO STRICTLY POSTPONE:",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = CrimsonRisk
                    )
                    plan.whatToPostpone.forEach { item ->
                        Text(text = "• $item", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    DetailSection(title = "SKILLS AS CAPITAL SUBSTITUTE", content = plan.skillSubstitutes)
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailSection(title = "ESSENTIAL SOFTWARE STACK", content = plan.essentialSoftware)
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailSection(title = "EMERGENCY RESERVES RULE", content = plan.emergencyReservesRule)
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailSection(title = "RATIONAL STOP & DOWNSIDE LIMIT", content = plan.downsideStopRule)
                }
            }
        }

        // DIRECTIVE 026: MATHEMATICAL SCALE ROADMAP
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text(
                    text = "THE MATHEMATICAL SCALE ROADMAP (DIRECTIVE 026)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Deconstructing wealth targets into units, prices, and required operations",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))

                ScaleTargetCard(
                    target = "First ₹10,000 Earned",
                    math = "1 client × ₹10,000 setup fee or 2 clients × ₹5,000 audit",
                    operations = "100% manual sweat equity; proves commercial willingness to pay."
                )
                Spacer(modifier = Modifier.height(6.dp))
                ScaleTargetCard(
                    target = "₹50,000 Monthly Income",
                    math = "2 retainers @ ₹25,000/mo or 5 retainers @ ₹10,000/mo",
                    operations = "Covers essential living expenses and establishes baseline financial independence."
                )
                Spacer(modifier = Modifier.height(6.dp))
                ScaleTargetCard(
                    target = "₹1,00,000 Monthly Income",
                    math = "4 retainers @ ₹25,000/mo with 85% gross margin",
                    operations = "Generates ₹40,000/mo investable surplus after taxes and essential expenses."
                )
                Spacer(modifier = Modifier.height(6.dp))
                ScaleTargetCard(
                    target = "₹1 Crore Annual Revenue",
                    math = "₹8,33,333/mo = 17 enterprise retainers @ ₹50,000/mo or 280 SaaS licenses @ ₹2,999/mo",
                    operations = "Requires team of 2-3 operators, formal LLP/Pvt Ltd entity, and institutional delivery."
                )
            }
        }
    }
}

@Composable
fun ScaleTargetCard(
    target: String,
    math: String,
    operations: String
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = LuxurySurfaceElevated,
        border = androidx.compose.foundation.BorderStroke(1.dp, LuxuryCardBorderSubtle),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = target,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = ImperialGoldPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Commercial Formula: $math",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = TextHighEmphasis
            )
            Text(
                text = "Operational Reality: $operations",
                style = MaterialTheme.typography.bodySmall,
                color = TextMediumEmphasis
            )
        }
    }
}
