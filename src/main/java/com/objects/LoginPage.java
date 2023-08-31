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
	private By registerBtn = By.xpath("//a[contains(text(),'REGISTER')]");
	private By firstName = By.xpath("//input[@name='firstName']");

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginMsg() {
		return driver.findElement(loginMsg).getText();
	}

	public RegistrationPage registeringCustBtnClick() {
		driver.findElement(registerBtn).click();
		waiting(firstName);
		return new RegistrationPage(driver);
	}

	

}
