package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatInGroupPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public ChatInGroupPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@id=\"toolimage_1752\"]")
	private WebElement groupicon;
	
	@FindBy(linkText = "Group 0001")
	private WebElement groupname;
	
	
	@FindBy(xpath="//img[@title=\"Chat\"]")
	private WebElement chaticon;
		
	@FindBy(xpath="//button[@data-name=\"Riyaz Ahamed\"]/i[@class=\"fa fa-comments text-muted\"]")
	private WebElement leavemsgicon;
	
	@FindBy(xpath="//div[@class=\"emoji-wysiwyg-editor\" and @contenteditable=\"true\"]")
	private WebElement message;
	
	@FindBy(id="chat-send-message")
	private WebElement sendmsgBtn;
	
	public void clickGroupicon() {
		this.groupicon.click(); 
	}
	
	public void clickGroupname() {
		this.groupname.click(); 
	}
	
	public void clickchaticon() {
		this.chaticon.click(); 
	}
	
	public void clickleavemsgicon() {
		this.leavemsgicon.click(); 
	}
	
	
	public void sendMessage(String message) {
		this.message.sendKeys(message);
	}
	
	public void clicksendMessageBtn() {
		this.sendmsgBtn.click();
	}
}
