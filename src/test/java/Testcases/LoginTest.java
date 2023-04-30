package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{
	
	
	public void test2()
	{
		LoginFunction("shivani@gmail.com","shivaniPa$$");
	}
	
	@Test
	public void test1()
	{
		LoginFunction("abc@gmail.com","Testing@123");
		WebElement error = driver.findElement(By.xpath("//div[@id='msg_box']"));
		
		String ActError = error.getText();
		String ExpError ="The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError,ExpError);
		
	}
	
	public void LoginFunction(String uname_val, String pwd_val)
	{
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys(uname_val);
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys(pwd_val);
		
		WebElement rem_me = driver.findElement(By.className("rememberMe"));
		rem_me.click();
		
		WebElement loginbtn = driver.findElement(By.name("btn_login"));
		loginbtn.click();
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	}

}
