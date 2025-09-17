package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SauceDemoTest {

    WebDriver driver;
    private String browerName="chrome";
    public SauceDemoTest() {
        if(browerName.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else if(browerName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browerName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
    }

    @Test
    @DisplayName("testing with valid credentials")
    public void sauceDemoTest1(){
        driver.get("http://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    String actualURL = driver.getCurrentUrl();
    String expectedURL = "https://www.saucedemo.com/inventory.html";
    assertEquals(expectedURL, actualURL);

    }

    @Test
    @DisplayName("testing with invalid credentials")
    public void sauceDemoTest2(){
        driver.get("http://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce2");

        driver.findElement(By.id("login-button")).click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        assertNotEquals(expectedURL, actualURL);
    }
}
