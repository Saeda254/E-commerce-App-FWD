package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;

public class WishlistStepDef {
    homePage wishlist = new homePage();

    @When("user add product to wishlist")
    public void user_add_product_to_wishlist() throws InterruptedException {
        wishlist.addProductToWishlist().click();
        Thread.sleep(5000);
    }

    @Then("wishlist notification success appear")
    public void wishlist_notification_success_appear() throws InterruptedException {
        wishlist.successMsg();
    }

}