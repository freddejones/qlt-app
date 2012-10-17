package jones.code;

import java.util.ArrayList;

import jones.code.QLPickupItemType;
import jones.code.timer.QLTimerTestHandler;
import jones.code.timer.TypeOfQLTimerTest;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestSuiteQLTimerHandler {

	QLTimerTestHandler testhandler;
	ArrayList<String> spawnValues;
	
	@Before
	public void setup()
	{
		spawnValues = new ArrayList<String>();
		spawnValues.add("0");
		spawnValues.add("1");
		testhandler = new QLTimerTestHandler();
	}
	
	@Test
	public void testCreateTwoMHTestInstances() {
		
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 10, spawnValues, 2, true);
		Assert.assertEquals(10,testhandler.getTestList().size());
	}
	
	
	@Test
	public void testArmorConstructor() {
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 1, spawnValues, 2, true);
		Assert.assertTrue(
				testhandler.getTestList().get(0).
				getCurrentPickupTimeValue().endsWith("0") ||
				testhandler.getTestList().get(0).
				getCurrentPickupTimeValue().endsWith("1"));
	}
	
	@Test
	public void testCorrectAnswer()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 1, spawnValues, 2, true);
		testhandler.getTestList().get(0).setNewPickupTime("10");
		Assert.assertTrue(testhandler.isCorrectAnswer("45"));
	}
	
	@Test
	public void testSizeOfCorrectAnswerTestList()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 6, spawnValues, 2, true);
		Assert.assertEquals(6, testhandler.getTestList().size());
		testhandler.getTestList().get(0).setNewPickupTime("5");
		testhandler.isCorrectAnswer("40");
		Assert.assertEquals(5, testhandler.getTestList().size());
	}
	
	@Test
	public void testSizeOfNotcorrectAnswerTestList()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 2, spawnValues, 2, true);
		Assert.assertEquals(2, testhandler.getTestList().size());
		testhandler.getTestList().get(0).setNewPickupTime("10");
		testhandler.isCorrectAnswer("40");
		Assert.assertEquals(1, testhandler.getTestList().size());
	}
	
	@Test
	public void testSizeOfResultAnswerList()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(0, testhandler.getResultList().size());
		testhandler.getTestList().get(0).setNewPickupTime("2");
		testhandler.isCorrectAnswer("37");
		Assert.assertEquals(1,testhandler.getResultList().size());
	}
	
	@Test
	public void testSizeOfResultFaultyResultList()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(0, testhandler.getResultList().size());
		testhandler.getTestList().get(0).setNewPickupTime("1");
		testhandler.isCorrectAnswer("37");
		Assert.assertEquals(1, testhandler.getResultList().size());
	}
	
	@Test
	public void testGetTotalNumberOfTestsForCorrectAnswer()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(4,testhandler.getTotalNumberOfTestOrdered());
		testhandler.getTestList().get(0).setNewPickupTime("2");
		testhandler.isCorrectAnswer("37");
		Assert.assertEquals(4,testhandler.getTotalNumberOfTestOrdered());
	}
	
	@Test
	public void testGetTotalNumberOfTestsForFaultyAnswer()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(4,testhandler.getTotalNumberOfTestOrdered());
		testhandler.getTestList().get(0).setNewPickupTime("2");
		testhandler.isCorrectAnswer("38");
		Assert.assertEquals(4,testhandler.getTotalNumberOfTestOrdered());
	}
	
	@Test
	public void testGetMhOnlyType()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(QLPickupItemType.MH, 
				testhandler.getCurrentPickupType());
		testhandler.isCorrectAnswer("1");
		Assert.assertEquals(QLPickupItemType.MH, 
				testhandler.getCurrentPickupType());
		testhandler.isCorrectAnswer("1");
		Assert.assertEquals(QLPickupItemType.MH, 
				testhandler.getCurrentPickupType());
	}
	
	@Test
	public void testGetRaOnlyType()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 4, spawnValues, 2, true);
		Assert.assertEquals(QLPickupItemType.RA, 
				testhandler.getCurrentPickupType());
		testhandler.isCorrectAnswer("1");
		Assert.assertEquals(QLPickupItemType.RA, 
				testhandler.getCurrentPickupType());
		testhandler.isCorrectAnswer("1");
		Assert.assertEquals(QLPickupItemType.RA, 
				testhandler.getCurrentPickupType());
	}
	
	@Test
	public void testResultListIsCorrect()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 2, spawnValues, 2, true);
		testhandler.getTestList().get(0).setNewPickupTime("10");
		testhandler.isCorrectAnswer("35");
		Assert.assertTrue(testhandler.getResultList().get(0).isPassedResult());
	}
	
	@Test
	public void testResultListIsFailed()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 2, spawnValues, 2, true);
		testhandler.getTestList().get(0).setNewPickupTime("10");
		testhandler.isCorrectAnswer("36");
		Assert.assertFalse(testhandler.getResultList().get(0).isPassedResult());
	}
	
	@Test
	public void testResultListNumberOfReturnedCorrectPosts()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 3, spawnValues, 2, true);
		testhandler.getTestList().get(0).setNewPickupTime("10");
		testhandler.getTestList().get(1).setNewPickupTime("10");
		testhandler.getTestList().get(2).setNewPickupTime("10");
		testhandler.isCorrectAnswer("35");
		testhandler.isCorrectAnswer("35");
		testhandler.isCorrectAnswer("35");
		Assert.assertEquals(3,testhandler.getTotalNumberOfSuccessTests());
	}
	
	@Test
	public void testThresholdInstansiateWithValue2()
	{
		int thresholdValue = 2;
		testhandler.createTestInstances(TypeOfQLTimerTest.MH_RA, 3, spawnValues, thresholdValue, true);
		Assert.assertEquals(2, testhandler.getThresholdValue());
	}
	
	@Test
	public void testInstancesWithCountingDownwards()
	{
		testhandler.createTestInstances(TypeOfQLTimerTest.RA_ONLY, 2, spawnValues, 2, false);
		testhandler.getTestList().get(0).setNewPickupTime("10");
		testhandler.isCorrectAnswer("45");
		Assert.assertTrue(testhandler.getResultList().get(0).isPassedResult());
	}
}
