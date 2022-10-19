package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Registerpage;


public class registerStepDef {
    Registerpage reg = new Registerpage();

    @Given("user open register page")
    public void user_go_to_register_page()

    {
        reg.registerbutton().click();
    }
    @When("user select gender type")
    public void gender() throws InterruptedException {
       reg.gender();
    }

    @And ("^user type first name \"(.*)\" and last name \"(.*)\"$")
    public void first_last_name(String firstname, String lastname)
    {
        reg.first_name().sendKeys(firstname);
        reg.last_name().sendKeys(lastname);
    }


    @And("user set date of birth")
    public void user_set_date_of_birth() throws InterruptedException {
        reg.date_of_birth();
    }
    @And("^user type email \"(.*)\" field$")
    public void user_type_email(String email)
    {
        reg.email().sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void fills_password_fields(String password, String confPassword) throws InterruptedException {
        reg.fillPassword().sendKeys(password);
        reg.confirmPassword().sendKeys(confPassword);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        reg.registerbutton().click();
    }
    @Then("success message is displayed")
    public void Success_message_displayed()
    {
        reg.result();

    }

}
