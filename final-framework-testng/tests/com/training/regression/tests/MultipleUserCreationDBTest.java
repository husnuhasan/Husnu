package com.training.regression.tests;
//TO verify whether application allows admin to create multiple user with different roles & register them to the course
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.UsersDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MultipleUserCreationPOM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MultipleUserCreationDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MultipleUserCreationPOM MultipleUserCreationPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		MultipleUserCreationPOM = new MultipleUserCreationPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Login");
		//After logging in as Admin,Click on 'adduser' button to add users
		MultipleUserCreationPOM.clickadduserBtn();
	
	}

	@AfterClass
	public void tearDown() throws Exception {
		
		  driver.quit();
	}



	@Test(dataProvider = "db-inputs", dataProviderClass = UsersDataProviders.class)
	public void MultipleUserCreationTest(String firstname, String lastname,String email,String phone,String login,String password,String profile) {
		
		//Providing all the mandatory fields needed to create user
		ArrayList<String> a = new ArrayList<String>();
		a.add(lastname+" "+firstname+" "+(login));
		MultipleUserCreationPOM.sendFirstname(firstname);
		MultipleUserCreationPOM.sendLastname(lastname);
		MultipleUserCreationPOM.sendemail(email);
		MultipleUserCreationPOM.sendphone(phone);
		MultipleUserCreationPOM.sendlogin(login);
		MultipleUserCreationPOM.sendPassword(password);
		MultipleUserCreationPOM.sendProfile(profile);
		//To add the next user
		MultipleUserCreationPOM.clickaddplusBtn();
		screenShot.captureScreenShot("User details");
		String actual=driver.findElement(By.xpath("//div[@class=\"alert alert-info\"]")).getText(); 
		String expected="The user has been added: "+firstname+" "+lastname;
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test ()
	public void UserAdditiontoCourseTest()
	{
		//To add the users to selected Course
				MultipleUserCreationPOM.clickadminlink();
				  MultipleUserCreationPOM.clickaddusertoCourse();
				  //Creating arraylist to store users to add to particular course
				  
				  
				  ArrayList<String> users = new ArrayList<String>();
				  users.add("izzath maryam (maryam45)");             
				  users.add("izzath maryam (maryam34)");
				    
				  MultipleUserCreationPOM.sendUserlist(users);
				  MultipleUserCreationPOM.sendCourselist("(540) selenium");
				  MultipleUserCreationPOM.clickaddtocourseBtn();
				  String expected="The selected users are subscribed to the selected course";
				  String actual=driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();
				  Assert.assertEquals(actual, expected);
				  screenShot.captureScreenShot("AddCourse");
	}

private Select Select(WebElement findElement) {
	// TODO Auto-generated method stub
	return null;
}
	
}