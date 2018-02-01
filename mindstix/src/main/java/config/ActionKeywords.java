package config;

import static executionEngine.DriverScript.OR;

import utility.Log;
import executionEngine.DriverScript;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionKeywords {

	public static WebDriver driver;

	// Common
	public static void OpenBrowser(String object, String data) {
		Log.info("Opening Browser");
		try {
			if (data.equals("Chrome")) {

				// Change the below
				// Path:---------------------------------------------------------

				// System.setProperty("webdriver.chrome.driver","C:\\Users\\Aditya\\Maven\\mindstix\\Drivers\\chromedriver.exe");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

				Log.info("Chrome browser started");
				// if (driver != null) {
				// driver.quit();
				// }
			} else if (data.equals("Firefox")) {

				// Change the below
				// Path:-----------------------------------------------------------
				// System.setProperty("webdriver.gecko.driver","C:\\Users\\Aditya\\Maven\\mindstix\\Drivers\\geckodriver.exe");

				// DesiredCapabilities capabilities =
				// DesiredCapabilities.firefox();
				// capabilities.setCapability("marionette", true);
				// driver = new FirefoxDriver(capabilities);

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
				if (driver != null) {
					driver.quit();
				}
			}
			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(data);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void EnterData(String object, String data) {
		try {
			Log.info("Entering the data");
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			Log.error("Not able to Enter data --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Assert(String object, String data) {
		try {
			Log.info("Comparing two Values");
			WebElement element = driver.findElement(By.xpath(OR.getProperty(object)));
			String strng = element.getText();

			if (data.equals(strng)) {
				DriverScript.bResult = true;
			} else
				DriverScript.bResult = false;


		} catch (Exception e) {
			Log.error("Not able to Compare two Values --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Click(String object, String data) {
		try {
			Log.info("Clicking the button");
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Wait2(String object, String data) throws Exception {
		try {
			Log.info("Wait for 2 seconds");
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error("Not able to Wait --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Maximize(String object, String data) throws Exception {
		try {
			Log.info("Maximizing the browser");
			driver.manage().window().maximize();
		} catch (Exception e) {
			Log.error("Not able to maximize --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Close(String object, String data) {
		try {
			Log.info("Closing the Window");
			driver.close();
		} catch (Exception e) {
			Log.error("Not able to Close the Window --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Enter(String object, String data) {
		try {
			Log.info("Enter Key");
			Robot rb = null;
			try {
				rb = new Robot();
				rb.keyPress(KeyEvent.VK_ENTER);

			} catch (AWTException e) {

				e.printStackTrace();
			}
		} catch (Exception e) {
			Log.error("Not able to Enter --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void Screenshot(String object, String data) {
		try {
			Log.info("Taking Screenshot");

			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String filename = new SimpleDateFormat("yyyyMMdd_hhmmss").format(Calendar.getInstance().getTime());

			// Change the below Path:-------------------------------------------
			File dest = new File("" + "Screenshots\\" + filename + ".png");
			FileUtils.copyFile(scr, dest);

		} catch (Exception e) {
			Log.error("Not able to take Screenshot --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void ExWait(String object, String data) throws Exception {
		try {
			Log.info("Waiting for the element");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
		} catch (Exception e) {
			Log.error("Element not visible --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void MouseHover(String object, String data) throws Exception {
		try {
			Log.info("Hovering the Element");
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(OR.getProperty(object)));
			action.moveToElement(we).build().perform();
		} catch (Exception e) {
			Log.error("Element not visible to Hover --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void DownKey(String object, String data) {
		try {
			Log.info("Entering the down value Key");
			Robot rb = null;
			try {
				rb = new Robot();
				rb.keyPress(KeyEvent.VK_DOWN);

			} catch (AWTException e) {

				e.printStackTrace();
			}
		} catch (Exception e) {
			Log.error("Not able to Enter the down value Key --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	// Common
	public static void End(String object, String data) {
		try {
			Log.info("Entering the End Key");
			Robot rb = null;
			try {
				rb = new Robot();
				rb.keyPress(KeyEvent.VK_END);

			} catch (AWTException e) {

				e.printStackTrace();
			}
		} catch (Exception e) {
			Log.error("Not able to Enter the End Key --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

}