package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class LogoutPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement toggle; 
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn; 
	
	
	
	public void clickToggle() {
		this.toggle.click(); 
		
	}
	
	public void clickLogout() {
		this.logoutBtn.click(); 
		
	}
}
