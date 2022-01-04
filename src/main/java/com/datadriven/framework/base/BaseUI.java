package com.datadriven.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUI {
	
	public WebDriver driver;
	
	public void invokeBrowser(String BrowserName)
	{
		if(BrowserName=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\kirti\\JavaTraining\\DataDrivenFrameWork\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
		
	}
	
	public void openURL(String websiteURL) {
		driver.get(websiteURL);
	}
	
	public void tearDown() {		
		driver.close();
		
	}
	
	public void quitBrowser() {
		driver.quit();
		
		
	}
	
	public void enterText(String xpath,String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}
	
	public void ElementClick(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
}
