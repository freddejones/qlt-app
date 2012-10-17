package jones.code.scenario;

import jones.code.GetRandomInstance;
import jones.code.QLPickupItemType;

public class PickupItem {

	private QLPickupItemType itemType;
	private int pickupTime;
	private int correctAnswer;
	
	private static int MINUTE_WRAPPER = 60;
	private static int MEGA_HEALTH_TIME = 35;
	private static int ARMOR_TIME = 25;
	
	public PickupItem() {
		this.itemType = generatePickupType();
		this.pickupTime = generatePickupTime();
		this.correctAnswer = calculateAnswer(this.pickupTime);
	}
	
	public QLPickupItemType getItemType() {
		return itemType;
	}
	
	public String getItemTypeAsString() {
		if (itemType == QLPickupItemType.MH)
			return "MH";
		
		return "RA";
	}
	
	public int getPickupTime()
	{
		return pickupTime;
	}
	
	public boolean validate(int guessedTime)
	{
		return (guessedTime == correctAnswer);
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	
	private QLPickupItemType generatePickupType() {
		boolean isMega = GetRandomInstance.getRandomInstance().nextBoolean();
		if (isMega)
		{
			return QLPickupItemType.MH;
		}
		return QLPickupItemType.RA;
	}
	
	private int generatePickupTime() {
		return GetRandomInstance.getRandomInstance().nextInt(60);
	}
	
	private int calculateAnswer(int pickupTime)
	{
		int calculatedAnswer = -1;
		switch (itemType)
		{
		case MH: 
			calculatedAnswer = pickupTime + MEGA_HEALTH_TIME;
			break;
		case RA:
			calculatedAnswer = pickupTime + ARMOR_TIME;
			break;
		}
		
		if (calculatedAnswer >= MINUTE_WRAPPER)
		{ calculatedAnswer = calculatedAnswer - MINUTE_WRAPPER; }
		
		return calculatedAnswer;
	}
}
