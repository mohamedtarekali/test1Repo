package pages;


import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;


public class LibraryPage extends PageBase {

	public LibraryPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	MobileElement addLibraryButton;
	
	@Step("Open Add Library Screen")
	public void userOPenAddLibraryScreen() {
		addLibraryButton=drvier.findElement(By.id("add_files_tv"));
		clickButton(addLibraryButton);
		new WebDriverWait(drvier, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_school_edu_sys")));
	}
	
	@Step("Add Library Data And Save")
	public void userAddLibrary(String title , String link) {
		//drvier.findElement(By.xpath("//android.widget.TextView[@text='IGCSE']")).click();
		drvier.findElement(By.id("et_title")).setValue(title);
		drvier.findElement(By.id("tv_publish_date")).click();
		drvier.findElement(By.xpath("//android.view.View[@checked='true']")).click();
		drvier.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		MobileElement uploadImage=drvier.findElement(By.id("choose_image_bt"));
		clickButton(uploadImage);
		drvier.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View\r\n" + 
				"")).click();
		org.openqa.selenium.Dimension dimensions = drvier.manage().window().getSize();
        int x = dimensions.getWidth()/10;
        int y = dimensions.getHeight()/5;
        System.out.println(x);
        System.out.println(y);
        TouchAction touchAction = new TouchAction(drvier);
        touchAction.tap(PointOption.point(x, y)).perform();
		drvier.findElement(By.id("et_external_link")).sendKeys(link);
        drvier.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"save"+"\").instance(0))").click();
        
       // MobileElement toastView = drvier.findElement(By.xpath("//android.widget.Toast[1]")); 
		//String actual_toast_msg = toastView.getAttribute("name").trim();
		//System.out.println(actual_toast_msg);
	}
	

}
