package InvokingBrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchingIEBrowser {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.ie.driver", "F:\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		/*System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		*/
		driver.close();

	}

}
