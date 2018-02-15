package org.fasttrackit.cart;

import org.fasttrackit.AppConfig;
import org.fasttrackit.webviews.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;



public class CartTest {

    @Test

    public void addProductToCart() {
        System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());

        WebDriver driver = new ChromeDriver();

        driver.get(AppConfig.getSiteUrl());

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);
        System.out.println("Pressed Enter in search field.");

        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();

        WebElement successMessageContainer = driver.findElement(By.cssSelector("li.success-msg"));

        assertThat("Product no added to cart.", successMessageContainer.getText(), containsString("Herald Glass Vase"));

        //todo: assert that product is present in cart
    }


    public void specialPriceDisplayedAfterSimpleSearch() {
        System.setProperty("webdriver.chrome.driver", "/Users/ElenaSimonaAncuta/Desktop/webDrivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";

        Header header = PageFactory.initElements(driver, Header.class);

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        String oldPrice = driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();

        String specialPrice = driver.findElement(By.xpath("//p[@class='special-price']//span[@class='price']")).getText();

        //div[@class='product-info' and ./descendant::*[@class='product-name' and ./a[text()='Modern Murray Ceramic Vase']]]//p[@class='old-price']//span[@class='price']

        //p[@class='old-price' and ./ancestor::*[.//*text()='Modern Murray Ceramic Vase']]]

        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name a"));

        System.out.println("Stored" + productNames.size() + "produce names from search results");

        for (WebElement productName : productNames) {
            assertThat("Some of the product names do not contain the searched keyword.", productName.getText(), containsString(keyword.toUpperCase()));
        }
    }

    public class CartTest {

        @Test
        public void checkSizeAndColor() {
            System.setProperty("webdriver.chrome.driver",
                    AppConfig.getChromeDriverPath());

            WebDriver driver = new ChromeDriver();
            driver.get(AppConfig.getSiteUrl());

            WebElement element = driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Women']"));

            Actions action = new Actions(driver);

            action.moveToElement(element).build().perform();

            driver.findElement(By.linkText("New Arrivals")).click();

            driver.findElement(By.xpath("//div[@class='product-info']//a[text()='View Details']")).click();

            driver.findElement(By.xpath("//div[@class='input-box']//*[contains(text(),'Pink')]")).click();

        }
    }
}


