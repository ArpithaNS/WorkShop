package com.OrangeHRM.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.OrangeHRM.pom.HomePage;
import com.OrangeHRM.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver.exe");
	}
	public static WebDriver driver;
	public  WebDriverCommonLib w = new WebDriverCommonLib();

	
	@BeforeClass
	public void openBrowser() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() throws IOException{
		Filelib f= new Filelib();
		String url =f.getPropertyValue("url");
		String un = f.getPropertyValue("username");
		String pw = f.getPropertyValue("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un,pw);
	}
		
	@AfterMethod
	public void logout(){
		HomePage h=new HomePage(driver);
		h.setLogout();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}

