package com.vuClip.Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utils {
	static Dimension size;
	
	public static void swipeDown(AppiumDriver<MobileElement> driver, int dim){
		 size = driver.manage().window().getSize();
	        int starty = (int) (size.height * 0.80);
	        int endy = (int) (size.height * 0.20);
	        int startx = size.width / 2;

	        try{
	        driver.swipe(startx, starty, startx, endy, dim);
	        }catch(Exception e){
	        	
	        }
	}
	
	public static  void waitForPageToLoad(AppiumDriver<MobileElement> driver,WebElement elem, int secs) {
        WebDriverWait wait = new WebDriverWait(driver, secs);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }
}
