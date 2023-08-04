package com.chimera.i3LocalLevelEvents;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ScreenshotCapture {
	
	public WebDriver driver;
	public ScreenshotCapture(WebDriver driver) {
		this.driver=driver;
//		super();
		PageFactory.initElements(driver, this);
	}
	public String takeScreenShot(String fileName) throws Throwable {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takeScreenshot.getScreenshotAs(OutputType.FILE);
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		File destFile = new File("target/screenshots/"+fileName);
		
		FileUtils.copyFile(screenshotAs, destFile);
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
}