package githubproject.github;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scenario1 {
	WebDriver driver;	
 @BeforeMethod
 
 public void openbrowser(){
	  System.setProperty("webdriver.chrome.driver" , "F:\\selenium\\chromedriver.exe");
		 this.driver = new ChromeDriver();
	 	 String url = "https://www.goibibo.com/";
	 	 driver.get(url);	 
	 	 driver.manage().window().maximize();
	 	 
	 	 System.out.print("Seesion is started");
	 
 }
 
  @Test
  public void searchhotel() throws InterruptedException {

	
	 
	 	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	 	WebElement hotel = driver.findElement(By.xpath("//a [contains(@href , '/hotels/')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hotel).click().perform();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);

		WebElement radio = driver.findElement(By.xpath("//input[contains(@type, 'radio')]"));
		action.moveToElement(radio).click().perform();

		WebElement place = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'e.g. - Area, Landmark or Property Name')]"));
		place.sendKeys("goa");
		place.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		place.sendKeys(Keys.ENTER);
		driver.findElement(
				By.xpath("//div[contains(@class ,'SearchBlockUIstyles__SearchInputWrap-sc-fity7j-11 iySGfO')]"))
				.click();
		Thread.sleep(2000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(@data-testid , 'openCheckinCalendar')]")).click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(@data-testid ,'date_li_20_6_2022')]")).click();

		driver.findElement(By.xpath("//li[contains(@data-testid ,'date_li_22_6_2022')]")).click();
         driver.findElement(By.xpath("//input[contains(@value , '2 Adults | 0 Child | 1 Room ')]")).click();
		Thread.sleep(2000);
		WebElement adult = driver.findElement(By.xpath("/html//div[@id='root']/div[2]/div[@class='HomePagestyles__HomeBodyWrapperContentDiv-sc-s8m7jv-1 kmNUVQ']/section[@class='HomePagestyles__SearchBlockOuterWrapper-sc-s8m7jv-5 gxpKrW']//div[@class='SearchBlockUIstyles__PaxCountWrap-sc-fity7j-9 heYAZX']//div[@class='PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK']/div[2]/div/span[1]"));
       adult.click();
       driver.findElement(By.xpath("//button[contains(@class, 'dwebCommonstyles__ButtonBase-sc-112ty3f-12 PaxWidgetstyles__ButtonWrapper-sc-gv3w6r-11 QWIoF jxqLbm')]")).click();
		Thread.sleep(2000);
       driver.findElement(By.xpath("//button[contains(@data-testid , 'searchHotelBtn')]")).click();

		Thread.sleep(3000);
  
  }
	 
  
  @AfterMethod
  
  public void closebrowser(){
 	  driver.close();
 	  driver.quit();
  }
  
  
}
