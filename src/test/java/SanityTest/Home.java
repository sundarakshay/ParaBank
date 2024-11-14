package SanityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SanityTest.RegisterPage;

public class Home {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

	@Test
	public void homePageWelcomeMessage() {

		RegisterPage reg = new RegisterPage();
		String username = reg.forRegister();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("akshaysundar");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		WebElement homePageWelcome = driver.findElement(By.xpath("//p[@class='smallText']"));
		String actualHomePageWelcomeMessage = homePageWelcome.getText();
		String expectedHomePageWelcomeMessage = "Welcome Akshay Sundar";
		Assert.assertEquals(actualHomePageWelcomeMessage, expectedHomePageWelcomeMessage);
		driver.quit();
	}
}
