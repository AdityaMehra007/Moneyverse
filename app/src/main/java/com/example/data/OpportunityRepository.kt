package com.example.data

object OpportunityRepository {

    val allOpportunities: List<Opportunity> = listOf(
        // TOP 1 - PRIMARY PATH (Domain 3: AI-Powered Business Models)
        Opportunity(
            id = "ai_b2b_workflow",
            rank = 1,
            title = "B2B AI Workflow Automation & SOP Digitization",
            domain = Domain.AI_MODELS,
            summary = "Audit fragmented manual spreadsheets/PDF workflows in mid-sized Indian logistics, manufacturing & export firms and replace them with automated AI ingestion & reporting pipelines.",
            targetCustomer = "Mid-sized logistics, export houses, and distributor firms in Bengaluru / Peenya / Whitefield with 15-80 employees.",
            economicBuyer = "Managing Director, Chief Operating Officer, or Founder.",
            coreProblem = "Employees spend 3-5 hours daily copying dispatch data, GST invoices, and bills of lading between emails, paper documents, and legacy ERPs, causing shipping delays and billing errors.",
            proposedOffer = "Turnkey 'Automated Dispatch & Invoice Parser' delivered in 5 days; ₹35,000 one-time setup + ₹15,000/mo ongoing monitoring and maintenance.",
            deliverable = "Cloud-hosted optical parser + Make.com/Python webhook pipeline syncing scanned invoices to WhatsApp and Google Sheets / Tally.",
            pricingHypothesis = "₹35,000 setup + ₹15,000/mo retainer (Target: 5 clients = ₹75,000/mo recurring).",
            typicalMonthlyRevenueInr = "₹75,000 - ₹2,00,000",
            deliveryCostPerCustomerInr = "₹1,800/mo (API tokens + webhook tier)",
            acquisitionMethod = "Personal visits to industrial estates (Peenya, Bommasandra) + LinkedIn outreach to Operations Directors + free 1-hour workflow audit.",
            stopCriterion = "If 25 verified operations heads refuse a free audit or report no cost savings after reviewing a 2-minute video demo.",
            keyMoat = "Deep domain understanding of Indian GST compliance, local distributor jargon, and proprietary prompt templates.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.5f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 9.5f,
            speedToValidationScore = 9.0f,
            profitabilityScore = 9.0f,
            scalabilityScore = 8.5f,
            recurringRevenueScore = 9.0f,
            riskScore = 8.0f,
            defensibilityScore = 7.5f
        ),

        // TOP 2 (Domain 2: Independent Services)
        Opportunity(
            id = "biz_research_crossborder",
            rank = 2,
            title = "Cross-Border Market Mapping & Supplier Discovery",
            domain = Domain.INDEPENDENT_SERVICES,
            summary = "Provide actionable overseas buyer & vetted supplier intelligence for Indian exporters expanding to GCC, Southeast Asia, and Europe.",
            targetCustomer = "Indian MSME exporters (textiles, spices, precision machinery, packaging).",
            economicBuyer = "Export Director, Business Development VP, or Sole Proprietor.",
            coreProblem = "Exporters rely on generic spam directories (Indiamart/Alibaba) full of low-intent brokers; lack vetted customs data and direct decision-maker emails.",
            proposedOffer = "A custom 25-page 'Target Market dossier': 50 verified active importers with customs manifest history, verified WhatsApp/LinkedIn of import managers, and tariff analysis.",
            deliverable = "Structured Google Sheet + executive PDF briefing deck delivered in 7 days.",
            pricingHypothesis = "₹25,000 per market dossier; ₹45,000 for 2 countries.",
            typicalMonthlyRevenueInr = "₹50,000 - ₹1,50,000",
            deliveryCostPerCustomerInr = "₹2,500 (Trade database access credits)",
            acquisitionMethod = "Cold email outreach to Federation of Indian Export Organisations (FIEO) directory members + Chamber of Commerce event networking.",
            stopCriterion = "If 40 contacted export directors state they only use personal referrals and won't review sample customs records.",
            keyMoat = "BBA International Business analytical rigor, custom tariff intelligence, and verified verified-delivery methodology.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.0f,
            personalFitScore = 9.5f,
            capitalEfficiencyScore = 9.5f,
            speedToValidationScore = 8.5f,
            profitabilityScore = 8.5f,
            scalabilityScore = 7.5f,
            recurringRevenueScore = 7.5f,
            riskScore = 8.5f,
            defensibilityScore = 8.0f
        ),

        // TOP 3 (Domain 1: Corporate & Professional Income)
        Opportunity(
            id = "corp_ai_operations_lead",
            rank = 3,
            title = "Technology & AI Operations Specialist (Bengaluru)",
            domain = Domain.EMPLOYMENT,
            summary = "High-growth corporate entry route: Orchestrate internal AI tooling, business analytics, and process workflows inside tech-enabled enterprises in Bengaluru.",
            targetCustomer = "Tier-1/Tier-2 GCCs (Global Capability Centers), tech startups, and management consulting firms in Bengaluru.",
            economicBuyer = "Hiring Manager (Head of Operations / Chief of Staff).",
            coreProblem = "Companies have purchased enterprise AI licenses (Copilot, Gemini) but business teams lack the bridge between raw models and daily operational workflows.",
            proposedOffer = "Proven operational competence: workflow automation portfolio, prompt engineering, SQL/BI dashboards, and international trade compliance acumen.",
            deliverable = "Full-time salary + benefits + elite corporate network + exposure to high-scale enterprise systems.",
            pricingHypothesis = "Starting CTC: ₹5.5 LPA - ₹9 LPA (₹45,000 - ₹75,000/mo base cash flow).",
            typicalMonthlyRevenueInr = "₹55,000 - ₹85,000 (Guaranteed Salary)",
            deliveryCostPerCustomerInr = "₹0 (Employee)",
            acquisitionMethod = "Direct outreach to Talent Acquisition & Founders via LinkedIn + tailored video portfolio demonstrating 3 live automated workflow prototypes.",
            stopCriterion = "If 50 targeted applications and 15 informational interviews yield zero first-round calls (trigger resume/portfolio rewrite).",
            keyMoat = "BBA International Business degree + demonstrated AI integration skills (rare combination).",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.5f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 10.0f,
            speedToValidationScore = 8.0f,
            profitabilityScore = 8.0f,
            scalabilityScore = 7.0f,
            recurringRevenueScore = 10.0f,
            riskScore = 9.0f,
            defensibilityScore = 7.0f
        ),

        // TOP 4 (Domain 4: Software, Apps & Infrastructure)
        Opportunity(
            id = "microsaas_gst_einv_notifier",
            rank = 4,
            title = "WhatsApp E-Way Bill & GST Reconciler Micro-SaaS",
            domain = Domain.SOFTWARE,
            summary = "A lightweight multi-tenant SaaS that alerts warehouse logistics heads when E-Way bills expire and auto-flags GSTIN vendor return mismatches.",
            targetCustomer = "Indian third-party logistics (3PL) providers and FMCG stockists.",
            economicBuyer = "CFO / Head of Supply Chain.",
            coreProblem = "Expired E-Way bills during transit result in 100% tax penalties and truck impoundment by GST state squads, costing ₹50,000+ per incident.",
            proposedOffer = "Automated WhatsApp & SMS expiration warnings 4 hours, 2 hours, and 30 mins before expiry with one-click extension.",
            deliverable = "Cloud micro-SaaS with WhatsApp Business Cloud API integration + simple web dashboard.",
            pricingHypothesis = "₹2,999/mo per warehouse or ₹0.50 per monitored consignment.",
            typicalMonthlyRevenueInr = "₹60,000 - ₹3,00,000 (20-100 subscribers)",
            deliveryCostPerCustomerInr = "₹200/mo (WhatsApp notification API costs)",
            acquisitionMethod = "Partnerships with local Tally accounting software dealers and transport associations in Yeshwantpur/Kalasipalyam.",
            stopCriterion = "Failure to acquire 3 paying pilot warehouses after demonstrating the ROI of preventing a single ₹50,000 penalty.",
            keyMoat = "Deep integration into the Indian GSTN portal API and local transport operational habits.",
            capitalTier = CapitalTier.TIER_10K,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.5f,
            personalFitScore = 8.5f,
            capitalEfficiencyScore = 8.5f,
            speedToValidationScore = 7.5f,
            profitabilityScore = 9.5f,
            scalabilityScore = 9.5f,
            recurringRevenueScore = 9.5f,
            riskScore = 7.5f,
            defensibilityScore = 8.5f
        ),

        // TOP 5 (Domain 2: Independent Services)
        Opportunity(
            id = "spreadsheet_dashboard_bi",
            rank = 5,
            title = "Executive Spreadsheet Automation & Looker Studio BI",
            domain = Domain.INDEPENDENT_SERVICES,
            summary = "Transform messy multi-branch business data into automated executive dashboards with zero ongoing SaaS fees for the client.",
            targetCustomer = "Regional retail chains, multi-location dental/medical clinics, and franchise operators in Karnataka.",
            economicBuyer = "Owner, Managing Partner, or Finance Head.",
            coreProblem = "Founders flying blind; take 10-15 days after month-end to understand branch-wise profitability, cash leaks, and dead stock.",
            proposedOffer = "Live executive KPI dashboard connected to existing Google Sheets / Excel / Tally exports. Real-time daily P&L and sales velocity on mobile.",
            deliverable = "Clean Google Looker Studio dashboard + automated AppSheet or Google Apps Script data pipeline.",
            pricingHypothesis = "₹30,000 per dashboard build + ₹8,000/mo support & monthly data audit.",
            typicalMonthlyRevenueInr = "₹60,000 - ₹1,40,000",
            deliveryCostPerCustomerInr = "₹500 (Storage/Cloud utilities)",
            acquisitionMethod = "Audit a founder's sample anonymized sheet in 24 hours and send a 90-second Loom showing instant revenue leaks.",
            stopCriterion = "If 15 business owners view the custom Loom demo and none express interest in seeing their real figures visualized.",
            keyMoat = "Business analysis capability from International Business degree + bespoke visual UI polish.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.0f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 9.5f,
            speedToValidationScore = 9.0f,
            profitabilityScore = 8.0f,
            scalabilityScore = 7.0f,
            recurringRevenueScore = 8.0f,
            riskScore = 8.5f,
            defensibilityScore = 7.0f
        ),

        // TOP 6 (Domain 7: Overlooked & Traditional Businesses)
        Opportunity(
            id = "b2b_industrial_packaging_brokerage",
            rank = 6,
            title = "B2B Corrugated & Eco-Packaging Procurement Brokerage",
            domain = Domain.TRADITIONAL,
            summary = "Contract supply brokerage connecting e-commerce D2C brands with unorganized industrial box manufacturers for 15-20% lower costs.",
            targetCustomer = "D2C brands and e-commerce sellers shipping 2,000 - 20,000 parcels/month.",
            economicBuyer = "Procurement Manager or Founder.",
            coreProblem = "D2C brands overpay retail rates for custom corrugated boxes and tape because big packaging converters only service giant conglomerates.",
            proposedOffer = "Guaranteed 12% reduction in bulk packaging expenses + guaranteed 48-hour delivery buffer stock.",
            deliverable = "Reliable supply contract; you manage quality inspection and batch ordering.",
            pricingHypothesis = "7-12% commission on monthly packaging spend (e.g. ₹3L spend = ₹25,000 monthly margin per client).",
            typicalMonthlyRevenueInr = "₹50,000 - ₹2,50,000",
            deliveryCostPerCustomerInr = "₹1,000 (Sample transport & QA visits)",
            acquisitionMethod = "Direct outreach to D2C founders via Instagram DM and Bengaluru D2C meetups; review their current box invoice.",
            stopCriterion = "Inability to find a manufacturer capable of beating current client quotes by at least 10% on identical GSM specs.",
            keyMoat = "Strong supplier relationships across manufacturing belts in Hosur and Rajajinagar.",
            capitalTier = CapitalTier.TIER_1K,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.5f,
            personalFitScore = 8.0f,
            capitalEfficiencyScore = 9.0f,
            speedToValidationScore = 8.0f,
            profitabilityScore = 8.5f,
            scalabilityScore = 8.0f,
            recurringRevenueScore = 9.0f,
            riskScore = 8.0f,
            defensibilityScore = 7.5f
        ),

        // TOP 7 (Domain 5: Digital Products & IP)
        Opportunity(
            id = "ip_crossborder_trade_playbooks",
            rank = 7,
            title = "Global Export Compliance & SOP Toolkit for MSMEs",
            domain = Domain.DIGITAL_PRODUCTS,
            summary = "Ready-to-use digital templates, legal contracts, bill of lading checklists, and customs compliance systems for new exporters.",
            targetCustomer = "First-time exporters, business students, and trading houses across India and South Asia.",
            economicBuyer = "Solo entrepreneurs and SME business owners.",
            coreProblem = "Hiring an export consultant costs ₹1,00,000+; amateur mistakes in Letters of Credit (LC) result in blocked consignments and bank penalties.",
            proposedOffer = "The Complete India-to-World Export Operating System: 45 editable contract templates, Incoterms 2020 calculator, and bank LC checklist.",
            deliverable = "Notion database + downloadable Excel / Word legal templates with step-by-step video walkthrough.",
            pricingHypothesis = "₹1,999 one-time download; ₹4,999 with 30-day email Q&A support.",
            typicalMonthlyRevenueInr = "₹40,000 - ₹1,20,000 (20-60 sales/month)",
            deliveryCostPerCustomerInr = "₹50 (Payment gateway + file hosting fees)",
            acquisitionMethod = "Educational LinkedIn carousels deconstructing real export fraud cases + YouTube tutorials on DGFT and ICEGATE filings.",
            stopCriterion = "Less than 5 sales after generating 1,000 targeted website visits from educational content.",
            keyMoat = "Accurate, legally sound, curated domain knowledge distilled from real International Business curricula and practitioner interviews.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.0f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 10.0f,
            speedToValidationScore = 8.5f,
            profitabilityScore = 9.5f,
            scalabilityScore = 9.5f,
            recurringRevenueScore = 6.0f,
            riskScore = 9.0f,
            defensibilityScore = 7.0f
        ),

        // TOP 8 (Domain 8: Media & Authority)
        Opportunity(
            id = "media_india_supplychain_intel",
            rank = 8,
            title = "India Sourcing & 'China+1' Supply Chain Intelligence",
            domain = Domain.MEDIA,
            summary = "A niche high-authority weekly executive intelligence briefing for Western procurement officers looking to manufacture in India.",
            targetCustomer = "Procurement directors, Amazon aggregators, and hardware startup founders in US, UK, and Germany.",
            economicBuyer = "Corporate Procurement Executive or Private Equity Operations partner.",
            coreProblem = "Western buyers want to diversify out of China into India but find Indian factory landscapes opaque, fragmented, and slow to navigate.",
            proposedOffer = "Bimonthly in-depth deep-dive: verified factory capacity reviews, cluster maps (e.g. Coimbatore castings, Tirupur apparel), and regulatory shifts.",
            deliverable = "Substack / Beehiiv paid newsletter + private directory of vetted manufacturers.",
            pricingHypothesis = "$49/month ($490/year) per corporate subscriber; sponsored industry slots at $500/edition.",
            typicalMonthlyRevenueInr = "₹60,000 - ₹3,50,000 (30-100 subscribers)",
            deliveryCostPerCustomerInr = "₹100 (Platform fees)",
            acquisitionMethod = "Publish high-signal breakdowns on LinkedIn/Twitter; participate in global sourcing Reddit/Hacker News discussions.",
            stopCriterion = "Failure to achieve 500 free corporate subscribers within 90 days of consistent publishing.",
            keyMoat = "On-the-ground physical presence in India + fluent English international business communication.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 8.0f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 9.5f,
            speedToValidationScore = 6.5f,
            profitabilityScore = 9.0f,
            scalabilityScore = 9.0f,
            recurringRevenueScore = 9.5f,
            riskScore = 8.0f,
            defensibilityScore = 8.5f
        ),

        // TOP 9 (Domain 9: Global Trade & Export)
        Opportunity(
            id = "global_remote_bizops_retainer",
            rank = 9,
            title = "Cross-Border Fractional Business Operations Partner",
            domain = Domain.GLOBAL_TRADE,
            summary = "Remote business operations, vendor liaison, and spreadsheet modeling for US/UK service agencies and boutique consultancies.",
            targetCustomer = "Boutique marketing, design, and software agencies in US, UK, Canada, Australia (10-30 staff).",
            economicBuyer = "Agency Founder / Operations Director.",
            coreProblem = "Western agency owners are drowned in project coordination, timesheet reconciliation, and invoice chasing, but local ops hires cost $60,000+/year.",
            proposedOffer = "20 hours/week dedicated high-caliber operations architecture: project management updates, client reporting, and dashboard maintenance.",
            deliverable = "Ongoing remote operational coverage on Slack / Asana / Notion during client business hours overlap.",
            pricingHypothesis = "$1,000 - $1,800/month (₹85,000 - ₹1,50,000/mo) per agency.",
            typicalMonthlyRevenueInr = "₹1,50,000 - ₹3,00,000 (2 clients)",
            deliveryCostPerCustomerInr = "₹2,000 (High-speed internet, Zoom, project tools)",
            acquisitionMethod = "Cold Loom video audits targeting agency founders on LinkedIn highlighting broken booking links, slow responses, or outdated case studies.",
            stopCriterion = "Sending 60 personalized video audits with zero replies or discovery calls scheduled.",
            keyMoat = "Elite asynchronous communication, timezone arbitrage, and high-trust business acumen.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.0f,
            personalFitScore = 9.0f,
            capitalEfficiencyScore = 9.5f,
            speedToValidationScore = 8.0f,
            profitabilityScore = 9.0f,
            scalabilityScore = 6.5f,
            recurringRevenueScore = 9.5f,
            riskScore = 8.0f,
            defensibilityScore = 7.5f
        ),

        // TOP 10 (Domain 10: Acquisitions & Ownership)
        Opportunity(
            id = "micro_acquisition_revenue_share",
            rank = 10,
            title = "Sweat-Equity Growth & Profit-Share in Stagnant MSMEs",
            domain = Domain.OWNERSHIP,
            summary = "Partner with an established traditional business owner (e.g., regional industrial distributor) to modernize their digital sales in exchange for 15-25% of new revenue.",
            targetCustomer = "Profitable, family-run B2B suppliers in Karnataka with retiring founders and zero online presence.",
            economicBuyer = "Sole Owner / Patriarch.",
            coreProblem = "Business has solid products and offline relationships but is losing ground to digital-native competitors; founder does not know how to run digital acquisition.",
            proposedOffer = "Zero upfront cash needed from founder: you rebuild the digital catalog, launch inbound B2B lead generation, and automate invoicing for a 20% cut of net new gross profit.",
            deliverable = "Contracted profit-share agreement with audited monthly accounts.",
            pricingHypothesis = "15-25% of incremental revenue generated (typically ₹40,000 - ₹1,50,000/mo after 90 days).",
            typicalMonthlyRevenueInr = "₹75,000 - ₹3,00,000",
            deliveryCostPerCustomerInr = "₹5,000 (Ad test budget or software)",
            acquisitionMethod = "In-person meetings through alumni networks, Rotary/Lions clubs, and trade association gatherings.",
            stopCriterion = "Failure to negotiate clear access to sales data or unwillingness of owner to sign a legally binding profit-share agreement.",
            keyMoat = "Combines modern software/marketing capability with respect for traditional commercial reality.",
            capitalTier = CapitalTier.TIER_10K,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 7.5f,
            personalFitScore = 8.5f,
            capitalEfficiencyScore = 8.5f,
            speedToValidationScore = 6.5f,
            profitabilityScore = 9.0f,
            scalabilityScore = 8.5f,
            recurringRevenueScore = 8.5f,
            riskScore = 7.0f,
            defensibilityScore = 8.5f
        ),

        // 40+ ADDITIONAL EXTENDED OPPORTUNITIES ACROSS ALL 10 DOMAINS
        // Domain 1: Employment & Professional Income
        Opportunity(
            id = "corp_bi_analyst",
            title = "Business Intelligence & Revenue Operations Analyst",
            domain = Domain.EMPLOYMENT,
            summary = "Synthesize multi-channel revenue data into PowerBI/Tableau dashboards for retail and fintech startups in Bengaluru.",
            targetCustomer = "Series A/B tech startups and mid-market IT services firms.",
            economicBuyer = "Director of Financial Planning & Analysis (FP&A).",
            coreProblem = "Executive management lacks unified pipeline velocity reports.",
            proposedOffer = "Certified SQL + PowerBI portfolio with financial modeling capabilities.",
            deliverable = "Full-time position (₹4.5 - ₹8 LPA).",
            pricingHypothesis = "₹38,000 - ₹65,000/mo salary.",
            typicalMonthlyRevenueInr = "₹50,000 (Fixed)",
            deliveryCostPerCustomerInr = "₹0",
            acquisitionMethod = "Naukri, LinkedIn, and direct referral via startup events in Koramangala.",
            stopCriterion = "Zero responses after 40 direct applications with custom dashboard attachments.",
            keyMoat = "Blend of accounting fundamentals and modern analytics tools.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 9.0f, personalFitScore = 8.5f, capitalEfficiencyScore = 10f, speedToValidationScore = 8f, profitabilityScore = 7.5f, scalabilityScore = 6.5f, recurringRevenueScore = 10f, riskScore = 9f, defensibilityScore = 7f
        ),
        Opportunity(
            id = "corp_supply_chain_coordinator",
            title = "Global Supply Chain & Logistics Coordinator",
            domain = Domain.EMPLOYMENT,
            summary = "Coordinate customs clearance, container tracking, and freight forwarding for e-commerce or manufacturing conglomerates.",
            targetCustomer = "Multinational shipping lines (Maersk, DB Schenker) and electronics manufacturers.",
            economicBuyer = "Logistics Manager.",
            coreProblem = "Port delays and documentation discrepancies cause demurrage charges.",
            proposedOffer = "BBA International Business graduate with customs tariff knowledge.",
            deliverable = "Full-time employment (₹4.0 - ₹7 LPA).",
            pricingHypothesis = "₹35,000 - ₹58,000/mo salary.",
            typicalMonthlyRevenueInr = "₹45,000 (Fixed)",
            deliveryCostPerCustomerInr = "₹0",
            acquisitionMethod = "Direct job portal applications and recruitment drives in Whitefield.",
            stopCriterion = "30 days without scheduled interviews.",
            keyMoat = "Specific coursework in International Logistics and Commercial Law.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 8.5f, personalFitScore = 9.0f, capitalEfficiencyScore = 10f, speedToValidationScore = 8f, profitabilityScore = 7.0f, scalabilityScore = 6.5f, recurringRevenueScore = 10f, riskScore = 9f, defensibilityScore = 7.5f
        ),
        Opportunity(
            id = "corp_management_trainee",
            title = "Management Trainee (Operations & General Management)",
            domain = Domain.EMPLOYMENT,
            summary = "Fast-track rotational leadership program across operations, procurement, and client management.",
            targetCustomer = "Tier-1 Indian corporate conglomerates (Tata, Reliance, Aditya Birla, ITC).",
            economicBuyer = "Campus & Early Talent Recruitment Board.",
            coreProblem = "Enterprises need future operational leaders grounded in business strategy.",
            proposedOffer = "Top-percentile academic standing and extracurricular leadership track record.",
            deliverable = "Structured 1-year rotational program.",
            pricingHypothesis = "₹6 LPA - ₹11 LPA starting CTC.",
            typicalMonthlyRevenueInr = "₹50,000 - ₹90,000",
            deliveryCostPerCustomerInr = "₹0",
            acquisitionMethod = "Off-campus corporate assessment drives and LinkedIn networking with alumni.",
            stopCriterion = "Age/grad year eligibility cutoffs exceeded.",
            keyMoat = "Generalist adaptability and strong executive presence.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 9.0f, personalFitScore = 8.5f, capitalEfficiencyScore = 10f, speedToValidationScore = 7f, profitabilityScore = 8.0f, scalabilityScore = 7.5f, recurringRevenueScore = 10f, riskScore = 8.5f, defensibilityScore = 8f
        ),

        // Domain 2: Independent Services
        Opportunity(
            id = "serv_competitor_pricing_scraping",
            title = "Automated Competitor Pricing & Stock Tracker Service",
            domain = Domain.INDEPENDENT_SERVICES,
            summary = "Monitor competitor SKUs across Amazon, Flipkart, and Quick Commerce (Blinkit, Zepto) and send daily alert summaries to brand managers.",
            targetCustomer = "Direct-to-Consumer food, beauty, and lifestyle brands.",
            economicBuyer = "E-commerce Growth Manager.",
            coreProblem = "Brands manually check competitor prices and miss aggressive discount windows.",
            proposedOffer = "Automated 8 AM WhatsApp briefing with competitor price changes and out-of-stock opportunities.",
            deliverable = "Automated Google Sheet synced to custom web scraper.",
            pricingHypothesis = "₹12,000/mo per competitor group (Target 5 brands = ₹60,000/mo).",
            typicalMonthlyRevenueInr = "₹40,000 - ₹1,00,000",
            deliveryCostPerCustomerInr = "₹1,000 (Proxy & cloud costs)",
            acquisitionMethod = "Free 3-day sample report sent directly to brand heads showing competitor price fluctuations.",
            stopCriterion = "Scraper anti-bot hurdles requiring excessive manual maintenance.",
            keyMoat = "Quick Commerce specialization (Zepto/Blinkit pricing dynamics).",
            capitalTier = CapitalTier.TIER_1K,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 8.5f, personalFitScore = 8.5f, capitalEfficiencyScore = 9.0f, speedToValidationScore = 9.0f, profitabilityScore = 8.5f, scalabilityScore = 8.5f, recurringRevenueScore = 9.0f, riskScore = 8.0f, defensibilityScore = 7.5f
        ),
        Opportunity(
            id = "serv_sop_documentation",
            title = "B2B Standard Operating Procedure (SOP) Architecture",
            domain = Domain.INDEPENDENT_SERVICES,
            summary = "Interview department heads and document pristine Notion/Loom operational wikis so companies can hire and delegate without chaotic retraining.",
            targetCustomer = "Growing digital agencies, clinics, and professional services firms (15-50 staff).",
            economicBuyer = "Founder / Chief Operating Officer.",
            coreProblem = "All organizational memory is stuck in the founder's head; new hires take 4 months to ramp up.",
            proposedOffer = "2-week 'Complete Company Operating Playbook': 25 core workflows documented with Loom walkthroughs and Notion templates.",
            deliverable = "Structured company Notion workspace + onboarding checklist.",
            pricingHypothesis = "₹45,000 flat fee per department.",
            typicalMonthlyRevenueInr = "₹45,000 - ₹1,20,000",
            deliveryCostPerCustomerInr = "₹500 (Software)",
            acquisitionMethod = "LinkedIn posts detailing 'The 5 systems every 20-person agency is missing'.",
            stopCriterion = "Clients taking longer than 3 weeks to provide review access.",
            keyMoat = "High business process clarity and structured documentation rigor.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.IMMEDIATE,
            demandScore = 8.0f, personalFitScore = 9.0f, capitalEfficiencyScore = 10f, speedToValidationScore = 8.5f, profitabilityScore = 8.5f, scalabilityScore = 7.0f, recurringRevenueScore = 6.5f, riskScore = 8.5f, defensibilityScore = 7.5f
        ),

        // Domain 3: AI-Powered Models
        Opportunity(
            id = "ai_recruitment_cv_screener",
            title = "Bespoke AI Resume Pre-Screener for Local Tech Agencies",
            domain = Domain.AI_MODELS,
            summary = "Build custom AI filtering systems that evaluate developer GitHub/portfolio links against exact job specs, saving recruiters 15 hours/week.",
            targetCustomer = "Boutique IT recruitment agencies in Bengaluru and Hyderabad.",
            economicBuyer = "Managing Director of Recruitment Firm.",
            coreProblem = "Recruiters receive 800 generic resumes per job post; traditional keyword search misses top candidates.",
            proposedOffer = "AI pipeline that parses, ranks, and writes a 3-bullet candidate synthesis directly into their CRM.",
            deliverable = "Custom webhook integration connecting email inbox to Airtable.",
            pricingHypothesis = "₹25,000 setup + ₹10,000/mo retainer.",
            typicalMonthlyRevenueInr = "₹50,000 - ₹1,50,000",
            deliveryCostPerCustomerInr = "₹1,200 (LLM API tokens)",
            acquisitionMethod = "Cold demo sent to 20 recruitment founders showing 10 sample resumes ranked in 30 seconds.",
            stopCriterion = "Failure to prove higher placement rate compared to manual screening.",
            keyMoat = "Fine-tuned prompting for developer portfolios and candidate quality.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.5f, personalFitScore = 8.5f, capitalEfficiencyScore = 9.0f, speedToValidationScore = 8.5f, profitabilityScore = 9.0f, scalabilityScore = 8.5f, recurringRevenueScore = 9.0f, riskScore = 8.0f, defensibilityScore = 7.5f
        ),
        Opportunity(
            id = "ai_customer_support_whatsapp",
            title = "AI WhatsApp Assistant for Real Estate Builders & Dealers",
            domain = Domain.AI_MODELS,
            summary = "Deploy 24/7 intelligent WhatsApp bot that answers property brochure questions, verifies buyer budget, and books site visits.",
            targetCustomer = "Property developers, brokers, and interior design studios in Bengaluru.",
            economicBuyer = "Sales Director / Marketing Head.",
            coreProblem = "Ad leads arriving at 9 PM go cold by morning; sales agents forget to qualify budget.",
            proposedOffer = "Sub-second WhatsApp responder trained on specific project floorplans, RERA details, and pricing sheets.",
            deliverable = "WhatsApp Business Cloud bot connected to Google Sheets CRM.",
            pricingHypothesis = "₹20,000 setup + ₹8,000/mo per active project.",
            typicalMonthlyRevenueInr = "₹40,000 - ₹1,60,000",
            deliveryCostPerCustomerInr = "₹1,500 (Meta WhatsApp conversation fees + AI tokens)",
            acquisitionMethod = "In-person visits to real estate sales lounges on outer ring road and Sarjapur.",
            stopCriterion = "Poor conversion of bot leads to physical site visits in initial 30 days.",
            keyMoat = "Bengaluru locality knowledge and real estate sales objection handling.",
            capitalTier = CapitalTier.TIER_1K,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 9.0f, personalFitScore = 8.0f, capitalEfficiencyScore = 9.0f, speedToValidationScore = 8.5f, profitabilityScore = 9.0f, scalabilityScore = 8.5f, recurringRevenueScore = 9.0f, riskScore = 7.5f, defensibilityScore = 7.5f
        ),

        // Domain 4: Software, Apps & Infrastructure
        Opportunity(
            id = "saas_clinic_inventory",
            title = "Cloud Dental & Dermatology Consumables Tracker",
            domain = Domain.SOFTWARE,
            summary = "Simple iPad/mobile inventory tracker for aesthetic clinics to prevent medicine expiry and theft.",
            targetCustomer = "Single & multi-chair dental clinics and dermatology centers in Tier 1 Indian cities.",
            economicBuyer = "Clinic Owner / Head Doctor.",
            coreProblem = "Expensive botox, implants, and composite materials expire or go missing; current software is clunky legacy desktop software.",
            proposedOffer = "Barcode-scanning cloud app on Android/iOS; zero training required, 10-second stock audits.",
            deliverable = "Multi-tenant Android/Web application.",
            pricingHypothesis = "₹1,499/mo per branch.",
            typicalMonthlyRevenueInr = "₹45,000 - ₹2,00,000",
            deliveryCostPerCustomerInr = "₹100 (Database & hosting)",
            acquisitionMethod = "Door-to-door clinic walk-ins in Indiranagar and Koramangala with an active tablet demo.",
            stopCriterion = "Doctors unwilling to pay more than ₹500/mo.",
            keyMoat = "Frictionless mobile UI designed specifically for dental nurses and receptionists.",
            capitalTier = CapitalTier.TIER_10K,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 8.0f, personalFitScore = 8.0f, capitalEfficiencyScore = 8.5f, speedToValidationScore = 7.0f, profitabilityScore = 9.0f, scalabilityScore = 9.5f, recurringRevenueScore = 9.5f, riskScore = 7.5f, defensibilityScore = 8.0f
        ),

        // Domain 5: Digital Products & IP
        Opportunity(
            id = "ip_financial_models_vc",
            title = "Seed & Pre-Series A Financial Model Templates",
            domain = Domain.DIGITAL_PRODUCTS,
            summary = "Industry-standard dynamic 3-statement financial models tailored for Indian SaaS and D2C startups raising angel/institutional capital.",
            targetCustomer = "Early-stage founders pitching to Indian angel networks and micro-VCs.",
            economicBuyer = "Startup Founder.",
            coreProblem = "Founders don't know how to model cohort retention, burn rate, and CAC payback; hiring an investment banker costs ₹1,50,000+.",
            proposedOffer = "Turnkey Excel financial model with unit economics tab, cap table generator, and investor-ready assumptions.",
            deliverable = "Comprehensive Excel file + 45-minute video walkthrough.",
            pricingHypothesis = "₹3,499 per license.",
            typicalMonthlyRevenueInr = "₹35,000 - ₹1,00,000",
            deliveryCostPerCustomerInr = "₹50",
            acquisitionMethod = "Share free micro-tools (e.g. burn rate calculator) on Twitter and LinkedIn startup communities.",
            stopCriterion = "Piracy and unauthorized file distribution eroding conversion.",
            keyMoat = "BBA Finance modeling quality tailored to Indian tax and corporate structures.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.0f, personalFitScore = 9.0f, capitalEfficiencyScore = 10f, speedToValidationScore = 8.5f, profitabilityScore = 9.5f, scalabilityScore = 9.5f, recurringRevenueScore = 5.0f, riskScore = 9.0f, defensibilityScore = 7.0f
        ),

        // Domain 6: Modern Commerce
        Opportunity(
            id = "comm_b2b_office_ergonomics",
            title = "Corporate Ergonomic Workspace Supplies (B2B Supply)",
            domain = Domain.COMMERCE,
            summary = "Contract supply of premium monitor arms, orthopedic footrests, and cable management trays directly to IT companies.",
            targetCustomer = "Mid-sized IT and tech consulting firms outfitting new floors in Bengaluru.",
            economicBuyer = "Facilities & Admin Manager.",
            coreProblem = "Buying individual units on Amazon is 30% more expensive; standard office vendors provide low-quality generic hardware.",
            proposedOffer = "Bulk catalog with 3-year replacement warranty and free installation.",
            deliverable = "Physical supply contract with 30-day payment terms.",
            pricingHypothesis = "20-30% gross margin on ₹2,00,000 - ₹10,00,000 purchase orders.",
            typicalMonthlyRevenueInr = "₹60,000 - ₹3,00,000 gross margin",
            deliveryCostPerCustomerInr = "Wholesale procurement cost",
            acquisitionMethod = "Relationship building with commercial interior designers and corporate real estate brokers.",
            stopCriterion = "Working capital constraints preventing 30-day credit fulfillment.",
            keyMoat = "Exclusive manufacturer distributor agreement in South India.",
            capitalTier = CapitalTier.TIER_50K,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 8.0f, personalFitScore = 8.0f, capitalEfficiencyScore = 7.5f, speedToValidationScore = 7.0f, profitabilityScore = 8.5f, scalabilityScore = 8.0f, recurringRevenueScore = 7.5f, riskScore = 7.0f, defensibilityScore = 7.5f
        ),

        // Domain 7: Overlooked & Traditional Businesses
        Opportunity(
            id = "trad_commercial_solar_leadgen",
            title = "Rooftop Commercial Solar Assessment Brokerage",
            domain = Domain.TRADITIONAL,
            summary = "Audit factory and cold-storage electricity bills, calculate rooftop solar savings, and connect them with Tier-1 EPC solar installers.",
            targetCustomer = "Factory owners and commercial cold-storage facilities in Karnataka with high commercial BESCOM tariffs.",
            economicBuyer = "Owner / Factory Director.",
            coreProblem = "Industrial electricity bills are ₹3L - ₹15L/mo; owners know solar saves money but distrust aggressive cold-calling installers.",
            proposedOffer = "Independent financial payback audit showing exact 3-year IRR and government capital subsidies.",
            deliverable = "Detailed solar ROI audit + vetted tender quotes from 3 certified EPC installers.",
            pricingHypothesis = "₹15,000 fee for independent audit OR 3-5% finder's fee on executed solar contract (₹1.5L - ₹5L per project).",
            typicalMonthlyRevenueInr = "₹75,000 - ₹3,50,000",
            deliveryCostPerCustomerInr = "₹1,500 (Site visit & drone roof scan)",
            acquisitionMethod = "Direct outreach to industrial belt association members.",
            stopCriterion = "State power distribution regulatory changes stalling net metering approvals.",
            keyMoat = "Unbiased financial analyst positioning rather than pushy equipment salesman.",
            capitalTier = CapitalTier.TIER_1K,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.5f, personalFitScore = 8.5f, capitalEfficiencyScore = 9.0f, speedToValidationScore = 7.5f, profitabilityScore = 9.5f, scalabilityScore = 8.0f, recurringRevenueScore = 5.0f, riskScore = 8.0f, defensibilityScore = 8.0f
        ),

        // Domain 8: Media & Authority
        Opportunity(
            id = "media_b2b_fintech_newsletter",
            title = "India Payments & Cross-Border FinTech Digest",
            domain = Domain.MEDIA,
            summary = "Curated intelligence covering RBI regulations, UPI cross-border expansions, and merchant acquiring shifts.",
            targetCustomer = "Fintech product managers, compliance heads, and venture investors.",
            economicBuyer = "Corporate subscribers / Fintech marketing heads.",
            coreProblem = "RBI circulars and NPCI technical updates are dense and confusing; executives miss crucial compliance deadlines.",
            proposedOffer = "Weekly 5-minute plain-English executive synthesis + monthly compliance breakdown.",
            deliverable = "Substack/Beehiiv newsletter + sponsored event webinars.",
            pricingHypothesis = "₹5,000/year corporate subscription + ₹25,000 per newsletter sponsor slot.",
            typicalMonthlyRevenueInr = "₹40,000 - ₹1,50,000",
            deliveryCostPerCustomerInr = "₹50",
            acquisitionMethod = "High-signal regulatory commentary on LinkedIn.",
            stopCriterion = "Failure to achieve 1,000 active subscribers in 6 months.",
            keyMoat = "Deep synthesis of complex regulatory jurisprudence and economics.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 8.0f, personalFitScore = 8.5f, capitalEfficiencyScore = 9.5f, speedToValidationScore = 6.5f, profitabilityScore = 8.5f, scalabilityScore = 9.0f, recurringRevenueScore = 8.5f, riskScore = 8.5f, defensibilityScore = 8.0f
        ),

        // Domain 9: Global Trade & Export
        Opportunity(
            id = "global_handicraft_amazon_export",
            title = "Artisan Handicrafts & Sustainable Decor Amazon Global Export",
            domain = Domain.GLOBAL_TRADE,
            summary = "Partner with Channapatna toy and Bidriware artisan clusters to list high-ticket sustainable home decor on Amazon US/UK.",
            targetCustomer = "Conscious home decor shoppers in North America and Western Europe.",
            economicBuyer = "Consumer (Retail B2C) / Boutique gift store buyers (B2B).",
            coreProblem = "Artisans sell locally for pennies; US buyers pay $45-$90 for authentic handcrafted woodcraft.",
            proposedOffer = "Modern Scandinavian-minimalist packaging for traditional Indian GI-tagged crafts.",
            deliverable = "Amazon FBA international listings + DHL export pipeline.",
            pricingHypothesis = "4x-6x markup over local procurement cost.",
            typicalMonthlyRevenueInr = "₹50,000 - ₹2,50,000 net profit",
            deliveryCostPerCustomerInr = "Procurement + international freight + Amazon FBA fees",
            acquisitionMethod = "Direct Amazon US PPC and social media reels showcasing authentic artisan workshops.",
            stopCriterion = "Customs export friction or high Amazon return rates on fragile items.",
            keyMoat = "Proximity to authentic Karnataka craft clusters and GI certification.",
            capitalTier = CapitalTier.TIER_50K,
            timeHorizon = TimeHorizon.MEDIUM_TERM,
            demandScore = 8.0f, personalFitScore = 8.0f, capitalEfficiencyScore = 7.5f, speedToValidationScore = 7.0f, profitabilityScore = 8.5f, scalabilityScore = 8.5f, recurringRevenueScore = 6.0f, riskScore = 7.0f, defensibilityScore = 8.0f
        ),

        // Domain 10: Acquisitions & Assets
        Opportunity(
            id = "own_newsletter_sponsorship_brokerage",
            title = "Boutique Newsletter Advertising Brokerage & Equity",
            domain = Domain.OWNERSHIP,
            summary = "Acquire exclusive ad-sales rights for top 10 Indian niche professional newsletters in exchange for 30% revenue share.",
            targetCustomer = "B2B SaaS companies and recruiting firms seeking niche audience attention.",
            economicBuyer = "B2B Marketing Director.",
            coreProblem = "Newsletter writers hate doing sales outreach; B2B brands struggle to find verified niche audiences.",
            proposedOffer = "Package 10 newsletters into a unified 50,000-subscriber B2B tech network with single-invoice booking.",
            deliverable = "Sold ad slots with tracked performance metrics.",
            pricingHypothesis = "₹1,50,000 network sponsorship bundle; ₹45,000 net fee per campaign.",
            typicalMonthlyRevenueInr = "₹60,000 - ₹2,00,000",
            deliveryCostPerCustomerInr = "₹500",
            acquisitionMethod = "Cold outreach to newsletter operators offering guaranteed ad revenue.",
            stopCriterion = "Newsletter creators refusing exclusive representation rights.",
            keyMoat = "Aggregated audience buying power and advertiser relationships.",
            capitalTier = CapitalTier.TIER_0,
            timeHorizon = TimeHorizon.NEAR_TERM,
            demandScore = 8.0f, personalFitScore = 8.5f, capitalEfficiencyScore = 9.5f, speedToValidationScore = 8.0f, profitabilityScore = 9.0f, scalabilityScore = 8.5f, recurringRevenueScore = 8.5f, riskScore = 8.0f, defensibilityScore = 8.0f
        )
    )

