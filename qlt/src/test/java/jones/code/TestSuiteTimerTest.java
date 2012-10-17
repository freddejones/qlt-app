package jones.code;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jones.code.QLPickupItemType;
import jones.code.timer.QLTimer;

public class TestSuiteTimerTest {
	
	public QLTimer timerMh;
	public QLTimer timerRa;
	public QLTimer timerMhCountingDown;
	public QLTimer timerRaCountingDown;
	
	private ArrayList<String> spawnValues;
	
	@Before
	public void setup()
	{
		spawnValues = new ArrayList<String>();
		spawnValues.add("0");
		spawnValues.add("5");
		timerMh = new QLTimer(QLPickupItemType.MH, spawnValues, true);
		timerRa = new QLTimer(QLPickupItemType.RA, spawnValues, true);
		timerMhCountingDown = new QLTimer(QLPickupItemType.MH, spawnValues, false);
		timerRaCountingDown = new QLTimer(QLPickupItemType.RA, spawnValues, false);
	}
	
	@After
	public void tearDown()
	{
		timerMh = null;
		timerRa = null;
	}
	
	
	@Test
	public void testInitMhPickupTime()
	{
		Assert.assertNotNull(timerMh.getCurrentPickupTimeValue());
	}
	
	@Test
	public void testInitRaPickupTime()
	{
		Assert.assertNotNull(timerRa.getCurrentPickupTimeValue());
	}
	
	@Test 
	public void testPositiveMhValues22()
	{
		timerMh.setNewPickupTime("22");	
		Assert.assertEquals(true, timerMh.validateInputValue("57"));
	}
	
	@Test
	public void testPositiveRaValue10()
	{
		timerRa.setNewPickupTime("10");
		Assert.assertTrue(timerRa.validateInputValue("35"));
	}
	
	@Test
	public void testPostivitMhvalue35()
	{
		timerMh.setNewPickupTime("35");	
		Assert.assertEquals(true, timerMh.validateInputValue("10"));
	}
	
	@Test
	public void testPostiveMhValue25()
	{
		timerMh.setNewPickupTime("25");
		Assert.assertEquals(true, timerMh.validateInputValue("0"));
	}
	
	@Test
	public void testNegativeMatching22()
	{
		timerMh.setNewPickupTime("22");
		Assert.assertEquals(false, timerMh.validateInputValue("56"));
		Assert.assertEquals(false, timerMh.validateInputValue("55"));
		Assert.assertEquals(false, timerMh.validateInputValue("22"));
		Assert.assertEquals(false, timerMh.validateInputValue("58"));
	}
	
	@Test
	public void testZeroStartingMhValue()
	{
		timerMh.setNewPickupTime("30");
		Assert.assertFalse(timerMh.validateInputValue("05"));
		Assert.assertTrue(timerMh.validateInputValue("5"));
	}
	
	@Test
	public void testGetQLTimerTestType()
	{
		Assert.assertEquals(QLPickupItemType.MH,timerMh.getPickupType());
		Assert.assertEquals(QLPickupItemType.RA,timerRa.getPickupType());
	}
	
	@Test
	public void testCountingDownwards()
	{
		timerMhCountingDown.setNewPickupTime("45");
		Assert.assertTrue(timerMhCountingDown.validateInputValue("10"));
	}
	
	@Test
	public void testCountingDownwardsMoreTests()
	{
		timerMhCountingDown.setNewPickupTime("35");
		Assert.assertTrue(timerMhCountingDown.validateInputValue("0"));
		timerMhCountingDown.setNewPickupTime("34");
		Assert.assertTrue(timerMhCountingDown.validateInputValue("59"));
		timerMhCountingDown.setNewPickupTime("36");
		Assert.assertTrue(timerMhCountingDown.validateInputValue("1"));
		timerMhCountingDown.setNewPickupTime("59");
		Assert.assertTrue(timerMhCountingDown.validateInputValue("24"));
	}

	@Test
	public void testCountingDownRA() {
		timerRaCountingDown.setNewPickupTime("25");
		Assert.assertTrue(timerRaCountingDown.validateInputValue("0"));
		timerRaCountingDown.setNewPickupTime("26");
		Assert.assertTrue(timerRaCountingDown.validateInputValue("1"));
		timerRaCountingDown.setNewPickupTime("24");
		Assert.assertTrue(timerRaCountingDown.validateInputValue("59"));
		timerRaCountingDown.setNewPickupTime("45");
		Assert.assertTrue(timerRaCountingDown.validateInputValue("20"));
	}
	
}
