package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WebActions;

public class LoginPage extends WebActions {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By loginMsg = By.xpath("//h3");

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginMsg() {
		return driver.findElement(loginMsg).getText();
	}

}