    val capitalPlans: List<CapitalAllocationPlan> = listOf(
        CapitalAllocationPlan(
            tier = CapitalTier.TIER_0,
            whatToStart = listOf(
                "High-ticket B2B service agency (AI workflow automation, research)",
                "Full-time technology operations career applications in Bengaluru",
                "Cross-border market intelligence for MSME exporters"
            ),
            whatToPostpone = listOf(
                "Paid advertisements or Facebook/Google ads",
                "Incorporating a Private Limited company (use Sole Proprietorship)",
                "Building complex multi-tenant SaaS before manual pilot validation"
            ),
            skillSubstitutes = "Replace money with sweat equity: personal cold outreach, Loom video audits, high-touch manual client onboarding, and open-source software.",
            essentialSoftware = "Free tiers of Google Workspace, Notion, Loom, Make.com, and LinkedIn standard account.",
            validationBudgetInr = "₹0 required. Validate strictly via paid customer deposits or pre-orders.",
            emergencyReservesRule = "100% of any personal savings must be held in high-yield bank savings/liquid fund; zero risk capital until income is established.",
            downsideStopRule = "Stop outreach after 50 targeted prospects if none engage with value-led sample work; iterate positioning."
        ),
        CapitalAllocationPlan(
            tier = CapitalTier.TIER_1K,
            whatToStart = listOf(
                "Custom domain name (.com or .in) + professional Google Workspace email",
                "Sample physical procurement visits (bus/metro across Bengaluru industrial belts)",
                "Micro-SaaS prototype hosting on free tier cloud with custom domain"
            ),
            whatToPostpone = listOf(
                "Trademark registration or paid PR press releases",
                "Hiring freelancers or virtual assistants"
            ),
            skillSubstitutes = "Build your own landing pages with free Webflow/Carrd and open-source Tailwind components.",
            essentialSoftware = "Custom domain (₹800/yr) + Cloudflare free DNS + Zoho Mail free tier.",
            validationBudgetInr = "₹1,000 total across 30 days.",
            emergencyReservesRule = "Keep at least 3 months of basic living costs insulated.",
            downsideStopRule = "Never renew domain or cloud service if zero customer leads are captured in 60 days."
        ),
        CapitalAllocationPlan(
            tier = CapitalTier.TIER_10K,
            whatToStart = listOf(
                "Paid trade database or Apollo.io lead enrichment plan for 1 month",
                "Professional sample production for packaging or physical B2B brokerage",
                "Local business MSME Udyam registration & formal invoicing software"
            ),
            whatToPostpone = listOf(
                "Inventory stock purchases without back-to-back customer purchase orders",
                "Fancy office space (work from home or public libraries)"
            ),
            skillSubstitutes = "Handle all accounting, client outreach, and prompt engineering personally.",
            essentialSoftware = "Paid Notion Plus, Make.com Starter, Apollo.io Basic (1-month targeted sprint).",
            validationBudgetInr = "₹3,000 allocated for testing customer response.",
            emergencyReservesRule = "Maintain minimum ₹25,000 personal safety buffer.",
            downsideStopRule = "Cap total experimental loss at ₹5,000 before evaluating product-market signal."
        ),
        CapitalAllocationPlan(
            tier = CapitalTier.TIER_50K,
            whatToStart = listOf(
                "Small-batch inventory for high-margin B2B packaging or physical trade sample",
                "LLP incorporation with trademark filing once 3 paying clients exist",
                "Paid targeted LinkedIn InMail credits to reach C-level buyers"
            ),
            whatToPostpone = listOf(
                "Full-time employee salaries (use milestone-based freelancers only)",
                "Long-term annual software commitments"
            ),
            skillSubstitutes = "Maintain direct founder sales and high-touch customer delivery.",
            essentialSoftware = "Tally Prime or Zoho Books subscription + professional CRM.",
            validationBudgetInr = "₹12,000 maximum testing budget.",
            emergencyReservesRule = "At least ₹35,000 preserved in liquid accounts.",
            downsideStopRule = "Stop any product experiment that fails to generate at least 50% gross margin on trial orders."
        ),
        CapitalAllocationPlan(
            tier = CapitalTier.TIER_1L,
            whatToStart = listOf(
                "Dedicated customer acquisition engine with small test PPC budget (₹15,000/mo)",
                "Working capital buffer to support 30-day payment terms for corporate clients",
                "Professional legal drafting of MSME service contracts and non-disclosures"
            ),
            whatToPostpone = listOf(
                "Expensive co-working private cabins or depreciating hardware",
                "Speculative financial trading or crypto investments"
            ),
            skillSubstitutes = "Strategic oversight, personal relationship management, and high-level architecture.",
            essentialSoftware = "Full enterprise stack (Slack, Google Workspace, Zapier/Make, Zoho CRM).",
            validationBudgetInr = "₹25,000 across 60 days.",
            emergencyReservesRule = "Maintain 6 months of personal living expenses separate from business accounts.",
            downsideStopRule = "Halt paid advertising immediately if Customer Acquisition Cost exceeds 35% of first-month retainer."
        )
    )

