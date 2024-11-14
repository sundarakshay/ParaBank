package SanityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTest.RegisterPage;

public class UpdateContactInfo {
	
	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
	Select selectVariable;

	@BeforeTest(alwaysRun = true)
	public void PreExecutionModule() throws Exception {

		RegisterPage reg = new RegisterPage();
		String username = reg.forRegister();
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
}
