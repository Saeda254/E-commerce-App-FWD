package org.example.pages;

import org.example.stepDefs.BrowserOPERATION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Registerpage {



    public WebElement registerbutton()
    {
        WebElement registerbutton =   BrowserOPERATION.driver.findElement(By.className("ico-register"));
        return registerbutton;
    }

    public void gender() throws InterruptedException {
        BrowserOPERATION.driver.findElement(By.id("gender-female")).click();
        Thread.sleep(3000);
    }
    public WebElement first_name()
    {
        By firstName = By.id("FirstName");

        WebElement firstNameEle = BrowserOPERATION.driver.findElement(firstName);

        return firstNameEle;
    }
    public WebElement last_name()
    {
        By lastName =  By.id("LastName");
        WebElement lastNameEle = BrowserOPERATION.driver.findElement(lastName);
        return lastNameEle;
    }


    public void date_of_birth() throws InterruptedException {
        WebElement birthDay = BrowserOPERATION.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        Thread.sleep(3000);
        select.selectByIndex(24);

        WebElement birthMonth = BrowserOPERATION.driver.findElement(By.name("DateOfBirthMonth"));
        select  = new Select(birthMonth);
        Thread.sleep(3000);
        select.selectByValue("4");

        WebElement birthYear = BrowserOPERATION.driver.findElement(By.name("DateOfBirthYear"));
        select  = new Select(birthYear);
        Thread.sleep(3000);
        select.selectByVisibleText("1994");
    }

    public WebElement email() {
        By email = By.id("Email");
        WebElement emailEle = BrowserOPERATION.driver.findElement(email);
        return emailEle;
    }
    public WebElement fillPassword() throws InterruptedException {
        By password = By.id("Password");
        Thread.sleep(3000);
        WebElement passwordEle = BrowserOPERATION.driver.findElement(password);

        return passwordEle;
    }
    public WebElement confirmPassword() throws InterruptedException {
        By confPassword = By.id("ConfirmPassword");
        Thread.sleep(3000);
        WebElement confirmpasswordEle = BrowserOPERATION.driver.findElement(confPassword);

        return confirmpasswordEle;
    }
    public WebElement registButton() throws InterruptedException {
        WebElement registButton=   BrowserOPERATION.driver.findElement(By.name("register-button"));
        Thread.sleep(5000);
        return registButton;
    }
    public void result() {

        String actualResult = BrowserOPERATION.driver.findElement
                (By.cssSelector("div[class=\"result\"]")).getText();
        System.out.println(actualResult);
        String expectedResult = "Your registration completed";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualResult, expectedResult);

        String expectedColor = BrowserOPERATION.driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        String actualColor = Color.fromString(expectedColor).asHex();


        soft.assertEquals(actualColor,"#4cb17c");

        soft.assertAll();
    }


}
