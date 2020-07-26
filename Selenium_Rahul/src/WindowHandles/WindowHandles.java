package WindowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://gmail.com/");
		driver.findElement(By.xpath("//a[@target='_blank']")).click();
		System.out.println("Before Switiching");
		System.out.println(driver.getTitle());
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it =id.iterator();
		String parentId = it.next();
		String childId =it.next();
		driver.switchTo().window(childId);
		System.out.println("After Switching");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println("Switching Back to Parent");
		System.out.println(driver.getTitle());

	}

}
