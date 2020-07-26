package DropDowns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentclearTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("profile.default_content_setting_values.notifications", 2);
	
		 
		 
	ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");

		driver.findElement(By.id("OneWay")).click();

		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("bangalore");
		Thread.sleep(5000);
		WebElement dest = driver.findElement(By.id("FromTag"));

		dest.clear();

		dest.sendKeys("Hyd");

		Thread.sleep(4000);

		dest.sendKeys(Keys.DOWN);

		dest.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.id("ToTag"));

		to.clear();

		to.sendKeys("washington");

		//for (int i=0; i<3; i++) {

		Thread.sleep(2000);

		to.sendKeys(Keys.DOWN);

		//}

		Thread.sleep(2000);

		to.sendKeys(Keys.ENTER);

		}

		
/*		List<WebElement> Options2 = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));
		for (WebElement Option : Options2) {
			if (Option.getText().contains("Bangalore, IN - Kempegowda International Airport (BLR)")) {
				Option.click();
				break;
			}
		}
		driver.findElement(By.id("ToTag")).sendKeys("delhi");
		Thread.sleep(5000);
		List<WebElement> Options1 = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]"));
		for (WebElement Option1 : Options1) {
			if (Option1.getText().contains("New Delhi, IN - Indira Gandhi Airport (DEL)")) {
				Option1.click();
				break;
			}
		}*/

/*		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");

		Select s2 = new Select(driver.findElement(By.id("Childrens")));
		s2.selectByValue("3");

		Select s3 = new Select(driver.findElement(By.id("Infants")));
		s3.selectByValue("2");

		driver.findElement(By.id("MoreOptionsLink")).click();

		Select s4 = new Select(driver.findElement(By.id("Class")));
		s4.selectByValue("Business");

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("abcdef");

		Thread.sleep(5000);

		driver.findElement(By.id("DepartDate")).click();

		Thread.sleep(5000);

		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());*/

	}


