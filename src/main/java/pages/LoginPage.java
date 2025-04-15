package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	//Locating WebElements on Login page 
	/*
	 * private By usernameTextBox = By.xpath("//input[@id='Email']"); 
	 * private By passwordTextBox = By.xpath("//input[@id='Password']"); 
	 * private By loginButton = By.xpath("//button[@type='submit']");
	 */
	
	
	//Locating WebElements using PageFactory
	@FindBy (id= "Email") 
	WebElement usernameTextBox;
	
	@FindBy (id= "Password") 
	WebElement passwordTextBox;
	
	@FindBy (xpath= "//button[@type='submit']") 
	WebElement loginButton;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action methods/functions for WebElements 
	public void enterUsername (String username) throws InterruptedException {
	//	driver.findElement(usernameTextBox).clear();
		usernameTextBox.clear();
		
	//	driver.findElement(usernameTextBox).sendKeys(username);
		usernameTextBox.sendKeys(username);
		
		Thread.sleep(1000);
	}
	
	public void enterPassword(String password) throws InterruptedException {
	//	driver.findElement(passwordTextBox).clear();
		passwordTextBox.clear();
				
	//	driver.findElement(passwordTextBox).sendKeys(password);
		passwordTextBox.sendKeys(password);
		Thread.sleep(1000);
	}
	
	public void clickLogin () throws InterruptedException {
		Log.info("Clicking login button.");
	//	driver.findElement(loginButton).click();
		loginButton.click();
		Thread.sleep(1000);
	}
	
}
