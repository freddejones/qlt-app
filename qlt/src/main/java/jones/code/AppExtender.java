package jones.code;

import java.util.ArrayList;

import jones.code.scenario.PickupItem;
import jones.code.scenario.ScenarioInformationHolder;
import jones.code.scenario.ScenarioResultHolder;
import jones.code.timer.QLTimerTestHandler;

import android.app.Application;

public class AppExtender extends Application {

	public QLTimerTestHandler timerHandler;
	public ArrayList<PickupItem> pickupItems;
	
	public PickupItem currentPickupItem;
	public ScenarioInformationHolder scenarioInfo;
	public ScenarioResultHolder resultHolder;
	
}
