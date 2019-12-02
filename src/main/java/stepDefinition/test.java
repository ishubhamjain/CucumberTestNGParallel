package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test {
	
	@Given("^I open the application$")
	public void i_open_the_application() throws Throwable {
		System.out.println("I open the application");
	}

	@When("^I enter username as Rob$")
	public void i_enter_username_as_Rob() throws Throwable {
		System.out.println("I enter username as Rob");
	}

	@When("^I enter password as xyz(\\d+)$")
	public void i_enter_password_as_xyz(int arg1) throws Throwable {
		System.out.println("I enter password as xyz");
	}

	@Then("^I enter title as title(\\d+)$")
	public void i_enter_title_as_title(int arg1) throws Throwable {
		System.out.println("I enter title as title");
	}

	@Then("^press submit$")
	public void press_submit() throws Throwable {
		System.out.println("press submit");
	}

	@When("^I enter username as Bob$")
	public void i_enter_username_as_Bob() throws Throwable {
		System.out.println("I enter username as Bob");
	}


}
