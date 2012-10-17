package jones.code.scenario;

public class ScenarioResult {

	private String itemType;
	private String message;
	private String spawnTime;
	private String correctTime;
	private String guessedTime;
	private boolean isPassed;
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSpawnTime() {
		return spawnTime;
	}
	public void setSpawnTime(String spawnTime) {
		this.spawnTime = spawnTime;
	}
	public String getCorrectTime() {
		return correctTime;
	}
	public void setCorrectTime(String correctTime) {
		this.correctTime = correctTime;
	}
	public String getGuessedTime() {
		return guessedTime;
	}
	public void setGuessedTime(String guessedTime) {
		this.guessedTime = guessedTime;
	}
	public boolean getIsPassed() {
		return isPassed;
	}
	public void setIsPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
}
