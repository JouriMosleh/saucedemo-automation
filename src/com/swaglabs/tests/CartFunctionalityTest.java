package com.swaglabs.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartFunctionalityTest {
	WebDriver driver=new ChromeDriver();
	String theWebsite="https://www.saucedemo.com/";
	
	@BeforeTest
	public void mySetup() {
		driver.get(theWebsite);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
    public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(priority=2)
    public void addToCart() {
    	List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    	System.out.println(addToCartButtons.size());
    	for(int i=0;i<addToCartButtons.size();i++) {
    		addToCartButtons.get(i).click();
    	}
    	
	}

	@Test(priority=3)
	public void removeFromCart() {
		List<WebElement> removeCartButtons = driver.findElements(By.className(".btn.btn_secondary.btn_small.btn_inventory")); 
		for (int i = 0 ; i<removeCartButtons.size();i++) {
			removeCartButtons.get(i).click(); 
		}
	
    }
	
	
	@AfterTest
    public void afterFinishingTheTest() {
		
	}

}
