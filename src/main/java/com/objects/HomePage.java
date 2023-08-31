package com.objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By userNameTextField = By.xpath("//input[@name='userName']");
	private By passwordTextField = By.xpath("//input[@name='password']");
	private By submitBtn = By.xpath("//input[@name='submit']");

	public String verifyTitle() {
		return driver.getTitle();
	}

	public LoginPage login(String userName, String password) throws IOException {
		driver.findElement(userNameTextField).sendKeys(userName);
		driver.findElement(passwordTextField).sendKeys(password);
		driver.findElement(submitBtn).click();
		return new LoginPage(driver);
	}

}