    val thirtyDayBlueprint: List<ActionPlanDay> = listOf(
        ActionPlanDay(
            dayRange = "Days 1–3",
            theme = "Market Reconnaissance & Opportunity Lock",
            tasks = listOf(
                "Filter the Opportunity Atlas down to your primary chosen path (AI Workflow Automation).",
                "Audit 15 target businesses in Bengaluru (Peenya/Whitefield logistics & exporters) via Google Maps and LinkedIn.",
                "Map out the exact friction points: invoice processing, delivery tracking, GST reconciliation.",
                "Set up a dedicated Notion execution tracker and professional email signature."
            ),
            deliverable = "Target List of 30 qualified businesses with verified names of Managing Directors / Operations Heads.",
            successGate = "Minimum 25 verified decision-maker names and direct contact details identified."
        ),
        ActionPlanDay(
            dayRange = "Days 4–7",
            theme = "Proof-of-Concept & Irresistible Offer Construction",
            tasks = listOf(
                "Build a live 2-minute prototype demonstrating automated invoice parsing to Google Sheets.",
                "Record a crisp 90-second Loom video demonstrating the prototype with zero fluff.",
                "Draft the 'Risk-Free Workflow Audit' offer: 'If we can't save your team 2 hours daily in 5 days, you pay nothing.'",
                "Prepare the 1-page PDF proposal template detailing scope, deliverables, and pricing."
            ),
            deliverable = "Completed demo video + 1-page high-converting proposal document.",
            successGate = "Demo successfully tested on 3 real sample invoices with zero extraction errors."
        ),
        ActionPlanDay(
            dayRange = "Days 8–14",
            theme = "Direct Outreach & Commercial Validation Sprint",
            tasks = listOf(
                "Send 10 personalized Loom video messages daily to verified Operations Directors on LinkedIn.",
                "Conduct 5 in-person visits to industrial park offices in Peenya or Bommasandra.",
                "Offer a free 30-minute operational audit to identify data bottlenecks.",
                "Secure 3 discovery calls or in-person walk-throughs."
            ),
            deliverable = "3 discovery sessions conducted; feedback recorded on willingness to pay.",
            successGate = "At least 1 qualified prospective client agrees to a trial pilot setup."
        ),
        ActionPlanDay(
            dayRange = "Days 15–21",
            theme = "Pilot Execution & First Paying Customer",
            tasks = listOf(
                "Deploy the automated workflow for the pilot client under a formal 7-day trial agreement.",
                "Onboard the client's dispatch manager via a 20-minute screen share.",
                "Monitor pipeline reliability daily; eliminate any formatting or OCR edge cases.",
                "Present the completed savings report: hours saved and error reduction quantified."
            ),
            deliverable = "Working system live in client's operational environment; first invoice raised.",
            successGate = "First payment received (₹15,000 pilot fee or ₹35,000 full setup deposit)."
        ),
        ActionPlanDay(
            dayRange = "Days 22–30",
            theme = "Case Study Formulation & System Standardization",
            tasks = listOf(
                "Capture written and video testimonial from the satisfied pilot client.",
                "Standardize prompt templates, webhooks, and setup scripts for rapid 24-hour redeployment.",
                "Launch second outreach wave featuring the quantified pilot case study.",
                "Review financial metrics: gross profit, cash in bank, and establish month-2 recurring retainer pipeline."
            ),
            deliverable = "Documented 1-page case study + reusable system template + 2nd client in pipeline.",
            successGate = "Verified revenue in bank account + positive contribution margin."
        )
    )

