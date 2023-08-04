package com.chimera.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chimera.i3LocalLevelEvents.EventDetailsModule;
import com.chimera.i3LocalLevelEvents.LogoHeaderModule;
import com.chimera.i3LocalLevelEvents.OrderOptionsModule;
import com.chimera.i3LocalLevelEvents.OrganizationModule;
import com.chimera.i3LocalLevelEvents.ScheduleModule;
import com.chimera.i3LocalLevelEvents.homePage;
import com.chimera.i3LocalLevelEvents.loginPage;
import com.chimera.i3LocalLevelEvents.sangramPluginEvent;
import com.chimera.i3LocalLevelEvents.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.chimera.i3LocalLevelEvents.CustomFieldsModule;
import com.chimera.i3LocalLevelEvents.DiscountsModule;

public class i3Test{
	
	private static ChromeDriver driver = null;
	private static loginPage login;
	private static homePage home;
	private static sangramPluginEvent sangram;
	private static OrganizationModule orgModule;
	private static EventDetailsModule eventsModule;
	private static ScheduleModule scheduleModule;
	private static OrderOptionsModule orderOptionModule;
	private static CustomFieldsModule customFieldsModule;
	private static LogoHeaderModule logoModule;
	private static DiscountsModule discountModule;
	ScreenshotCapture screenshotcapture;
	
	String FILE_PATH = "C:\\Users\\ShanmugaSrinivasS\\Downloads\\11.pdf";
	
    ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports/i3_Reports.html");
    
	@AfterMethod
	public void i3AfterMethod() {
//		driver.quit();
		extent.flush();
	}
	
	@BeforeMethod
	public void i3BeforeMethod() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
		FileReader reader = new FileReader("C:\\Users\\ShanmugaSrinivasS\\eclipse-workspace\\i3LocalLevelEvents\\src\\test\\resources\\datafile.properties");
	    Properties props = new Properties();
	    props.load(reader);
	    driver.get(props.getProperty("url"));
	    
	    
	    login = new loginPage(driver);
	    home = new homePage(driver);
	    sangram = new sangramPluginEvent(driver);
	    orgModule = new OrganizationModule(driver);
	    eventsModule = new EventDetailsModule(driver);
	    scheduleModule = new ScheduleModule(driver);
	    orderOptionModule = new OrderOptionsModule(driver);
	    customFieldsModule = new CustomFieldsModule(driver);
	    logoModule = new LogoHeaderModule(driver);
	    discountModule = new DiscountsModule(driver);
	    screenshotcapture = new ScreenshotCapture(driver);
	    
	}
	
	public void extentCreateTest(String TestSuiteName, String AuthorName, String TestCaseName, String fileName)
			throws Throwable {
		extent.attachReporter(spark);
		extent.createTest(TestSuiteName + "::" + TestCaseName).createNode(TestCaseName).assignAuthor(AuthorName)
				.pass(MediaEntityBuilder
						.createScreenCaptureFromPath(screenshotcapture.takeScreenShot(fileName + ".png")).build());
	}
	
	@BeforeTest
	public void extentReportsMethod() {
		spark.config().setReportName("i3 Test Report");
		spark.config().setDocumentTitle("MyReport");
		
		extent.attachReporter(spark);
		extent.setSystemInfo("QA Team", "i3 Test");
		
	}
	
	
	@Test
	public void i3TestMethod() throws Throwable {
		
		String TestSuiteName = "i3_Test_Suite";
		String AuthorName = "QA_Team";
		
		try {
			login.loginPageActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 login module is completed", "loginPageActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":loginPageActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("loginPageActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			home.getLLESangram();
			extentCreateTest(TestSuiteName, AuthorName, "i3 LLESangram module is completed", "getLLESangram");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":getLLESangram").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("getLLESangram" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			sangram.sangramActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 sangram module is completed", "sangramActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":sangramActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("sangramActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			orgModule.orgActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 organization module is completed", "orgActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":orgActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("orgActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			eventsModule.eventDetailsActions(FILE_PATH);
			extentCreateTest(TestSuiteName, AuthorName, "i3 event details module is completed", "eventDetailsActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":eventDetailsActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("eventDetailsActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			scheduleModule.scheduleActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 schedule module is completed", "scheduleActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":scheduleActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("scheduleActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			orderOptionModule.orderOptionsModuleActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 order options module is completed", "orderOptionsModuleActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":orderOptionsModuleActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("orderOptionsModuleActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			customFieldsModule.customFieldsModuleActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 custom fields module is completed", "customFieldsModuleActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":customFieldsModuleActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("customFieldsModuleActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			logoModule.LogoHeaderModuleActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 logo header module is completed", "LogoHeaderModuleActions");
		
		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":LogoHeaderModuleActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("LogoHeaderModuleActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		try {
			discountModule.discountModuleActions();
			extentCreateTest(TestSuiteName, AuthorName, "i3 discount module is completed", "discountModuleActions");

		}catch(Exception e) {
			e.printStackTrace();
			extent.createTest("Issue Occured in:" + TestSuiteName + ":discountModuleActions").fail(MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotcapture.takeScreenShot("discountModuleActions" + ".png")).build())
				.log(Status.FAIL, e);
			return;
		}
		
		
	}

}
