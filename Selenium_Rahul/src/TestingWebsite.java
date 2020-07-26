import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingWebsite {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.findElement(By.cssSelector("a.theme-btn.register-btn")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("qasdd");
		driver.findElement(By.xpath("//input[contains(@data-disable-with,'Log')]")).click();
		
	}
}
