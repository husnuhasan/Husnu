package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
	@Test(priority = 1 )
	public void validLoginTest() {
		loginPOM.sendUserName("test13");
		loginPOM.sendPassword("test");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login");
	}

	@Test(priority = 2)
	public void CourseCatalogTest()  {
		loginPOM.clickCourseCatalog();
		loginPOM.sendSearchname("123testing");
		loginPOM.clickSubscribe();
		String actual= driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
		String expected="User test test (test13) has been registered to course 123testing";
		AssertJUnit.assertEquals(actual, expected);
		screenShot.captureScreenShot("Course catalog");
		
	}
	
	@Test(priority = 3)
	public void MyCourseTest()  {
		loginPOM.clickMyCourse();
		loginPOM.clickCourse();
		loginPOM.clickCourseDesc();
		String actual= driver.findElement(By.xpath("//div[@class='panel-heading']")).getText();
		String expected="Course description of 123testing below.";
		AssertJUnit.assertEquals(actual, expected);
		screenShot.captureScreenShot("Course decription");
		loginPOM.clickToggle();
		
		loginPOM.clickLogout();
		
		
	}
	
	@Test(priority = 4)
	public void ClickLogoutTest()  {
		
		  loginPOM.sendUserName("123"); 
		  loginPOM.sendPassword("123"); 
		  loginPOM.clickLoginBtn();
		  String actual1=driver.findElement(By.xpath("//p[contains(text(),'Hello')]")).getText();		  
		  String expected1="Hello 123 123 and welcome,";
		  AssertJUnit.assertEquals(actual1, expected1);		 
		loginPOM.clickToggle();
		loginPOM.clickLogout();		
		String actual= driver.getCurrentUrl();
		String expected="http://elearningm1.upskills.in/index.php";
		AssertJUnit.assertEquals(actual, expected);
		screenShot.captureScreenShot("logout");
		
	}
}
