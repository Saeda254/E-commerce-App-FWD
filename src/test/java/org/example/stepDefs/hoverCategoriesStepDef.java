package org.example.stepDefs;

import io.cucumber.java.en.When;
import org.example.pages.homePage;


public class hoverCategoriesStepDef {

    homePage category = new homePage();
    @When("user could hover categories and select sub Category")
    public void user_hover_categories() throws InterruptedException {
        category.hoverCategories();

    }
}
