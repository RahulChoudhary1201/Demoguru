package com.testrunner;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basesetup.BaseDriverSetup;
import com.objects.FlightsPage;
import com.objects.HomePage;
import com.objects.LoginPage;
import com.objects.RegistrationPage;
import com.utils.ExcelReader;
import com.utils.PropertiesFileReader;

public class TestRunner extends BaseDriverSetup {

	LoginPage lp;
	FlightsPage fp;

	@Test(groups = {"newUser"})
	public void loginTest() throws IOException {
		log.info("Starting the test for login");
		HomePage hp = new HomePage(driver);
		String title = hp.verifyTitle();
		log.info("Getting the page title");
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		log.info("Title verified for Homepage.");
		Properties prop = PropertiesFileReader.readPropertiesFile(
				".\\src\\test\\java\\com\\testdata\\config.properties");
		log.info("Entering the Username and password");
		lp = hp.login(prop.getProperty("user"), prop.getProperty("pass"));
		log.info("Login Successfull");
	}
	@Test(dependsOnMethods = {"loginTest"}, groups = {"newUser"})
	public void registeration() throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login: Mercury Tours");
		log.info("Title verified for Loginpage.");
		System.out.println(lp.getLoginMsg());
	}
	@Test(dependsOnGroups = {"newUser"}, dataProvider = "myData")
	public void registrationFormFilling(String firstNameValue,
			String lastNameValue, String phoneValue, String emailValue,
			String addressValue, String cityValue, String stateValue,
			String postalCodeValue, String countryValue, String userNameValue,
			String passValue, String confirmPassValue)
			throws InterruptedException, IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.navigatingToRegPage();
		String title = rp.getRegPageTitle();
		Assert.assertEquals(title, "Register: Mercury Tours");
		fp = rp.fillingForm(firstNameValue, lastNameValue, phoneValue,
				emailValue, addressValue, cityValue, stateValue,
				postalCodeValue, countryValue, userNameValue, passValue,
				confirmPassValue);
		fp.navigateToFPage();
		Assert.assertEquals(fp.getFlightPageTitle(),
				"Find a Flight: Mercury Tours:");
		Properties prop = PropertiesFileReader.readPropertiesFile(
				".\\src\\test\\java\\com\\testdata\\config.properties");
		fp.fillingFlightDetails(prop.getProperty("passengerNumber"),
				prop.getProperty("departingCity"),
				prop.getProperty("departingMonth"),
				prop.getProperty("departingDay"),
				prop.getProperty("arrivingCity"),
				prop.getProperty("returningMonth"),
				prop.getProperty("returningDay"), prop.getProperty("airline"));

	}

	@Test(priority = 3, enabled = false)
	public void bookingFlights() throws IOException {
		Properties prop = PropertiesFileReader.readPropertiesFile(
				".\\src\\test\\java\\com\\testdata\\config.properties");
		fp.fillingFlightDetails(prop.getProperty("passengerNumber"),
				prop.getProperty("departingCity"),
				prop.getProperty("departingMonth"),
				prop.getProperty("departingDay"),
				prop.getProperty("arrivingCity"),
				prop.getProperty("returningMonth"),
				prop.getProperty("returningDay"), prop.getProperty("airline"));
	}

	@DataProvider(name = "myData")
	public Object[][] dataProvide() throws IOException {

		Object[][] data = ExcelReader.readingExcelSheet(
				".\\src\\test\\java\\com\\testdata",
				"DemoGuruLoginTestData.xlsx", "Sheet1");
		Object[][] formattedData = new String[data.length - 1][data[1].length];
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				formattedData[i - 1][j] = data[i][j];
			}
		}
		return formattedData;
	}

}
