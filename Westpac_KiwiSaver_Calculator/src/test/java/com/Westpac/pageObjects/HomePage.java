package com.Westpac.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Initiate the driver
	private WebDriver driver;

	//Write the constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Identify the elements on Home page
	@FindBy(id="ubermenu-section-link-kiwisaver-ps")
	@CacheLookup
	private WebElement KiwiSaverMenu;

	@FindBy(id="ubermenu-item-cta-kiwisaver-calculators-ps")
	@CacheLookup
	private WebElement btnKiwiSaverCalculators;

	@FindBy(xpath="/html/body/div[2]/main/div/div/article/div[2]/div/section/p[4]/a")
	//@FindBy(xpath="//a[@href='/kiwisaver/calculators/kiwisaver-calculator/']")
	@CacheLookup
	private WebElement btnGetStarted;

	//Create ActionMethods



	public void mouseOverKiwiSaver()
	{
		Actions act=new Actions(driver);
		act.moveToElement(KiwiSaverMenu).build().perform();
	}

	public void clickKiwiSaverCalc()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		btnKiwiSaverCalculators.click();
	}


	public void getStarted()
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", btnGetStarted);
		btnGetStarted.click();
	}
}
