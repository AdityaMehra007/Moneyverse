package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Experiment
import com.example.data.ExperimentStatus
import com.example.data.OpportunityRepository
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.MoneyverseViewModel

@Composable
fun EmpireLabScreen(
    viewModel: MoneyverseViewModel,
    modifier: Modifier = Modifier
) {
    val experiments by viewModel.experiments.collectAsState()
    val evaluationResult by viewModel.evaluationResult.collectAsState()
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    var ideaInput by remember { mutableStateOf("") }
    var problemInput by remember { mutableStateOf("") }
    var buyerInput by remember { mutableStateOf("") }
    var showNewExperimentDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("empire_lab_list"),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {
            LuxuryHeader(
                title = "EMPIRE LAB",
                subtitle = "First-Customer Playbook, Idea Stress-Tester & Experiment Factory"
            )
        }

        // OUTPUT D: FIRST CUSTOMER PLAYBOOK (DIRECTIVE 008)
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Send,
                                contentDescription = "Playbook",
                                tint = ImperialGoldPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "FIRST-CUSTOMER PLAYBOOK",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = ImperialGoldPrimary,
                                letterSpacing = 1.sp
                            )
                        }

                        IconButton(
                            onClick = {
                                clipboardManager.setText(AnnotatedString(OpportunityRepository.samplePlaybook.body))
                                Toast.makeText(context, "Outreach script copied to clipboard", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(Icons.Default.ContentCopy, contentDescription = "Copy Script", tint = ImperialGoldPrimary)
                        }
                    }

                    Text(
                        text = "Target: ${OpportunityRepository.samplePlaybook.channel}",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextLowEmphasis
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = LuxurySurfaceElevated,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "Subject: ${OpportunityRepository.samplePlaybook.subject}",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = ChampagneAccent
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = OpportunityRepository.samplePlaybook.body,
                                style = MaterialTheme.typography.bodySmall,
                                color = TextMediumEmphasis,
                                lineHeight = 18.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Objection Handling
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = AmberCaution.copy(alpha = 0.12f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, AmberCaution.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
                            Icon(Icons.Default.TipsAndUpdates, contentDescription = "Objection Tip", tint = AmberCaution, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = OpportunityRepository.samplePlaybook.objectionHandlingTip,
                                style = MaterialTheme.typography.bodySmall,
                                color = TextHighEmphasis
                            )
                        }
                    }
                }
            }
        }

        // DIRECTIVE 005: RUTHLESS 20-POINT IDEA STRESS-TESTER
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Text(
                    text = "RUTHLESS 20-POINT IDEA STRESS-TESTER",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextHighEmphasis
                )
                Text(
                    text = "Filter unvalidated excitement against real commercial willingness to pay",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextLowEmphasis
                )

                Spacer(modifier = Modifier.height(12.dp))

                LuxuryGoldCard {
                    OutlinedTextField(
                        value = ideaInput,
                        onValueChange = { ideaInput = it },
                        label = { Text("Business / Product Idea Name") },
                        placeholder = { Text("e.g. AI Invoice Parser for Logistics") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("tester_idea_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ImperialGoldPrimary,
                            unfocusedBorderColor = LuxuryCardBorderSubtle,
                            focusedTextColor = TextHighEmphasis,
                            unfocusedTextColor = TextHighEmphasis
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = problemInput,
                        onValueChange = { problemInput = it },
                        label = { Text("Exact Expensive Problem Solved") },
                        placeholder = { Text("e.g. Staff wastes 4 hours daily copying PDF invoices") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("tester_problem_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ImperialGoldPrimary,
                            unfocusedBorderColor = LuxuryCardBorderSubtle,
                            focusedTextColor = TextHighEmphasis,
                            unfocusedTextColor = TextHighEmphasis
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = buyerInput,
                        onValueChange = { buyerInput = it },
                        label = { Text("Specific Economic Buyer (Who has budget?)") },
                        placeholder = { Text("e.g. Logistics Operations Director in Bengaluru") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("tester_buyer_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ImperialGoldPrimary,
                            unfocusedBorderColor = LuxuryCardBorderSubtle,
                            focusedTextColor = TextHighEmphasis,
                            unfocusedTextColor = TextHighEmphasis
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = {
                            if (ideaInput.isNotBlank()) {
                                viewModel.evaluateIdea(ideaInput, problemInput, buyerInput)
                            } else {
                                Toast.makeText(context, "Please enter an idea title", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("stress_test_button"),
                        colors = ButtonDefaults.buttonColors(containerColor = ImperialGoldPrimary)
                    ) {
                        Icon(Icons.Default.Speed, contentDescription = "Run Test", tint = Color(0xFF0F172A))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("RUN COMMERCIAL STRESS TEST", color = Color(0xFF0F172A), fontWeight = FontWeight.Bold)
                    }

                    // Display Result
                    if (evaluationResult != null) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider(color = LuxuryCardBorderSubtle)
                        Spacer(modifier = Modifier.height(12.dp))

                        val res = evaluationResult!!
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "COMMERCIAL VIABILITY SCORE",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = ImperialGoldPrimary
                            )
                            Text(
                                text = "${res.score}/100",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Black,
                                color = if (res.score >= 80) EmeraldWealth else if (res.score >= 60) AmberCaution else CrimsonRisk
                            )
                        }

                        ScoreProgressBar(
                            score = res.score.toFloat(),
                            maxScore = 100f,
                            label = "Viability Index",
                            barColor = if (res.score >= 80) EmeraldWealth else if (res.score >= 60) AmberCaution else CrimsonRisk
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = res.verdict, style = MaterialTheme.typography.bodyMedium, color = TextHighEmphasis, fontWeight = FontWeight.Medium)

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "FATAL ASSUMPTION TO VERIFY:", style = MaterialTheme.typography.labelSmall, color = CrimsonRisk, fontWeight = FontWeight.Bold)
                        Text(text = res.fatalAssumption, style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "CHEAPEST MEANINGFUL VALIDATION TEST:", style = MaterialTheme.typography.labelSmall, color = SapphireTech, fontWeight = FontWeight.Bold)
                        Text(text = res.cheapestValidationTest, style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "RATIONAL STOP CRITERION:", style = MaterialTheme.typography.labelSmall, color = AmberCaution, fontWeight = FontWeight.Bold)
                        Text(text = res.recommendedStopCondition, style = MaterialTheme.typography.bodySmall, color = TextMediumEmphasis)
                    }
                }
            }
        }

        // DIRECTIVE 023: THE MONEY-MAKING EXPERIMENT FACTORY
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "THE EXPERIMENT FACTORY",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextHighEmphasis
                        )
                        Text(
                            text = "Hypothesis → Test → Measure → Decide",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextLowEmphasis
                        )
                    }

                    IconButton(
                        onClick = { showNewExperimentDialog = true },
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(ImperialGoldPrimary)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Experiment", tint = Color(0xFF0F172A))
                    }
                }
            }
        }

        items(experiments) { exp ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                ExperimentCard(
                    experiment = exp,
                    onStatusChange = { newStatus -> viewModel.updateExperimentStatus(exp.id, newStatus) }
                )
            }
        }
    }

    // New Experiment Dialog
    if (showNewExperimentDialog) {
        NewExperimentDialog(
            onDismiss = { showNewExperimentDialog = false },
            onConfirm = { title, customer, hypothesis, budget, days ->
                viewModel.addExperiment(title, customer, hypothesis, budget, days)
                showNewExperimentDialog = false
            }
        )
    }
}

