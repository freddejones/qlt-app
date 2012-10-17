package jones.code;

public class ResultHolder {

	private String guessedTime;
	private String pickupTime;
	private String time;
	private boolean isPassed;
	private QLPickupItemType testType;
	
	public ResultHolder(boolean isPass)
	{ isPassed = isPass; }
	
	public boolean isPassedResult()
	{ return isPassed; }
	
	public void setPickupType(QLPickupItemType testType)
	{ this.testType = testType; }
	
	public String getPickupType()
	{ 
		if (testType == QLPickupItemType.MH)
		return "MH";
	
		return "RA";
	}
	
	public void setPickuptime(String pickupTime)
	{ this.pickupTime = pickupTime; }
	
	public String getPickupTime()
	{ return this.pickupTime; }
	
	public void setTime(String time)
	{ this.time = time; }
	
	public String getTime()
	{ return time; }
	
	public void setGuessedTime(String message)
	{ guessedTime = message; }
	
	public String getGuessedTime()
	{ return guessedTime; }
	
}
