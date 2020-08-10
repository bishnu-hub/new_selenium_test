package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;
	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.edge.driver","msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://13.235.135.188:3001/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
  @Test
  public void VerifyTitle() {
		
		String X = driver.getTitle();
		System.out.println(X);
		Assert.assertEquals(X,"Login");
  }
  @Test
  public void VerifyURL() {
	  
		String X = driver.getCurrentUrl();
		System.out.println(X);
		Assert.assertEquals(X,"http://13.235.135.188:3001/");
  }
  
  @Test
  public void VerifyLogin() {
	  
	    driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("click")).click();
	    String X = driver.getCurrentUrl();
		System.out.println(X);
		Assert.assertEquals(X,"http://13.235.135.188:3001/");
  }
  
  @AfterClass
  public void close(){
	driver.close();  
  }
}
