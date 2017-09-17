package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginCRM {
	WebDriver driver;

	@Test
	public void login() {
		driver.get("http://crm.techcanvass.co.in/");
		driver.findElement(By.id("btnlogin")).click();
		driver.findElement(By.id("txtuname")).sendKeys("techcanvassuser@techcanvass.co.in");
		driver.findElement(By.id("txtpwd")).sendKeys("user1234");
		driver.findElement(By.id("loginbtn")).click();
		WebElement label = driver.findElement(By.id("ctl00_lblcompanyname"));
		String actualResult = label.getText();
		String expectedResult = "Techcanvass";
		Assert.assertEquals(actualResult, expectedResult, "Does not match - Changed in 17Sep");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
