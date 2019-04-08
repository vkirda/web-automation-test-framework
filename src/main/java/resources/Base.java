package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties props;

	// Making method for driver initialization. This will be used many times.
	public WebDriver initializeDriver() {

		props = new Properties();

		// Loading properties file. There is set what kind of browser i use.
		try {
			String fileName = "data.properties";
			String workingDirectory = System.getProperty("user.dir");
			String absolutePath = workingDirectory + File.separator + "src" + File.separator + "main" + File.separator
					+ "java" + File.separator + "resources" + File.separator + fileName;
			FileInputStream fis = new FileInputStream(absolutePath);
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error on calling properties file");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error on loading properties file");
		}

		// Getting browser information from properties file
		String browserName = props.getProperty("browser");

		// Initializing web driver.
		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("opera")) {

			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// Waiting page to load. (Might be error if no wait)
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void checkIsElementPresent(WebDriver driver, By locator, int time) {

		boolean isPresent = false;
		int counter = 0;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		do {
			try {
				isPresent = driver.findElements(locator).size() > 0;
				System.out.println(locator.toString() + " rado? - " + isPresent + "; Ieskoma " + counter
						+ " kartu, laiko intervalas 1s");

				counter++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (StaleElementReferenceException e) {
				isPresent = false;
				System.out.println("StaleElementReferenceException - elemento paieska kartojama " + counter);
			} catch (NoSuchElementException e1) {
				isPresent = false;
				System.out.println("NoSuchElementException - elemento paieska kartojama " + counter);
			}
		} while (!isPresent && counter != time);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	public void click(WebDriver driver, By locator, int time) {

		checkIsElementPresent(driver, locator, time);

		WebElement element = driver.findElement(locator);

		int attempts = 0;

		do {
			try {

				Actions actions = new Actions(driver);

				actions.moveToElement(element);
				actions.click();
				actions.perform();

				break;

			} catch (StaleElementReferenceException e) {
				// wait one sec
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("StaleElementReferenceException - elemento paieska kartojama " + attempts);
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				System.out.println("NoSuchElementException - elemento paieska kartojama " + attempts);
			}
			attempts++;
		} while (attempts < time);

	}

	public void type(WebDriver driver, By locator, String value, int time) {

		WebElement element = driver.findElement(locator);

		checkIsElementPresent(driver, locator, time);

		Actions actions = new Actions(driver);

		int attempts = 0;

		while (attempts < time) {
			try {

				actions.moveToElement(element);
				actions.click();
				actions.perform();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				actions.sendKeys(value);
				actions.perform();

				break;

			} catch (StaleElementReferenceException e) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("StaleElementReferenceException - elemento paieska kartojama " + attempts);

			} catch (NoSuchElementException e) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("NoSuchElementException - elemento paieska kartojama " + attempts);

			}
			attempts++;
		}

	}

	public void select(WebDriver driver, By locator, String value, int time) {

		WebElement element = driver.findElement(locator);

		checkIsElementPresent(driver, locator, time);

		int attempts = 0;

		do {
			try {

				Select s = new Select(element);

				s.selectByVisibleText(value);

				break;

			} catch (StaleElementReferenceException e) {
				// wait one sec
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("StaleElementReferenceException - elemento paieska kartojama " + attempts);
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				System.out.println("NoSuchElementException - elemento paieska kartojama " + attempts);
			}
			attempts++;
		} while (attempts < time);

	}

	public String getTextOfinput(WebDriver driver, By locator) {

		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(locator);

		String value = javaScriptExecutor.executeScript("return arguments[0].value", element).toString();

		return value;

	}

	public String verifySelect(WebDriver driver, By locator) {

		WebElement element = driver.findElement(locator);

		Select s = new Select(element);

		return s.getFirstSelectedOption().getText();

	}

}