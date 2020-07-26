package Web_Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/29054/eng-vs-wi-2nd-test-west-indies-tour-of-england-2020");
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
      int row=    table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms")).size();
      int count = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
	
      for (int i=0;i<count-2;i++) {
    String value =	  table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();
   int valueinteger =  Integer.parseInt(value);
   sum=sum+valueinteger;
   System.out.println(sum);
      }
      String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
      int extrasvalue = Integer.parseInt(extras);
      sum=sum+extrasvalue;
      System.out.println(sum);
      String total=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
      int totalruns = Integer.parseInt(total);
      if(sum==totalruns) {
    	  System.out.println("countmatches");
      }else
      {
    	  System.out.println("count not matches");
      }
      
	
	}

}
