package com.Westpac.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Westpac.pageObjects.HomePage;
import com.Westpac.pageObjects.KiwiSaverRetirementCalc;

import resources.BaseClass;

public class TC002_Validate_InfoIcomMessage_Age extends BaseClass {

	@BeforeTest

	public void initialize() throws IOException
	{

		driver =initializeDriver();

		driver.get(prop.getProperty("url"));
	}


	//Verify "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below the current age field.
	@Test

	public void accessKIWISavercalculator()
	{
		HomePage hp=new HomePage(driver);
		hp.mouseOverKiwiSaver();
		hp.clickKiwiSaverCalc();
		hp.getStarted();
		KiwiSaverRetirementCalc kc=new KiwiSaverRetirementCalc(driver);
		//kc.mouseOverInfoIconAge();
		kc.InfoIconMessageAge();

	}
	@AfterTest
	
	public void TearDown()
	{
		driver.close();
	}


}
