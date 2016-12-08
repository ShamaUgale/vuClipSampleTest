package com.vuClip.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vuClip.Base.BaseTest;
import com.vuClip.pageObjects.DownloadsPage;
import com.vuClip.pageObjects.LandingPage;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppTest extends BaseTest{
	
	
	@Test(description="verify video download displayed on the home page")
	public void downlowdVideoOnHomePageTest(){
		
		LandingPage lp= new LandingPage(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), lp);
		lp.closePopUpWindow();
		lp.downloadVideoOnLandingPage(driver, 1000);
		lp.goToDownloadsPage();
		
		DownloadsPage dp=new DownloadsPage(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), dp);
		boolean isVideoDownloadInProgress=dp.verifyVideoDownloadProgress();
		
		Assert.assertTrue(isVideoDownloadInProgress, "video downloading failed on the home page");
	}
	
	
	
}
