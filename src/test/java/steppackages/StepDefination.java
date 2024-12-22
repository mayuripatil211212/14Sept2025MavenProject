package steppackages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends BaseJava {

	//bdd cucumber - hooks concept
	
	@Before //This setup() will execute before each scenario
	public void setup() throws Exception {
		System.out.println("Set Up method execute before each scenario");
		
		readConfig =new ReadConfig();//Creating object of ReadConfig
		
		String browserValue=readConfig.getBrowser();//firefox
		
		if(browserValue.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browserValue.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browserValue.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() throws Exception {
	   
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
		admin=new AdminPage(driver);//Create object of AdminPage
		Thread.sleep(2000);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
	   driver.get(url);
		Thread.sleep(2000);

	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
       admin.setEmail(email);
       Thread.sleep(2000);
       admin.setPassword(password);
       Thread.sleep(2000);

	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
       admin.ClickOnLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
	   Assert.assertEquals("Dashboard / nopCommerce administration",title);
	}

	@Then("close browser")
	public void close_browser() {
       driver.quit();
	}
	
	@After // teardown() will execute after each scenario
	public void teardown(Scenario sc) throws Exception {
		
		System.out.println("Tear down method will execute after each scenario");
 
		if(sc.isFailed()) {
		String filepath="C:\\Users\\Prashant\\eclipse-workspace\\14Sept2025WeekendBDDMavenProject\\screenshots\\failedScreenshot.png";
		
		
		//1. Convert WebDriber into TakeScrenshot
		 TakesScreenshot scrShot=(TakesScreenshot)driver;
		 
		 //2. call getScreenshotAs()
		 
		 File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		 
		 File destFile=new File(filepath);
		 
		 //3. We have to copy the scrFile and past it into destFile
		 
		 FileUtils.copyFile(scrFile, destFile);
		 
		 
		} 
		
	}
	
	

}
