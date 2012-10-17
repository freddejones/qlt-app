package jones.code.scenario;

public class ScenarioInformationHolder {

	private int numberOfItems;
	private int timeoutBetweenSpawns;
	private int timeoutItemVisible;
	private int numberOfScenarios;
	
	public int getNumberOfScenarios() {
		return numberOfScenarios;
	}
	public void setNumberOfScenarios(int numberOfScenarios) {
		this.numberOfScenarios = numberOfScenarios;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public int getTimeoutBetweenSpawns() {
		return timeoutBetweenSpawns;
	}
	public void setTimeoutBetweenSpawns(int timeoutBetweenSpawns) {
		this.timeoutBetweenSpawns = timeoutBetweenSpawns;
	}
	public int getTimeoutItemVisible() {
		return timeoutItemVisible;
	}
	public void setTimeoutItemVisible(int timeoutItemVisible) {
		this.timeoutItemVisible = timeoutItemVisible;
	}
	
}
