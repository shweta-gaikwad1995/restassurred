import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	static WebDriver driver;
	static boolean flag = false;
	
	public static SoftAssert softassert=new SoftAssert();

	@Test
	public void m1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Navigate to url
		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=SignUp");

		// chcek email field conatins small chaarcters or not

		WebElement element = driver.findElement(By.xpath("//input[@type='email']"));
		element.sendKeys("shwetagaiA15");

		String value = element.getAttribute("value");
		System.out.println("email value having big charcteres:=   " + value);
		
		
		
	
		Assert.assertEquals(Pattern.matches("[0-9]+", value)==true, "Digits allowed ");
		System.out.println("Digits allowed");
		
		Assert.assertEquals(Pattern.matches("[A-Z]+", value)==false, "Capital nlt not  letters allowed ");
		System.out.println("Capital Letters not allowed");

		
		//Verify lenegth of string
		if(value.length()>5)
		{
			flag=true;
		}
		
		
		
		
		/*
		 * if(Pattern.matches("[A-Z]+", value)==false) {
		 * System.out.println("email conatind Capital letter"); }
		 */
	}
}
