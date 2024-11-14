package RegressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateContactInfo {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
	Select selectVariable;

	@BeforeTest(alwaysRun = true)
	public void PreExecutionModule() throws Exception {

		Register reg = new Register();
		String username = reg.clickingRegisterWithAllDetails();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		driver.findElement(By.xpath("//a[text()='Update Contact Info']")).click();
	}

	@Test(priority = 1)
	public void clickingUpdateProfileRemovingFirstName() {

		driver.findElement(By.xpath("//input[@name='customer.firstName']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement firstNameError = driver.findElement(By.xpath("//span[@id='firstName-error']"));
		String actualFirstNameErrorMessage = firstNameError.getText();
		String expectedFirstNameErrorMessage = "First name is required.";
		Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);

	}

	@Test(priority = 2)
	public void clickingUpdateProfileRemovingLastName() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement lastNameError = driver.findElement(By.xpath("//span[@id='lastName-error']"));
		String actualLastNameErrorMessage = lastNameError.getText();
		String expectedLastNameErrorMessage = "Last name is required.";
		Assert.assertEquals(actualLastNameErrorMessage, expectedLastNameErrorMessage);
	}

	@Test(priority = 3)
	public void clickingUpdateProfileRemovingAddress() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement addressError = driver.findElement(By.xpath("//span[@id='street-error']"));
		String actualAddressErrorMessage = addressError.getText();
		String expectedAddressErrorMessage = "Address is required.";
		Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
	}

	@Test(priority = 4)
	public void clickingUpdateProfileRemovingCity() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement cityError = driver.findElement(By.xpath("//span[@id='city-error']"));
		String actualCityErrorMessage = cityError.getText();
		String expectedCityErrorMessage = "City is required.";
		Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
	}

	@Test(priority = 5)
	public void clickingUpdateProfileRemovingState() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement stateError = driver.findElement(By.xpath("//span[@id='state-error']"));
		String actualStateErrorMessage = stateError.getText();
		String expectedStateErrorMessage = "State is required.";
		Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
	}

	@Test(priority = 6)
	public void clickingUpdateProfileRemovingZipcode() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='zipCode-error']"));
		String actualzipCodeErrorMessage = zipCodeError.getText();
		String expectedzipCodeErrorMessage = "Zip Code is required.";
		Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
	}

	@Test(priority = 8)
	public void clickingUpdateProfileWithAllDetails() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Sundar");
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("59148");
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		driver.quit();
	}

	@Test(priority = 7)
	public void clickingUpdateProfileWithoutAnyDetails() {

		driver.findElement(By.xpath("//input[@id='customer.firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.street']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.city']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.state']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).clear();
		driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		WebElement firstNameError = driver.findElement(By.xpath("//span[@id='firstName-error']"));
		String actualFirstNameErrorMessage = firstNameError.getText();
		String expectedFirstNameErrorMessage = "First name is required.";
		Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage);
		WebElement lastNameError = driver.findElement(By.xpath("//span[@id='lastName-error']"));
		String actualLastNameErrorMessage = lastNameError.getText();
		String expectedLastNameErrorMessage = "Last name is required.";
		Assert.assertEquals(actualLastNameErrorMessage, expectedLastNameErrorMessage);
		WebElement addressError = driver.findElement(By.xpath("//span[@id='street-error']"));
		String actualAddressErrorMessage = addressError.getText();
		String expectedAddressErrorMessage = "Address is required.";
		Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		WebElement cityError = driver.findElement(By.xpath("//span[@id='city-error']"));
		String actualCityErrorMessage = cityError.getText();
		String expectedCityErrorMessage = "City is required.";
		Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		WebElement stateError = driver.findElement(By.xpath("//span[@id='state-error']"));
		String actualStateErrorMessage = stateError.getText();
		String expectedStateErrorMessage = "State is required.";
		Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='zipCode-error']"));
		String actualzipCodeErrorMessage = zipCodeError.getText();
		String expectedzipCodeErrorMessage = "Zip Code is required.";
		Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
	}
}
