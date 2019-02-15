package com.step.sauce;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import gridnodes.StepLib;
import gridnodes.listeningcount;




/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider
 * in order to supply multiple browser combinations.
 *
 * @author Anvar
 */
public class TestBase {

	public String buildTag = System.getenv("BUILD_TAG");
	StepLib stepLib=new StepLib();

	/**
	 * ThreadLocal variable which contains the {@link WebDriver} instance which is
	 * used to perform browser interactions with.
	 */
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * ThreadLocal variable which contains the Sauce Job Id.
	 */
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();
	
	public void register() {
		stepLib.setJobId(listeningcount.jobId);
		stepLib.setRunId(listeningcount.runId);
	 }

	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	/**
	 *
	 * @return the Sauce Job id for the current thread
	 */
	public String getSessionId() {
		return sessionId.get();
	}

	
	protected void createDriver() throws MalformedURLException, UnexpectedException {

		
		//DesiredCapabilities capsFF = DesiredCapabilities.firefox();

		System.out.println("Starting first test");


	      DesiredCapabilities caps = DesiredCapabilities.android();
	      caps.setCapability("appiumVersion", "1.7.1");
	      caps.setCapability("deviceName","Samsung Galaxy S4 Emulator");
	     // caps.setCapability("deviceName","Samsung Galaxy Nexus Emulator");
	  	
	      caps.setCapability("deviceOrientation", "portrait");
	      caps.setCapability("browserName", "Browser");
	      caps.setCapability("platformVersion", "4.4");
	      caps.setCapability("platformName","Android");
	      System.out.println("Calling driver");

		
	/*		System.out.println("Starting second test");
		capsFF.setCapability("platform", "Windows 7");
		capsFF.setCapability("version", "32.0");*/
		
	//	capabilities.setCapability("appiumVersion", "1.5.3");
		
		if(stepLib.getJobId() == null) {
	         register();
	     }
		
		webDriver.set(stepLib.getDriver(caps, "Sauce sample test"));
		//webDriver.set(stepLib.getDriver(capsFF, "Sauce sample test 2"));
		

		String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
		sessionId.set(id);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		((JavascriptExecutor) webDriver.get())
				.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		webDriver.get().quit();
	}

	protected void annotate(String text) {
		((JavascriptExecutor) webDriver.get()).executeScript("sauce:context=" + text);
	}
}


