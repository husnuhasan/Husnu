package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class CompleteAssignmentsPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public CompleteAssignmentsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Assignments")
	private WebElement assignmentlink; 
	
	@FindBy(linkText="test")
	private WebElement assignments; 
	
	@FindBy(linkText="Upload my assignment")
	private WebElement uploadBtn; 

	@FindBy(id="tabs2")
	private WebElement uploadassign;
		
	
	@FindBy(id="form-work_file")
	private WebElement uploadfile;
	
	public void clickAssign() {
		this.assignmentlink.click(); 
	}
	
	
	  @FindBy(id="form-work_submitWork") 
	  private WebElement submitfile;
	 
	
	public void clickAssignLink() {
		this.assignments.click(); 
	}
	
	public void clickuploadBtn() {
		this.uploadBtn.click(); 
	}
	
	public void clickuploadassign() { 
		 this.uploadassign.click();
	  
	  }
	 
	public void clickuploadfile(String path) { 
		 this.uploadfile.sendKeys(path);
	  
	  }

		
	
	  public void submitFile() {
		  this.submitfile.click();
	  
	  }
	 
	
	
}
