package com.training.sanity.tests;
/*
TestCase Objective:To verify whether application allows student to complete the assignments
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
import com.training.pom.CompleteAssignmentsPOM;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class CompleteAssignmentsTests{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CourseCatalogPOM courseCatalogPOM;
	private CompleteAssignmentsPOM completeAssignmentsPOM;
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
		courseCatalogPOM = new CourseCatalogPOM(driver); 
		completeAssignmentsPOM = new CompleteAssignmentsPOM(driver); 
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
	public void CompleteAssignmentTest() throws InterruptedException  {
		
		//login to application
		
		  loginPOM.sendUserName("test34"); 
		  loginPOM.sendPassword("test");
		  loginPOM.clickLoginBtn();
		
		  //click on 'Course catalog' button
		  courseCatalogPOM.clickCourseCatalog();
		  //search for a course(passed as an argument)
		  courseCatalogPOM.sendSearchname("testing innovation");	
		//Click to Subscribe the course
		  courseCatalogPOM.clickSubscribe();
		//Click on Assignment icon
		  completeAssignmentsPOM.clickAssign();
		//Click on the assignment link
		  completeAssignmentsPOM.clickAssignLink();
		//clicking upload file button
		  	completeAssignmentsPOM.clickuploadBtn();	
		 //Uploading assignment file by clicking upload(simple)
			completeAssignmentsPOM.clickuploadassign();	
		//Selecting the path from local machine
			completeAssignmentsPOM.clickuploadfile("C:\\Users\\HusnuSoudhaHasanAbdu\\Documents\\Automation training\\test file.txt");	
		//Submitting the file
			completeAssignmentsPOM.submitFile();
			screenShot.captureScreenShot("CompleteAssignment");
			String actual = driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
			String expected= "The file has been added to the list of publications.";
			Assert.assertEquals(actual, expected);

	}
	
	
}
