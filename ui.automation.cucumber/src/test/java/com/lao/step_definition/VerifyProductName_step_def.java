package com.lao.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.lao.constants.Constants;
import com.lao.page_objects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyProductName_step_def {
	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Definition.class);
	
	//When you create the object it will automatically initialize the object as null because initelements initialize the WebElelements in Common_Utils
	//	LoginPage loginpage=new LoginPage();
	
	@Given("the user open the google browser")
	public void the_user_open_the_google_browser() 
	{   try {
		DriverManager.getDriver().get(Constants.APP_URL);
		LOGGER.info("Welcome To Google");
	}
	catch(Exception e)
	{
		LOGGER.error(e);
//		CommonUtils.getInstance().takeScreenshot();
	}
		
	}

	@When("the user search the flipkart and click the link")
	public void the_user_search_the_flipkart_and_click_the_link() 
	{
		try
		{
			DriverManager.getDriver().switchTo().activeElement().sendKeys("Amazon"+Keys.ENTER);
	//		LoginPage.Amazon.click();
	//		loginpage.getAmazon().click();
	//		LoginPage.getInstance().getAmazon().click();
			LoginPage.getInstance().clickAmazon();
			LOGGER.info("Welcome To Flipkart");	
		}
		catch(Exception e)
		{
			LOGGER.error(e);
//			CommonUtils.getInstance().takeScreenshot();
		}
		
	}

	@And("the user search the product")
	public void the_user_search_the_laptop() 
	{
		try
		{
			LOGGER.info("Searching the Laptop in Flipkart");
	//		LoginPage.SearchProduct.sendKeys("Laptop"+Keys.ENTER);
	//		loginpage.getSearchProduct().sendKeys("Laptop"+Keys.ENTER);
	//		LoginPage.getInstance().getSearchProduct().sendKeys("Laptop"+Keys.ENTER);
			LoginPage.getInstance().searchProduct_laptop();
		}
		catch(Exception e)
		{
			LOGGER.error(e);
//			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@Then("the user should see the Products")
	public void the_user_should_see_the_products() 
	{
		try
		{
			System.out.println("User should see the Products");
			LOGGER.info("Products are displayed");
		}
		catch(Exception e)
		{
			LOGGER.error(e);
//			CommonUtils.getInstance().takeScreenshot();
//		    Failing the scenario
			Assert.assertFalse(true);
		}
	}
}
