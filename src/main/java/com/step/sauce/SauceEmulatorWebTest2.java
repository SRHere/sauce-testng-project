package com.step.sauce;



import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SauceEmulatorWebTest2 extends TestBase {
	 private String applicationName;
	    
	  @org.testng.annotations.Factory(dataProvider = "parallelDp")
	    public SauceEmulatorWebTest2(String applicationName) {
	      this.applicationName = applicationName;
	    }
	  
	  @DataProvider(name = "parallelDp")
	    public static Object[][] parallelDp() {
	      return new Object[][] {
	       {"Samsung Galaxy S4 Emulator"}
	    	   
	      };
	    }
	@Test
	public void verifyCommentInputTest()
			throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		this.createDriver();
		WebDriver driver = this.getWebDriver();

		System.out.println("Calling  new  driver");


		driver.get("https://www.ups.com/in/en/Home.page?");
		
WebElement search=driver.findElement(By.name("trackNums"));
		search.sendKeys("999999999");
	//	WebElement searchPass=driver.findElement(By.name("password"));
	//	searchPass.sendKeys("Ustglobal123!");
//search.submit() ;
search.submit();
WebElement searchTrack=driver.findElement(By.id("stApp_trackingNumber"));
searchTrack.sendKeys("999999999");
driver.findElement(By.id("stApp_btnTrack")).click();
	//	String tit=	driver.getTitle();
	//	System.out.println(tit);

		//WebElement search=driver.findElement(By.name("email"));
		//search.sendKeys("C00091@ust-global.com");
		//WebElement searchPass=driver.findElement(By.name("pass"));
		//searchPass.sendKeys("Athira@ust2");
		//search.submit() ;
		//searchPass.submit();
		
		


		System.out.println("Test 2 finished");

	}

}

