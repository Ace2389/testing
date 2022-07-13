package githubproject.github;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scenario4 {
	WebDriver driver;
	 String rating = null;
	 String price = null;
	 
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
  public void filter() throws InterruptedException {
	  
		WebElement payathotel = driver.findElement(By.xpath("//span[text()= 'Pay At Hotel Available']"));
		payathotel.click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html//div[@id='root']/div[@class='dwebCommonstyles__BaseColumnWrap-sc-112ty3f-2 fVGWFo']//section[@class='SRPstyles__LeftSectionWrapperStyle-sc-19ucfhx-3 dzHuQA']/div/div/div[4]/div[5]/div[@class='CheckBoxList__TextCenteredDiv-sc-5k7440-1 iXanIV']")).click();
		Thread.sleep(3000);
		
		 String  Expectedrating ="4+";
         String Expectedprice = "?6001 - ?8000"	;
        
         
        
         
         try {
        	 this.rating = driver.findElement(By.xpath("/html//div[@id='root']/div[@class='dwebCommonstyles__BaseColumnWrap-sc-112ty3f-2 fVGWFo']/div[@class='SRPstyles__BodyWrapperContentStyle-sc-19ucfhx-1 kwbcQS']/section[@class='SRPstyles__LeftSectionWrapperStyle-sc-19ucfhx-3 dzHuQA']/div/div//div[@class='Filtersstyles__AverageReviewWrapper-sc-bkjigy-9 lkmokb']/span[@class='Filtersstyles__AverageReviewText-sc-bkjigy-8 kmeHqf']")).getText();
        		}catch(Exception e) {
        			 Assert.assertEquals(rating, Expectedrating, "Not matched");
        			
        		}
        
         
         
         try {
        	 this.price = driver.findElement(By.xpath("/html//div[@id='root']/div[@class='dwebCommonstyles__BaseColumnWrap-sc-112ty3f-2 fVGWFo']//section[@class='SRPstyles__LeftSectionWrapperStyle-sc-19ucfhx-3 dzHuQA']/div/div/div[4]/div[5]/div[@class='CheckBoxList__TextCenteredDiv-sc-5k7440-1 iXanIV']")).getText();
        		}catch(Exception e) {
        			Assert.assertEquals(price, Expectedprice, "Not matched");
        	         
        			
        		}
        
         
         System.out.println("price is "  + price);
         System.out.println("rating is "  + rating);
         
         
  }

  @AfterMethod
  
  public void closebrowser(){
 	  driver.close();
 	  driver.quit();
 	 System.out.print("Seesion is closed");
  }
  
}
