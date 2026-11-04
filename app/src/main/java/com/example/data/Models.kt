package com.example.data

enum class Domain(val displayName: String, val iconName: String) {
    EMPLOYMENT("1. Career & Tech Ops", "Work"),
    INDEPENDENT_SERVICES("2. B2B Services", "Handyman"),
    AI_MODELS("3. AI-Powered Models", "Psychology"),
    SOFTWARE("4. Software & Micro-SaaS", "Terminal"),
    DIGITAL_PRODUCTS("5. Digital IP & Assets", "MenuBook"),
    COMMERCE("6. Modern Commerce", "Storefront"),
    TRADITIONAL("7. Overlooked & Boring", "Build"),
    MEDIA("8. Media & Authority", "Campaign"),
    GLOBAL_TRADE("9. Global Trade & Export", "Public"),
    OWNERSHIP("10. Acquisitions & Assets", "AccountBalance")
}

enum class CapitalTier(val label: String, val maxInr: Long) {
    TIER_0("₹0 Capital", 0L),
    TIER_1K("< ₹1,000", 1_000L),
    TIER_10K("< ₹10,000", 10_000L),
    TIER_50K("< ₹50,000", 50_000L),
    TIER_1L("< ₹1 Lakh", 100_000L),
    TIER_5L("< ₹5 Lakhs", 500_000L),
    TIER_10L_PLUS("₹10 Lakhs+", 1_000_000L)
}

enum class TimeHorizon(val label: String) {
    IMMEDIATE("Immediate (1-7 Days)"),
    NEAR_TERM("30-90 Days"),
    MEDIUM_TERM("6-24 Months"),
    LONG_TERM("Multi-Year Compounding")
}

data class Opportunity(
    val id: String,
    val rank: Int = 0,
    val title: String,
    val domain: Domain,
    val summary: String,
    val targetCustomer: String,
    val economicBuyer: String,
    val coreProblem: String,
    val proposedOffer: String,
    val deliverable: String,
    val pricingHypothesis: String,
    val typicalMonthlyRevenueInr: String,
    val deliveryCostPerCustomerInr: String,
    val acquisitionMethod: String,
    val stopCriterion: String,
    val keyMoat: String,
    val capitalTier: CapitalTier,
    val timeHorizon: TimeHorizon,
    
    // Directive 006: 9-factor weighted scoring (1-10)
    val demandScore: Float,           // 20%
    val personalFitScore: Float,      // 15%
    val capitalEfficiencyScore: Float,// 15%
    val speedToValidationScore: Float,// 10%
    val profitabilityScore: Float,    // 10%
    val scalabilityScore: Float,      // 10%
    val recurringRevenueScore: Float, // 10%
    val riskScore: Float,             // 5%
    val defensibilityScore: Float     // 5%
) {
    val weightedScore: Float
        get() = (demandScore * 0.20f) +
                (personalFitScore * 0.15f) +
                (capitalEfficiencyScore * 0.15f) +
                (speedToValidationScore * 0.10f) +
                (profitabilityScore * 0.10f) +
                (scalabilityScore * 0.10f) +
                (recurringRevenueScore * 0.10f) +
                (riskScore * 0.05f) +
                (defensibilityScore * 0.05f)
}

data class OutreachTemplate(
    val channel: String,
    val subject: String,
    val body: String,
    val followupDay3: String,
    val objectionHandlingTip: String
)

data class Experiment(
    val id: String,
    val title: String,
    val targetCustomer: String,
    val hypothesis: String,
    val maxBudgetInr: Long,
    val timeLimitDays: Int,
    val testMethod: String,
    val successThreshold: String,
    val failureThreshold: String,
    val status: ExperimentStatus = ExperimentStatus.TESTING,
    val notes: String = ""
)

enum class ExperimentStatus(val label: String) {
    TESTING("In Progress"),
    VALIDATED("Validated"),
    DISPROVEN("Disproven"),
    SCALED("Scaled")
}

data class CapitalAllocationPlan(
    val tier: CapitalTier,
    val whatToStart: List<String>,
    val whatToPostpone: List<String>,
    val skillSubstitutes: String,
    val essentialSoftware: String,
    val validationBudgetInr: String,
    val emergencyReservesRule: String,
    val downsideStopRule: String
)

data class ActionPlanDay(
    val dayRange: String,
    val theme: String,
    val tasks: List<String>,
    val deliverable: String,
    val successGate: String
)

data class TwelveMonthStage(
    val stage: String,
    val title: String,
    val coreFocus: String,
    val keyMilestones: List<String>,
    val gatingCriterion: String
)

data class RiskMatrixItem(
    val riskCategory: String,
    val threatDescription: String,
    val likelihood: String, // High, Medium, Low
    val impact: String,     // Severe, Moderate, Minor
    val earlyWarning: String,
    val preventiveControl: String,
    val contingencyAction: String
)

data class LegalComplianceGuide(
    val entityType: String,
    val bestFor: String,
    val gstRules: String,
    val inwardRemittance: String,
    val contractsRequired: String,
    val taxOptimizationTip: String
)
