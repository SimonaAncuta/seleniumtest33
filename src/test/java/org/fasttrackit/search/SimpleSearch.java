package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class SimpleSearch {

    @Test

    public void SimpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "/Users/ElenaSimonaAncuta/Desktop/webDrivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");





        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);


    }

}

