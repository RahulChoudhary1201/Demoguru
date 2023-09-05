package com.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {
	private WebDriver driver;
	protected Logger log = LogManager.getLogger(getClass());
	public WebActions(WebDriver driver) {
		this.driver = driver;
	}
	public void waiting(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void dropDownAction(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	public void dropDownByVisibleText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}

}
