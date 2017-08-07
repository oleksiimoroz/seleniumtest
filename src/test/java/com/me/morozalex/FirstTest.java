package com.me.morozalex;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 8/6/17.
 */
public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/?hl=en");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void wixSearch() {
       WebElement searchField = driver.findElement(By.name("q"));
       searchField.sendKeys("wix");
       WebElement searchButton = driver.findElement(By.name("btnK"));
       searchButton.click();
       WebElement wixLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a"));
       wixLink.click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainCta")));


    }
}