@Composable
fun ExperimentCard(
    experiment: Experiment,
    onStatusChange: (ExperimentStatus) -> Unit
) {
    LuxuryGoldCard(
        borderColor = when (experiment.status) {
            ExperimentStatus.VALIDATED -> EmeraldWealth.copy(alpha = 0.5f)
            ExperimentStatus.DISPROVEN -> CrimsonRisk.copy(alpha = 0.5f)
            else -> LuxuryCardBorderSubtle
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = experiment.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = TextHighEmphasis
            )

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = when (experiment.status) {
                    ExperimentStatus.VALIDATED -> EmeraldWealth.copy(alpha = 0.2f)
                    ExperimentStatus.DISPROVEN -> CrimsonRisk.copy(alpha = 0.2f)
                    ExperimentStatus.SCALED -> SapphireTech.copy(alpha = 0.2f)
                    else -> ImperialGoldPrimary.copy(alpha = 0.15f)
                }
            ) {
                Text(
                    text = experiment.status.label,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = when (experiment.status) {
                        ExperimentStatus.VALIDATED -> EmeraldWealth
                        ExperimentStatus.DISPROVEN -> CrimsonRisk
                        ExperimentStatus.SCALED -> SapphireTech
                        else -> ImperialGoldPrimary
                    },
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Hypothesis: ${experiment.hypothesis}",
            style = MaterialTheme.typography.bodySmall,
            color = TextMediumEmphasis
        )

        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Target: ${experiment.targetCustomer}",
                style = MaterialTheme.typography.labelSmall,
                color = TextLowEmphasis
            )
            Text(
                text = "Cap: ₹${experiment.maxBudgetInr} | ${experiment.timeLimitDays} Days",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = EmeraldWealth
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Status Switcher
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            OutlinedButton(
                onClick = { onStatusChange(ExperimentStatus.VALIDATED) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = EmeraldWealth)
            ) {
                Text("Validate", fontSize = 11.sp)
            }
            OutlinedButton(
                onClick = { onStatusChange(ExperimentStatus.DISPROVEN) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = CrimsonRisk)
            ) {
                Text("Disprove", fontSize = 11.sp)
            }
            OutlinedButton(
                onClick = { onStatusChange(ExperimentStatus.SCALED) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = SapphireTech)
            ) {
                Text("Scale", fontSize = 11.sp)
            }
        }
    }
}

