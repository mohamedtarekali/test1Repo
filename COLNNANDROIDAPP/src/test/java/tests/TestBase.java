package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import utilities.Helper;

public class TestBase { 
	
	public static AndroidDriver<MobileElement> driver ;
	public DesiredCapabilities cap;
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
		//DesiredCapabilities cap = new DesiredCapabilities();
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Tarek");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("app",System.getProperty("user.dir")+"\\AppsApk\\colnnStage.apk");
		
		URL url=new URL(" http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);	
		userCanLogin();
//		driver.findElement(By.id("english_bt")).click();
//		driver.findElement(By.id("userNameEt")).setValue("test");
//		driver.findElement(By.id("input_password")).setValue("12345678");
//		driver.findElement(By.id("btn_login")).click();	
//		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("previous_tv")));
		
	}
	
	@AfterSuite
	public void teardown() 
	{
		//driver.resetApp();
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
//		if (result.getStatus() == ITestResult.FAILURE)
//		{
//			System.out.println("Failed!");
//			System.out.println("Taking Screenshot....");
//			Helper.captureScreenshot(driver, result.getName());
//		}
	}
	
	 @AfterClass
	    public void restartApp() {
	        driver.resetApp();
	        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	    }
	 
	 @Step("User Login")
	 public void userCanLogin() {
		 driver.findElement(By.id("english_bt")).click();
			driver.findElement(By.id("userNameEt")).setValue("a.sayed");
			driver.findElement(By.id("input_password")).setValue("!@#Cr$.6D");
			driver.findElement(By.id("btn_login")).click();	
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("previous_tv")));
	 }

	public WebDriver getDriver() {
		
		return driver;
	}

	



	 
	 
}
