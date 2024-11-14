package SanityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTest.RegisterPage;

public class BillPayPage {
	
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
		driver.findElement(By.xpath("//a[text()='Bill Pay']")).click();
	}
	  @Test(priority = 1)
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
