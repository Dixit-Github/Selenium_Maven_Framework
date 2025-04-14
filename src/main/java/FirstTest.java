import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		System.out.println("Title: " + driver.getTitle());

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		
		Thread.sleep(2000);
		textBox.sendKeys("Selenium");
        submitButton.click();
        
		WebElement message = driver.findElement(By.id("message"));
        System.out.println("Message :"+message.getText());
        Thread.sleep(2000);

		driver.quit();
	}

}
