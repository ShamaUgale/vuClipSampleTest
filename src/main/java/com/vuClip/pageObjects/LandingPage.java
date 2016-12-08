package com.vuClip.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vuClip.Base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage {
	AppiumDriver<MobileElement> driver;
	
	public LandingPage(AppiumDriver<MobileElement> driver){
		this.driver=driver;
	}

	@AndroidFindBy(id="com.vuclip.viu:id/iv_close")
	MobileElement closeBtn;
	
	@AndroidFindBy(id="com.vuclip.viu:id/llContent")
	MobileElement goForItBtn;
	
	@AndroidFindBy(id="com.vuclip.viu:id/iv_download")
	MobileElement downloadBtn;
	
	@AndroidFindBy(id="com.vuclip.viu:id/tv_high")
	MobileElement HDBtn;
	
	@AndroidFindBy(id="com.vuclip.viu:id/iv_search")
	MobileElement searchBtn;
	
	@AndroidFindBy(id="com.vuclip.viu:id/search_box")
	MobileElement searchTxtBox;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
	MobileElement myDownloadsBtn;
	
	public void closePopUpWindow(){
		Utils.waitForPageToLoad(driver, closeBtn, 25);
		closeBtn.click();
	}
	
	public void goToDownloadsPage(){
		Utils.waitForPageToLoad(driver, myDownloadsBtn, 25);
		myDownloadsBtn.click();
	}
	
	public void downloadVideoOnLandingPage(AppiumDriver<MobileElement> driver, int dim){
		Utils.swipeDown(driver, dim);
		downloadBtn.click();
		HDBtn.click();
	}
	
}
