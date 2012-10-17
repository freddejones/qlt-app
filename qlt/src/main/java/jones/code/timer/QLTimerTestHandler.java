package jones.code.timer;

import java.util.ArrayList;
import java.util.Random;

import jones.code.GetRandomInstance;
import jones.code.QLPickupItemType;
import jones.code.ResultHolder;

public class QLTimerTestHandler {

	private ArrayList<QLTimer> testInstances;
	private ArrayList<ResultHolder> results;
	private int totalNrOfTests = 0;
	private int thresholdValue = 5;
	
	public QLTimerTestHandler() {
	}	
	
	public void createTestInstances(TypeOfQLTimerTest typeOfTimerTest,
			int numberOfTests, ArrayList<String> spawnTimes, int thresholdValue,
			boolean countingUpwards)
	{
		results = new ArrayList<ResultHolder>();
		testInstances = new ArrayList<QLTimer>();
		totalNrOfTests = numberOfTests;
		this.thresholdValue = thresholdValue;
		
		QLPickupItemType selection = null;
		if (typeOfTimerTest == TypeOfQLTimerTest.MH_ONLY)
		{	selection = QLPickupItemType.MH; }
		else if (typeOfTimerTest == TypeOfQLTimerTest.RA_ONLY)
		{	selection = QLPickupItemType.RA; }
		
		
		Random rand = GetRandomInstance.getRandomInstance();
		for (int i = 0; i < numberOfTests; i++) {
			
			if (typeOfTimerTest == TypeOfQLTimerTest.MH_RA)
			{
				/* default setting */
				selection = QLPickupItemType.RA;
				
				if (rand.nextBoolean())
				{ selection = QLPickupItemType.MH; }
			}
			
			// FIX add variable here to create instances
			testInstances.add(new QLTimer(selection, spawnTimes, countingUpwards));
		}
	}

	public ArrayList<QLTimer> getTestList() {
		return testInstances;
	}

	public boolean isTestEmpty()
	{
		return testInstances.isEmpty();
	}
	
	public boolean isCorrectAnswer(String inputValue)
	{
		return isCorrectAnswer(inputValue, "0");
	}
	
	public boolean isCorrectAnswer(String inputValue, String diffTime) {
		
		if (testInstances.isEmpty())
			return false;
		
		ResultHolder resultsOfTest;
		String testTime = testInstances.get(0).getCurrentPickupTimeValue().toString();
		testTime = formatNumberUnder10(testTime);
		
		if (testInstances.get(0).validateInputValue(inputValue))
		{
			resultsOfTest = new ResultHolder(true);
			setResultHolderValues(diffTime, resultsOfTest, testTime, 
					formatNumberUnder10(inputValue));
			return true;
		} else 
		{
			resultsOfTest = new ResultHolder(false);
			setResultHolderValues(diffTime, resultsOfTest, testTime, 
					formatNumberUnder10(inputValue));
			return false;
		}
	}

	private String formatNumberUnder10(String time) {
		if (time.length() == 1)
		{ 
			time = "0" + time;
		}
		
		return time;
	}

	private void setResultHolderValues(String diffTime,
			ResultHolder resultsOfTest, String pickupTime, 
			String guessTime) {
		resultsOfTest.setTime(diffTime);
		resultsOfTest.setPickupType(testInstances.get(0).getPickupType());
		resultsOfTest.setPickuptime(pickupTime);
		resultsOfTest.setGuessedTime(guessTime);
		results.add(resultsOfTest);
		testInstances.remove(0);
	}

	public ArrayList<ResultHolder> getResultList() {
		return results;
	}

	public int getTotalNumberOfTestOrdered()
	{
		return totalNrOfTests;
	}
	
	public QLPickupItemType getCurrentPickupType()
	{
		if (testInstances.isEmpty())
			return QLPickupItemType.MH;
		
		return testInstances.get(0).getPickupType();
	}

	public int getTotalNumberOfSuccessTests() {
		
		int passedTestCount = 0;
		for (int i = 0; i < results.size(); i++) {
			
			if (results.get(i).isPassedResult())
				passedTestCount++;
		}
		
		return passedTestCount;
	}

	public int getThresholdValue() {
		return thresholdValue;
	}


}
