package com.chimera.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	WebDriver driver = null;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");


	@BeforeTest
	public void beforeTest() {

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
//
////		String workingDir = System.getProperty("user.dir");
////		System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/resources/data/drivers/chrome/chromedriver_win32/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}

	@Test
	public void googleTest() {
		ExtentTest test = extent.createTest("google test").assignAuthor("Satish").assignCategory("Functional").assignDevice("windows");
		test.info("I am doin google test");
		if(driver.getTitle().equals("Google")) {
			test.pass("page title is verified: " +driver.getTitle());
		}
		else
		{
			Assert.fail("page title is not match: " +driver.getTitle());
		}
	}
	
	@Test
	public void googleTest1() {
		ExtentTest test = extent.createTest("google test").assignAuthor("Satish").assignCategory("Functional").assignDevice("windows");
		test.info("I am doin google test");
		driver.get("https://www.google.com");
		if(driver.getTitle().equals("Yahoo")) {
			test.pass("page title is verified: " +driver.getTitle());
		}
		else
		{
			Assert.fail("page title is not match: " +driver.getTitle());
		}
	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
