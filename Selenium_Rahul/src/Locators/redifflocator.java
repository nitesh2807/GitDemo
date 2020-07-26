package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class redifflocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.findElement(By.xpath("login-btn")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abcd");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("qasdd");
		driver.findElement(By.xpath("//input[contains(@data-disable-with,'Log')]")).click();
		

	}

}
