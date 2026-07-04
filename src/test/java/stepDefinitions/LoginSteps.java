package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.BaseTest;


public class LoginSteps  {
public WebDriver driver;
	 
	@Before
	public void setup() throws IOException {
		BaseTest.launchBrowser();
		driver = BaseTest.driver;
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
	    //WebDriver driver = testContextSetup.testBase.WebDriverManager();

	    if (scenario.isFailed())
	    {
	        // screenshot
	        File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
	        scenario.attach(fileContent, "image/png", "image");
	    }
	}
	@Given("I navigate to {string}")
	public void i_navigate_to(String url)  {
		
		//driver.get(url); 
		driver.get(BaseTest.getProperty("url"));
	}

	@And("^I enter (.+) into username field$")
	public void i_enter_into_username_field(String uname) {
		LoginPage lp = new LoginPage(driver);
	    lp.enterUsername(uname);
	    lp.enterPassword("Learning@830$3mK2");
	   
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
		LoginPage lp = new LoginPage(driver);
	    lp.clickLogin();
	    
	}

	@Then("I should get logged-in")
	public void i_should_get_logged_in() {
		
	   String text = driver.findElement(By.xpath("//a[text()='ProtoCommerce Home']")).getText();
	   System.out.println(text);
	   Assert.assertEquals(text, "ProtoCommerce Home");
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
}
