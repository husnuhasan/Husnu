package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class LoginPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Course catalog")
	private WebElement coursecatalog; 
	
	
	@FindBy(name="search_term")
	private WebElement search_term; 
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement search_btn; 

	@FindBy(linkText="Subscribe")
	private WebElement subscribe; 
	
	@FindBy(linkText="My courses")
	private WebElement mycourse; 
		
	@FindBy(linkText="123testing")
	private WebElement course; 
	
	@FindBy(linkText="Course description")
	private WebElement coursedesc; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement toggle; 
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	
	public void clickCourseCatalog() {
		this.coursecatalog.click(); 
	}
	
	public void sendSearchname(String searchterm) {
		this.search_term.clear();
		this.search_term.sendKeys(searchterm);
		this.search_btn.click(); 
		driver.findElement(By.linkText(searchterm)).click();
		
	}
	
	public void clickSubscribe() {
		this.subscribe.click(); 
		
	}
	
	public void clickMyCourse() {
		this.mycourse.click(); 
		
	}
	
	public void clickCourse() {
		this.course.click(); 
		
	}
	
	public void clickCourseDesc() {
		this.coursedesc.click(); 
		
	}
	
	public void clickToggle() {
		this.toggle.click(); 
	;
	
		
		
	}
	
	public void clickLogout() {
		this.logoutBtn.click(); 
		
	}
}
