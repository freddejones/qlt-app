package jones.code;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jones.code.InputHandler;

public class TestSuiteInputHandler {

	InputHandler ih;
	
	@Before
	public void setup()
	{
		ih = new InputHandler();
	}
	
	@Test
	public void testFormattingOfInput()
	{
		Assert.assertEquals("33", ih.formatInputTimerValue("333"));
		Assert.assertEquals("12", ih.formatInputTimerValue("312"));
		Assert.assertEquals("1", ih.formatInputTimerValue("01"));
		Assert.assertEquals("0", ih.formatInputTimerValue("00"));
		Assert.assertEquals("0", ih.formatInputTimerValue("000"));
	}
	
	@Test
	public void testClearInputValue()
	{
		String clearedValue = ih.clearInputValue();
		Assert.assertEquals("0", clearedValue);
	}
}
