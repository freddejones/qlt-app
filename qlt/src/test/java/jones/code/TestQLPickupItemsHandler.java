package jones.code;

import jones.code.scenario.PickupItemsHandler;

import junit.framework.*;

import org.junit.Test;

public class TestQLPickupItemsHandler {

	
	@Test
	public void createQLPickupItemsHandlerTest() {
		PickupItemsHandler qlpihL = new PickupItemsHandler(0);
		Assert.assertNotNull(qlpihL);
	}
	
	@Test
	public void createFiveQlPickupItemsTest() {
		PickupItemsHandler qlpihL = new PickupItemsHandler(5);
		qlpihL.generateItems();
		Assert.assertEquals(5, qlpihL.getPickupItemsList().size());
	}
	
	
}
