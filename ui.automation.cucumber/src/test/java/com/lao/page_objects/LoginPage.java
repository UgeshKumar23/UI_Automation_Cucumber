package com.lao.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

public class LoginPage {
	
	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, null);
			 
	private static LoginPage loginpageInstance;
	
	private LoginPage(){}
	
	public static LoginPage getInstance()
	{
		if(loginpageInstance==null)
		{
			loginpageInstance=new LoginPage();
		}
		return loginpageInstance;
		
	}
//	Using Static
//	public static WebElement SearchProduct;
//	public static WebElement Amazon;
	
//	Using Page Factory
//	@FindBy(xpath="//span[text()='Shop online at Amazon India']")
//	private WebElement Amazon;
//	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
//	private WebElement SearchProduct;
//	

//	public WebElement getAmazon() 
//	{
//		return Amazon;
//	}
//	public WebElement getSearchProduct() 
//	{
//		return SearchProduct;
//	}
	
//	Using By
	
	By Amazon=By.xpath("//span[text()='Shop online at Amazon India']");
	By SearchProduct=By.xpath("//input[@id='twotabsearchtextbox");
	
	public void clickAmazon()
	{
		try
		{
		CommonUtils.getInstance().highLightElement(driver.findElement(Amazon));
		driver.findElement(Amazon).click();
		}
		catch(Exception e)
		{
			System.out.println("Element is not Visible Please wait for sometimes");
			try 
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(Amazon));
				
			} 
			catch (Exception e2) 
			{
				System.out.println("Element is not Visible");			}
			}
	}
	public void searchProduct_laptop()
	{
		try
		{
			CommonUtils.getInstance().highLightElement(driver.findElement(SearchProduct));
			driver.findElement(SearchProduct).sendKeys("Laptop"+Keys.ENTER);
		}
		catch(Exception e)
		{
			System.out.println("Element is not Visible Please wait for sometimes");
			try 
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(Amazon));
				
			} 
			catch (Exception e2) 
			{
				System.out.println("Element is not Visible");			}
			}
	}
}
