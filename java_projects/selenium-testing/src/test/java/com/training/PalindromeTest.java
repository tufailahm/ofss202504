package com.training;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PalindromeTest {

    WebDriver driver;
    private String browerName="chrome";
    public PalindromeTest(){
        System.out.println("Cons called");
        if (browerName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browerName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browerName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
    }

    @Given("the user is on the landing page of the website")
    public void the_user_is_on_the_landing_page_of_the_website() {
        System.out.println("The user is on the landing page of the website");
        driver.get("https://www.fileconverts.com/text/check-palindrome/");
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @When("^user types string in input box (.*)$")
    public void user_types_string_in_input_box(String word) {
        System.out.println("Type string in input box");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div[1]/textarea")).sendKeys(word);
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div/button[2]")).click();
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @Then("^user should see the result in output box (.*)$")
    public void user_should_see_the_result_in_output_box(String result) {
        System.out.println("Result in output box");
        WebElement actualResult= driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div[2]/textarea"));
        Assert.assertEquals(result,actualResult.getText());
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
}
