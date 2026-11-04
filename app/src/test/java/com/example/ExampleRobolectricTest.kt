package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.OpportunityRepository
import com.example.viewmodel.FinancialSimulation
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Moneyverse", appName)
  }

  @Test
  fun `verify opportunity repository contains comprehensive atlas`() {
    val allOpps = OpportunityRepository.allOpportunities
    assertTrue("Atlas should have at least 10 opportunities", allOpps.size >= 10)
    val top1 = allOpps.find { it.rank == 1 }
    assertTrue("Top 1 opportunity should exist", top1 != null)
    assertTrue("Top 1 should have positive weighted score", top1!!.weightedScore > 8.0f)
  }

  @Test
  fun `verify financial simulation unit economics formulas`() {
    val sim = FinancialSimulation(
      clientCount = 5,
      pricePerClientInr = 25_000L,
      directCostPerClientInr = 2_500L,
      cacPerClientInr = 3_500L,
      monthlyFixedOverheadInr = 8_000L
    )

    assertEquals(125_000L, sim.monthlyRevenue)
    assertEquals(12_500L, sim.totalDirectCosts)
    assertEquals(112_500L, sim.grossProfit)
    assertEquals(90.0f, sim.grossMarginPercent, 0.01f)
    assertEquals(17_500L, sim.totalAcquisitionCost)
    // Operating Profit = Gross Profit (112,500) - Overhead (8,000) - CAC (17,500) = 87,000
    assertEquals(87_000L, sim.operatingProfit)
    assertEquals(1, sim.breakEvenClients)
  }
}
