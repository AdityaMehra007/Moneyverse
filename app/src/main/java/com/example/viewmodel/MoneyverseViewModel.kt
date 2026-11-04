package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class FinancialSimulation(
    val clientCount: Int = 5,
    val pricePerClientInr: Long = 25_000L,
    val directCostPerClientInr: Long = 2_500L,
    val cacPerClientInr: Long = 3_500L,
    val monthlyFixedOverheadInr: Long = 8_000L
) {
    val monthlyRevenue: Long
        get() = clientCount * pricePerClientInr

    val totalDirectCosts: Long
        get() = clientCount * directCostPerClientInr

    val grossProfit: Long
        get() = monthlyRevenue - totalDirectCosts

    val grossMarginPercent: Float
        get() = if (monthlyRevenue > 0) (grossProfit.toFloat() / monthlyRevenue) * 100f else 0f

    val totalAcquisitionCost: Long
        get() = clientCount * cacPerClientInr

    val operatingProfit: Long
        get() = grossProfit - monthlyFixedOverheadInr - totalAcquisitionCost

    val breakEvenClients: Int
        get() {
            val contributionMarginPerClient = pricePerClientInr - directCostPerClientInr - cacPerClientInr
            return if (contributionMarginPerClient > 0) {
                ((monthlyFixedOverheadInr.toDouble() / contributionMarginPerClient) + 0.99).toInt()
            } else {
                -1 // Unprofitable unit economics
            }
        }
}

data class PersonalFinances(
    val monthlyIncomeInr: Long = 0L,
    val essentialLivingExpensesInr: Long = 18_000L,
    val liquidCashInr: Long = 15_000L,
    val debtObligationsInr: Long = 0L
) {
    val runwayMonths: Float
        get() = if (essentialLivingExpensesInr > 0) {
            liquidCashInr.toFloat() / essentialLivingExpensesInr.toFloat()
        } else 0f
}

data class IdeaEvaluationResult(
    val ideaName: String,
    val score: Int, // 0 - 100
    val verdict: String,
    val economicBuyer: String,
    val fatalAssumption: String,
    val cheapestValidationTest: String,
    val recommendedStopCondition: String
)

sealed interface AiCopilotState {
    data object Idle : AiCopilotState
    data object Thinking : AiCopilotState
    data class Response(val answer: String) : AiCopilotState
    data class Error(val message: String) : AiCopilotState
}

class MoneyverseViewModel : ViewModel() {

    // Opportunities & Filters
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedDomain = MutableStateFlow<Domain?>(null)
    val selectedDomain: StateFlow<Domain?> = _selectedDomain.asStateFlow()

    private val _selectedCapitalTier = MutableStateFlow<CapitalTier?>(null)
    val selectedCapitalTier: StateFlow<CapitalTier?> = _selectedCapitalTier.asStateFlow()

    private val _selectedOpportunity = MutableStateFlow<Opportunity?>(null)
    val selectedOpportunity: StateFlow<Opportunity?> = _selectedOpportunity.asStateFlow()

    // Financial Model Simulator
    private val _simulation = MutableStateFlow(FinancialSimulation())
    val simulation: StateFlow<FinancialSimulation> = _simulation.asStateFlow()

    // Personal Finances
    private val _personalFinances = MutableStateFlow(PersonalFinances())
    val personalFinances: StateFlow<PersonalFinances> = _personalFinances.asStateFlow()

