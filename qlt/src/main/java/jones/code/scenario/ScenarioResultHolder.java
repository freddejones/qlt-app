package jones.code.scenario;

import java.util.ArrayList;


public class ScenarioResultHolder {

	private ArrayList<ScenarioResult> results = null;
	
	public ScenarioResultHolder() {
		results = new ArrayList<ScenarioResult>();
	}
	
	public void addNewResult(ScenarioResult result) {
		results.add(result);
	}
	
	public ArrayList<ScenarioResult> getResultsList() {
		return results;
	}
}
