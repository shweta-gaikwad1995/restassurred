package com.ProductDetaills.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;



/**
 * 
 * http://www.automationfraternity.com/selenium/selenium-real-time-scenario-flipcart-search-product-and-find-lowest-and-highest-priced-product/
 * @author admin
 *
 */
public class ProductResults {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException ,NumberFormatException{

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
		
		//Check if search Results is displayed-VALIDATION 1
				WebElement txtbx_search_result_text = driver.findElement(By.xpath("//span[contains(text(),'1-16 of over 2,000 results for')]"));
				Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);
				
				String total_productSearch_result = txtbx_search_result_text.getText();
				System.out.println("Results for iphone :- " +total_productSearch_result);
				
				System.out.println("=================== =====================================");
				System.out.println("========================================================");
				
				//Check if search Results is displayed-VALIDATION 2
				String exp_search_title = "Amazon.in : iphone";
				String actual_search_title = driver.getTitle();
				if(actual_search_title.toLowerCase().contains(exp_search_title.toLowerCase())) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
				Reporter.log("Search Box set with value :" + exp_search_title + " and search results displayed" + "<br>", true);
	

				//Fetch All the Products Text
				System.out.println("=============List of Products====================");
				
				List<WebElement> list_of_products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
				int total_Products=list_of_products.size();
				System.out.println("====Total products in Search Result==="+ ":- "+total_Products);
				
				
				for(WebElement element:list_of_products)
				{
					//total Products in Search Result
					
					System.out.println(element.getText());
					
					
				}
			
			
				List<WebElement> list_of_products_price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
				//Use of HashMaop to store Products and Their prices(after conversion to Integer)
				String product_name;
				String product_price;
				int int_product_price;
				HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
				for(int i=0;i<list_of_products.size();i++) {
					product_name = list_of_products.get(i).getText();//Iterate and fetch product name
					product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
					product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
				
					try {
						int_product_price = Integer.parseInt(product_price);//Convert to Integer
						map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					}
					
				}
				Reporter.log("Product Name and price fetched from UI and saved in HashMap as:" + map_final_products.toString() + "<br>",true);
		 
				//Find the Highest and Lowest prices
				//One way is to fetch all values of the hashMap and then save it in the ArrayList
				//Then using Collections class in java, sort it. this we can easily get highest and lowest
				
				//Get all the keys from Hash Map
				Set<Integer> allkeys = map_final_products.keySet();
				ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
				
				//Sort the Prices in Array List using Collections class
				//this will sort in ascending order lowest at the top and highest at the bottom
				Collections.sort(array_list_values_product_prices);
				
				//Highest Product is
				int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
				
				//Low price is
				int low_price = array_list_values_product_prices.get(0);
				
				Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
				Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
				
				//Get List of All values from Hash Map. Right now we do not need it so commenting
				//Collection<String> allValues = map_final_products.values();
				//ArrayList<String> array_list_values_product_names = new ArrayList<String>(allValues);
	}
		
		 
				
				}
			
				
	


