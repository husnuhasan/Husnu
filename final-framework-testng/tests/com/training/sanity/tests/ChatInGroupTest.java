/*
TestCase Objective:To verify whether application allows student to chat in group
*/
package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

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
import com.training.pom.ChatInGroupPOM;
import com.training.pom.CompleteAssignmentsPOM;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class ChatInGroupTest{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CourseCatalogPOM courseCatalogPOM;
	private ChatInGroupPOM chatingroupPOM;
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
		chatingroupPOM = new ChatInGroupPOM(driver); 
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
	public void ChatInGroupTest() throws InterruptedException  {
		
		//login to application
		
		  loginPOM.sendUserName("test36"); 
		  loginPOM.sendPassword("test");
		  loginPOM.clickLoginBtn();
		  
		 //click on 'Course catalog' button
		  courseCatalogPOM.clickCourseCatalog();
		  //search for a course(passed as an argument)
		  courseCatalogPOM.sendSearchname("123testing");
		//Click to Subscribe the course
		  courseCatalogPOM.clickSubscribe();
			
		//To click on 'Group' icon of the course
		chatingroupPOM.clickGroupicon();
		//Click on the name name of the group
		chatingroupPOM.clickGroupname();
		//Click on the chat icon	
		chatingroupPOM.clickchaticon();
		//Click on 'Leave a message' icon next to any group member - To do this ,switching to child window by using getWindowHandles()
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.manage().window().maximize();
		chatingroupPOM.clickleavemsgicon();
		//Enter the message
		chatingroupPOM.sendMessage("Hello");
		//Click to send message
		chatingroupPOM.clicksendMessageBtn();
		screenShot.captureScreenShot("Chat In Group");
		String actual= driver.findElement(By.tagName("p")).getText();
		String expected ="Hello";
		Assert.assertEquals(actual, expected);
	}
	
	
}
