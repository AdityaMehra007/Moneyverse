package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.data.OpportunityRepository
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.AiCopilotState
import com.example.viewmodel.MoneyverseViewModel

@Composable
fun WarRoomScreen(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    val finances by viewModel.personalFinances.collectAsState()
    val copilotState by viewModel.copilotState.collectAsState()
    var copilotPrompt by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("war_room_screen_list"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            LuxuryHeader(
                title = "WAR ROOM & ROADMAP",
                subtitle = "Weekly Decision Dashboard, 30-Day Plan & Strategic AI Copilot"
            )
        }

        // DIRECTIVE 022: LIVE PERFORMANCE DASHBOARD
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                LuxuryGoldCard(
                    borderColor = ImperialGoldPrimary.copy(alpha = 0.5f),
                    backgroundColor = Color(0xFF0F172A)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "WEEKLY DECISION DASHBOARD",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = ImperialGoldPrimary,
                            letterSpacing = 1.sp
                        )
                        Icon(Icons.Default.Dashboard, contentDescription = "Dashboard", tint = ImperialGoldPrimary)
                    }

                    Text(
                        text = "Real financial reserves, active pipeline & strategic bottlenecks",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextLowEmphasis
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatMetricBadge(
                            label = "Emergency Runway",
                            value = "${String.format("%.1f", finances.runwayMonths)} Months",
                            subValue = "Liquid: ₹${finances.liquidCashInr}",
                            accentColor = if (finances.runwayMonths >= 3f) EmeraldWealth else AmberCaution,
                            modifier = Modifier.weight(1f)
                        )
                        StatMetricBadge(
                            label = "Monthly Burn",
                            value = "₹${finances.essentialLivingExpensesInr}",
                            subValue = "Essential costs only",
                            accentColor = SapphireTech,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = LuxurySurfaceElevated,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "CURRENT STRATEGIC BOTTLENECK:",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = CrimsonRisk
                            )
                            Text(
                                text = "Zero paying clients acquired yet. Must execute 50 personalized outreach touches this week to validate willingness to pay.",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextHighEmphasis
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "NEXT HIGHEST-VALUE DECISION:",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = EmeraldWealth
                            )
                            Text(
                                text = "Complete 90-second invoice parsing demo and contact 10 Bengaluru logistics operators by 5 PM.",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextHighEmphasis
                            )
                        }
                    }
                }
            }
        }

        // AI STRATEGIC COPILOT (DIRECTIVES 030 & 031)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Text(
                    text = "AI STRATEGIC COPILOT (MONEYVERSE ∞)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Consult the commercial intelligence engine on any dilemma or strategy",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))

                LuxuryGoldCard {
                    OutlinedTextField(
                        value = copilotPrompt,
                        onValueChange = { copilotPrompt = it },
                        placeholder = { Text("Ask strategic question (e.g. How do I price a logistics retainer in Bengaluru?)", color = TextDisabled) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("copilot_prompt_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ImperialGoldPrimary,
                            unfocusedBorderColor = LuxuryCardBorderSubtle,
                            focusedTextColor = TextHighEmphasis,
                            unfocusedTextColor = TextHighEmphasis
                        ),
                        maxLines = 3
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Quick Presets
                        TextButton(
                            onClick = {
                                copilotPrompt = "How should I structure the first invoice parser pilot for a Bengaluru manufacturer?"
                            },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Sample Query", color = SapphireTech, style = MaterialTheme.typography.labelSmall)
                        }

                        Button(
                            onClick = {
                                if (copilotPrompt.isNotBlank()) {
                                    viewModel.askCopilot(copilotPrompt)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = ImperialGoldPrimary),
                            modifier = Modifier.testTag("copilot_send_button")
                        ) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = "Consult Copilot", tint = Color(0xFF0F172A))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("CONSULT COPILOT", color = Color(0xFF0F172A), fontWeight = FontWeight.Bold)
                        }
                    }

                    // Copilot Response Display
                    when (copilotState) {
                        is AiCopilotState.Thinking -> {
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                CircularProgressIndicator(color = ImperialGoldPrimary, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(10.dp))
                                Text("Synthesizing commercial directives & market reality...", style = MaterialTheme.typography.bodySmall, color = ImperialGoldPrimary)
                            }
                        }
                        is AiCopilotState.Response -> {
                            Spacer(modifier = Modifier.height(14.dp))
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = LuxurySurfaceElevated,
                                border = androidx.compose.foundation.BorderStroke(1.dp, ImperialGoldPrimary.copy(alpha = 0.3f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = (copilotState as AiCopilotState.Response).answer,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextHighEmphasis,
                                    lineHeight = 20.sp,
                                    modifier = Modifier.padding(14.dp)
                                )
                            }
                        }
                        is AiCopilotState.Error -> {
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Error: ${(copilotState as AiCopilotState.Error).message}",
                                style = MaterialTheme.typography.bodySmall,
                                color = CrimsonRisk
                            )
                        }
                        AiCopilotState.Idle -> {}
                    }
                }
            }
        }

        // OUTPUT I: 30-DAY ACTION BLUEPRINT
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Text(
                    text = "THE 30-DAY ACTION BLUEPRINT (OUTPUT I)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "A concrete stage-by-stage cadence to secure the first paying client",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        items(OpportunityRepository.thirtyDayBlueprint) { plan ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                LuxuryGoldCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = plan.dayRange.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = ImperialGoldPrimary
                        )
                        Text(
                            text = plan.theme,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = TextHighEmphasis
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    plan.tasks.forEach { task ->
                        Row(modifier = Modifier.padding(vertical = 2.dp), verticalAlignment = Alignment.Top) {
                            Text(text = "•", color = ImperialGoldPrimary, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = task, style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Deliverable: ${plan.deliverable}", style = MaterialTheme.typography.labelSmall, color = SapphireTech, fontWeight = FontWeight.SemiBold)
                    Text(text = "Success Gate: ${plan.successGate}", style = MaterialTheme.typography.labelSmall, color = EmeraldWealth, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        // OUTPUT J: 12-MONTH STAGED ROADMAP
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text(
                    text = "12-MONTH EVOLUTION ROADMAP (OUTPUT J)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Staged milestone evolution governed strictly by validated performance",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        items(OpportunityRepository.twelveMonthRoadmap) { stage ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                LuxuryGoldCard(backgroundColor = LuxurySurfaceVariant) {
                    Text(
                        text = "${stage.stage}: ${stage.title}".uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = ImperialGoldPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stage.coreFocus,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextHighEmphasis
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    stage.keyMilestones.forEach { m ->
                        Text(text = "✓ $m", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Advance Gate: ${stage.gatingCriterion}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = EmeraldWealth
                    )
                }
            }
        }

        // OUTPUT K: RISK REGISTER
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text(
                    text = "RISK REGISTER & CONTINGENCY CONTROLS (OUTPUT K)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Proactive defensive controls against fatal failure modes (Directive 020)",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        items(OpportunityRepository.riskRegister) { risk ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                LuxuryGoldCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = risk.riskCategory.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = CrimsonRisk
                        )
                        Text(
                            text = "${risk.likelihood} Likelihood / ${risk.impact} Impact",
                            style = MaterialTheme.typography.labelSmall,
                            color = AmberCaution
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = risk.threatDescription, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TextHighEmphasis)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Early Warning: ${risk.earlyWarning}", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                    Text(text = "Preventive Control: ${risk.preventiveControl}", style = MaterialTheme.typography.bodySmall, color = EmeraldWealth)
                    Text(text = "Contingency Action: ${risk.contingencyAction}", style = MaterialTheme.typography.bodySmall, color = SapphireTech)
                }
            }
        }

        // DIRECTIVE 021: LEGAL & COMPLIANCE FRAMEWORK
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                Text(
                    text = "LEGAL, TAX & COMPLIANCE (DIRECTIVE 021)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Essential regulatory compass for Indian and Cross-Border operations",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(10.dp))

                LuxuryGoldCard {
                    Text(text = "ENTITY SELECTION: START WITH SOLE PROPRIETORSHIP", style = MaterialTheme.typography.labelLarge, color = ImperialGoldPrimary, fontWeight = FontWeight.Bold)
                    Text(text = "Do not spend ₹15,000 incorporating a Pvt Ltd before earning ₹5,000. Open a current bank account with an MSME Udyam Certificate (100% free online) under your trade name.", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "GST THRESHOLDS (INDIA)", style = MaterialTheme.typography.labelLarge, color = ImperialGoldPrimary, fontWeight = FontWeight.Bold)
                    Text(text = "Service providers in India are exempt from mandatory GST registration until annual turnover exceeds ₹20 Lakhs. When exceeding ₹20L, charge 18% GST.", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "CROSS-BORDER INWARD REMITTANCE (FIRC / e-FIRA)", style = MaterialTheme.typography.labelLarge, color = ImperialGoldPrimary, fontWeight = FontWeight.Bold)
                    Text(text = "When billing overseas clients (US/UK/EU), receive funds via Wise Business, Payoneer, or direct wire with Purpose Code P0802 (Software/Business Consultancy). Always download the e-FIRA for 0% zero-rated GST export compliance.", style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                }
            }
        }

        // OUTPUT N: IMMEDIATE ACTION LIST (5 ACTIONS TODAY)
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)) {
                LuxuryGoldCard(
                    borderColor = EmeraldWealth.copy(alpha = 0.6f),
                    backgroundColor = Color(0xFF0A1820)
                ) {
                    Text(
                        text = "OUTPUT N: FIVE IMMEDIATE ACTIONS FOR TODAY",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = EmeraldWealth,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    ActionTodayItem(number = "1", title = "Identify 10 Target Operations Heads", desc = "Search LinkedIn for 'Head of Operations' or 'Dispatch Manager' in Peenya / Whitefield logistics firms.")
                    ActionTodayItem(number = "2", title = "Record a 90-Second Demo", desc = "Record a screen capture parsing a messy scanned PDF invoice into a structured Google Sheet.")
                    ActionTodayItem(number = "3", title = "Send 10 Tailored Inquiries", desc = "Use the First-Customer Playbook script with the demo link offering a free 5-sample trial.")
                    ActionTodayItem(number = "4", title = "Log Your First Commercial Experiment", desc = "Record your outreach in the Experiment Factory with a 7-day stop rule.")
                    ActionTodayItem(number = "5", title = "Protect Personal Cash Reserves", desc = "Commit zero personal savings to speculative assets; protect 100% of liquid funds for essential living costs.")
                }
            }
        }
    }
}

@Composable
fun ActionTodayItem(number: String, title: String, desc: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp), verticalAlignment = Alignment.Top) {
        Surface(
            shape = RoundedCornerShape(4.dp),
            color = EmeraldWealth.copy(alpha = 0.2f),
            modifier = Modifier.size(20.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = number, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = EmeraldWealth)
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = TextHighEmphasis)
            Text(text = desc, style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
        }
    }
}
