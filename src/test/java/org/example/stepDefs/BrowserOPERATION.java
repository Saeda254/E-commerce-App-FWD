package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserOPERATION {
    public static WebDriver driver = null;


    @Before
    public static void openBrowser()
    {
    //  SET DRIVER
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // SET CONFIGURATION
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // OPEN the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }



}