@Composable
fun NewExperimentDialog(
    onDismiss: () -> Unit,
    onConfirm: (title: String, customer: String, hypothesis: String, budget: Long, days: Int) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var customer by remember { mutableStateOf("") }
    var hypothesis by remember { mutableStateOf("") }
    var budgetStr by remember { mutableStateOf("1000") }
    var daysStr by remember { mutableStateOf("7") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Launch New Commercial Experiment", color = ImperialGoldPrimary, fontWeight = FontWeight.Bold)
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Experiment Title") },
                    placeholder = { Text("e.g. Cold Outreach to 20 Importers") },
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ImperialGoldPrimary)
                )
                OutlinedTextField(
                    value = customer,
                    onValueChange = { customer = it },
                    label = { Text("Target Customer Profile") },
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ImperialGoldPrimary)
                )
                OutlinedTextField(
                    value = hypothesis,
                    onValueChange = { hypothesis = it },
                    label = { Text("Testable Commercial Hypothesis") },
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ImperialGoldPrimary)
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = budgetStr,
                        onValueChange = { budgetStr = it },
                        label = { Text("Max Budget (₹)") },
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ImperialGoldPrimary)
                    )
                    OutlinedTextField(
                        value = daysStr,
                        onValueChange = { daysStr = it },
                        label = { Text("Time Limit (Days)") },
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ImperialGoldPrimary)
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val budget = budgetStr.toLongOrNull() ?: 1000L
                    val days = daysStr.toIntOrNull() ?: 7
                    if (title.isNotBlank() && hypothesis.isNotBlank()) {
                        onConfirm(title, customer, hypothesis, budget, days)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = ImperialGoldPrimary)
            ) {
                Text("DEPLOY EXPERIMENT", color = Color(0xFF0F172A), fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = TextMediumEmphasis)
            }
        },
        containerColor = LuxurySurface,
        shape = RoundedCornerShape(16.dp)
    )
}
