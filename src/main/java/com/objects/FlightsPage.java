package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WebActions;

public class FlightsPage extends WebActions {

	private WebDriver driver;
	public FlightsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	private By flightsPage = By.xpath("//a[normalize-space()='Flights']");
	private By typeTrip = By.xpath("//input[@value='oneway']");
	private By passengerNumber = By.xpath("//select[@name='passCount']");
	private By departinFrom = By.xpath("//select[@name='fromPort']");
	private By onMonth = By.xpath("//select[@name='fromMonth']");
	private By onMonthDay = By.xpath("//select[@name='fromDay']");
	private By arrivingIn = By.xpath("//select[@name='toPort']");
	private By returningMonth = By.xpath("//select[@name='toMonth']");
	private By returingDay = By.xpath("//select[@name='toDay']");
	private By serviceClass = By.xpath("//input[@value='Business']");
	private By airline = By.xpath("//select[@name='airline']");
	private By continueBtn = By.xpath("//input[@name='findFlights']");

	public String getFlightPageTitle() {
		return driver.getTitle();
	}
	public void navigateToFPage() {
		driver.findElement(flightsPage).click();
		waiting(typeTrip);
	}

	public void fillingFlightDetails(String passengerNum, String departingCity,
			String departingMon, String monthDay, String arrivingCity,
			String returningMonthValue, String returnMonthDayValue,
			String airlineValue) {
		driver.findElement(typeTrip).click();
		dropDownAction(driver.findElement(passengerNumber), passengerNum);
		dropDownAction(driver.findElement(departinFrom), departingCity);
		dropDownAction(driver.findElement(onMonth), departingMon);
		dropDownAction(driver.findElement(onMonthDay), monthDay);
		dropDownAction(driver.findElement(arrivingIn), arrivingCity);
		dropDownAction(driver.findElement(returningMonth), returningMonthValue);
		dropDownAction(driver.findElement(returingDay), returnMonthDayValue);
		driver.findElement(serviceClass).click();
		dropDownByVisibleText(driver.findElement(airline), airlineValue);
		driver.findElement(continueBtn).click();
	}

}
