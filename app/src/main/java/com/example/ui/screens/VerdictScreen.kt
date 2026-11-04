package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.Opportunity
import com.example.data.OpportunityRepository
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.MoneyverseViewModel

@Composable
fun VerdictScreen(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    val selectedOpportunity by viewModel.selectedOpportunity.collectAsState()
    val top10Opportunities = remember {
        OpportunityRepository.allOpportunities.sortedByDescending { it.weightedScore }.take(10)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("verdict_screen_list"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            LuxuryHeader(
                title = "MONEYVERSE ∞",
                subtitle = "Executive Intelligence & Wealth Architecture System"
            )
        }

        // OUTPUT A: EXECUTIVE VERDICT CARD
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                LuxuryGoldCard(
                    borderColor = ImperialGoldPrimary.copy(alpha = 0.5f),
                    backgroundColor = Color(0xFF0F1728)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(ImperialGoldPrimary.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Shield,
                                contentDescription = "Executive Verdict",
                                tint = ImperialGoldPrimary,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "OUTPUT A: EXECUTIVE VERDICT",
                            style = MaterialTheme.typography.labelLarge,
                            color = ImperialGoldPrimary,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Immediate Income Path
                    VerdictBulletItem(
                        icon = Icons.Default.Bolt,
                        iconTint = EmeraldWealth,
                        tag = "STRONGEST IMMEDIATE INCOME PATH",
                        headline = "B2B AI Workflow Automation & SOP Digitization",
                        body = "Zero upfront capital. Mid-sized Bengaluru industrial & logistics firms have immediate budget to eliminate 15-20 hours/week of manual GST/invoice data entry."
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Long-Term Ownership Path
                    VerdictBulletItem(
                        icon = Icons.Default.AccountBalance,
                        iconTint = SapphireTech,
                        tag = "STRONGEST LONG-TERM OWNERSHIP PATH",
                        headline = "Sweat-Equity Modernization in Stagnant MSMEs",
                        body = "Partner with un-digitized traditional manufacturing/distribution firms. Modernize sales channels in exchange for 15-25% gross profit share."
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // #1 Fatal Mistake
                    VerdictBulletItem(
                        icon = Icons.Default.Warning,
                        iconTint = CrimsonRisk,
                        tag = "#1 STRATEGIC MISTAKE TO AVOID",
                        headline = "Building Products Before Paid Customer Validation",
                        body = "Never spend months writing software without signed intent or pre-orders. Evidence outranks excitement; cash flow velocity beats theoretical venture scale."
                    )
                }
            }
        }

        // DIRECTIVE 007: THE 4-ENGINE WEALTH ARCHITECTURE
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Text(
                    text = "THE 4-ENGINE WEALTH ARCHITECTURE",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Connected economic engines working in synchronized symbiosis",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    EngineMiniCard(
                        number = "01",
                        title = "Cash Flow",
                        subtitle = "B2B Services",
                        icon = Icons.Default.Payments,
                        color = EmeraldWealth,
                        modifier = Modifier.weight(1f)
                    )
                    EngineMiniCard(
                        number = "02",
                        title = "Earning Power",
                        subtitle = "AI & Trade Ops",
                        icon = Icons.Default.TrendingUp,
                        color = SapphireTech,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    EngineMiniCard(
                        number = "03",
                        title = "Ownership",
                        subtitle = "Micro-SaaS & IP",
                        icon = Icons.Default.Hub,
                        color = ImperialGoldPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    EngineMiniCard(
                        number = "04",
                        title = "Compounding",
                        subtitle = "Asset Allocation",
                        icon = Icons.Default.Savings,
                        color = ElectricIndigo,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // OUTPUT C: RANKED TOP 10 OPPORTUNITIES
        item {
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "RANKED TOP 10 OPPORTUNITIES",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextHighEmphasis
                    )
                    Text(
                        text = "9-Factor Weighted Score",
                        style = MaterialTheme.typography.labelSmall,
                        color = ImperialGoldPrimary
                    )
                }
                Text(
                    text = "Ranked strictly by verified commercial viability, capital efficiency, and speed",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )
            }
        }

        items(top10Opportunities) { opp ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                OpportunityRankedCard(
                    opportunity = opp,
                    onClick = { viewModel.selectOpportunity(opp) }
                )
            }
        }
    }

    // Opportunity Detail Dialog
    if (selectedOpportunity != null) {
        OpportunityDetailDialog(
            opportunity = selectedOpportunity!!,
            onDismiss = { viewModel.selectOpportunity(null) }
        )
    }
}

@Composable
fun VerdictBulletItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconTint: Color,
    tag: String,
    headline: String,
    body: String
) {
    Row(verticalAlignment = Alignment.Top) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(iconTint.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = tag,
                tint = iconTint,
                modifier = Modifier.size(14.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = tag,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = iconTint,
                letterSpacing = 0.5.sp
            )
            Text(
                text = headline,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                color = TextHighEmphasis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = body,
                style = MaterialTheme.typography.bodySmall,
                color = TextMediumEmphasis,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun EngineMiniCard(
    number: String,
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LuxurySurfaceVariant),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.25f))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = number,
                        style = MaterialTheme.typography.labelSmall,
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextHighEmphasis
                    )
                }
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = TextLowEmphasis
                )
            }
        }
    }
}

