package hellofitnesse;

import hellocucumber.HotDogManager;

public class LastOrderTime {
	private HotDogManager hotDogManager;

	public void reset() {
		hotDogManager = new HotDogManager();
	}

	public void setDayOfWeek(String day) {
		hotDogManager.setDay(day);
	}

	public String lastOrderTime() {
		return hotDogManager.getLastOrderTime();
	}
}
