import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tagname {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement footer1 = footer.findElement(By.xpath("table/tbody/tr/td[1]/ul"));
		System.out.println(footer1.findElements(By.tagName("a")).size());
		
		for(int i=1;i<footer1.findElements(By.tagName("a")).size();i++) {
			
			String tabKeys = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			footer1.findElements(By.tagName("a")).get(i).sendKeys(tabKeys);
			Thread.sleep(5000);
		}
			Set<String> tab =driver.getWindowHandles();
			Iterator<String> it =tab.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}

	}


