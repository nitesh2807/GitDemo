package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_End_Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//input[@value='OneWay']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@text='Gorakhpur (GOP)']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@text='Bengaluru (BLR)'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BOM']")).click();;
		/*driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Its Disabled");
		}else {
			System.out.println("Its Enabled");
		}
		
		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		driver.findElement(By.id("divpaxinfo")).click();
		
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
          s.selectByValue("5");
          
          Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
          s1.selectByValue("4");
          
          Select s2 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
          s2.selectByValue("3");
          
          Select s3 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
          s3.selectByValue("AED");
          
          driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
          
         System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());     
         
         driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		*/
	}

}
