package RegressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPassword {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/lookup.htm";
	private Select selectVariable;

	@Test(priority = 1)
	public void checkingTitleOfPage() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement TitleForgotPage = driver.findElement(By.tagName("h1"));
		String actualTitleForgotPage = TitleForgotPage.getText();
		String expectedTitleForgotPage = "Customer Lookup";
		Assert.assertEquals(actualTitleForgotPage, expectedTitleForgotPage);
		driver.quit();

	}

	@Test(priority = 2)
	public void checkingSubTitleOfPage() {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		// driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		WebElement subTitleForgotPage = driver.findElement(By.cssSelector("div[id='rightPanel'] p"));
		String actualSubTitleForgotPage = subTitleForgotPage.getText();
		String expectedSubTitleForgotPage = "Please fill out the following information in order to validate your account.";
		Assert.assertEquals(actualSubTitleForgotPage, expectedSubTitleForgotPage);
		driver.quit();
	}

	@Test(priority = 3)
	public void clickingFindMyLoginInfoWithoutAnyDetails() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		// driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		if (true) {
			WebElement firstNameError = driver.findElement(By.xpath("//span[@id='firstName.errors']"));
			String actualFirstNameErrorMessage = firstNameError.getText();
			String expectedFirstNameErrorMessage = "First name is required.";
			Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);
		}
		if (true) {
			WebElement lastNameError = driver.findElement(By.xpath("//span[@id='lastName.errors']"));
			String actualLastNameErrorMessage = lastNameError.getText();
			String expectedLastNameErrorMessage = "Last name is required.";
			Assert.assertEquals(actualLastNameErrorMessage, expectedLastNameErrorMessage);
		}
		if (true) {
			WebElement addressError = driver.findElement(By.xpath("//span[@id='address.street.errors']"));
			String actualAddressErrorMessage = addressError.getText();
			String expectedAddressErrorMessage = "Address is required.";
			Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		}
		if (true) {
			WebElement cityError = driver.findElement(By.xpath("//span[@id='address.city.errors']"));
			String actualCityErrorMessage = cityError.getText();
			String expectedCityErrorMessage = "City is required.";
			Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		}
		if (true) {
			WebElement stateError = driver.findElement(By.xpath("//span[@id='address.state.errors']"));
			String actualStateErrorMessage = stateError.getText();
			String expectedStateErrorMessage = "State is required.";
			Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		}
		if (true) {
			WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='address.zipCode.errors']"));
			String actualzipCodeErrorMessage = zipCodeError.getText();
			String expectedzipCodeErrorMessage = "Zip Code is required.";
			Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
		}
		if (true) {
			WebElement ssnError = driver.findElement(By.xpath("//span[@id='ssn.errors']"));
			String actualssnErrorMessage = ssnError.getText();
			String expectedssnErrorMessage = "Social Security Number is required.";
			Assert.assertEquals(actualssnErrorMessage, expectedssnErrorMessage);
		}
		driver.quit();
	}

	@Test(priority = 4)
	public void clickingFindMyLoginInfoWithoutFirstName() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53559");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement firstNameError = driver.findElement(By.xpath("//span[@id='firstName.errors']"));
		String actualFirstNameErrorMessage = firstNameError.getText();
		String expectedFirstNameErrorMessage = "First name is required.";
		Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);
		driver.quit();
	}

	@Test(priority = 5)
	public void clickingFindMyLoginInfoWithoutLastName() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		;
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53559");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement lastNameError = driver.findElement(By.xpath("//span[@id='lastName.errors']"));
		String actuallastNameErrorMessage = lastNameError.getText();
		String expectedlastNameErrorMessage = "Last name is required.";
		Assert.assertEquals(actuallastNameErrorMessage, expectedlastNameErrorMessage);
		driver.quit();
	}

	@Test(priority = 6)
	public void clickingFindMyLoginInfoWithoutAddress() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		;
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).clear();
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53559");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement addressError = driver.findElement(By.xpath("//span[@id='address.street.errors']"));
		String actualAddressErrorMessage = addressError.getText();
		String expectedAddressErrorMessage = "Address is required.";
		Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		driver.quit();
	}

	@Test(priority = 7)
	public void clickingFindMyLoginInfoWithoutCity() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		;
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).clear();
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53559");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement cityError = driver.findElement(By.xpath("//span[@id='address.city.errors']"));
		String actualCityErrorMessage = cityError.getText();
		String expectedCityErrorMessage = "City is required.";
		Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		driver.quit();
	}

	@Test(priority = 8)
	public void clickingFindMyLoginInfoWithoutState() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		;
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).clear();
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53559");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement stateError = driver.findElement(By.xpath("//span[@id='address.state.errors']"));
		String actualStateErrorMessage = stateError.getText();
		String expectedStateErrorMessage = "State is required.";
		Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		driver.quit();
	}

	@Test(priority = 9)
	public void clickingFindMyLoginInfoWithoutZipCode() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		;
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='address.zipCode.errors']"));
		String actualzipCodeErrorMessage = zipCodeError.getText();
		String expectedzipCodeErrorMessage = "Zip Code is required.";
		Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
		driver.quit();
	}

	@Test(priority = 10)
	public void clickingFindMyLoginInfoWithoutSSN() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53694");
		driver.findElement(By.xpath("//input[@id='ssn']")).clear();
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement zipCodeError = driver.findElement(By.xpath("//input[@id='address.zipCode']"));
		WebElement ssnError = driver.findElement(By.xpath("//span[@id='ssn.errors']"));
		String actualssnErrorMessage = ssnError.getText();
		String expectedssnErrorMessage = "Social Security Number is required.";
		Assert.assertEquals(actualssnErrorMessage, expectedssnErrorMessage);
		driver.quit();
	}

	@Test(priority = 11)
	public void clickingFindMyLoginInfoWithAllDetails() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[text()='Forgot login info?']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys("53694");
		driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		WebElement mainMessage = driver.findElement(By.tagName("h1"));
		String actualMainMessageDisplayed = mainMessage.getText();
		String expectedMainMessageDisplayed = "Error!";
		Assert.assertEquals(actualMainMessageDisplayed, expectedMainMessageDisplayed);
		WebElement subMessage = driver.findElement(By.xpath("//p[@class='error']"));
		String actualManinMessageDisplayed = subMessage.getText();
		String expectedManinMessageDisplayed = "The customer information provided could not be found.";
		Assert.assertEquals(actualManinMessageDisplayed, expectedManinMessageDisplayed);
		driver.quit();
	}
}