@Composable
fun OpportunityRankedCard(
    opportunity: Opportunity,
    onClick: () -> Unit
) {
    LuxuryGoldCard(
        onClick = onClick,
        borderColor = if (opportunity.rank == 1) ImperialGoldPrimary.copy(alpha = 0.8f) else LuxuryCardBorderSubtle,
        backgroundColor = if (opportunity.rank == 1) Color(0xFF141F36) else LuxurySurface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Rank Circle
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(
                            if (opportunity.rank == 1) ImperialGoldPrimary else Color(0xFF1E293B)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "#${opportunity.rank}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Black,
                        color = if (opportunity.rank == 1) Color(0xFF0F172A) else TextHighEmphasis
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = opportunity.domain.displayName,
                        style = MaterialTheme.typography.labelSmall,
                        color = ImperialGoldPrimary
                    )
                    Text(
                        text = opportunity.title,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = TextHighEmphasis
                    )
                }
            }

            // Weighted Score Badge
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = ImperialGoldPrimary.copy(alpha = 0.15f),
                border = androidx.compose.foundation.BorderStroke(1.dp, ImperialGoldPrimary.copy(alpha = 0.4f))
            ) {
                Text(
                    text = String.format("%.2f", opportunity.weightedScore),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = ImperialGoldPrimary,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = opportunity.summary,
            style = MaterialTheme.typography.bodySmall,
            color = TextMediumEmphasis,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = LuxurySurfaceElevated
                ) {
                    Text(
                        text = opportunity.capitalTier.label,
                        style = MaterialTheme.typography.labelSmall,
                        color = EmeraldWealth,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = LuxurySurfaceElevated
                ) {
                    Text(
                        text = opportunity.typicalMonthlyRevenueInr,
                        style = MaterialTheme.typography.labelSmall,
                        color = SapphireTech,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Details",
                    style = MaterialTheme.typography.labelSmall,
                    color = ImperialGoldPrimary
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "View Details",
                    tint = ImperialGoldPrimary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun OpportunityDetailDialog(
    opportunity: Opportunity,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(20.dp),
            color = LuxurySurface,
            border = androidx.compose.foundation.BorderStroke(1.dp, ImperialGoldPrimary.copy(alpha = 0.5f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = opportunity.domain.displayName.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            color = ImperialGoldPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = opportunity.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = TextHighEmphasis
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = TextMediumEmphasis
                        )
                    }
                }

                Divider(
                    color = LuxuryCardBorderSubtle,
                    modifier = Modifier.padding(vertical = 12.dp)
                )

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    item {
                        DetailSection(title = "CORE PROBLEM & FRICTION", content = opportunity.coreProblem)
                    }
                    item {
                        DetailSection(title = "ECONOMIC BUYER", content = opportunity.economicBuyer)
                    }
                    item {
                        DetailSection(title = "THE PROPOSED OFFER", content = opportunity.proposedOffer)
                    }
                    item {
                        DetailSection(title = "TANGIBLE DELIVERABLE", content = opportunity.deliverable)
                    }
                    item {
                        DetailSection(title = "PRICING HYPOTHESIS", content = opportunity.pricingHypothesis)
                    }
                    item {
                        DetailSection(title = "DELIVERY COST PER CUSTOMER", content = opportunity.deliveryCostPerCustomerInr)
                    }
                    item {
                        DetailSection(title = "CUSTOMER ACQUISITION ROUTE", content = opportunity.acquisitionMethod)
                    }
                    item {
                        DetailSection(title = "STOP CRITERION (PREVENT SUNK COST)", content = opportunity.stopCriterion)
                    }
                    item {
                        DetailSection(title = "DURABLE COMPETITIVE ADVANTAGE (MOAT)", content = opportunity.keyMoat)
                    }
                    item {
                        Text(
                            text = "9-FACTOR WEIGHTED SCORES",
                            style = MaterialTheme.typography.labelLarge,
                            color = ImperialGoldPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ScoreProgressBar(score = opportunity.demandScore, label = "Customer Demand (20%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.personalFitScore, label = "Personal Fit (15%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.capitalEfficiencyScore, label = "Capital Efficiency (15%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.speedToValidationScore, label = "Speed to Validation (10%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.profitabilityScore, label = "Profitability (10%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.scalabilityScore, label = "Scalability (10%)")
                        Spacer(modifier = Modifier.height(6.dp))
                        ScoreProgressBar(score = opportunity.recurringRevenueScore, label = "Recurring Potential (10%)")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = ImperialGoldPrimary)
                ) {
                    Text(
                        text = "CLOSE BRIEFING",
                        color = Color(0xFF0F172A),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun DetailSection(title: String, content: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = ImperialGoldPrimary,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            color = TextMediumEmphasis,
            lineHeight = 20.sp
        )
    }
}
