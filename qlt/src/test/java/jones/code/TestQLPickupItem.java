package jones.code;

import jones.code.scenario.PickupItem;

import junit.framework.*;

import org.junit.Before;
import org.junit.Test;

public class TestQLPickupItem {

	private PickupItem qlItem;
	
	@Before
	public void setup() {
		qlItem = new PickupItem();
	}
	
	@Test
	public void createQlPickupItemTest() {
		PickupItem qlItem = new PickupItem();
		Assert.assertNotNull("Object not null", qlItem);
	}
	
	@Test
	public void notNullValuesOfGeneratedQlPickupItem() {
		Assert.assertNotNull(qlItem.getCorrectAnswer());
		Assert.assertNotNull(qlItem.getItemType());
		Assert.assertNotNull(qlItem.getPickupTime());
	}
	
	@Test
	public void validateAnswerNegative() {
		int notCorrect = qlItem.getCorrectAnswer() + 1;
		notCorrect++;
		Assert.assertFalse(qlItem.validate(notCorrect));
	}
	
	@Test
	public void validateAnswerPositive() {
		int correct = qlItem.getCorrectAnswer();
		Assert.assertTrue(qlItem.validate(correct));
	}
	
}
