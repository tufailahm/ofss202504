package com.training;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParaBankTest {

    WebDriver driver;
    private String browerName="chrome";
    public ParaBankTest() {
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




    @Given("the user is on the login page of the website")
    public void the_user_is_on_the_login_page_of_the_website() {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        System.out.println("Login page of the website");
    }
    @When("user types username and password")
    public void user_types_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
    //    throw new io.cucumber.java.PendingException();
        driver.findElement(By.name("username")).sendKeys("aadhya");
        driver.findElement(By.name("password")).sendKeys("aadhya@123");
        System.out.println("Type username and password");
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks on login button");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input")).click();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("user should be navigated to customer dashboard page")
    public void user_should_be_navigated_to_customer_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String exptectedURL = "https://parabank.parasoft.com/parabank/overview.htm";
        String actualURL = driver.getCurrentUrl();
        assertEquals(exptectedURL, actualURL);
        System.out.println("Customer Dashboard Page");
    }

}
