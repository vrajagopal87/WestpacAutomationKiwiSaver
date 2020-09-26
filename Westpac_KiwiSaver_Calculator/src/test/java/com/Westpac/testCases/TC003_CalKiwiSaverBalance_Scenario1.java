package com.Westpac.testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Westpac.pageObjects.HomePage;
import com.Westpac.pageObjects.KiwiSaverRetirementCalc;

import resources.BaseClass;

public class TC003_CalKiwiSaverBalance_Scenario1 extends BaseClass 

{

	@BeforeTest

	public void initialize() throws IOException
	{

		driver =initializeDriver();

		driver.get(prop.getProperty("url"));
	}


	//Verify user with current age is 30, Employed @ a Salary 82000 p/a and high risk (17.5) can calculate the KiwiSaver balance 
	@Test

	public void CalculateKiwiSaverBalance()
	{
		HomePage hp=new HomePage(driver);
		hp.mouseOverKiwiSaver();
		hp.clickKiwiSaverCalc();
		hp.getStarted();
		KiwiSaverRetirementCalc kc=new KiwiSaverRetirementCalc(driver);
		kc.ViewProjection();
		kc.EmpStatus();
		kc.SelectRiskProfile();
		kc.ViewKiwiSaverProjection();

	}
	@AfterTest
	
	public void TearDown()
	{
		driver.close();
	}


}
