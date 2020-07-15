package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class MultipleUserCreationPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public MultipleUserCreationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Add a user")
	private WebElement adduser; 
	
	@FindBy(id = "firstname")
	private WebElement firstname; 
	
	@FindBy(id = "lastname")
	private WebElement lastname; 
	
	@FindBy(id = "email")
	private WebElement email; 
	
	@FindBy(id = "phone")
	private WebElement phone; 
	
	@FindBy(id = "username")
	private WebElement login; 
	
	@FindBy(id = "password")
	private WebElement password; 
	
	@FindBy(id="status_select")
	private WebElement role;
	
	@FindBy(name = "submit_plus")
	private WebElement addplus;
	
	@FindBy(linkText ="Administration")
	private WebElement adminlink;
	
	@FindBy(linkText ="Add users to course")
	private WebElement addusertocourse;

	
	@FindBy(name = "UserList[]")
	private WebElement userlist;

	
	
	@FindBy(name = "CourseList[]")
	private WebElement courselist;
	
	@FindBy(xpath = "//button[ @type=\"submit\"and@value=\"Add to the course(s) >>\"]")
	private WebElement addcourseBtn;

	public void clickadduserBtn() {
		this.adduser.click(); 
	}
	
	public void sendFirstname(String firstname) {
		this.firstname.clear(); 
		this.firstname.sendKeys(firstname); 
	}
	
	public void sendLastname(String lastname) {
		this.lastname.clear(); 
		this.lastname.sendKeys(lastname); 
	}
	
	public void sendemail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendphone(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone); 
	}
	
	public void sendlogin(String login) {
		this.login.clear(); 
		this.login.sendKeys(login); 
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	
	  public void sendProfile(String profile) {
		  Select sel=new Select(role);
		  sel.selectByVisibleText(profile);
		  }
	 

	public void clickaddplusBtn() {
		this.addplus.click(); 
	}
	
	public void clickadminlink() {
		this.adminlink.click(); 
	}
	
	public void clickaddusertoCourse() {
		this.addusertocourse.click(); 
	}
	
	 public void sendUserlist(ArrayList<String> a) {
		  Select sel=new Select(userlist);
		  Select sel1= new Select(driver.findElement(By.name("firstLetterUser")));
		  sel1.selectByVisibleText("I");
		  sel.selectByVisibleText(a.get(0));
		  sel.selectByVisibleText(a.get(1));
		  }
	 
	 public void sendCourselist(String course) {
		  Select sel=new Select(courselist);
		  sel.selectByVisibleText(course);
		  }

	 public void clickaddtocourseBtn() {
			this.addcourseBtn.click(); 
		}
}


