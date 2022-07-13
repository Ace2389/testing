package githubproject.github;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class secnario2 {
	WebDriver driver;
	String hotel =null;
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		this.driver = new ChromeDriver();
		String url = "https://www.goibibo.com/hotels/find-hotels-in-Goa/8717279093827200968/8717279093827200968/%7B%22ci%22:%2220220731%22,%22co%22:%2220220803%22,%22r%22:%221-1-0%22%7D/?{%22filter%22:{}}&sec=dom&cc=IN";
		driver.get(url);
		driver.manage().window().maximize();

		System.out.print("Seesion is started");

	}
	
	
	
	 @Test
  public  void hotel() throws InterruptedException  {	
		  
		 Thread.sleep(3000);
		WebElement hotelname = driver
				.findElement(By.xpath("//h4[text()  = 'goSTOPS Goa Baga | Dorms & Private Rooms']"));
		hotelname.click();
		String parenthandle = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		// Loop through all handles
		for (String handle : winHandles) {
			if (!handle.equals(parenthandle)) {
				driver.switchTo().window(handle);
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

				String expected = "goSTOPS Goa Baga | Dorms & Private Ros";

				
				
				  try {
					  this.hotel = driver
								.findElement(By.xpath("//h1[text()  = 'goSTOPS Goa Baga | Dorms & Private Rooms']")).getText();
			        		}catch(Exception e) {
			        			Assert.assertEquals(hotel, expected, "hotel name is not mactched");
			        			
			        		}
			        
				
				driver.findElement(By.xpath("//input[contains(@id ,'Free Breakfast')]")).click();
				driver.findElement(By.xpath("//button[contains(@data-testid ,'selectRoomBtn')]")).click();
				WebElement Firstname = driver
						.findElement(By.xpath("//input[contains(@placeholder , 'Enter First Name')]"));
				Firstname.sendKeys("Duggu");
				WebElement lasttname = driver
						.findElement(By.xpath("//input[contains(@placeholder , 'Enter Last Name')]"));

				lasttname.sendKeys("doctor");
				WebElement email = driver
						.findElement(By.xpath("//input[contains(@placeholder , ' Enter Email Address')]"));
				email.sendKeys("jhsgdjfd@gmail.com");
				Thread.sleep(2000);
				WebElement phoneno = driver
						.findElement(By.xpath("//input[contains(@placeholder , ' Enter Phone Number')]"));
				phoneno.sendKeys("254564645");

				driver.findElement(By.xpath("//span[text() = 'Proceed To Payment Options']")).click();

				driver.findElement(By.xpath("//a[contains(@data-testid , 'navigation-header-cta-#guest-reviews')]"))
						.click();

	}
			}
		 
		   
			}	   
	

	@AfterMethod
	public void afterMethod() {

		driver.close();
		driver.quit();
		System.out.print("Seesion is closed");
	}

			}
	
