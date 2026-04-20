package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
private WebDriver driver;
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	 
	@Given("I navigate to {string}")
	public void i_navigate_to(String url) {
	   driver.get(url); 
	}

	@Given("I enter {string} into username field")
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
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	
}
