package steppackages;

import org.openqa.selenium.WebDriver;

import pageobjects.AddNewCustPage;
import pageobjects.AdminPage;
import utilities.ReadConfig;

public class BaseJava {

	WebDriver driver;
	
	AdminPage admin;
	
	ReadConfig readConfig;
	
	AddNewCustPage addCust;
}
