package com.example.ui.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import kotlin.math.cos
import kotlin.math.sin

data class MonthlyDataPoint(
    val monthNumber: Int,
    val monthLabel: String,
    val revenue: Long,
    val operatingProfit: Long,
    val cumulativeCash: Long
)

enum class VisualizerMode(val label: String) {
    TRAJECTORY("Revenue & Profit Trends"),
    COMPOUNDING("Cumulative Wealth"),
    MARKET_INSIGHTS("Market Intelligence")
}

@Composable
fun FinancialDataVisualizer(
    clientCount: Int,
    pricePerClient: Long,
    operatingProfit: Long,
    modifier: Modifier = Modifier
) {
    var mode by remember { mutableStateOf(VisualizerMode.TRAJECTORY) }
    var selectedMonthIndex by remember { mutableStateOf<Int?>(5) } // default M6

    // Derive 12-month data points dynamically based on simulation client ramp
    val monthlyData = remember(clientCount, pricePerClient, operatingProfit) {
        val list = mutableListOf<MonthlyDataPoint>()
        var runningCash = 0L
        for (m in 1..12) {
            // S-curve ramp factor reflecting real client acquisition
            val rampRatio = when (m) {
                1 -> 0.25f
                2 -> 0.45f
                3 -> 0.65f
                4 -> 0.80f
                5 -> 0.90f
                6 -> 1.00f
                7 -> 1.05f
                8 -> 1.15f
                9 -> 1.25f
                10 -> 1.35f
                11 -> 1.45f
                else -> 1.55f
            }
            val rev = (clientCount * pricePerClient * rampRatio).toLong()
            val prof = (operatingProfit * rampRatio).toLong()
            runningCash += (prof * 0.75).toLong() // 25% retained buffer for tax/reinvestment
            list.add(
                MonthlyDataPoint(
                    monthNumber = m,
                    monthLabel = "M$m",
                    revenue = rev,
                    operatingProfit = prof,
                    cumulativeCash = runningCash
                )
            )
        }
        list
    }

    LuxuryGoldCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("financial_data_visualizer_card"),
        borderColor = ImperialGoldPrimary.copy(alpha = 0.5f),
        backgroundColor = Color(0xFF0A0F1D)
    ) {
        // Card Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(ImperialGoldPrimary.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoGraph,
                        contentDescription = "Data Visualization",
                        tint = ImperialGoldPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "ELITE WEALTH VISUALIZER",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = ImperialGoldPrimary,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "12-Month Mathematical Trajectory & Market Vectors",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextLowEmphasis
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = LuxurySurfaceElevated,
                border = androidx.compose.foundation.BorderStroke(1.dp, LuxuryCardBorderSubtle)
            ) {
                Text(
                    text = "D3 / RECHARTS ENGINE",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = SapphireTech,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Mode Selector Tabs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            VisualizerMode.values().forEach { vMode ->
                val isSelected = mode == vMode
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    color = if (isSelected) ImperialGoldPrimary else LuxurySurfaceVariant,
                    onClick = { mode = vMode }
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when (vMode) {
                                VisualizerMode.TRAJECTORY -> "Trends"
                                VisualizerMode.COMPOUNDING -> "Compounding"
                                VisualizerMode.MARKET_INSIGHTS -> "Market Pulse"
                            },
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color(0xFF0F172A) else TextMediumEmphasis
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Interactive Inspection Tooltip
        selectedMonthIndex?.let { idx ->
            if (idx in monthlyData.indices) {
                val pt = monthlyData[idx]
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = LuxurySurfaceElevated,
                    border = androidx.compose.foundation.BorderStroke(1.dp, ImperialGoldPrimary.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "INSPECTION: MONTH ${pt.monthNumber}",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = ImperialGoldPrimary
                            )
                            Text(
                                text = "Gross Revenue: ₹${String.format("%,d", pt.revenue)}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = TextHighEmphasis
                            )
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "Net Operating: ₹${String.format("%,d", pt.operatingProfit)}",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = EmeraldWealth
                            )
                            Text(
                                text = "Accumulated Cash: ₹${String.format("%,d", pt.cumulativeCash)}",
                                style = MaterialTheme.typography.labelSmall,
                                color = SapphireTech
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
            }
        }

        // Active Chart Canvas based on mode
        when (mode) {
            VisualizerMode.TRAJECTORY -> {
                WealthTrendBezierCanvas(
                    data = monthlyData,
                    selectedIndex = selectedMonthIndex,
                    onSelectIndex = { selectedMonthIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                )
            }
            VisualizerMode.COMPOUNDING -> {
                WealthCompoundingBarCanvas(
                    data = monthlyData,
                    selectedIndex = selectedMonthIndex,
                    onSelectIndex = { selectedMonthIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                )
            }
            VisualizerMode.MARKET_INSIGHTS -> {
                MarketInsightRadarCanvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Legend Indicators
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(ImperialGoldPrimary)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Gross Revenue",
                style = MaterialTheme.typography.labelSmall,
                color = TextMediumEmphasis
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(EmeraldWealth)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Net Operating Cash Flow",
                style = MaterialTheme.typography.labelSmall,
                color = TextMediumEmphasis
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(SapphireTech)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Accumulated Reserves",
                style = MaterialTheme.typography.labelSmall,
                color = TextMediumEmphasis
            )
        }
    }
}

@Composable
fun WealthTrendBezierCanvas(
    data: List<MonthlyDataPoint>,
    selectedIndex: Int?,
    onSelectIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val animProgress by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 800),
        label = "chart_anim"
    )

    androidx.compose.foundation.Canvas(
        modifier = modifier
            .pointerInput(data) {
                detectTapGestures { offset ->
                    val widthPerStep = size.width / (data.size - 1).coerceAtLeast(1)
                    val clickedIdx = ((offset.x + widthPerStep / 2) / widthPerStep).toInt().coerceIn(0, data.size - 1)
                    onSelectIndex(clickedIdx)
                }
            }
            .pointerInput(data) {
                detectDragGestures { change, _ ->
                    val widthPerStep = size.width / (data.size - 1).coerceAtLeast(1)
                    val draggedIdx = ((change.position.x + widthPerStep / 2) / widthPerStep).toInt().coerceIn(0, data.size - 1)
                    onSelectIndex(draggedIdx)
                }
            }
    ) {
        val w = size.width
        val h = size.height
        val maxVal = (data.maxOfOrNull { it.revenue } ?: 100_000L).coerceAtLeast(10_000L) * 1.15f

        // Draw horizontal subtle grid lines & Y labels
        val gridLines = 4
        for (i in 0..gridLines) {
            val yPos = h - (h * (i.toFloat() / gridLines)) * 0.85f - 20f
            drawLine(
                color = Color(0x1AFFFFFF),
                start = Offset(0f, yPos),
                end = Offset(w, yPos),
                strokeWidth = 1f
            )

            val gridVal = (maxVal * (i.toFloat() / gridLines)).toLong()
            val textPaint = Paint().apply {
                color = android.graphics.Color.argb(120, 203, 213, 225)
                textSize = 24f
                typeface = Typeface.DEFAULT
            }
            drawContext.canvas.nativeCanvas.drawText(
                "₹${gridVal / 1000}k",
                8f,
                yPos - 6f,
                textPaint
            )
        }

        val stepX = w / (data.size - 1)

        // 1. Path for Revenue (Gold)
        val revenuePath = Path()
        val revenueFillPath = Path()

        val pointsRev = data.mapIndexed { idx, pt ->
            val x = idx * stepX
            val ratio = (pt.revenue.toFloat() / maxVal) * animProgress
            val y = (h - 25f) - (ratio * (h - 50f))
            Offset(x, y)
        }

        if (pointsRev.isNotEmpty()) {
            revenuePath.moveTo(pointsRev.first().x, pointsRev.first().y)
            revenueFillPath.moveTo(pointsRev.first().x, h - 20f)
            revenueFillPath.lineTo(pointsRev.first().x, pointsRev.first().y)

            for (i in 0 until pointsRev.size - 1) {
                val p0 = pointsRev[i]
                val p1 = pointsRev[i + 1]
                val controlX1 = p0.x + (p1.x - p0.x) / 2
                val controlY1 = p0.y
                val controlX2 = p0.x + (p1.x - p0.x) / 2
                val controlY2 = p1.y

                revenuePath.cubicTo(controlX1, controlY1, controlX2, controlY2, p1.x, p1.y)
                revenueFillPath.cubicTo(controlX1, controlY1, controlX2, controlY2, p1.x, p1.y)
            }

            revenueFillPath.lineTo(pointsRev.last().x, h - 20f)
            revenueFillPath.close()

            // Draw Area Fill under Gold line
            drawPath(
                path = revenueFillPath,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        ImperialGoldPrimary.copy(alpha = 0.35f),
                        ImperialGoldPrimary.copy(alpha = 0.03f)
                    ),
                    startY = 0f,
                    endY = h
                )
            )

            // Draw Gold Stroke Line
            drawPath(
                path = revenuePath,
                brush = Brush.horizontalGradient(
                    listOf(ImperialGoldBright, ImperialGoldPrimary, Color(0xFFC9981A))
                ),
                style = Stroke(width = 3.5f, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
        }

        // 2. Path for Operating Profit (Emerald)
        val profitPath = Path()
        val pointsProf = data.mapIndexed { idx, pt ->
            val x = idx * stepX
            val ratio = (pt.operatingProfit.toFloat() / maxVal) * animProgress
            val y = (h - 25f) - (ratio * (h - 50f))
            Offset(x, y)
        }

        if (pointsProf.isNotEmpty()) {
            profitPath.moveTo(pointsProf.first().x, pointsProf.first().y)
            for (i in 0 until pointsProf.size - 1) {
                val p0 = pointsProf[i]
                val p1 = pointsProf[i + 1]
                val controlX1 = p0.x + (p1.x - p0.x) / 2
                val controlY1 = p0.y
                val controlX2 = p0.x + (p1.x - p0.x) / 2
                val controlY2 = p1.y

                profitPath.cubicTo(controlX1, controlY1, controlX2, controlY2, p1.x, p1.y)
            }

            // Draw Emerald Stroke Line
            drawPath(
                path = profitPath,
                color = EmeraldWealth,
                style = Stroke(width = 2.5f, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
        }

        // Draw points and inspection indicator line
        pointsRev.forEachIndexed { i, pRev ->
            val isSelected = selectedIndex == i

            if (isSelected) {
                // Vertical indicator cursor line
                drawLine(
                    color = ImperialGoldPrimary.copy(alpha = 0.6f),
                    start = Offset(pRev.x, 0f),
                    end = Offset(pRev.x, h - 20f),
                    strokeWidth = 1.5f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )

                // Highlighted glowing outer circle
                drawCircle(
                    color = ImperialGoldPrimary.copy(alpha = 0.35f),
                    radius = 12f,
                    center = pRev
                )
            }

            // Normal point dot
            drawCircle(
                color = if (isSelected) ImperialGoldBright else ImperialGoldPrimary,
                radius = if (isSelected) 6f else 3.5f,
                center = pRev
            )

            // Profit dot
            if (i < pointsProf.size) {
                drawCircle(
                    color = EmeraldWealth,
                    radius = if (isSelected) 5f else 2.5f,
                    center = pointsProf[i]
                )
            }

            // Draw X-axis label
            if (i % 2 == 0 || i == data.size - 1) {
                val textPaint = Paint().apply {
                    color = if (isSelected) android.graphics.Color.WHITE else android.graphics.Color.argb(140, 148, 163, 184)
                    textSize = 22f
                    textAlign = Paint.Align.CENTER
                    typeface = if (isSelected) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
                }
                drawContext.canvas.nativeCanvas.drawText(
                    data[i].monthLabel,
                    pRev.x,
                    h - 4f,
                    textPaint
                )
            }
        }
    }
}

@Composable
fun WealthCompoundingBarCanvas(
    data: List<MonthlyDataPoint>,
    selectedIndex: Int?,
    onSelectIndex: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val animProgress by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 800),
        label = "bar_anim"
    )

    androidx.compose.foundation.Canvas(
        modifier = modifier
            .pointerInput(data) {
                detectTapGestures { offset ->
                    val barSlotWidth = size.width / data.size
                    val idx = (offset.x / barSlotWidth).toInt().coerceIn(0, data.size - 1)
                    onSelectIndex(idx)
                }
            }
    ) {
        val w = size.width
        val h = size.height
        val maxCash = (data.maxOfOrNull { it.cumulativeCash } ?: 100_000L).coerceAtLeast(10_000L) * 1.1f
        val barSlotWidth = w / data.size
        val barWidth = barSlotWidth * 0.65f

        data.forEachIndexed { i, pt ->
            val isSelected = selectedIndex == i
            val x = i * barSlotWidth + (barSlotWidth - barWidth) / 2
            val barHeight = ((pt.cumulativeCash.toFloat() / maxCash) * (h - 40f)) * animProgress
            val y = (h - 25f) - barHeight

            // Draw Bar with luxury sapphire-to-gold gradient
            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = if (isSelected) {
                        listOf(ImperialGoldBright, ImperialGoldPrimary)
                    } else {
                        listOf(SapphireTech.copy(alpha = 0.9f), Color(0xFF0284C7))
                    },
                    startY = y,
                    endY = h - 25f
                ),
                topLeft = Offset(x, y),
                size = androidx.compose.ui.geometry.Size(barWidth, barHeight),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(6f, 6f)
            )

            // Month Label
            if (i % 2 == 0 || i == data.size - 1) {
                val textPaint = Paint().apply {
                    color = if (isSelected) android.graphics.Color.WHITE else android.graphics.Color.argb(140, 148, 163, 184)
                    textSize = 22f
                    textAlign = Paint.Align.CENTER
                }
                drawContext.canvas.nativeCanvas.drawText(
                    pt.monthLabel,
                    x + barWidth / 2,
                    h - 4f,
                    textPaint
                )
            }
        }
    }
}

