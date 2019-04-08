package testCasess;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.ToolsQAAutomationPracticeTable;
import pageObjects.ToolsQAWebPageMain;
import resources.Base;
import resources.FileUpload;
import resources.ScreenshotMaker;

public class Demo {

	WebDriver driver;

	Base d = new Base();

	@BeforeTest
	public void beforeTest() {

		driver = d.initializeDriver();
		driver.manage().window().maximize();

		System.out.flush();

	}

	//takes parameters from DemoTestng.xml file
	@Parameters({ "name", "lastName", "continent", "webECommands", "header1", "header2", "downloadDirLocation" })
	@Test
	public void demo(String name, String lastName, String continent, String webECommands, String header1,
			String header2, String downloadDirLocation) {

		ToolsQAWebPageMain tqa = new ToolsQAWebPageMain(driver);
		ToolsQAAutomationPracticeTable pt = new ToolsQAAutomationPracticeTable(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// link to website
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		
		Assert.assertEquals(driver.findElement(tqa.getHeader()).getText(), header1);

		d.click(driver, tqa.getFirstLink(), 5);

		d.click(driver, tqa.getSecondLink(), 5);

		Assert.assertEquals(driver.findElement(pt.getHeader()).getText(), header2);

		driver.navigate().back();

		d.type(driver, tqa.getFirstName(), name, 5);

		d.type(driver, tqa.getLastName(), lastName, 5);

		d.click(driver, tqa.getSexRadioMaleImput(), 5);

		d.click(driver, tqa.getYearsOfExp1(), 5);

		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		d.type(driver, tqa.getDate(), date, 5);

		d.click(driver, tqa.getProfession(), 5);

		d.click(driver, tqa.getImportButton(), 5);

		FileUpload upload = new FileUpload();
		Robot robot;

		String workspaceDirectory = System.getProperty("user.dir");
		String absolutePath = workspaceDirectory + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "resources" + File.separator + "pictureForUpload.jpg";

		try {
			robot = new Robot();
			upload.fileUpload(robot, absolutePath);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		d.click(driver, tqa.getDownloadFramework(), 5);

		d.click(driver, tqa.getAutomationTool(), 5);

		d.select(driver, tqa.getContinents(), continent, 5);

		d.select(driver, tqa.getSeleniumCommands(), webECommands, 5);

		Assert.assertEquals(d.getTextOfinput(driver, tqa.getFirstName()), name);
		Assert.assertEquals(d.getTextOfinput(driver, tqa.getLastName()), lastName);
		Assert.assertTrue(driver.findElement(tqa.getSexRadioMaleImput()).isSelected());
		Assert.assertEquals(d.getTextOfinput(driver, tqa.getDate()), date);
		Assert.assertTrue(driver.findElement(tqa.getProfession()).isSelected());
		Assert.assertTrue(d.getTextOfinput(driver, tqa.getImportButton()).contains("pictureForUpload.JPG"));
		Assert.assertTrue(d.isFileDownloaded(downloadDirLocation, "Test-File-to-Download.xlsx"));
		Assert.assertTrue(driver.findElement(tqa.getAutomationTool()).isSelected());
		Assert.assertEquals(d.verifySelect(driver, tqa.getContinents()), continent);
		Assert.assertEquals(d.verifySelect(driver, tqa.getSeleniumCommands()), webECommands);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		// This gonna do printscreen if test fails
		ScreenshotMaker scr = new ScreenshotMaker();
		scr.makeScr(result, driver);

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

		System.out.close();

	}

}