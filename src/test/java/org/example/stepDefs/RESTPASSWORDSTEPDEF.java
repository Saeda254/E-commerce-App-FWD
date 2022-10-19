package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.loginpage;

public class RESTPASSWORDSTEPDEF {


    loginpage forgetpasswor = new loginpage();
    @Given("user open login page")
    public void userOpenLoginPage() {
        forgetpasswor.loginBtn().click();
    }

    @And("user clicks on forget password button")
    public void userClicksOnForgetPasswordButton() throws InterruptedException {
        forgetpasswor.forgetpasswordbutton().click();
    }
    @And("user type email \"valid\" \"(.*)\" and \"(.*)\"$")
    public void user_type_email(String validEmail)
    {
        forgetpasswor.validEmail().sendKeys(validEmail);

    }

    @And("user clicks on recover button")
    public void userClicksOnRecoverButton() throws InterruptedException {
        forgetpasswor.forgetpasswordbutton().click();
    }

    @Then("success message is displayed as Email with instructions has been sent to you")
    public void successMessageIsDisplayedAsEmailWithInstructionsHasBeenSentToYou() {
        forgetpasswor.successsuccess();
    }
}

