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
import com.training.pom.CourseDescriptionPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
/*
TestCase Objective:To verify whether application displays course details registered by the student
*/
public class CourseDescriptionTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CourseDescriptionPOM coursedescriptionPOM;
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
		coursedescriptionPOM = new CourseDescriptionPOM(driver); 
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
	public void MyCourseTest()  {
		
		//login to application
		loginPOM.sendUserName("test13");
		loginPOM.sendPassword("test");
		loginPOM.clickLoginBtn(); 
		//Go to 'My Course' tab
		coursedescriptionPOM.clickMyCourse();
		//Click on Subscribed course
		coursedescriptionPOM.clickCourse();
		
		//Click on course description
		coursedescriptionPOM.clickCourseDesc();
		String actual= driver.findElement(By.xpath("//div[@class='panel-heading']")).getText();
		String expected="Course description of 123testing below.";
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("Course decription");
			
	}
	
	
}