    val twelveMonthRoadmap: List<TwelveMonthStage> = listOf(
        TwelveMonthStage(
            stage = "Months 1–3",
            title = "Foundation & First Paying Clients",
            coreFocus = "Validate demand, deliver outstanding results manually, and achieve first ₹50,000 - ₹1,00,000 monthly cash flow.",
            keyMilestones = listOf(
                "Secure first 3 paying B2B clients for workflow automation or market research.",
                "Accumulate ₹1,00,000+ in gross revenue.",
                "Refine delivery time from 10 days down to 4 days per client.",
                "Document 3 detailed case studies with measurable ROI metrics."
            ),
            gatingCriterion = "Must have at least 2 repeat retainer clients paying on time before expanding software subscriptions."
        ),
        TwelveMonthStage(
            stage = "Months 4–6",
            title = "Repeatability, Pricing Power & Financial Systems",
            coreFocus = "Increase retainers from ₹15,000 to ₹30,000/mo. Separate business and personal accounts. Register formal MSME / LLP.",
            keyMilestones = listOf(
                "Reach 5 active monthly retainers generating ₹1,50,000/mo consistent revenue.",
                "Build automated client onboarding and monthly performance reporting dashboards.",
                "Build 3-month living expense personal emergency runway in liquid bank funds.",
                "Hire first vetted freelance technical contractor for routine webhook maintenance."
            ),
            gatingCriterion = "Operating margin must stay above 70% before adding any overhead or contractors."
        ),
        TwelveMonthStage(
            stage = "Months 7–9",
            title = "Scalable Channels & Productization",
            coreFocus = "Turn custom bespoke service into a standardized productized service or micro-SaaS with multi-tenant capabilities.",
            keyMilestones = listOf(
                "Launch standardized packaging for specific vertical (e.g. Logistics Dispatch Automation).",
                "Scale monthly revenue past ₹2,50,000/mo.",
                "Establish referral partnerships with 2 accounting software dealers in Karnataka.",
                "Begin testing inbound content engine (LinkedIn thought leadership + YouTube case studies)."
            ),
            gatingCriterion = "Zero customer churn on existing core retainers over a 60-day window."
        ),
        TwelveMonthStage(
            stage = "Months 10–12",
            title = "Ownership, Compounding & Empire Architecture",
            coreFocus = "Review annual profitability, allocate profits into diversified compounding assets, and explore micro-acquisitions.",
            keyMilestones = listOf(
                "Achieve ₹30,00,000+ annual business run rate with 65%+ net margins.",
                "Accumulate 12 months of operational business runway.",
                "Explore profit-share partnerships or software IP spin-offs with top enterprise clients.",
                "Prudently allocate personal surplus into diversified index funds and debt reserves."
            ),
            gatingCriterion = "Annual net profit audit completed; tax compliance and GST returns verified in full."
        )
    )

