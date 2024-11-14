package RegressionTest;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BillPay {
	
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
		driver.findElement(By.xpath("//a[text()='Bill Pay']")).click();
	}
	
  @Test(priority = 2)
  public void CheckingTheTitle() {
	  
	  WebElement mainTitle = driver.findElement(By.xpath("//h1[text()='Bill Payment Service']"));
	  String actualmainTitle =mainTitle.getText();
	  String expectedmainTitle = "Bill Payment Service";
	  Assert.assertEquals(actualmainTitle, expectedmainTitle);
	  WebElement subTitle = driver.findElement(By.xpath("//p[text()='Enter payee information']"));
	  String actualsubTitle =subTitle.getText();
	  String expectedsubTitle = "Enter payee information";
	  Assert.assertEquals(actualsubTitle, expectedsubTitle);
	  
  }
  
  @Test(priority = 3)
  public void ClickSendPaymentWithoutAnyDetails() {
	  
	  driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		if (true) {
			WebElement payeeNameError = driver.findElement(By.xpath("//span[@id='validationModel-name']"));
			String actualpayeeNameErrorMessage = payeeNameError.getText();
			String expectedpayeeNameErrorErrorMessage = "Payee name is required.";
			Assert.assertEquals(actualpayeeNameErrorMessage, expectedpayeeNameErrorErrorMessage);
		}
		if (true) {
			WebElement addressError = driver.findElement(By.xpath("//span[@id='validationModel-address']"));
			String actualAddressErrorMessage = addressError.getText();
			String expectedAddressErrorMessage = "Address is required.";
			Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
		}
		if (true) {
			WebElement cityError = driver.findElement(By.xpath("//span[@id='validationModel-city']"));
			String actualCityErrorMessage = cityError.getText();
			String expectedCityErrorMessage = "City is required.";
			Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
		}
		if (true) {
			WebElement stateError = driver.findElement(By.xpath("//span[@id='validationModel-state']"));
			String actualStateErrorMessage = stateError.getText();
			String expectedStateErrorMessage = "State is required.";
			Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
		}
		if (true) {
			WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='validationModel-zipCode']"));
			String actualzipCodeErrorMessage = zipCodeError.getText();
			String expectedzipCodeErrorMessage = "Zip Code is required.";
			Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
		}
		if (true) {
			WebElement phoneNumberError = driver.findElement(By.xpath("//span[@id='validationModel-phoneNumber']"));
			String actualphoneNumberErrorMessage = phoneNumberError.getText();
			String expectedphoneNumberErrorMessage = "Phone number is required.";
			Assert.assertEquals(actualphoneNumberErrorMessage, expectedphoneNumberErrorMessage);
		}
		if (true) {
			WebElement accountNumberError = driver.findElement(By.xpath("//span[@id='validationModel-account-empty']"));
			String actualaccountNumberErrorMessage = accountNumberError.getText();
			String expectedaccountNumberErrorMessage = "Account number is required.";
			Assert.assertEquals(actualaccountNumberErrorMessage, expectedaccountNumberErrorMessage);
		}
		if (true) {
			WebElement accountNumberReverifyError = driver.findElement(By.xpath("//span[@id='validationModel-verifyAccount-empty']"));
			String actualaccountNumberReverifyErrorMessage = accountNumberReverifyError.getText();
			String expectedaccountNumberReverifyErrorMessage = "Account number is required.";
			Assert.assertEquals(actualaccountNumberReverifyErrorMessage, expectedaccountNumberReverifyErrorMessage);
		}
		if (true) {
			WebElement amountError = driver.findElement(By.xpath("//span[@id='validationModel-amount-empty']"));
			String actualamountErrorMessage = amountError.getText();
			String expectedamountErrorMessage = "The amount cannot be empty.";
			Assert.assertEquals(actualamountErrorMessage, expectedamountErrorMessage);
		}
  }
  
  @Test(priority = 4)
	public void clickingRegisterWithoutPayeeName() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).clear();
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement payeeNameError = driver.findElement(By.xpath("//span[@id='validationModel-name']"));
		String actualpayeeNameErrorMessage = payeeNameError.getText();
		String expectedpayeeNameErrorErrorMessage = "Payee name is required.";
		Assert.assertEquals(actualpayeeNameErrorMessage, expectedpayeeNameErrorErrorMessage);
	}
  @Test(priority = 5)
	public void clickingRegisterWithoutPayeeAddress() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).clear();
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement addressError = driver.findElement(By.xpath("//span[@id='validationModel-address']"));
		String actualAddressErrorMessage = addressError.getText();
		String expectedAddressErrorMessage = "Address is required.";
		Assert.assertEquals(actualAddressErrorMessage, expectedAddressErrorMessage);
	}
  @Test(priority = 6)
	public void clickingRegisterWithoutCity() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).clear();
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement cityError = driver.findElement(By.xpath("//span[@id='validationModel-city']"));
		String actualCityErrorMessage = cityError.getText();
		String expectedCityErrorMessage = "City is required.";
		Assert.assertEquals(actualCityErrorMessage, expectedCityErrorMessage);
	}
  @Test(priority = 7)
	public void clickingRegisterWithoutState() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).clear();
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement stateError = driver.findElement(By.xpath("//span[@id='validationModel-state']"));
		String actualStateErrorMessage = stateError.getText();
		String expectedStateErrorMessage = "State is required.";
		Assert.assertEquals(actualStateErrorMessage, expectedStateErrorMessage);
	}
  @Test(priority = 8)
 	public void clickingRegisterWithoutZipCode() {

 		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
 		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
 		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
 		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
 		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).clear();
 		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
 		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
 		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
 		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
 		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement zipCodeError = driver.findElement(By.xpath("//span[@id='validationModel-zipCode']"));
		String actualzipCodeErrorMessage = zipCodeError.getText();
		String expectedzipCodeErrorMessage = "Zip Code is required.";
		Assert.assertEquals(actualzipCodeErrorMessage, expectedzipCodeErrorMessage);
 	}
  
  @Test(priority = 9)
 	public void clickingRegisterWithoutphoneNumber() {

 		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
 		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
 		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
 		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
 		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
 		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).clear();
 		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
 		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
 		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
 		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement phoneNumberError = driver.findElement(By.xpath("//span[@id='validationModel-phoneNumber']"));
		String actualphoneNumberErrorMessage = phoneNumberError.getText();
		String expectedphoneNumberErrorMessage = "Phone number is required.";
		Assert.assertEquals(actualphoneNumberErrorMessage, expectedphoneNumberErrorMessage);
 	}
  @Test(priority = 10)
 	public void clickingRegisterWithoutAccountNumber() {

 		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
 		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
 		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
 		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
 		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
 		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
 		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).clear();
 		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
 		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
 		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement accountNumberError = driver.findElement(By.xpath("//span[@id='validationModel-account-empty']"));
		String actualaccountNumberErrorMessage = accountNumberError.getText();
		String expectedaccountNumberErrorMessage = "Account number is required.";
		Assert.assertEquals(actualaccountNumberErrorMessage, expectedaccountNumberErrorMessage);
 	}
  
  @Test(priority = 11)
	public void clickingRegisterWithoutVerifyAccount() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).clear();
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement accountNumberReverifyError = driver.findElement(By.xpath("//span[@id='validationModel-verifyAccount-empty']"));
		String actualaccountNumberReverifyErrorMessage = accountNumberReverifyError.getText();
		String expectedaccountNumberReverifyErrorMessage = "Account number is required.";
		Assert.assertEquals(actualaccountNumberReverifyErrorMessage, expectedaccountNumberReverifyErrorMessage);
	}
  @Test(priority = 12)
	public void clickingRegisterWithoutVerifyAmount() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).clear();
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement amountError = driver.findElement(By.xpath("//span[@id='validationModel-amount-empty']"));
		String actualamountErrorMessage = amountError.getText();
		String expectedamountErrorMessage = "The amount cannot be empty.";
		Assert.assertEquals(actualamountErrorMessage, expectedamountErrorMessage);
	}
  @Test(priority = 13)
	public void clickingRegisterWithDifferentAccountNumber() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		WebElement differentAccountNumberError = driver.findElement(By.xpath("//span[@id='validationModel-verifyAccount-mismatch']"));
		String actualdifferentAccountNumberErrorMessage = differentAccountNumberError.getText();
		String expecteddifferentAccountNumberErrorMessage = "The account numbers do not match.";
		Assert.assertEquals(actualdifferentAccountNumberErrorMessage, expecteddifferentAccountNumberErrorMessage);
	}
  
  @Test(priority = 14)
	public void clickingRegisterWithAllDetails() {

		driver.findElement(By.xpath("//input[@name='payee.name']")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name='payee.address.street']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@name='payee.address.city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@name='payee.address.state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@name='payee.address.zipCode']")).sendKeys("51803");
		driver.findElement(By.xpath("//input[@name='payee.phoneNumber']")).sendKeys("9746517370");
		driver.findElement(By.xpath("//input[@name='payee.accountNumber']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='verifyAccount']")).sendKeys("987654321");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
		driver.quit();
	}
  		
} 
