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

public class GoogleTest {

    WebDriver driver;
    private String browerName="chrome";
    public GoogleTest() {
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
    @DisplayName("testing google search")
    public void googleSearchTest(){
        driver.get("http://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("1RKBellandur");
        //
        driver.findElement(By.name("btnK")).click();
    }
}
