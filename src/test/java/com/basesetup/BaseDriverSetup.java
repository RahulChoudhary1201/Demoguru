package com.basesetup;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverSetup {

	protected static WebDriver driver;

	private void setupDriver(String browserName, String url) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = initChromeDriver(url);
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = initEdgeDriver(url);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = initFireFoxDriver(url);
		} else {
			System.out.println("Initilizing Chrome Browser...");
			driver = initChromeDriver(url);
		}
	}
	private static WebDriver initChromeDriver(String url) {
		System.out.println("Launching Chrome Browser with new profile...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}
	private static WebDriver initEdgeDriver(String url) {
		System.out.println("Launching Edge Browser with new profile...");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	private static WebDriver initFireFoxDriver(String url) {
		System.out.println("Launching FireFox Browser with new profile...");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	@Parameters({"browserName", "url"})
	@BeforeClass
	public void invokeDriver(String browserName, String url) {
		try {
			setupDriver(browserName, url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
		String reportPath = System.getProperty("user.dir")
				+ "\\Reports\\report.html";
		Desktop.getDesktop().browse(new File(reportPath).toURI());
	}
	public String getScreenshot(String testCaseName, WebDriver driver)
			throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\Reports\\"
				+ testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\Reports\\" + testCaseName
				+ ".png";
	}

}
