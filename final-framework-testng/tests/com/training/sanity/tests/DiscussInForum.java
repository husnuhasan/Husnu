package com.training.sanity.tests;
/*
TestCase Objective:TO verify whether application allows student to discuss in the forum
*/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.DiscussInForumPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class DiscussInForum{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CourseCatalogPOM courseCatalogPOM;
	private DiscussInForumPOM DiscussInForumPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		courseCatalogPOM = new CourseCatalogPOM(driver);
		DiscussInForumPOM = new DiscussInForumPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void DiscussInForumTest() throws InterruptedException   {
		
		//login to application
		
		  loginPOM.sendUserName("test35"); 
		  loginPOM.sendPassword("test");
		  loginPOM.clickLoginBtn();
		 
		
		  //click on 'Course catalog' button
		courseCatalogPOM.clickCourseCatalog();
		  //search for a course(passed as an argument)
		courseCatalogPOM.sendSearchname("123testing");
		//Click to Subscribe the course
		courseCatalogPOM.clickSubscribe();
		//driver.findElement(By.linkText("Course home")).click();
		//To click on the Forum icon
		DiscussInForumPOM.clickForum();
		//To click on the particular group
		DiscussInForumPOM.clickgroupName();
		//To click create thread icon to create a new tread
		DiscussInForumPOM.clickThread();
		//To enter the title of the thread
		DiscussInForumPOM.createThreadtitle("Sample");
		Thread.sleep(5000);
		//To enter the text of the thread
		DiscussInForumPOM.createThreadtext("This is a sample thread-need help");
		//Clicking on 'Create thread' button
		DiscussInForumPOM.clickThreadBtn();
		//Replying to the thread
		DiscussInForumPOM.clickreplyBtn();
		//Entering reply text to the thread
		DiscussInForumPOM.replyThreadtext("Here is the sample reply to the thread");
		screenShot.captureScreenShot("Discuss Forum");
		
		String actual= driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
		String expected="The reply has been added";
		Assert.assertEquals(actual, expected);
	

	}
	
	
}
