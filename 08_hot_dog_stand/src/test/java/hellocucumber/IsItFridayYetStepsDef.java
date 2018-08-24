package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class IsItFridayYetStepsDef implements En {
	public IsItFridayYetStepsDef() {
		Given("^today is Sunday$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		When("^I ask whether it's Friday yet$", () -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});

		Then("^I should be told \"([^\"]*)\"$", (String arg1) -> {
			// Write code here that turns the phrase above into concrete actions
			throw new PendingException();
		});
	}
}
