package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenshotMaker {

	public void makeScr(ITestResult result, WebDriver driver) {

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Testas feilino daroma nuotrauka");

			try {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

				File fileSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				String fileName = "screenshot.jpeg";
				String workingDirectory = System.getProperty("user.dir");
				String absolutePath = workingDirectory + File.separator + "ScreenShots" + File.separator
						+ result.getName() + timeStamp + fileName;

				FileUtils.copyFile(fileSource, new File(absolutePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}