    val riskRegister: List<RiskMatrixItem> = listOf(
        RiskMatrixItem(
            riskCategory = "Commercial Demand",
            threatDescription = "Prospective business clients say they love the idea but delay signing or refuse to pay upfront.",
            likelihood = "High",
            impact = "Severe",
            earlyWarning = "Prospect praises the demo but takes more than 5 days to approve a ₹15,000 pilot.",
            preventiveControl = "Offer a bounded 5-day performance pilot with payment tied strictly to measurable hours saved.",
            contingencyAction = "If 15 prospects stall, pivot the offer from general 'automation' to an urgent compliance requirement (e.g., E-Way bill penalty prevention)."
        ),
        RiskMatrixItem(
            riskCategory = "Cash Flow & Late Payments",
            threatDescription = "Indian corporate clients delay invoice clearing by 60-90 days, straining working capital.",
            likelihood = "High",
            impact = "Moderate",
            earlyWarning = "Accounts department asks for multiple revisions of GST invoices or ignores email reminders.",
            preventiveControl = "Require 50% upfront payment before delivery and automate WhatsApp payment reminders with UPI QR codes.",
            contingencyAction = "Pause ongoing software support and data pipeline syncing after 10 days of payment overdue."
        ),
        RiskMatrixItem(
            riskCategory = "Technical Dependency & AI Drift",
            threatDescription = "Third-party AI API update alters OCR extraction accuracy on unusual handwritten invoices.",
            likelihood = "Medium",
            impact = "Moderate",
            earlyWarning = "Client flags 2 consecutive invoice extraction mismatches.",
            preventiveControl = "Implement strict schema validation with confidence scoring; flag low-confidence parses for human review.",
            contingencyAction = "Maintain human-in-the-loop review buffer for any documents scoring below 95% certainty."
        ),
        RiskMatrixItem(
            riskCategory = "Personal Resilience & Burnout",
            threatDescription = "Founder tries to juggle 6 disparate business ideas simultaneously, making zero meaningful progress on any.",
            likelihood = "High",
            impact = "Severe",
            earlyWarning = "Spends all week designing logos, websites, and business cards without contacting a single real customer.",
            preventiveControl = "Directive 007 Rule: Commit 100% of commercial energy to ONE validated opportunity until first ₹50,000 is earned.",
            contingencyAction = "Impose daily accountability: measure customer conversations and proposals sent, not internal busywork."
        )
    )

