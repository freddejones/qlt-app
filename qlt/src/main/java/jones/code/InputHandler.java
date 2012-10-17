package jones.code;

public class InputHandler {

	public String formatInputTimerValue(String currentValue)
	{
		if (currentValue.length() > 2)
		{
			currentValue = currentValue.substring(1);
		}
		
		if (currentValue.length() > 1 &&
				currentValue.startsWith("0"))
		{
			currentValue = currentValue.substring(1);
		}
		
		return currentValue;
	}

	public String clearInputValue() {
		return "0";
	}
	
}
