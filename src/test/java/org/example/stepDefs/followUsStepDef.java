package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class followUsStepDef {
    homePage followUs = new homePage();

    @When("user opens facebook link")
    public void user_opens_facebook_link()
    {
        followUs.clickfacebookLink().click();
    }

    @And("^facebook \"([^\"]*)\" is opened in new tab$")
    public void facebook_opened_in_new_tab(String facebook) throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(BrowserOPERATION.driver.getWindowHandles());
        BrowserOPERATION.driver.switchTo().window(tabs.get(1));
        facebook = "https://www.facebook.com/nopCommerce";
        System.out.println(BrowserOPERATION.driver.getCurrentUrl());
        System.out.println(BrowserOPERATION.driver.getTitle());
        Assert.assertEquals(BrowserOPERATION.driver.getCurrentUrl(),facebook);
        BrowserOPERATION.driver.close();
        BrowserOPERATION.driver.switchTo().window(tabs.get(0));
    }
    @And("user opens twitter link")
    public void user_opens_twitter_link()
    {
        followUs.clickTwitterLink().click();
    }


    @And(("^twitter \"([^\"]*)\" is opened in new tab$"))
    public void twitter_opened_in_new_tab(String twitter) throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(BrowserOPERATION.driver.getWindowHandles());
        BrowserOPERATION.driver.switchTo().window(tabs.get(1));
        twitter = "https://twitter.com/nopCommerce";
        System.out.println(BrowserOPERATION.driver.getCurrentUrl());
        System.out.println(BrowserOPERATION.driver.getTitle());
        Assert.assertEquals(BrowserOPERATION.driver.getCurrentUrl(),twitter);
        BrowserOPERATION.driver.close();
        BrowserOPERATION.driver.switchTo().window(tabs.get(0));
    }

    @And("user opens rss link")
    public void user_opens_rss_link()
    {
        followUs.clickRssLink().click();
    }

    @And("^rss \"([^\"]*)\" is opened in new tab$")
    public void rss_opened_in_new_tab(String rss) throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(BrowserOPERATION.driver.getWindowHandles());
        BrowserOPERATION.driver.switchTo().window(tabs.get(1));
        rss = "https://demo.nopcommerce.com/new-online-store-is-open";
        System.out.println(BrowserOPERATION.driver.getCurrentUrl());
        System.out.println(BrowserOPERATION.driver.getTitle());
        Assert.assertEquals(BrowserOPERATION.driver.getCurrentUrl(),rss);
        BrowserOPERATION.driver.close();
        BrowserOPERATION.driver.switchTo().window(tabs.get(0));
    }

    @And("user opens youtube link")
    public void user_opens_youtube_link()
    {
        followUs.clickUtubeLink().click();
    }

    @Then("^youtube \"([^\"]*)\" is opened in new tab$")
    public void youtube_opened_in_new_tab(String youtube) throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(BrowserOPERATION.driver.getWindowHandles());
        BrowserOPERATION.driver.switchTo().window(tabs.get(1));
        youtube = "https://www.youtube.com/user/nopCommerce";
        System.out.println(BrowserOPERATION.driver.getCurrentUrl());
        System.out.println(BrowserOPERATION.driver.getTitle());
        Assert.assertEquals(BrowserOPERATION.driver.getCurrentUrl(),youtube);
        BrowserOPERATION.driver.close();
        BrowserOPERATION.driver.switchTo().window(tabs.get(0));
    }



}