@Composable
fun MarketInsightRadarCanvas(
    modifier: Modifier = Modifier
) {
    val vectors = listOf(
        "B2B Demand" to 0.92f,
        "Margin Health" to 0.88f,
        "Regulatory" to 0.78f,
        "Speed to Pay" to 0.85f,
        "Stickiness" to 0.90f
    )

    androidx.compose.foundation.Canvas(modifier = modifier) {
        val cx = size.width / 2
        val cy = size.height / 2
        val radius = (size.height.coerceAtMost(size.width) / 2) - 35f

        val sides = vectors.size
        val angleStep = (2 * Math.PI / sides).toFloat()

        // Draw concentric web rings
        for (level in 1..4) {
            val r = radius * (level / 4f)
            val webPath = Path()
            for (i in 0 until sides) {
                val angle = i * angleStep - (Math.PI.toFloat() / 2)
                val x = cx + r * cos(angle)
                val y = cy + r * sin(angle)
                if (i == 0) webPath.moveTo(x, y) else webPath.lineTo(x, y)
            }
            webPath.close()
            drawPath(
                path = webPath,
                color = Color(0x22FFFFFF),
                style = Stroke(width = 1f)
            )
        }

        // Draw radar filled polygon
        val polyPath = Path()
        vectors.forEachIndexed { i, (_, score) ->
            val angle = i * angleStep - (Math.PI.toFloat() / 2)
            val r = radius * score
            val x = cx + r * cos(angle)
            val y = cy + r * sin(angle)
            if (i == 0) polyPath.moveTo(x, y) else polyPath.lineTo(x, y)
        }
        polyPath.close()

        drawPath(
            path = polyPath,
            brush = Brush.radialGradient(
                colors = listOf(
                    ImperialGoldPrimary.copy(alpha = 0.45f),
                    EmeraldWealth.copy(alpha = 0.15f)
                ),
                center = Offset(cx, cy),
                radius = radius
            )
        )

        drawPath(
            path = polyPath,
            color = ImperialGoldPrimary,
            style = Stroke(width = 2.5f)
        )

        // Labels
        vectors.forEachIndexed { i, (label, score) ->
            val angle = i * angleStep - (Math.PI.toFloat() / 2)
            val r = radius + 22f
            val x = cx + r * cos(angle)
            val y = cy + r * sin(angle)

            val textPaint = Paint().apply {
                color = android.graphics.Color.WHITE
                textSize = 22f
                textAlign = Paint.Align.CENTER
                typeface = Typeface.DEFAULT_BOLD
            }
            drawContext.canvas.nativeCanvas.drawText(
                "$label (${(score * 100).toInt()}%)",
                x,
                y + 8f,
                textPaint
            )
        }
    }
}
