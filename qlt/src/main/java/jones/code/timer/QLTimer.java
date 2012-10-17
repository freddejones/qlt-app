package jones.code.timer;

import java.util.ArrayList;
import java.util.Random;

import jones.code.GetRandomInstance;
import jones.code.QLPickupItemType;

public class QLTimer {

	private String currentPickupTime;
	private QLPickupItemType testType;
	private Random rand;
	
	private static int MEGA_HEALTH_TIME = 35;
	private static int ARMOR_TIME = 25;
	private static int MINUTE_WRAPPER = 60;
	
	private boolean countingUp = false;

	private ArrayList<String> spawnTimes;
	
	public QLTimer(QLPickupItemType type, ArrayList<String> spawnTimes,
			boolean countingUp)
	{
		testType = type;
		this.spawnTimes = spawnTimes;
		rand = GetRandomInstance.getRandomInstance();
		createNewPickupTime();
		this.countingUp = countingUp;
	}
	
	public boolean validateInputValue(String inputValue) 
	{
		int totalTime; 
		if (countingUp)
		{
			totalTime = setTotalTime();
		} else {
			totalTime = setTotalTimeDownwards();
		}
		
		
		
		
		return inputValue.equals(Integer.toString(totalTime));
	}

	private int setTotalTimeDownwards() {
		int totalTime;
		switch (testType) {
		case MH:
			totalTime = Integer.parseInt(currentPickupTime) - MEGA_HEALTH_TIME;
			break;
		case RA:
			totalTime = Integer.parseInt(currentPickupTime) - ARMOR_TIME;
			break;
		default:
			totalTime = 0;
			break;
		}
		
		if (totalTime < 0)
		{	totalTime =  MINUTE_WRAPPER + totalTime; }
		
		return totalTime;
	}

	private int setTotalTime() {
		int totalTime;
		switch (testType) {
		case MH:
			totalTime = Integer.parseInt(currentPickupTime) + MEGA_HEALTH_TIME;
			break;
		case RA:
			totalTime = Integer.parseInt(currentPickupTime) + ARMOR_TIME;
			break;
		default:
			totalTime = 0;
			break;
		}
		
		if (totalTime >= MINUTE_WRAPPER)
		{	totalTime = totalTime - MINUTE_WRAPPER; }
		
		return totalTime;
	}

	protected void createNewPickupTime()
	{
		setNewPickupTime(generateNewPickupTimeValue());
	}
	
	public void setNewPickupTime(String time)
	{
		currentPickupTime = time;
	}
	
	public String getCurrentPickupTimeValue()
	{
		return currentPickupTime;
	}
	
	protected String generateNewPickupTimeValue()
	{		
		int pick = rand.nextInt(spawnTimes.size());
		currentPickupTime = spawnTimes.get(pick);
		
		return currentPickupTime;
	}
		public QLPickupItemType getPickupType() {
		return testType;
	}
}
