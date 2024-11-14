package SanityTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPage {
	
	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/register.htm";
	public String usernameForRegister;


	@Test(priority = 1)
	public void clickingRegisterWithAllDetails() {

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
	public String forRegister() {

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

	
}