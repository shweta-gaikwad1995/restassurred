package com.ProductDetaills.page;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortProducts_High_to_Low {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Navigate to url
		driver.get("https://www.amazon.in/?ie=UTF8&tag=googmantxtmob50-21&ascsubtag=_k_EAIaIQobChMIkI-Vjdqn-wIVlDMrCh1shgLqEAAYASAAEgJiHPD_BwE_k_&gclid=EAIaIQobChMIkI-Vjdqn-wIVlDMrCh1shgLqEAAYASAAEgJiHPD_BwE");

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
		
		//Total Product Serach result
		
		WebElement search_Result=driver.findElement(By.xpath("//span[contains(text(),'of over')]"));
		String totalSearchResult=search_Result.getText();
		System.out.println("Product Search Result :- "+totalSearchResult);
		
		//Inspect Product price on Page
		
	List<WebElement> product_price=	driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0;i<product_price.size();i++)
		{
			String product_priceDetail = product_price.get(i).getText();
			
			System.out.println(product_priceDetail);
		}
		
		
		String[] iphone= {"62,900","61,900","61,900","79,900",
				"89,900","56,900","48,900","79,900","388","400",
				"488","79,900","89,900","89,900","61,900","1,11,900","11,999",
				"61,900","3,055","3,530","3,723","1,599","79,900",
				"79,900","18,999","89,900","11,999","57,899"};
			Arrays.sort(iphone);
			/*
			 * A toString() is an in-built method in Java that returns the value given 
			 * to it in string format. Hence, 
			 * any object that this method is applied on, 
			 * will then be returned as a string object.
			 */
			System.out.println(Arrays.toString(iphone));
			
		




				
		

	}

}
