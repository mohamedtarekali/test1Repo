package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class DashBoardPage extends PageBase {

	public DashBoardPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	MobileElement onlineQuizTab ; 
	
	@Step("Open Library Screen From Dashboard")
	public void userOpenLibraryFromDashBoard() {
		onlineQuizTab = drvier.findElement(By.xpath("//android.widget.TextView[@text='library']"));
		clickButton(onlineQuizTab);
		
	}
}
