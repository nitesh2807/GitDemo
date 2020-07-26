package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggestivedropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		WebElement source = driver.findElement(By.id("fromCity"));
		source.click();
		source.sendKeys("che");
		//source.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(5000);
		source.sendKeys(Keys.ENTER);

	}

}
