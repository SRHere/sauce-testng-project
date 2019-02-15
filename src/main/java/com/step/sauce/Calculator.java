package com.step.sauce;


import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class Calculator extends TestBase {
	@Test
	public void verifyCommentInputTest()
			throws MalformedURLException, InvalidElementStateException, UnexpectedException {
		this.createDriver();
		WebDriver driver = this.getWebDriver();

		System.out.println("Calling driver");

		driver.findElement(By.id("digit5")).click();
		System.out.println("5");

		driver.findElement(By.id("plus")).click();
		System.out.println("+");
		driver.findElement(By.id("digit2")).click();
		System.out.println("2");
		driver.findElement(By.id("equal")).click();
		System.out.println("=");

		WebElement sumOfNumbersEle = driver.findElement(By.className("android.widget.EditText"));

		String sumOfNumbers = sumOfNumbersEle.getText();

		Assert.assertTrue(sumOfNumbers.endsWith("7"));

		System.out.println("Test 01 finished");

	}

}

