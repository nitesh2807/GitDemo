package WindowHandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[@target='_blank']")).click();
		System.out.println("Before Switiching");
		System.out.println(driver.getTitle());
		Set<String> id =driver.getWindowHandles();
		Iterator<String> it =id.iterator();
		String parentid =it.next();
		String childid =it.next();
		driver.switchTo().window(childid);
		System.out.println("AfterSwitching");
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3 ")).getText());
		driver.switchTo().window(parentid);
		System.out.println("Switching back to parent");
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

	}

}
