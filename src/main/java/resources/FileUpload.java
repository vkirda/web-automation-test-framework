package resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class FileUpload {

	String osName = null;
	StringSelection ss = null;

	public FileUpload() {

	}

	public void fileUpload(Robot robot, String pathToFile) throws AWTException {
		osName = System.getProperty("os.name");

		if (osName.contains("Mac")) {// OS X

			robot.setAutoDelay(2000);

			ss = new StringSelection(pathToFile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			robot.setAutoDelay(2000);

			// go to folder(shift+cmd+g)
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_META);
			
			robot.setAutoDelay(1000);

			// paste(cmd+v)
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);
			
			robot.setAutoDelay(1000);

			// enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.setAutoDelay(1000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} else if (osName.contains("Windows")) {

			robot.setAutoDelay(2000);

			ss = new StringSelection(pathToFile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.setAutoDelay(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} else {
			System.out.println(osName);
		}
	}

}
