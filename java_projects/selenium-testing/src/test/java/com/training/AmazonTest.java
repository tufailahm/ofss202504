package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class AmazonTest {
    WebDriver driver;
   //     private String browserName = "chrome";
    private String browserName = "edge";

    public AmazonTest() {
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("safari")){
            driver = new SafariDriver();
        }
        else if(browserName.equals("edge")){
            driver = new EdgeDriver();
        }
    }


    @Test
    @DisplayName("Serach for 'diamond studded name plate")
    public void amazonSearchTest1()
    {
            driver.get("https://www.amazon.in");

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("diamond studded name plate");
            driver.findElement(By.id("nav-search-submit-button")).click();
//            String expectedImageUrl = "https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL320_.jpg";
          WebElement imageURL =   driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL320_.jpg']"));
          assertTrue(imageURL.isDisplayed());

          driver.quit();

    }



}

