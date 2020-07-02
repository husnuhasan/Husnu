package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class CourseDescriptionPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public CourseDescriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="My courses")
	private WebElement mycourse; 
		
	@FindBy(linkText="123testing")
	private WebElement course; 
	
	@FindBy(linkText="Course description")
	private WebElement coursedesc; 
	
	
	
	public void clickMyCourse() {
		this.mycourse.click(); 
		
	}
	
	public void clickCourse() {
		this.course.click(); 
		
	}
	
	public void clickCourseDesc() {
		this.coursedesc.click(); 
		
	}
	
	
}
