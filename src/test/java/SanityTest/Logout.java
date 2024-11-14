package SanityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import SanityTest.RegisterPage;

public class Logout {
	
	 WebDriver driver;
	 String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
	
  @Test
  public void LogoutFeature() {
	 
		RegisterPage reg = new RegisterPage();
		String username = reg.forRegister();
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
