package com.OrangeHRM.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OrangeHRM.generic.BaseClass;
import com.OrangeHRM.generic.Filelib;
import com.OrangeHRM.generic.WebDriverCommonLib;
import com.OrangeHRM.pom.Admin;
import com.OrangeHRM.pom.HomePage;


	@Listeners(com.OrangeHRM.generic.ListenerImplements.class)
	public class OrganisationModule extends BaseClass
	{
	@Test
	public void testOrganizationModule() throws InterruptedException, EncryptedDocumentException, IOException, InvalidFormatException
	{
		Reporter.log("Edit Organization",true);
		Filelib f = new Filelib();
		String Organizationname= f.getExcelValue("EditOrganization", 1, 0);
		String Email = f.getExcelValue("EditOrganization", 1, 1);
		HomePage h = new HomePage(driver);
		Admin ad = new Admin(driver);
		Actions a = new Actions(driver);
		WebDriverCommonLib w = new WebDriverCommonLib();
		a.moveToElement(h.getAdminDropDown()).perform();
		a.moveToElement(ad.getOrganizationDropDown()).perform();
//		moose hover to admin drop drown
		w.mouseHover(driver,h.getAdminDropDown());
		//mouseHover to organization drop down
		w.mouseHover(driver,ad.getOrganizationDropDown());
		
		//Click on GeneralInformation option
		ad.getGeneralInformationOption().click();
		//Click on Edit Button
		ad.getEditBtn().click();
		//Clear the OragnisationNameTextBox
		ad.getOrganisationNametbx().clear();
		//Add the Organisation Name
		ad.getOrganisationNametbx().sendKeys(Organizationname);
		//cLear the email textbox
		ad.getEmailTbx().clear();
		//Add the email
		ad.getEmailTbx().sendKeys(Email);
		String ActualOrganization = ad.getOrganisationNametbx().getAttribute("value");
		Assert.assertEquals(ActualOrganization, Organizationname);
		
	}

}

