package com.objects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WebActions;

public class HomePage extends WebActions {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By userNameTextField = By.xpath("//input[@name='userName']");
	private By passwordTextField = By.xpath("//input[@name='password']");
	private By submitBtn = By.xpath("//input[@name='submit']");

	public String verifyTitle() {
		log.info("returing the title of HomePage.");
		return driver.getTitle();
	}

	public LoginPage login(String userName, String password) throws IOException {
		log.info("Entering the user name and password");
		driver.findElement(userNameTextField).sendKeys(userName);
		driver.findElement(passwordTextField).sendKeys(password);
		log.info("Username and password filled successfully");
		driver.findElement(submitBtn).click();
		log.info("Clicking ob the submit button.");
		log.info("returning the login page Object");
		return new LoginPage(driver);
		
	}

}
