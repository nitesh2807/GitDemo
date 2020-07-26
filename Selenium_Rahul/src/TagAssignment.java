import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
	String s =	driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[1]")).getText();
	
	Select s1 = new Select(driver.findElement(By.id("dropdown-class-example")));
	s1.selectByVisibleText(s);
	
	driver.findElement(By.name("enter-name")).sendKeys(s);
	
	driver.findElement(By.id("alertbtn")).click();
	
	String s2 =driver.switchTo().alert().getText();
	System.out.println(s2);
	if(s2.contains(s)){
		System.out.println("AlertMessagesuccess");
	}
	else {
		System.out.println("Alertmessagefail");
	}
	

	}

}
