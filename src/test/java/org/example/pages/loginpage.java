package org.example.pages;

import org.example.stepDefs.BrowserOPERATION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

    public class loginpage {
    public WebElement loginBtn()
    {
        WebElement loginBtn =   BrowserOPERATION.driver.findElement(By.className("ico-login"));
        return loginBtn;
    }

    public WebElement validEmail()
    {
        By validEmail = By.id("Email");

        WebElement validEmailEle = BrowserOPERATION.driver.findElement(validEmail);

        return validEmailEle;
    }
    public WebElement validPassword()
    {
        By validPassword =  By.id("Password");
        WebElement validPasswordEle = BrowserOPERATION.driver.findElement(validPassword);
        return validPasswordEle;
    }
    public WebElement invalidEmail()
    {
        By invalidEmail = By.id("Email");

        WebElement invalidEmailEle = BrowserOPERATION.driver.findElement(invalidEmail);

        return invalidEmailEle;
    }
    public WebElement invalidPassword()
    {
        By invalidPassword =  By.id("Password");
        WebElement invalidPasswordEle = BrowserOPERATION.driver.findElement(invalidPassword);
        return invalidPasswordEle;
    }


    public WebElement logBtn() throws InterruptedException {
    WebElement logBtn =   BrowserOPERATION.driver.findElement(By.className("login-button"));
    Thread.sleep(3000);
    return logBtn;
    }

    public void successLogin() {

        String actualResult = BrowserOPERATION.driver.getCurrentUrl();
        System.out.println(actualResult);
        String expectedResult = "https://demo.nopcommerce.com/";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualResult, expectedResult);

        WebElement accountTab = BrowserOPERATION.driver.findElement(By.className("ico-account"));
        soft.assertTrue(accountTab.isDisplayed(), String.valueOf(true));

        soft.assertAll();
    }

    public void unSuccessLogin() {
        String actualMsg = BrowserOPERATION.driver.findElement(By.className("message-error")).getText();
        System.out.println(actualMsg);

        String expectedMsg = "Login was unsuccessful";

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualMsg.contains(expectedMsg));

        String  actualColor = BrowserOPERATION.driver.findElement(By.className("message-error")).getCssValue("color");
        String expectedColor = Color.fromString(actualColor).asHex();

        soft.assertEquals(expectedColor,"#e4434b");
        soft.assertAll();
    }


            public WebElement forgetpasswordbutton()throws InterruptedException{
                WebElement forgetpasswordbutton =   BrowserOPERATION.driver.findElement(By.className("forgot-password"));
                Thread.sleep(3000);
                return forgetpasswordbutton;

            }
            public WebElement recoverbutton(){
                By recoverbutton = By.className("button-1 password-recovery-button");
                WebElement recoverbuttonELe= BrowserOPERATION.driver.findElement(recoverbutton);

                return recoverbuttonELe;
            }
            public void successsuccess() {

                String actualResult = BrowserOPERATION.driver.getCurrentUrl();
                System.out.println(actualResult);
                String expectedResult = "https://demo.nopcommerce.com/passwordrecovery";
                SoftAssert soft = new SoftAssert();
                soft.assertEquals(actualResult, expectedResult);

                WebElement accountTab = BrowserOPERATION.driver.findElement(By.className("bar-notification success"));
                soft.assertTrue(accountTab.isDisplayed(), String.valueOf(true));

                soft.assertAll();
            }

}
