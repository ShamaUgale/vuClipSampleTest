package com.vuClip.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AppiumDriver<MobileElement> driver;
	public Properties config=null;
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	
	public void initialize() throws IOException{
	
		if(config==null){
			config=new Properties();
			FileInputStream ip= new FileInputStream(new File(PROJECT_PATH + File.separator + "config.properties"));
			config.load(ip);
		}
		int implicitWait=Integer.parseInt(config.getProperty("implicitWait"));
		if(driver==null){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", config.getProperty("deviceName"));

	        caps.setCapability("app", PROJECT_PATH + File.separator + "base.apk");
	        driver = new AndroidDriver(new URL(config.getProperty("hubURL") + "/wd/hub"), caps);
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}
	
	@BeforeSuite
	public void setUp() throws IOException{
		initialize();
	}
	
}
