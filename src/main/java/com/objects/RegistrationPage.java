package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WebActions;

public class RegistrationPage extends WebActions {
	private WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	private By registerBtn = By.xpath("//a[contains(text(),'REGISTER')]");
	private By firstName = By.xpath("//input[@name='firstName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By phone = By.xpath("//input[@name='phone']");
	private By email = By.xpath("//input[@id='userName']");
	private By address = By.xpath("//input[@name='address1']");
	private By city = By.xpath("//input[@name='city']");
	private By state = By.xpath("//input[@name='state']");
	private By postalCode = By.xpath("//input[@name='postalCode']");
	private By country = By.xpath("//select[@name='country']");
	private By userName = By.xpath("//input[@id='email']");
	private By pass = By.xpath("//input[@name='password']");
	private By confPass = By.xpath("//input[@name='confirmPassword']");
	private By submitBtn = By.xpath("//input[@name='submit']");

	public String getRegPageTitle() {
		log.info("returning the title of Registration page.");
		return driver.getTitle();
	}

	public void navigatingToRegPage() {
		log.info("Clicking on the registration page link for navigating to it.");
		driver.findElement(registerBtn).click();
		log.info("Clicked the link and waiting for the page to load.");
		waiting(firstName);
	}

	public FlightsPage fillingForm(String firstNameValue, String lastNameValue,
			String phoneValue, String emailValue, String addressValue,
			String cityValue, String stateValue, String postalCodeValue,
			String countryValue, String userNameValue, String passValue,
			String confirmPassValue) throws InterruptedException {
		log.info("Entering the data from the dataprovide to respective fields.");
		driver.findElement(firstName).sendKeys(firstNameValue);
		driver.findElement(lastName).sendKeys(lastNameValue);
		driver.findElement(phone).sendKeys(phoneValue);
		driver.findElement(email).sendKeys(emailValue);
		driver.findElement(address).sendKeys(addressValue);
		driver.findElement(city).sendKeys(cityValue);
		driver.findElement(state).sendKeys(stateValue);
		driver.findElement(postalCode).sendKeys(postalCodeValue);
		WebElement dropDown = driver.findElement(country);
		dropDownAction(dropDown, countryValue);
		driver.findElement(userName).sendKeys(userNameValue);
		driver.findElement(pass).sendKeys(passValue);
		driver.findElement(confPass).sendKeys(confirmPassValue);
		log.info("Entered all the data. Clicking on the Submit button.");
		driver.findElement(submitBtn).click();
		log.info("Clicked on the submit button and returing Flights page Object.");
		return new FlightsPage(driver);
	}

}
