package com.Westpac.testCases;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Westpac.pageObjects.HomePage;

import resources.BaseClass;

public class TC001_AccessKiwiSaverCalc extends BaseClass{

	@BeforeTest

	public void initialize() throws IOException
	{

		driver =initializeDriver();

		driver.get(prop.getProperty("url"));
	}


	//Verify use can access KiwiSaver Retirement Calculator page
	@Test

	public void accessKIWISavercalculator()
	{
		HomePage hp=new HomePage(driver);
		hp.mouseOverKiwiSaver();
		hp.clickKiwiSaverCalc();
		hp.getStarted();
		String title = driver.getTitle();
		System.out.println(title);
		if(driver.getTitle().equals("KiwiSaver Retirement Calculator - Westpac NZ"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}
	@AfterTest
	
	public void TearDown()
	{
		driver.close();
	}

}