    // Experiments
    private val _experiments = MutableStateFlow<List<Experiment>>(
        listOf(
            Experiment(
                id = "exp_1",
                title = "Peenya Logistics Invoice Parser Pilot",
                targetCustomer = "5 Logistics & 3PL operators in Bengaluru",
                hypothesis = "At least 2 out of 5 warehouse managers will agree to a 5-day trial if shown a 90-second video demo.",
                maxBudgetInr = 1_500L,
                timeLimitDays = 7,
                testMethod = "Personal visit + tailored Loom video outreach",
                successThreshold = "1 signed trial agreement with live test documents",
                failureThreshold = "5 rejections stating they prefer manual paper logging",
                status = ExperimentStatus.TESTING,
                notes = "Demo video created; visited 2 warehouses in Peenya on Tuesday."
            ),
            Experiment(
                id = "exp_2",
                title = "MSME Export Market Dossier Pre-Orders",
                targetCustomer = "Indian textile and spice exporters",
                hypothesis = "3 exporters will pay ₹15,000 for verified overseas customs manifest buyer contacts.",
                maxBudgetInr = 500L,
                timeLimitDays = 10,
                testMethod = "Direct email and LinkedIn outreach to FIEO members",
                successThreshold = "₹15,000 advance deposit received",
                failureThreshold = "Zero positive replies after 40 verified contacts",
                status = ExperimentStatus.TESTING,
                notes = "Drafted sample customs report format."
            )
        )
    )
    val experiments: StateFlow<List<Experiment>> = _experiments.asStateFlow()

    // Idea Evaluator
    private val _evaluationResult = MutableStateFlow<IdeaEvaluationResult?>(null)
    val evaluationResult: StateFlow<IdeaEvaluationResult?> = _evaluationResult.asStateFlow()

    // AI Copilot
    private val _copilotState = MutableStateFlow<AiCopilotState>(AiCopilotState.Idle)
    val copilotState: StateFlow<AiCopilotState> = _copilotState.asStateFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectDomain(domain: Domain?) {
        _selectedDomain.value = domain
    }

    fun selectCapitalTier(tier: CapitalTier?) {
        _selectedCapitalTier.value = tier
    }

    fun selectOpportunity(opportunity: Opportunity?) {
        _selectedOpportunity.value = opportunity
    }

    fun updateClientCount(count: Int) {
        _simulation.update { it.copy(clientCount = count.coerceAtLeast(1)) }
    }

    fun updatePricePerClient(price: Long) {
        _simulation.update { it.copy(pricePerClientInr = price.coerceAtLeast(1000L)) }
    }

    fun updateDirectCost(cost: Long) {
        _simulation.update { it.copy(directCostPerClientInr = cost.coerceAtLeast(0L)) }
    }

    fun updateCac(cac: Long) {
        _simulation.update { it.copy(cacPerClientInr = cac.coerceAtLeast(0L)) }
    }

    fun updateFixedOverhead(overhead: Long) {
        _simulation.update { it.copy(monthlyFixedOverheadInr = overhead.coerceAtLeast(0L)) }
    }

    fun updatePersonalFinances(income: Long, expenses: Long, cash: Long, debt: Long) {
        _personalFinances.value = PersonalFinances(
            monthlyIncomeInr = income,
            essentialLivingExpensesInr = expenses,
            liquidCashInr = cash,
            debtObligationsInr = debt
        )
    }

    fun addExperiment(title: String, customer: String, hypothesis: String, budget: Long, days: Int) {
        val newExp = Experiment(
            id = "exp_${System.currentTimeMillis()}",
            title = title,
            targetCustomer = customer,
            hypothesis = hypothesis,
            maxBudgetInr = budget,
            timeLimitDays = days,
            testMethod = "Direct outreach & measurable offer test",
            successThreshold = "Paid pilot or deposit received",
            failureThreshold = "Stop rule reached with zero willingness to pay",
            status = ExperimentStatus.TESTING
        )
        _experiments.update { listOf(newExp) + it }
    }

    fun updateExperimentStatus(id: String, newStatus: ExperimentStatus) {
        _experiments.update { list ->
            list.map { if (it.id == id) it.copy(status = newStatus) else it }
        }
    }

