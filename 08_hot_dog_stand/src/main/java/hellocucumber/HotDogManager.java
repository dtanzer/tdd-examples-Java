package hellocucumber;

public class HotDogManager {

	private String day;
	private int bunAmount;
	private boolean orderInProgress;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setBunAmount(int bunAmount) {
		this.bunAmount = bunAmount;
	}

	public int getBunAmount() {
		return bunAmount;
	}

	public void orderHotDog() {
		bunAmount--;
		orderInProgress = true;
	}

	public boolean isOrderInProgress() {
		return orderInProgress;
	}

	public String getLastOrderTime() {
		switch (day) {
			case "Thursday":
				return "16:00";
			case "Friday":
				return "22:00";
			default:
				return null;
		}
	}
}
