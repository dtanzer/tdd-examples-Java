package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

import static org.junit.Assert.assertTrue;

public class AmountTooSmallSteps implements En {

	private String dayToTest;

	public AmountTooSmallSteps() {
		HotDogManager hdm = new HotDogManager();
		Given("^today is ([^\"]*)$", (String day) -> {
			hdm.setDay(day);
		});

		Given("^the amount of buns is (\\d+)$", (Integer initialBunAmount) -> {
			hdm.setBunAmount(initialBunAmount);
		});

		When("^somebody orders a hot dog$", () -> {
			hdm.orderHotDog();
		});

		Then("^the application has to order buns$", () -> {
			assertTrue(hdm.isOrderInProgress());
		});
	}
}
