package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RestpasswordStepDef {
    loginpage forgetpasswor = new loginpage();
    @Given("user open login page")
    public void userOpenLoginPage() {
        forgetpasswor.loginBtn().click();
    }

    @And("user clicks on forget password button")
    public void userClicksOnForgetPasswordButton() {
        forgetpasswor.forgetpasswordbutton().click();
    }
    @And("user type email \"valid\" \"(.*)\" and \"(.*)\"$")
    public void user_type_email(String validEmail)
    {
        forgetpasswor.validEmail().sendKeys(validEmail);

    }

    @And("user clicks on recover button")
    public void userClicksOnRecoverButton() {
        forgetpasswor.forgetpasswordbutton().click();
    }

    @Then("success message is displayed as Email with instructions has been sent to you")
    public void successMessageIsDisplayedAsEmailWithInstructionsHasBeenSentToYou() {
        forgetpasswor.successsuccess();
    }
}
