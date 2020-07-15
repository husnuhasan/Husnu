package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import com.training.pom.TestCreationEvaluationPOM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
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
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCreationEvaluationTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private CourseCatalogPOM courseCatalogPOM;
	private TestCreationEvaluationPOM TestCreationEvaluationPOM;
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
		logoutPOM =new LogoutPOM(driver);
		courseCatalogPOM = new CourseCatalogPOM(driver);
		TestCreationEvaluationPOM=new TestCreationEvaluationPOM(driver);
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
	public void validLoginTest() {
		loginPOM.sendUserName("husnusoudha");
		loginPOM.sendPassword("test");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login");
	}
	
	
	@Test(priority = 2)
	public void createTest() throws InterruptedException
	{
		TestCreationEvaluationPOM.clickCourselink();//click on Courselink
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TestCreationEvaluationPOM.clickTesticon();//Clik test icon
		TestCreationEvaluationPOM.clickCreateTestBtn();
		TestCreationEvaluationPOM.sendTestname("Assessment345");//Test name
		TestCreationEvaluationPOM.clickAdvanceparam();
		Thread.sleep(5000);
		TestCreationEvaluationPOM.sendcontent2test("sample text");//Test description
		TestCreationEvaluationPOM.clickFeedbackBtn();
		TestCreationEvaluationPOM.checkStartdate(); //date of test
		TestCreationEvaluationPOM.enterStarttimeBtn();
		TestCreationEvaluationPOM.enterStarttime();
		TestCreationEvaluationPOM.clickdoneBtn();
		TestCreationEvaluationPOM.sendPasspercent("70");//pass percentage is entered
		TestCreationEvaluationPOM.clickproceedtoquesBtn();
		TestCreationEvaluationPOM.clickMCBtn(); //Creating multiple choice questions
		TestCreationEvaluationPOM.sendQuestion1("which course are you learning");	//Question 1 is entered
		Thread.sleep(3000);
		TestCreationEvaluationPOM.sendanswer1("Selenium");	
		Thread.sleep(3000);
		TestCreationEvaluationPOM.sendanswer2("C");	
		TestCreationEvaluationPOM.sendanswer3("C++");	
		TestCreationEvaluationPOM.sendanswer4("Java");
		//click on radio  button for question1
		TestCreationEvaluationPOM.clickQuest1Btn();

		TestCreationEvaluationPOM.sendscore1();
	
		TestCreationEvaluationPOM.clickQuestSubBtn();
		//Enter the next question
		TestCreationEvaluationPOM.clickMCBtn();
		TestCreationEvaluationPOM.sendQuestion1("which language are you using in selenium");	//Question 2 is entered
		Thread.sleep(3000);
		TestCreationEvaluationPOM.sendanswer1("Python");	
		TestCreationEvaluationPOM.sendanswer2("Java");	
		TestCreationEvaluationPOM.sendanswer3("C#");	
		TestCreationEvaluationPOM.sendanswer4("C");
		Thread.sleep(3000);
		TestCreationEvaluationPOM.clickQuest2Btn();
		TestCreationEvaluationPOM.sendscore2();
		TestCreationEvaluationPOM.clickQuestSubBtn();  //test created
		TestCreationEvaluationPOM.clickPreviewBtn();
		String actual= driver.findElement(By.linkText("Start test")).getText();
		String expected="Start test";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void validLogoutTest() {
		logoutPOM.clickToggle();
		logoutPOM.clickLogout();
	}
	
	@Test(priority = 4)
	public void studentLoginTest() {
		//login as a Student
		loginPOM.sendUserName("test10");
		loginPOM.sendPassword("test");
		loginPOM.clickLoginBtn(); 
		 courseCatalogPOM.clickCourseCatalog();
		  //search for a course(passed as an argument)
		courseCatalogPOM.sendSearchname("SampleCourse-Husnu");
		
		//Click to Subscribe the course
		courseCatalogPOM.clickSubscribe();
		
		//click on test icon
		TestCreationEvaluationPOM.clicktesticon1();
		TestCreationEvaluationPOM.clicktestlink();
		//Start test and answer all the questions
		TestCreationEvaluationPOM.clickstarttestBtn();
		TestCreationEvaluationPOM.clickanswer1();
		TestCreationEvaluationPOM.clicknextBtn();
		TestCreationEvaluationPOM.clickanswer2();
		TestCreationEvaluationPOM.clicknextBtn();
	}
	@Test(priority = 5)
	public void studentLogoutTest() {
		logoutPOM.clickToggle();
		logoutPOM.clickLogout();
	}

	@Test(priority = 6)
	public void teacherLoginTest() {
		loginPOM.sendUserName("husnusoudha");
		loginPOM.sendPassword("test");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login");
	}
	
	@Test(priority = 7)
	public void evaluateTest() throws InterruptedException
	{
		TestCreationEvaluationPOM.clickCourselink();//click on Courselink
		TestCreationEvaluationPOM.clickreporting();//clicking on reporting icon
		TestCreationEvaluationPOM.clickstudBtn();// >> button
		TestCreationEvaluationPOM.clickquizicon();//test button
		TestCreationEvaluationPOM.clicksendemail(); //send email checkbox
		//To correct test
		TestCreationEvaluationPOM.clickcorrecttest();
		
		String actual= driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText();
		String expected="Message Sent";
		Assert.assertEquals(actual, expected);
		TestCreationEvaluationPOM.clickCourselink();
		String actual1= driver.findElement(By.linkText("SampleCourse-Husnu")).getText();
		String expected1="SampleCourse-Husnu";
		Assert.assertEquals(actual1, expected1);
	} 
}

