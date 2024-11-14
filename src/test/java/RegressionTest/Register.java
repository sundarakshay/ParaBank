package RegressionTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/register.htm";
	public String usernameForRegister;

	@Test(priority = 1)
	public void checkingTitleOfPage() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement TitleRegister = driver.findElement(By.tagName("h1"));
		String actualTitleRegister = TitleRegister.getText();
		String expectedTitleRegister = "Signing up is easy!";
		Assert.assertEquals(actualTitleRegister, expectedTitleRegister);
		driver.quit();

	}

	@Test(priority = 2)
	public void checkingSubTitleOfPage() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement subTitleRegister = driver.findElement(By.cssSelector("div[id='rightPanel'] p"));
		String actualsubTitleRegister = subTitleRegister.getText();
		String expectedsubTitleRegister = "If you have an account with us you can sign-up for free instant online access. You will have to provide some personal information.";
		Assert.assertEquals(actualsubTitleRegister, expectedsubTitleRegister);
		driver.quit();
	}

	@Test(priority = 3)
	public void clickingRegisterWithoutAnyDetails() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		if (true) {
			WebElement firstNameError = driver.findElement(By.xpath("//span[@id='customer.firstName.errors']"));
			String actualFirstNameErrorMessage = firstNameError.getText();
			String expectedFirstNameErrorMessage = "First name is required.";
			Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);
		}
		if (true) {
			WebElement lastNameError = driver.findElement(By.xpath("//span[@id='customer.lastName.errors']"));
			String actualLastNameErrorMessage = lastNameError.getText();
			String expectedLastNameErrorMessage = "Last name is required.";
			Assert.assertEquals(actualLastNameErrorMessage, expectedLastNameErrorMessage);
		}
		if (true) {
			WebElement addressError = driver.findElement(By.xpath("//span[@id='customer.address.street.errors']"));
			String actualAddressErrorMessage = addressError.getText();
			String expectedAddressErrorMessage = "Address is required.";
			Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		}
		if (true) {
			WebElement cityError = driver.findElement(By.xpath("//span[@id='customer.address.city.errors']"));
			String actualCityErrorMessage = cityError.getText();
			String expectedCityErrorMessage = "City is required.";
			Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		}
		if (true) {
			WebElement stateError = driver.findElement(By.xpath("//span[@id='customer.address.state.errors']"));
			String actualStateErrorMessage = stateError.getText();
			String expectedStateErrorMessage = "State is required.";
			Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		}
		if (true) {
			WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='customer.address.zipCode.errors']"));
			String actualzipCodeErrorMessage = zipCodeError.getText();
			String expectedzipCodeErrorMessage = "Zip Code is required.";
			Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
		}
		if (true) {
			WebElement ssnError = driver.findElement(By.xpath("//span[@id='customer.ssn.errors']"));
			String actualssnErrorMessage = ssnError.getText();
			String expectedssnErrorMessage = "Social Security Number is required.";
			Assert.assertEquals(actualssnErrorMessage, expectedssnErrorMessage);
		}
		if (true) {
			WebElement usernamError = driver.findElement(By.xpath("//span[@id='customer.username.errors']"));
			String actualusernameErrorMessage = usernamError.getText();
			String expectedusernameErrorMessage = "Username is required.";
			Assert.assertEquals(actualusernameErrorMessage, expectedusernameErrorMessage);
		}
		if (true) {
			WebElement passwordError = driver.findElement(By.xpath("//span[@id='customer.password.errors']"));
			String actualpasswordErrorMessage = passwordError.getText();
			String expectedpasswordErrorMessage = "Password is required.";
			Assert.assertEquals(actualpasswordErrorMessage, expectedpasswordErrorMessage);
		}
		if (true) {
			WebElement passwordConfirmationError = driver
					.findElement(By.xpath("//span[@id='repeatedPassword.errors']"));
			String actualpasswordConfirmationErrorMessage = passwordConfirmationError.getText();
			String expectedpasswordConfirmationErrorMessage = "Password confirmation is required.";
			Assert.assertEquals(actualpasswordConfirmationErrorMessage, expectedpasswordConfirmationErrorMessage);
		}
		driver.quit();
	}

	@Test(priority = 4)
	public void clickingRegisterWithoutFirstName() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement firstNameError = driver.findElement(By.xpath("//span[@id='customer.firstName.errors']"));
		String actualFirstNameErrorMessage = firstNameError.getText();
		String expectedFirstNameErrorMessage = "First name is required.";
		Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);
		driver.quit();
	}

	@Test(priority = 5)
	public void clickingRegisterWithoutLastName() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement lastNameError = driver.findElement(By.xpath("//span[@id='customer.lastName.errors']"));
		String actualLastNameErrorMessage = lastNameError.getText();
		String expectedLastNameErrorMessage = "Last name is required.";
		Assert.assertEquals(actualLastNameErrorMessage, expectedLastNameErrorMessage);
		driver.quit();
	}

	@Test(priority = 6)
	public void clickingRegisterWithoutAddress() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement addressError = driver.findElement(By.xpath("//span[@id='customer.address.street.errors']"));
		String actualAddressErrorMessage = addressError.getText();
		String expectedAddressErrorMessage = "Address is required.";
		Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		driver.quit();
	}

	@Test(priority = 7)
	public void clickingRegisterWithoutCity() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement cityError = driver.findElement(By.xpath("//span[@id='customer.address.city.errors']"));
		String actualCityErrorMessage = cityError.getText();
		String expectedCityErrorMessage = "City is required.";
		Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		driver.quit();
	}

	@Test(priority = 8)
	public void clickingRegisterWithoutState() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement stateError = driver.findElement(By.xpath("//span[@id='customer.address.state.errors']"));
		String actualStateErrorMessage = stateError.getText();
		String expectedStateErrorMessage = "State is required.";
		Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		driver.quit();
	}

	@Test(priority = 9)
	public void clickingRegisterWithoutZipCode() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='customer.address.zipCode.errors']"));
		String actualzipCodeErrorMessage = zipCodeError.getText();
		String expectedzipCodeErrorMessage = "Zip Code is required.";
		Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
		driver.quit();
	}

	@Test(priority = 10)
	public void clickingRegisterWithoutSSN() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement ssnError = driver.findElement(By.xpath("//span[@id='customer.ssn.errors']"));
		String actualssnErrorMessage = ssnError.getText();
		String expectedssnErrorMessage = "Social Security Number is required.";
		Assert.assertEquals(actualssnErrorMessage, expectedssnErrorMessage);
		driver.quit();
	}

	@Test(priority = 11)
	public void clickingRegisterWithoutUsername() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement usernamError = driver.findElement(By.xpath("//span[@id='customer.username.errors']"));
		String actualusernameErrorMessage = usernamError.getText();
		String expectedusernameErrorMessage = "Username is required.";
		Assert.assertEquals(actualusernameErrorMessage, expectedusernameErrorMessage);
		driver.quit();
	}

	@Test(priority = 12)
	public void clickingRegisterWithoutPassword() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).clear();
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement passwordError = driver.findElement(By.xpath("//span[@id='customer.password.errors']"));
		String actualpasswordErrorMessage = passwordError.getText();
		String expectedpasswordErrorMessage = "Password is required.";
		Assert.assertEquals(actualpasswordErrorMessage, expectedpasswordErrorMessage);
		driver.quit();
	}

	@Test(priority = 13)
	public void clickingRegisterWithoutRepeatPassword() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Test Username");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Test Lastname");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).clear();
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement passwordConfirmationError = driver.findElement(By.xpath("//span[@id='repeatedPassword.errors']"));
		String actualpasswordConfirmationErrorMessage = passwordConfirmationError.getText();
		String expectedpasswordConfirmationErrorMessage = "Password confirmation is required.";
		Assert.assertEquals(actualpasswordConfirmationErrorMessage, expectedpasswordConfirmationErrorMessage);
		driver.quit();
	}

	@Test(priority = 14)
	public void clickingRegisterWithAllDetail() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("59017");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		usernameForRegister = functionToGenerateRandomUsername();
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(usernameForRegister);
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement titleHomePage = driver.findElement(By.tagName("h1"));
		String actualTitleHomePage = titleHomePage.getText();
		String expectedTitleHomePage = "Welcome " + usernameForRegister;
		Assert.assertEquals(actualTitleHomePage, expectedTitleHomePage);
		WebElement subTitleHomePage = driver.findElement(By.cssSelector("div[id='rightPanel'] p"));
		String actualsubTitleHomePage = subTitleHomePage.getText();
		String expectedsubTitleHomePage = "Your account was created successfully. You are now logged in.";
		Assert.assertEquals(actualsubTitleHomePage, expectedsubTitleHomePage); // driver.quit();
		driver.quit();
	}

	public String clickingRegisterWithAllDetails() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("59017");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("987654321");
		usernameForRegister = functionToGenerateRandomUsername();
		driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(usernameForRegister);
		driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		WebElement titleHomePage = driver.findElement(By.tagName("h1"));
		String actualTitleHomePage = titleHomePage.getText();
		String expectedTitleHomePage = "Welcome " + usernameForRegister;
		Assert.assertEquals(actualTitleHomePage, expectedTitleHomePage);
		WebElement subTitleHomePage = driver.findElement(By.cssSelector("div[id='rightPanel'] p"));
		String actualsubTitleHomePage = subTitleHomePage.getText();
		String expectedsubTitleHomePage = "Your account was created successfully. You are now logged in.";
		Assert.assertEquals(actualsubTitleHomePage, expectedsubTitleHomePage);
		driver.quit();
		return usernameForRegister;
	}

	public String functionToGenerateRandomUsername() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 8;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		return randomString;
	}

}
