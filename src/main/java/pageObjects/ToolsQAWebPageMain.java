package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAWebPageMain {

	WebDriver driver;

	public ToolsQAWebPageMain(WebDriver driver) {
		this.driver = driver;
	}

	By header = By.xpath("//h1[contains(text(),'Automation Practice Form')]");
	By firstLink = By.xpath("//strong[contains(text(),'Partial Link Test')]");
	By secondLink = By.xpath("//a[contains(@title,'Automation Practice Table')]//strong[contains(text(),'Link Test')]");
	By firstName = By.xpath("//input[contains(@name,'firstname')]");
	By lastName = By.xpath("//input[contains(@name,'lastname')]");
	By sexRadioMaleImput = By.xpath("//input[@value='Male']");
	By sexRadioFemaleImput = By.xpath("//input[@value='Female']");
	By yearsOfExp1 = By.xpath("//input[@value='1']");
	By date = By.xpath("//input[@id='datepicker']");
	By profession = By.xpath("//input[@value='Automation Tester']");
	By importButton = By.xpath("//input[@id='photo']");
	By downloadFramework = By.xpath("//a[contains(text(),'Test File to Download')]");
	By automationTool = By.xpath("//input[@value='Selenium Webdriver']");
	By continents = By.xpath("//select[@id='continents']");
	By seleniumCommands = By.xpath("//select[@id='selenium_commands']");
	By button = By.xpath("//button[@id='submit']");
	
	

	public By getFirstLink() {
		return firstLink;
	}

	public By getSecondLink() {
		return secondLink;
	}

	public By getFirstName() {
		return firstName;
	}

	public By getLastName() {
		return lastName;
	}

	public By getSexRadioMaleImput() {
		return sexRadioMaleImput;
	}

	public By getSexRadioFemaleImput() {
		return sexRadioFemaleImput;
	}

	public By getYearsOfExp1() {
		return yearsOfExp1;
	}

	public By getDate() {
		return date;
	}

	public By getProfession() {
		return profession;
	}

	public By getImportButton() {
		return importButton;
	}

	public By getAutomationTool() {
		return automationTool;
	}

	public By getDownloadFramework() {
		return downloadFramework;
	}

	public By getContinents() {
		return continents;
	}

	public By getSeleniumCommands() {
		return seleniumCommands;
	}

	public By getButton() {
		return button;
	}

	public By getHeader() {
		return header;
	}

}
