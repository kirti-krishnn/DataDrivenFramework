package com.datadriven.framework.test.LoginTest;

// test flow for rediff

import org.testng.annotations.Test;

import com.datadriven.framework.base.BaseUI;

public class loginTest extends BaseUI{
	
	@Test
	public void testOne() {
		
		invokeBrowser("Chrome");
		System.out.println("1");
		openURL("websiteURL");
		ElementClick("signinBtn_xpath");
		enterText("userNameTextBox_id","TestUserRediff");
		enterText("passwordTextBox_xpath","Test@123");
		ElementClick("submitBtn_CSS");
		tearDown();
		//quitBrowser();
		
	}
    
	//@Test (dependsOnMethods="testOne")
	public void testTwo() {
		
		invokeBrowser("browserName");
		System.out.println("2");
		openURL("websiteURL");
		ElementClick("signinBtn_xpath");
		enterText("userNameTextBox_xpath","TestUserRediff");
		enterText("passwordTextBox_xpath","Test@123");
		ElementClick("submitBtn_xpath");
		tearDown();
		//quitBrowser();
	}
	
	//@Test(dependsOnMethods="testTwo")
	public void testThree() {
		invokeBrowser("browserName");
		System.out.println("3");
		openURL("websiteURL");
		ElementClick("signinBtn_xpath");
		enterText("userNameTextBox_xpath","TestUserRediff");
		enterText("passwordTextBox_xpath","Test@123");
		ElementClick("submitBtn_xpath");
		tearDown();
		//quitBrowser();
	}
}
