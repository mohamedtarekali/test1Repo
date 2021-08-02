package tests;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import data.ExcelReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.DashBoardPage;
import pages.LibraryPage;
import utilities.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression 01")
@Feature("Library")
public class AddLibraryTest extends TestBase {
	DashBoardPage dashBoardPageObject;
	LibraryPage libraryPageObject;
	 
	@DataProvider(name="userDataFromExcel")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader("AddLibraryData");
		return ER.getExcelData();
	}

	@Test(priority=1,dataProvider="userDataFromExcel" , description="Add New Library")
	@Description("User Can Add New Library")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Add Library From Android - 12345")
	public void userCanAddLibrary(String title , String link) {
		dashBoardPageObject = new DashBoardPage(driver);
		dashBoardPageObject.userOpenLibraryFromDashBoard();
		libraryPageObject = new LibraryPage(driver);
		libraryPageObject.userOPenAddLibraryScreen();
		libraryPageObject.userAddLibrary(title , link);
		//System.out.println("done from server side");
	}

}
