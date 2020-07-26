package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Id {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.id("email")).sendKeys("niteshraya@gmail.com");
		driver.findElement(By.cssSelector("#email")).sendKeys("wytd@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("nitesh123");
		//driver.findElement(By.xpath("//input[contains(@id,'u_')]")).click();
		driver.findElement(By.cssSelector("input[id*='u_']")).click();
		//driver.findElement(By.linkText("Forgotten account?")).click();
		
	}

}
