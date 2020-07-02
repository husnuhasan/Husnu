package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
/*
 TestCase Objective:To verify whether application allows student to get log out from the application
 */
public class LogoutTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		logoutPOM = new LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void ClickLogoutTest()  {
		//login to application
		  loginPOM.sendUserName("123"); 
		  loginPOM.sendPassword("123"); 
		  loginPOM.clickLoginBtn();
		  String actual1=driver.findElement(By.xpath("//p[contains(text(),'Hello')]")).getText();		  
		  String expected1="Hello 123 123 and welcome,";
		  Assert.assertEquals(actual1, expected1);		 
		logoutPOM.clickToggle();
		
		////logout from the application
		logoutPOM.clickLogout();		
		String actual= driver.getCurrentUrl();
		String expected="http://elearningm1.upskills.in/index.php";
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("logout");
		
	}
}
