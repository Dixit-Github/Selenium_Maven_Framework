package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//WebElements on Login page 
	private  By usernameTextBox = By.xpath("//input[@id='Email']");
	private By passwordTextBox = By.xpath("//input[@id='Password']");
	private By loginButton = By.xpath("//button[@type='submit']");
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//Action methods/functions for WebElements 
	public void enterUsername (String username) throws InterruptedException {
		driver.findElement(usernameTextBox).clear();
		Thread.sleep(1000);
		driver.findElement(usernameTextBox).sendKeys(username);
		Thread.sleep(1000);
	}
	
	public void enterPassword(String password) throws InterruptedException {
		driver.findElement(passwordTextBox).clear();
		Thread.sleep(1000);
		driver.findElement(passwordTextBox).sendKeys(password);
		Thread.sleep(1000);
	}
	
	public void clickLogin () throws InterruptedException {
		driver.findElement(loginButton).click();
		Thread.sleep(1000);
	}
	
}
