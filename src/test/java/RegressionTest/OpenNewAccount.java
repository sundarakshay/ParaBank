package RegressionTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenNewAccount {

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
		driver.findElement(By.xpath("//a[text()='Open New Account']")).click();
	}

	@Test(priority = 1)
	public void OneNewAccountCheckTitle() {

		WebElement newAccountCheckTitle = driver.findElement(By.tagName("h1"));
		String actualNewAccountCheckTitle = newAccountCheckTitle.getText();
		String expectedNewAccountCheckTitle = "Open New Account";
		Assert.assertEquals(actualNewAccountCheckTitle, expectedNewAccountCheckTitle);
		WebElement newAccountCheckSubTitleAccountType = driver
				.findElement(By.xpath("//b[text()='What type of Account would you like to open?']"));
		String actualNewAccountCheckSubTitleAccountType = newAccountCheckSubTitleAccountType.getText();
		String expectedNewAccountCheckSubTitleAccountType = "What type of Account would you like to open?";
		Assert.assertEquals(actualNewAccountCheckSubTitleAccountType, expectedNewAccountCheckSubTitleAccountType);
		WebElement newAccountCheckSubTitleAccountInfo = driver.findElement(By.xpath(
				"//b[text()='A minimum of $100.00 must be deposited into this account at time of opening. Please choose an existing account to transfer funds into the new account.']"));
		String actaulNewAccountCheckSubTitleAccountInfo = newAccountCheckSubTitleAccountInfo.getText();
		String exepctedNewAccountCheckSubTitleAccountInfo = "A minimum of $100.00 must be deposited into this account at time of opening. Please choose an existing account to transfer funds into the new account.";
		Assert.assertEquals(actaulNewAccountCheckSubTitleAccountInfo, exepctedNewAccountCheckSubTitleAccountInfo);

	}

	@Test(priority = 2)
	public void OpenNewAccountWithoutSelectingNothing() {

		WebElement newAccountCheckType = driver.findElement(By.xpath("//select[@id='type']"));
		selectVariable = new Select(newAccountCheckType);
		selectVariable.selectByIndex(0);
		WebElement newAccountAmountTransferFrom = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
		selectVariable = new Select(newAccountAmountTransferFrom);
		selectVariable.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		driver.quit();

	}

}
