package com.datadriven.framework.test.LoginTest;

// test flow for rediff

import org.testng.annotations.Test;

import com.datadriven.framework.base.BaseUI;

public class loginTest extends BaseUI{
	
	@Test
	public void testOne() {
		
		invokeBrowser("Chrome");
		openURL("https:\\www.rediff.com");
		ElementClick("//*[@id=\"signin_info\"]/a[1]");
		enterText("//*[@id=\"login1\"]","TestUserRediff");
		enterText("//*[@id=\"password\"]","Test@123");
		ElementClick("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]");
		tearDown();
		
	}
    
	@Test(dependsOnMethods="testOne")
	public void testTwo() {
		
		invokeBrowser("Chrome");
		openURL("https:\\www.rediff.com");
		ElementClick("//*[@id=\"signin_info\"]/a[1]");
		enterText("//*[@id=\"login1\"]","TestUserRediff");
		enterText("//*[@id=\"password\"]","Test@123");
		ElementClick("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]");
		tearDown();
	}
	
	@Test(dependsOnMethods="testTwo")
	public void testThree() {
		invokeBrowser("Chrome");
		openURL("https:\\www.rediff.com");
		ElementClick("//*[@id=\"signin_info\"]/a[1]");
		enterText("//*[@id=\"login1\"]","TestUserRediff");
		enterText("//*[@id=\"password\"]","Test@123");
		ElementClick("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]");
		tearDown();
	}
}
