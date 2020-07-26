package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class classname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=eu");
		//driver.findElement(By.id("username")).sendKeys("abcd");
		driver.findElement(By.cssSelector("input#username")).sendKeys("abcde");
		driver.findElement(By.name("pw")).sendKeys("1234");
		//driver.findElement(By.className("button r4 wide primary")).click();error
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		System.out.println(driver.findElement(By.cssSelector("#error")).getText());

		/*driver.findElement(By.className("inputtext login_form_input_box")).sendKeys("abcd");
		driver.findElement(By.className("inputtext login_form_input_box")).sendKeys("qwe");*/
	}

}
