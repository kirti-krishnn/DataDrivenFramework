package com.datadriven.framework.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseUI {

	public WebDriver driver;

	public Properties prop;

	// Open the browser
	public void invokeBrowser(String browserName) {
		if (prop == null) {
			System.out.println("k4");
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						"C:\\kirti\\JavaTraining\\DataDrivenFrameWork\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
				System.out.println("k3");
				prop.load(file);
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("k6");
			}
		}

		System.out.println("k1");
		if (browserName == "Chrome") {
			System.out.println("8");
			System.setProperty("webdriver.chrome.driver",
					"C:\\kirti\\JavaTraining\\DataDrivenFrameWork\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.setAcceptInsecureCerts(true);
			System.out.println("k7");
			driver = new ChromeDriver();
			System.out.println("k5");
		}
		System.out.println("k2");
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		// System.out.println(System.getProperty("user.dir"));

	}

	// load the website
	public void openURL(String websiteURLkey) {
		driver.get(prop.getProperty(websiteURLkey));
	}

	// close the driver
	public void tearDown() {
		driver.close();

	}

	// quit the browser
	public void quitBrowser() {
		driver.quit();

	}

	// Enter text in textfield
	public void enterText(String xpathKey, String data) {
		// driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		getElement(xpathKey).sendKeys(data);
	}

	// Click the element
	public void ElementClick(String xpathKey) {
		// driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
		getElement(xpathKey).click();
	}

	public WebElement getElement(String locatorKey) {
		WebElement element = null;

		try {
		if (locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_LinkText")) {
			element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_PartialLinkText")) {
			element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_Name")) {
			element = driver.findElement(By.name(prop.getProperty(locatorKey)));
		}
		}catch(Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
			
			Assert.fail("Failing the testcase: ",e.getMessage());
		}
		
		return element;
	}

	public void reportFail(String reportString) {

	}

	public void reportPass(String reportString) {

	}

	public void takeScreenShotOnFailure() {

	}

}
