package RegressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

	@Test(priority = 1)
	public void withoutUsernameAndPassword() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String actualErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String expectedErrorText = "Please enter a username and password.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		driver.quit();

	}

	@Test(priority = 2)
	public void withUsernameAndWithoutPassword() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String actualErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String expectedErrorText = "Please enter a username and password.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		driver.quit();

	}

	@Test(priority = 3)
	public void withPasswordAndWithoutUsername() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String actualErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String expectedErrorText = "Please enter a username and password.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		driver.quit();

	}

	@Test(priority = 5)
	public void correctusernameAndIncorrectPassword() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("akshaysundar");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testpassword");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String actualErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String expectedErrorText = "The username and password could not be verified.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		driver.quit();

	}

	@Test(priority = 6)
	public void incorrectusernameAndcorrectPassword() throws Exception {

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testusername");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testpassword");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		String actualErrorText = driver.findElement(By.xpath("//p[@class='error']")).getText();
		String expectedErrorText = "The username and password could not be verified.";
		Assert.assertEquals(actualErrorText, expectedErrorText);
		driver.quit();
	}

	@Test(priority = 7)
	public void correctPasswordAndUsername() throws Exception {

		Register reg = new Register();
		String username = reg.clickingRegisterWithAllDetails();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		driver.quit();

	}

	@Test(priority = 8)
	public void Logout() throws Exception {

		Register reg = new Register();
		String username = reg.clickingRegisterWithAllDetails();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		driver.quit();

	}
}
