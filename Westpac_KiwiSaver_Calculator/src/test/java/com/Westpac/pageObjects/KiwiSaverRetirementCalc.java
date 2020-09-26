package com.Westpac.pageObjects;

//import org.openqa.selenium.By;

//import org.openqa.selenium.By;

//import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;

public class KiwiSaverRetirementCalc
{
	private WebDriver driver;

	//Write the constructor
	public KiwiSaverRetirementCalc(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Identify the elements on KiwiSaver Retirement Calculator page


	@FindBy(xpath="//div[@help-id='CurrentAge']//button")
	@CacheLookup
	private WebElement InfoIconCurrentAge;

	@FindBy(xpath="//div[@model='ctrl.data.CurrentAge']//input[@type='text']")
	@CacheLookup
	private WebElement CurrentAge;

	@FindBy(xpath="//div[@help-id='EmploymentStatus']//div[@class='control-well']")
	@CacheLookup
	private WebElement EmployementStatus;
	
	@FindBy(xpath="//li[@class='option-item ng-scope ng-isolate-scope first-non-empty-option-item']")
	@CacheLookup
	private WebElement ValueEmployed;
	
	@FindBy(xpath="//div[@class='control text-control  control-with-prefix currency-control']//input")
	@CacheLookup
	private WebElement SalaryPerYear;
	
	@FindBy(xpath="//input[@id='radio-option-04F']")
	@CacheLookup
	private WebElement KiwiSaverContribution;
	
	@FindBy(xpath="//input[@id='radio-option-01C']")
	@CacheLookup
	private WebElement RiskProfileGrowth;
	
	@FindBy(xpath="	//button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")
	@CacheLookup
	private WebElement ViewProjection;
	

	
	public void mouseOverInfoIconAge()
	{
		Actions act=new Actions(driver);
		act.moveToElement(InfoIconCurrentAge).build().perform();
	}	

	public void InfoIconMessageAge()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InfoIconCurrentAge.click();
	}

	public void ViewProjection()
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(0);
		CurrentAge.sendKeys("30");


	}

	public void EmpStatus()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Select ES=new Select (EmployementStatus);
		EmployementStatus.click();
		ValueEmployed.click();
		SalaryPerYear.sendKeys("82000");
		KiwiSaverContribution.click();
		//ES.selectByVisibleText("Employed");
		//WebElement element=driver.findElement(By.xpath("//div[@help-id='EmploymentStatus']//div[@class='control-well']"));
		//Select ES=new Select (element);
		//ES.selectByVisibleText("Employed");
	}
	
	public void SelectRiskProfile()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RiskProfileGrowth.click();
	}
	
	public void ViewKiwiSaverProjection()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ViewProjection.click();
	}

}
