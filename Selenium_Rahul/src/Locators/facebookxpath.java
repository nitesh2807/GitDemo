package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebookxpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	/*	driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("asdfg@fki");
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();*/
		
		driver.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys("abscsg");
		driver.findElement(By.cssSelector("input[data-testid='royal_pass']")).sendKeys("qwer");
		driver.findElement(By.cssSelector("input[data-testid='royal_login_button']")).click();

	}

}
