package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	
	public AdminPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//Used to initilize Web Element of respective page object class
	}

	// java project-

	// WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
	// Maven project

	@FindBy(xpath = "//input[@id='Email']")
	WebElement textEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement textPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;

	// User defined method to perform on web element

	public void setEmail(String email) {
		textEmail.clear();
     textEmail.sendKeys(email);
	}

	public void setPassword(String pass) {
		textPassword.clear();
		textPassword.sendKeys(pass);
	}

	public void ClickOnLogin() {

		btnLogin.click();
		
	}

}
