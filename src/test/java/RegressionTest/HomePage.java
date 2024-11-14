package RegressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

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
	}

	@Test(priority = 1)
	public void homePageWelcomeMessage() {

		WebElement homePageWelcome = driver.findElement(By.xpath("//p[@class='smallText']"));
		String actualHomePageWelcomeMessage = homePageWelcome.getText();
		String expectedHomePageWelcomeMessage = "Welcome Akshay Sundar";
		Assert.assertEquals(actualHomePageWelcomeMessage, expectedHomePageWelcomeMessage);

	}

	@Test(priority = 2)
	public void homePageMenuTitle() {

		WebElement homePageMenuTitle = driver.findElement(By.tagName("h2"));
		String actualHomePageMenuTitle = homePageMenuTitle.getText();
		String expectedHomePageMenuTitle = "Account Services";
		Assert.assertEquals(actualHomePageMenuTitle, expectedHomePageMenuTitle);

	}

	@Test(priority = 3)
	public void homePageMenuItems() {

		WebElement homePageMenuItemOne = driver.findElement(By.xpath("//a[text()='Open New Account']"));
		String actualHomePageMenuITemOne = homePageMenuItemOne.getText();
		String expectedHomePageMenuITemOne = "Open New Account";
		Assert.assertEquals(actualHomePageMenuITemOne, expectedHomePageMenuITemOne);
		WebElement homePageMenuItemTwo = driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
		String actualHomePageMenuITemTwo = homePageMenuItemTwo.getText();
		String expectedHomePageMenuITemTwo = "Accounts Overview";
		Assert.assertEquals(actualHomePageMenuITemTwo, expectedHomePageMenuITemTwo);
		WebElement homePageMenuItemThree = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
		String actualHomePageMenuITemThree = homePageMenuItemThree.getText();
		String expectedHomePageMenuITemThree = "Transfer Funds";
		Assert.assertEquals(actualHomePageMenuITemThree, expectedHomePageMenuITemThree);
		WebElement homePageMenuItemFour = driver.findElement(By.xpath("//a[text()='Bill Pay']"));
		String actualHomePageMenuITemFour = homePageMenuItemFour.getText();
		String expectedHomePageMenuITemFour = "Bill Pay";
		Assert.assertEquals(actualHomePageMenuITemFour, expectedHomePageMenuITemFour);
		WebElement homePageMenuItemFive = driver.findElement(By.xpath("//a[text()='Find Transactions']"));
		String actualHomePageMenuITemFive = homePageMenuItemFive.getText();
		String expectedHomePageMenuITemFive = "Find Transactions";
		Assert.assertEquals(actualHomePageMenuITemFive, expectedHomePageMenuITemFive);
		WebElement homePageMenuItemSix = driver.findElement(By.xpath("//a[text()='Update Contact Info']"));
		String actualHomePageMenuITemSix = homePageMenuItemSix.getText();
		String expectedHomePageMenuITemSix = "Update Contact Info";
		Assert.assertEquals(actualHomePageMenuITemSix, expectedHomePageMenuITemSix);
		WebElement homePageMenuItemSeven = driver.findElement(By.xpath("//a[text()='Request Loan']"));
		String actualHomePageMenuITemSeven = homePageMenuItemSeven.getText();
		String expectedHomePageMenuITemSeven = "Request Loan";
		Assert.assertEquals(actualHomePageMenuITemSeven, expectedHomePageMenuITemSeven);
		WebElement homePageMenuItemEight = driver.findElement(By.xpath("//a[text()='Log Out']"));
		String actualHomePageMenuITemEight = homePageMenuItemEight.getText();
		String expectedHomePageMenuITemEight = "Log Out";
		Assert.assertEquals(actualHomePageMenuITemEight, expectedHomePageMenuITemEight);

	}

	@Test(priority = 4)
	public void homePageMainTitle() {

		WebElement homePageMainTitle = driver.findElement(By.tagName("h1"));
		String actualHomePageMainTitle = homePageMainTitle.getText();
		String expectedHomePageMainTitle = "Accounts Overview";
		Assert.assertEquals(actualHomePageMainTitle, expectedHomePageMainTitle);

	}

	@Test(priority = 5)
	public void homePageAccountTableDetails() {

		WebElement homePageTableHeaderOne = driver
				.findElement(By.xpath("//table[@id='accountTable']//tr/th[text()='Account']"));
		String actualhomePageTableHeaderOne = homePageTableHeaderOne.getText();
		String expectedhomePageTableHeaderOne = "Account";
		Assert.assertEquals(actualhomePageTableHeaderOne, expectedhomePageTableHeaderOne);
		WebElement homePageTableHeaderTwo = driver
				.findElement(By.xpath("//table[@id='accountTable']//tr/th[text()='Balance*']"));
		String actualhomePageTableHeaderTwo = homePageTableHeaderTwo.getText();
		String expectedhomePageTableHeaderTwo = "Balance*";
		Assert.assertEquals(actualhomePageTableHeaderTwo, expectedhomePageTableHeaderTwo);
		WebElement homePageTableHeaderThree = driver
				.findElement(By.xpath("//table[@id='accountTable']//tr/th[text()='Available Amount']"));
		String actualhomePageTableHeaderThree = homePageTableHeaderThree.getText();
		String expectedhomePageTableHeaderThree = "Available Amount";
		Assert.assertEquals(actualhomePageTableHeaderThree, expectedhomePageTableHeaderThree);
		WebElement homePageTableAccountMessage = driver.findElement(By.xpath(
				"//table[@id='accountTable']//tr/td[text()='*Balance includes deposits that may be subject to holds']"));
		String actualhomePageTableAccountMessage = homePageTableAccountMessage.getText();
		String expectedhomePageTableAccountMessage = "*Balance includes deposits that may be subject to holds";
		Assert.assertEquals(actualhomePageTableAccountMessage, expectedhomePageTableAccountMessage);
		driver.quit();
	}
}
