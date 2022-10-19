package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.homePage;

public class currenciesStepDef {

    homePage currency = new homePage();

    @Given("user select euro currency")
    public void user_select_euro() throws InterruptedException {
        currency.selectEuro();
    }

    @Then("user can find euro symbol displayed in home page products")
    public void euro_symbol()
    {
        currency.euroSymbol();
    }
}
