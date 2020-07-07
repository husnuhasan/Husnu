package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class DiscussInForumPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public DiscussInForumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@id=\"toolimage_1749\"]")
	private WebElement forumicon;
	
	@FindBy(linkText = "rockers")
	private WebElement groupname;
	
	@FindBy(xpath = "//img[@title=\"Create thread\"]")
	private WebElement createthread;
	
	 @FindBy(id="thread_post_title")
	 private WebElement threadtitle;
	 
	 
	  @FindBy(xpath="//body[@contenteditable=\"true\" and  @class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]")
	  private WebElement threadtext;
		 
	 
	 @FindBy(id="thread_SubmitPost")
	 private WebElement threadBtn;
	 
	 
	 @FindBy(xpath="//a[@title=\"Reply to this message\"]")
	 private WebElement replyBtn;
	
	
	public void clickForum() 
	{ 
		this.forumicon.click();
	}
	public void clickgroupName() 
	{ 
		this.groupname.click();
	}
	public void clickThread() 
	{ 
		this.createthread.click();
	}
	
	public void createThreadtitle(String title) 
	{ 
		this.threadtitle.sendKeys(title);
		
	}
	public void createThreadtext(String text) throws InterruptedException 
	{ 
		//Moving focus to frame
		driver. switchTo().frame(0);
		this.threadtext.sendKeys(text);
		driver.switchTo().defaultContent();
	
	}
	
	
	public void clickThreadBtn() 
	{ 
		this.threadBtn.click();
		
	}
	
	public void clickreplyBtn() 
	{ 
		this.replyBtn.click();
		
	}
	public void replyThreadtext(String replytext) throws InterruptedException  
	{ 
		
		this.threadtitle.click();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		this.threadtext.sendKeys(replytext);
		driver.switchTo().defaultContent();
		this.threadBtn.click();
	}
}
