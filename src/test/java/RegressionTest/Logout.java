package RegressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {

	private WebDriver driver;
	private String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

	@Test
	public void logoutFeature() throws Exception {

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
		WebElement successLogout = driver.findElement(By.tagName("h2"));
		String actualsuccessLogoutMessage = successLogout.getText();
		String expectedsuccessLogoutMessage = "Customer Login";
		Assert.assertEquals(actualsuccessLogoutMessage, expectedsuccessLogoutMessage);
		driver.quit();
	}
}
