package com.shoppingCart.postive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Verify wheather your Amazon  Shopping Cart is Empoty Cart

public class Verify_Product_count_in_shopping_cart {

	public static WebDriver driver;

	
	

	

	 /*
	  *  Verify the Product Count in amazon Shopping Cart
	  */
	@Test
	public void AddIteam() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
	
		// Enter email in email textBox
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@type='email']"));
		emailTextBox.sendKeys("shwetagaikwad1595@gmail.com");

		// Click Continue Button
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[2]/span/span/input")))
				.click();
		// driver.findElement(By.xpath("//span[@id='continue-announce']")).click();

		// Semd Password
		driver.findElement(By.name("password")).sendKeys("Vrushali2000@");

		// Sign-in Button
		driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div/form/div/div[2]/span/span/input"))
				.click();
		WebElement signButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in to your account')]"));
		signButton.click();

		

	}
}
