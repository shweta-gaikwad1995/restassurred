package com.ProductDetaills.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	static WebDriver driver;
	boolean status=false;

	@Test
	public void searchResulyt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Navigate to url
		driver.get(
				"https://www.amazon.in/?ie=UTF8&tag=googmantxtmob50-21&ascsubtag=_k_EAIaIQobChMIkI-Vjdqn-wIVlDMrCh1shgLqEAAYASAAEgJiHPD_BwE_k_&gclid=EAIaIQobChMIkI-Vjdqn-wIVlDMrCh1shgLqEAAYASAAEgJiHPD_BwE");

		// Clicking on Cross button

		// Check Search Box is Displayed
		WebElement searchbx = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Assert.assertEquals(searchbx.isDisplayed(), true);
		Reporter.log("Search Box is displayed." + "<br>", true);
		System.out.println("========================================================");
		System.out.println("========================================================");

		// Enter TV in Search text box
		searchbx.sendKeys("iphone");
		searchbx.sendKeys(Keys.ENTER);
		
		List<WebElement> allcheckboxes=driver.findElements(By.xpath("//div[@id='brandsRefinements']//a"));
	
	for(WebElement chbox:allcheckboxes)
	{
	String checkbox=	driver.findElement(By.xpath("//div[@id='brandsRefinements']//a//span")).getText();
	
	if(checkbox.equals("Apple")&&checkbox.equals("OnePlus"))
	{
		 chbox.click();
	}
	
	}
	
	}
}
