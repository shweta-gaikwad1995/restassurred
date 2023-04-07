package com.dynamic.webtable;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maximum_valueFromTable {

	static WebDriver driver;

	static String max;
	static double m = 0, r = 0;

	@Test
	public void m1() throws ParseException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/weather");

		// No.of rows
		List<WebElement> rows = driver
				.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		System.out.println("Total No of rows are : " + rows.size());

		for (int i = 1; i < rows.size(); i++) {
			max = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[contains(text(),'°C')]")).getText();
			System.out.println("" + max);

			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(max);
			max = num.toString();
			m = Double.parseDouble(max);
			if (m > r) {
				r = m;
			}
		}
		System.out.println(" " + max);
		System.out.println(" " + r);

	}

	@Test
	public void maxmumprice() {

		String max;
		String[] maxprice = null;  
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/weather");
		// No.of rows
		List<WebElement> rows = driver
				.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		System.out.println("Total No of rows are : " + rows.size());

		for (int i = 1; i < rows.size(); i++) {
			max = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[contains(text(),'°C')]")).getText();
			System.out.println("" + max+",");
	
			//declaring an empty string array  
			
			//converting using String.split() method with whitespace as a delimiter  
			maxprice = max.split(","); 
			
			Arrays.sort(maxprice);
			
		
			
		}
		System.out.print(" "+Arrays.toString(maxprice)+",");
	}

}
