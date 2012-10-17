package jones.code.scenario;

import java.util.ArrayList;

public class PickupItemsHandler {

	private ArrayList<PickupItem> pickupItems;
	private int nrOfPickupItems;
	
	public PickupItemsHandler(int nrOfPickupItems)
	{
		this.nrOfPickupItems = nrOfPickupItems;
	}
	
	public void generateItems() {
		
		pickupItems = new ArrayList<PickupItem>();
		for (int i = 0; i < nrOfPickupItems; i++) {
			pickupItems.add(new PickupItem());
		}
	}
	
	public ArrayList<PickupItem> getPickupItemsList()
	{
		return pickupItems;
	}
}