    fun evaluateIdea(ideaTitle: String, problem: String, targetAudience: String) {
        // High-conviction heuristic evaluation based on Directive 005 (Ruthless Filter)
        val titleLower = ideaTitle.lowercase()
        val problemLower = problem.lowercase()
        val targetLower = targetAudience.lowercase()

        val isB2B = targetLower.contains("b2b") || targetLower.contains("business") || targetLower.contains("company") || targetLower.contains("director") || targetLower.contains("firm") || targetLower.contains("clinic")
        val solvesCostOrTime = problemLower.contains("hour") || problemLower.contains("cost") || problemLower.contains("delay") || problemLower.contains("error") || problemLower.contains("manual") || problemLower.contains("save")
        val clearBudget = isB2B

        var score = 55
        if (isB2B) score += 20
        if (solvesCostOrTime) score += 15
        if (titleLower.contains("ai") || titleLower.contains("auto")) score += 5
        score = score.coerceIn(30, 96)

        val verdict = when {
            score >= 80 -> "HIGH-CONVICTION COMMERCIAL POTENTIAL. The problem directly impacts business efficiency and budget holders can measure ROI within 30 days."
            score >= 60 -> "VIABLE BUT REQUIRES SHARPENING. Ensure your economic buyer has discretionary budget authority without requiring 6-month enterprise committee approval."
            else -> "HIGH RISK / VAGUE VALUE CAPTURE. Problem appears discretionary or targets non-paying consumers. Pivot to a specific B2B workflow bottleneck."
        }

        val buyer = if (isB2B) "Managing Director, COO, or Department Head with P&L authority" else "Individual consumer (Low willingness to pay)"
        val fatalAssumption = "Assuming customer interest in a demo equates to willingness to sign a contract and clear an invoice."
        val cheapestTest = "Draft a 1-page sample deliverable and contact 10 prospective buyers on LinkedIn offering a free 24-hour audit. Measure reply rate."
        val stopCondition = "If 20 qualified prospects view the offer and none ask 'How much does it cost?', immediately abandon or reframe."

        _evaluationResult.value = IdeaEvaluationResult(
            ideaName = ideaTitle,
            score = score,
            verdict = verdict,
            economicBuyer = buyer,
            fatalAssumption = fatalAssumption,
            cheapestValidationTest = cheapestTest,
            recommendedStopCondition = stopCondition
        )
    }

    fun askCopilot(query: String) {
        viewModelScope.launch {
            _copilotState.value = AiCopilotState.Thinking
            
            // Generate structured, commercial reality response adhering to MONEYVERSE ∞ Directives
            val queryClean = query.trim()
            val responseText = buildString {
                append("### MONEYVERSE ∞ EXECUTIVE DIRECTIVE\n\n")
                append("**Query Analysis:** \"$queryClean\"\n\n")
                
                append("**1. Commercial Reality Check:**\n")
                append("• Evidence outranks excitement. In India (especially starting in Bengaluru), cash flow velocity beats theoretical venture scale.\n")
                append("• Immediate focus should be B2B Workflow Automation or Cross-Border Trade Intelligence where gross margins exceed 80% and setup costs are ₹0.\n\n")
                
                append("**2. Unit Economics & Pricing Model:**\n")
                append("• Never charge by the hour; charge for the outcome.\n")
                append("• Anchor pricing on money saved: e.g. saving an Indian logistics firm 15 employee hours/week (worth ~₹30,000/mo) justifies a ₹15,000/mo retainer effortlessly.\n\n")
                
                append("**3. The Immediate 48-Hour Next Step:**\n")
                append("1. Find 10 target operations heads in Bengaluru on LinkedIn.\n")
                append("2. Send a 90-second Loom recording showing automated document parsing into Google Sheets.\n")
                append("3. Offer a free 5-sample trial. If they don't reply, stop and iterate the hook.\n\n")
                
                append("**4. Fatal Risk to Guard Against:**\n")
                append("• Sunk cost fallacy: Do not build an app or write code for 3 months before a paying client commits to a deposit.")
            }

            kotlinx.coroutines.delay(600) // Smooth visual transition
            _copilotState.value = AiCopilotState.Response(responseText)
        }
    }
}
