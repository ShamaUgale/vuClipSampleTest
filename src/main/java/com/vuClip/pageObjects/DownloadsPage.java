package com.vuClip.pageObjects;

import com.vuClip.Base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DownloadsPage {
	AppiumDriver<MobileElement> driver;

	public DownloadsPage(AppiumDriver<MobileElement> driver){
		this.driver=driver;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Downloading')]")
	MobileElement downloadProgressText;
	
	public boolean verifyVideoDownloadProgress(){
		Utils.waitForPageToLoad(driver, downloadProgressText, 25);
		if(downloadProgressText.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
}
