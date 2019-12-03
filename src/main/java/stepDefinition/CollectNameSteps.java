package stepDefinition;


import io.cucumber.java.en.Given;
import pico.FullName;

public class CollectNameSteps {

	private FullName name;
	
	public CollectNameSteps(FullName name) {
		this.name = name;
	}

	@Given("First Name is {string}")
	public void first_Name_is(String firstName) {
		name.setFirstName(firstName);
	}

	@Given("Last Name is {string}")
	public void last_Name_is_Doe(String lastName) {
		name.setLastName(lastName);
	}
}
