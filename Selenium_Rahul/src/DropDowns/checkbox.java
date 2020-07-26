package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {
	
	public static void main(String[] args) {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	Assert.assertFalse(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).isSelected());
	System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).isSelected());
	driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).click();
	System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).isSelected());
	Assert.assertFalse(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_friendsandfamily")).isSelected());
	System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
}
	
}
