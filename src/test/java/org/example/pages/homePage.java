package org.example.pages;

import org.example.stepDefs.BrowserOPERATION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage {

public void selectEuro() throws InterruptedException {
    WebElement euro = BrowserOPERATION.driver.findElement(By.name("customerCurrency"));
    Select select = new Select(euro);
    Thread.sleep(2000);
    select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }
        public void euroSymbol()
        {
          int count =  BrowserOPERATION.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).size();
          for (int x = 0; x<count; x++)
          {
            String text = BrowserOPERATION.driver.findElements(By.cssSelector("Span[class=\"price actual-price\"]")).get(x).getText();
            Assert.assertTrue(text.contains("€"));
          }
    }


        public void searchBox()
        {
            By searchBox =  By.id("small-searchterms");
            WebElement searchBoxEle = BrowserOPERATION.driver.findElement(searchBox);
        }
         public WebElement searchBtn()
        {
        By searchBtn =  By.className("button-1");
        WebElement searchBtnEle = BrowserOPERATION.driver.findElement(searchBtn);
        String searchUrl = BrowserOPERATION.driver.getCurrentUrl();
        System.out.println(searchUrl);
        String expectedUrl = "https://demo.nopcommerce.com/search?";
        Assert.assertTrue(expectedUrl.contains(searchUrl));
        return searchBtnEle;

        }

        public void typeProductName(String productname)
        {

            int pcount = BrowserOPERATION.driver.findElements(By.id("small-searchterms")).size();
            for (int x = 0; x<pcount; x++)
            {
                BrowserOPERATION.driver.findElements(By.id("small-searchterms")).get(x).sendKeys(productname);
            }

        }
        public void searchResult()
        {

            int item = BrowserOPERATION.driver.findElements(By.id("small-searchterms")).size();
            for (int x = 0; x<item; x++)
            {
                 String itemname =   BrowserOPERATION.driver.findElements(By.className("product-item")).get(x).getText();
                 String searchinput =  BrowserOPERATION.driver.findElements(By.id("small-searchterms")).get(x).getText();
                 Assert.assertTrue(itemname.contains(searchinput));
            }
        }

        public void typeProductSku(String sku) throws InterruptedException
        {
            int scount = BrowserOPERATION.driver.findElements(By.id("small-searchterms")).size();
             for (int x = 0; x<scount; x++)
             {
            BrowserOPERATION.driver.findElements(By.id("small-searchterms")).get(x).sendKeys(sku);
            Thread.sleep(2000);
             }
        }

        public void skuResult(String sku) throws InterruptedException {


            BrowserOPERATION.driver.findElement(By.className("picture")).click();
           Thread.sleep(3000);
            String actualsku =  BrowserOPERATION.driver.findElement(By.className("sku")).getText();
            System.out.println("actual  " + actualsku);
            System.out.println("expected  " + sku);
            String tag = "SKU: ";
            Assert.assertEquals(tag.concat(sku), actualsku);
        }



        public void hoverCategories() {
            Actions action = new Actions(BrowserOPERATION.driver);
            List<WebElement> mainCategories = BrowserOPERATION.driver.findElements
                    (By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
            int count = mainCategories.size();
            System.out.println(count);
            int min = 0;
            int max = count - 1;
            int selectedMainCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            action.moveToElement(mainCategories.get(selectedMainCategory)).perform();
            String selectedMainCategoryName = mainCategories.get(selectedMainCategory).getText();
            System.out.println("The selected main category name is : " + selectedMainCategoryName);



            String locator = "(//ul[@class='top-menu notmobile']//ul)[" + (selectedMainCategory + 1) +"]/li";
            List<WebElement> subCategoryLinks = BrowserOPERATION.driver.findElements(By.xpath(locator));
            BrowserOPERATION.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            if(!subCategoryLinks.isEmpty())
            {
                int subCount = subCategoryLinks.size();
                System.out.println("The selected sub category count is  " + subCount);
                int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
                String selectedSubCategoryName = subCategoryLinks.get(selectedSubCategory).getText();
                System.out.println("The selected sub category name is  " + selectedSubCategoryName);
                subCategoryLinks.get(selectedSubCategory).click();
                String subCategoryTitle = BrowserOPERATION.driver.getCurrentUrl();
                System.out.println("Sub Category Title is :" + subCategoryTitle);
                Assert.assertTrue(subCategoryTitle.contains(selectedSubCategoryName.toLowerCase().trim()));            }
            else
            {
                mainCategories.get(selectedMainCategory).click();

                Assert.assertTrue(BrowserOPERATION.driver.getCurrentUrl().contains(selectedMainCategoryName.toLowerCase().trim()));
            }

            BrowserOPERATION.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

    public WebElement locateFirstSlider() throws InterruptedException {
        By firstSlider = By.xpath("//a[@rel=\"0\"]");
        WebElement firstSliderEle = BrowserOPERATION.driver.findElement(firstSlider);
        Thread.sleep(1000);

        System.out.println(firstSliderEle.getText());
        return firstSliderEle;
    }
    public WebElement selectFirstProduct() throws InterruptedException {
        By firstSliderProduct =  By.xpath("//*[@id=\"nivo-slider\"]/a[1]");
        WebElement firstSliderProductEle = BrowserOPERATION.driver.findElement(firstSliderProduct);
        Thread.sleep(1000);
        return firstSliderProductEle;
    }
    public void getFirstSliderProductUrl()
    {

        String firstSliderProductUrl = BrowserOPERATION.driver.getCurrentUrl();
        BrowserOPERATION.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(firstSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(firstSliderProductUrl, expectedUrl);
    }



    public WebElement locateSecondSlider() throws InterruptedException {
        By secondSlider =  By.xpath("//a[@rel=\"1\"]");
        WebElement secondSliderEle = BrowserOPERATION.driver.findElement(secondSlider);
        Thread.sleep(1000);
        System.out.println(secondSliderEle.getText());
        return secondSliderEle;
    }

    public WebElement selectSecondProduct() throws InterruptedException {
        By SecondSliderProduct =   By.xpath("//*[@id=\"nivo-slider\"]/a[2]");
        WebElement secondSliderProductEle = BrowserOPERATION.driver.findElement(SecondSliderProduct);

        Thread.sleep(1000);

        return secondSliderProductEle;
    }
    public void getSecondSliderProductUrl()
    {

        String SecondSliderProductUrl = BrowserOPERATION.driver.getCurrentUrl();
        BrowserOPERATION.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(SecondSliderProductUrl);
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        Assert.assertEquals(SecondSliderProductUrl, expectedUrl);

    }

    public WebElement clickfacebookLink()
    {
        WebElement faceBookEle = BrowserOPERATION.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
        String faceBookLink = faceBookEle.getText();
        System.out.println(faceBookLink);
        return faceBookEle;
    }

    public WebElement clickTwitterLink()
    {
        WebElement twitterEle = BrowserOPERATION.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
        String twitterLink = twitterEle.getText();
        System.out.println(twitterLink);
        return twitterEle;
    }

    public WebElement clickRssLink()
    {
        WebElement rssEle = BrowserOPERATION.driver.findElement(By.className("rss"));
        String rssLink = rssEle.getText();
        System.out.println(rssLink);
        return rssEle;
    }


    public WebElement clickUtubeLink()
    {
        WebElement uTubeEle = BrowserOPERATION.driver.findElement(By.className("youtube"));
        String uTubeLink = uTubeEle.getText();
        System.out.println(uTubeLink);
        return uTubeEle;
    }
    public WebElement addProductToWishlist()  {
        WebElement htcBtnEle = BrowserOPERATION.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
        String htcBtn = htcBtnEle.getText();

        System.out.println(htcBtn);

        return htcBtnEle;
    }
    public void getsuccessMsg()
    {
        WebElement successBar = BrowserOPERATION.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
        String succesMsgColor = successBar.getCssValue("background-color");
        String expectedColor = Color.fromString(succesMsgColor).asHex();


        SoftAssert soft = new SoftAssert();
        soft.assertTrue(successBar.isDisplayed(), "success notification bar is not displayed");
        soft.assertEquals(expectedColor,"#4bb07a");
        soft.assertAll();
        System.out.println("actual color is : " +succesMsgColor);
        System.out.println("expected color is :" +expectedColor);
        System.out.println("actual color is : " +succesMsgColor);
        System.out.println("expected color is :" +expectedColor);
    }
    public WebElement getWishList()
    {
        return BrowserOPERATION.driver.findElement(By.xpath("//a[@href=\"/wishlist\"]"));
    }
    public void getWishlistQuantity()
    {
        WebElement  wishlistquantityEle = BrowserOPERATION.driver.findElement(By.cssSelector("#bar-notification > div > p"));
        String wishlistquantity = wishlistquantityEle.getAttribute("value");
        System.out.println(wishlistquantity);
            int actualQuantity = Integer.parseInt(wishlistquantity);
        Assert.assertTrue(actualQuantity  > 0 );

    }









}











