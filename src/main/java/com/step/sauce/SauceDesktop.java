package com.step.sauce;



import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SauceDesktop extends TestBase {
	@Test
	public void verifyCommentInputTest()
			throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		this.createDriver();
		WebDriver driver = this.getWebDriver();

		System.out.println("Calling  new  driver");


driver.get("https://www.amazon.in/");

		System.out.println("Test finished");

	}

}

