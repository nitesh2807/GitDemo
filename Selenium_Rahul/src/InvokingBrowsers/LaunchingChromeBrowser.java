package InvokingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LaunchingChromeBrowser {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "F:\\drivers\\ChromeDriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://www.yahoo.com/");
		driver.navigate().back();
		System.out.println("Navigating Back to Gmail");
		driver.navigate().forward();
		System.out.println("Navigating forward to Yahoo");
		driver.close();
		//driver.quit();

		


}
}