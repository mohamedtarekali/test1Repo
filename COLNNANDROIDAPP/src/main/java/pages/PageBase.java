package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageBase {	
	
	protected AndroidDriver<MobileElement> drvier ; 
	public JavascriptExecutor jse ; 
	public Select select ; 
	public Actions action ;
	public WebDriverWait wait;
	
	public PageBase(AndroidDriver<MobileElement> driver) 
	{
		this.drvier=driver;
		//PageFactory.initElements(driver, this);
	}
	protected static void clickButton(MobileElement button) 
	{
		button.click();
	}
	
	protected static void setTextElementText(MobileElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom() 
	
	{
		jse.executeScript("scrollBy(0,1000)"); 
	} 
	
	public void clearText(MobileElement element) 
	{
		element.clear();
	}
	public MobileElement WaitForElementById(String selector) {
		wait = new WebDriverWait(drvier, 10);
	    MobileElement element=(MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selector)));
		return element;
	}
	
	public MobileElement WaitForElementByXpath(String selector) {
		wait = new WebDriverWait(drvier, 10);
		MobileElement element=(MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
		return element;
	}

}
