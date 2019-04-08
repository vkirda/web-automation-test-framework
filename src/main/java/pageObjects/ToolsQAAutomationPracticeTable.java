package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQAAutomationPracticeTable {
	
	WebDriver driver;

	public ToolsQAAutomationPracticeTable(WebDriver driver) {
		this.driver = driver;
	}
	
	By header = By.xpath("//div[@id='content']//h1[contains(text(),'Automation Practice Table')]");

	public By getHeader() {
		return header;
	}

}
