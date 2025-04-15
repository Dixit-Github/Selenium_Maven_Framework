package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}

//	@Test (dataProvider = "LoginData")

	@Test
	@Parameters({ "username", "password" }) // taking form testng.xml
	public void testValidLogin(String username, String password) throws InterruptedException {

		Log.info("Starting valid login test...");
		test = ExtentReportManager.createTest("Login Test -" + username);

		test.info("Navigating to URL.");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Entering valid username and password.");
		test.info("Adding correct credentials.");

		// loginPage.enterUsername("admin@yourstore.com");
		// loginPage.enterPassword("admin");

		// DataProvider username and password
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		test.info("Clicking on Login button.");
		loginPage.clickLogin();

		System.out.println("Title of page: " + driver.getTitle());
		Thread.sleep(1000);

		Log.info("Verifying page title...");
		test.info("Verifying page title.");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");

		test.pass("Login Successful.");
		Log.info("Login test completed.");
	}

	@Test(enabled = false)
	public void testInvalidLogin() throws InterruptedException {

		Log.info("Starting invalid login test...");
		test = ExtentReportManager.createTest("Login Test");

		test.info("Navigating to URL.");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Entering invalid username and password.");
		test.info("Adding incorrect credentials.");
		loginPage.enterUsername("admin123@yourstore.com");
		loginPage.enterPassword("admin123");

		test.info("Clicking on Login button.");
		loginPage.clickLogin();

		System.out.println("Title of page: " + driver.getTitle());
		Thread.sleep(1000);

		Log.info("Verifying page title...");
		test.info("Verifying page title.");
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");

		test.pass("Login Successful.");
		Log.info("Login test completed.");
	}
}
