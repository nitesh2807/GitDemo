package Amazon_Interview;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j=0;
		String[] vegetable = {"Cauliflower","Beans","Potato"};
		List<WebElement> product = driver.findElements(By.className("product-name"));
		
		for(int i=0;i<product.size();i++) {
			String[] name = product.get(i).getText().split("-");
			String formattedName=name[0].trim();
		
			List<String> itemsList  =Arrays.asList(vegetable);
			
			if(itemsList.contains(formattedName)) {
				j++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==vegetable.length) {
					break;
				}
			}
					
		}
		
		

	}

}
