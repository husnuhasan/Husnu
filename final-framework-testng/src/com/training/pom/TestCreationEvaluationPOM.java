package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.sanity.tests.List;

public class TestCreationEvaluationPOM {
	private static final String search = null;

	private WebDriver driver; 
	
	public TestCreationEvaluationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "SampleCourse-Husnu")
	private WebElement courselink;
	
	@FindBy(id="toolimage_20909")
	private WebElement testicon;
	
	@FindBy(xpath = "//img[@title=\"Create a new test\"]")
	private WebElement createtestBtn;
	
	@FindBy(id="exercise_title")
	private WebElement testname;
	
	@FindBy(id="advanced_params")
	private WebElement advanceparam;
	
	@FindBy(xpath = "//body[@contenteditable=\"true\" and @class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]")
	private WebElement cntnt2testbox;
	
	@FindBy(id="exerciseType_0")
	private WebElement feedbackBtn;
	
	@FindBy(name="activate_start_date_check")
	private WebElement strtdate;
	
	@FindBy(xpath= "//img[@title=\"Select date\"]")
	private WebElement strttimeBtn;
	

	@FindBy(xpath = "//*[@class=\"ui-datepicker-calendar\"]/tbody/tr[3]/td[2]")
	private WebElement strttime;
	
	@FindBy(xpath= "//button[@class=\"ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all\"]")
	private WebElement doneBtn;
	
	@FindBy(id="pass_percentage")
	private WebElement passpercent;
	
	@FindBy(id="exercise_admin_submitExercise")
	private WebElement proceedtoquesBtn;
	
	@FindBy(xpath = "//img[@title=\"Multiple choice\"]")
	private WebElement MCBtn;
	
	@FindBy(id="question_admin_form_questionName")
	private WebElement question;
	

	@FindBy(xpath = "//body[@contenteditable=\"true\" and @class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]")
	private WebElement answerbox;
	
	@FindBy(xpath="//*[@class=\"table table-striped table-hover\"]/tbody/tr[1]/td[2]//input[@value=\"1\"]")
	private WebElement question1;

	@FindBy(xpath="//*[@class=\"table table-striped table-hover\"]/tbody/tr[1]/td[5]//input[@id=\"question_admin_form_weighting[1]\"]")
	private WebElement score1;
	
	@FindBy(xpath="//*[@class=\"table table-striped table-hover\"]/tbody/tr[4]/td[5]//input[@id=\"question_admin_form_weighting[4]\"]")
	private WebElement score2;
	
	@FindBy(id="submit-question")
	private WebElement submitquestion;
	
	@FindBy(xpath="//*[@class=\"table table-striped table-hover\"]/tbody/tr[2]/td[2]//input[@value=\"2\"]")
	private WebElement question2;

	@FindBy(xpath = "//img[@title=\"Preview\"]")
	private WebElement PreviewBtn;
	
	@FindBy(id="toolimage_20909")
	private WebElement testicon1;
	
	@FindBy(linkText ="Assessment345")
	private WebElement testlink;
	
	@FindBy(linkText ="Start test")
	private WebElement starttestBtn;
	
	@FindBy(id="choice-436-1")
	private WebElement ans1;
	
	@FindBy(id="choice-437-2")
	private WebElement ans2	;
	
	@FindBy(xpath = "//button[@type=\"button\" and @name=\"save_now\"]")
	private WebElement nextBtn;
	
	
	@FindBy(id= "question_admin_form_weighting[1]")
	private WebElement score;
	
	@FindBy(id ="toolimage_20925")
	private WebElement reporting;
	
	@FindBy(xpath = "//table[@class=\"table table-bordered data_table\"]/tbody//tr[9]/td[16]")
	private WebElement studBtn;
	
	@FindBy(xpath="//table[@class=\"table table-striped table-hover\"]/tbody/tr[1]/td[5]//img[@title=\"Test\"]")
	private WebElement quizicon;
	
	@FindBy(name= "send_notification")
	private WebElement sendemail;
	
	@FindBy(id ="form-email_submit")
	private WebElement correcttest;
	
	public void clickCourselink() {
		this.courselink.click(); 
	}
	
	public void clickTesticon() {
		this.testicon.click(); 
	}
	
	public void clickCreateTestBtn() {
		this.createtestBtn.click(); 
	}
	
	public void sendTestname(String testname) {
		this.testname.clear();
		this.testname.sendKeys(testname);
	}
	
	public void clickAdvanceparam() {
		this.advanceparam.click(); 
	}
	public void sendcontent2test(String text) throws InterruptedException {
		
		
		driver.switchTo().frame(0);
		
		this.cntnt2testbox.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	
	public void clickFeedbackBtn() {
		this.feedbackBtn.click(); 
	}
	public void checkStartdate() {
		this.strtdate.click(); 
	}
	
	public void enterStarttimeBtn() {
		this.strttimeBtn.click();
	}
	public void enterStarttime() {
		this.strttime.click();
	}
	public void clickdoneBtn() {
		this.doneBtn.click();
	}
	
	public void sendPasspercent(String percent) {
		this.passpercent.clear();
		this.passpercent.sendKeys(percent);
	}
	public void clickproceedtoquesBtn() {
		this.proceedtoquesBtn.click();
	}
	
	public void clickMCBtn() {
		this.MCBtn.click();
	}
	
	public void sendQuestion1(String question) {
		this.question.clear();
		this.question.sendKeys(question);
	}
	public void sendscore1() {
		this.score1.clear();
		this.score1.sendKeys("1");
	}
	
	public void sendscore2() {
		this.score2.clear();
		this.score2.sendKeys("1");
	}
	
	public void sendanswer1(String text) throws InterruptedException {
		driver.switchTo().frame(1);	
		this.answerbox.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	public void sendanswer2(String text) throws InterruptedException {
		driver.switchTo().frame(3);	
		this.answerbox.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	public void sendanswer3(String text) throws InterruptedException {
		driver.switchTo().frame(5);	
		this.answerbox.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	public void sendanswer4(String text) throws InterruptedException {
		driver.switchTo().frame(7);	
		this.answerbox.sendKeys(text);
		driver.switchTo().defaultContent();
	}
	
	public void clickQuest1Btn() {
		this.question1.click();
	}
	
	public void clickQuestSubBtn() {
		this.submitquestion.click();
	}
	
	public void clickQuest2Btn() {
		this.question2.click();
	}
	public void clickPreviewBtn() {
		this.PreviewBtn.click();
	}
	
	public void clicktesticon1() {
		this.testicon1.click();
	}
	
	public void clicktestlink() {
		this.testlink.click();
	}
	
	public void clickstarttestBtn() {
		this.starttestBtn.click();
	}
	public void clickanswer1() {
		this.ans1.click();
	}
	public void clicknextBtn() {
		this.nextBtn.click();
	}
	
	public void clickanswer2() {
		this.ans2.click();
	}
	
	public void clickreporting() {
		this.reporting.click();
	}
	
	public void clickstudBtn() {
		this.studBtn.click();
	}
	
	public void clickquizicon() {
		this.quizicon.click();
	
	}
	
	public void clicksendemail() {
		this.sendemail.click();
	}
	
	public void clickcorrecttest() {
		this.correcttest.click();
	}
	
}