    val samplePlaybook = OutreachTemplate(
        channel = "LinkedIn DM / Direct Email to Bengaluru Operations Directors",
        subject = "Quick question on your dispatch & invoice processing in Peenya",
        body = """
            Hi [First Name],
            
            Noticed your operations at [Company Name] are scaling dispatch across South India.
            
            Most logistics and manufacturing directors I speak with in Bengaluru tell me their staff spends 3+ hours every afternoon manually copying supplier invoices and E-Way bill data into Excel and Tally.
            
            We built a lightweight 1-click parser that auto-extracts line items from scanned PDF invoices directly into your system with 99.4% accuracy, saving ~15 hours of manual data entry every week.
            
            I put together a 90-second video showing how it handles standard Indian GST invoices:
            [Loom Link]
            
            Happy to run 5 of your real sample invoices through it for free this week so you can see the speed for yourself.
            
            Would Thursday afternoon work for a quick 10-minute check?
            
            Best regards,
            [Your Name] | International Business & Operations Specialist
        """.trimIndent(),
        followupDay3 = """
            Hi [First Name],
            
            Following up on this — even if you already have an ERP in place, this sits on top to eliminate the manual typing your dispatch team does before the data ever reaches the ERP.
            
            Glad to send over a 1-page sample breakdown if helpful.
        """.trimIndent(),
        objectionHandlingTip = "If they say 'We already have staff doing this': Answer 'Understood — our clients keep their staff, but free them from mindless typing so they can handle 2x more customer orders without hiring additional headcount.'"
    )
}
