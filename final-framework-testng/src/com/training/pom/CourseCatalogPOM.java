package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class CourseCatalogPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public CourseCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="Course catalog")
	private WebElement coursecatalog; 
	
	
	@FindBy(name="search_term")
	private WebElement search_term; 
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement search_btn; 

	@FindBy(linkText="Subscribe")
	private WebElement subscribe; 
	
	
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
}
