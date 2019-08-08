package StepsDefenition;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class LoginSteps {
    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("GivenSteps");
//        throw new PendingException();
    }


    @And("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click login page$")
    public void iClickLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("AndTwo");
 //       throw new cucumber.api.PendingException();
    }

    @Then("^I should see user page$")
    public void iShouldSeeUserPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then");
        throw new cucumber.api.PendingException();
    }


}
