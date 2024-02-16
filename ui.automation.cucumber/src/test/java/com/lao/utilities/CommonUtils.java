package com.lao.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.lao.constants.Constants;
import com.lao.page_objects.LoginPage;
import com.lao.step_definition.Common_Step_Definition;
import com.lao.webdriver_manager.DriverManager;

public class CommonUtils {
	
	//SingleTon Pattern
	private static CommonUtils commonutilsInstance=null;
	 
	private CommonUtils()
	{
		
	}
	
	public static CommonUtils getInstance()
	{
		if(commonutilsInstance==null)
		{
			commonutilsInstance=new CommonUtils();
		}
		return commonutilsInstance;
	}
	
	// Loading the values from config.properties
	public void loadProperties()throws FileNotFoundException
	{
		FileReader reader=null;
		 try 
		 {
			 reader=new FileReader("config.properties");
		 } 
		 catch (FileNotFoundException e) 
		 {
			e.printStackTrace();
	     }
		 
		 Properties properties=new Properties();
		 try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Constants.APP_URL=properties.getProperty("App_Url");
		 Constants.BROWSER_TO_Launch=properties.getProperty("Browser");
		 Constants.USERNAME=properties.getProperty("Username");
		 Constants.PASSWORD=properties.getProperty("password");
		 Constants.CHROME_DRIVER_LOCATION=properties.getProperty("Chrome_driver_location");
		 Constants.FIREFOX_DRIVER_LOCATION=properties.getProperty("Firefox_driver_location");
		 Constants.EDGE_DRIVER_LOCATION=properties.getProperty("Edge_driver_location");
		 
	}
	
//	Initialise the Elements from Page Object Repository
	public static void initWebElements()
	{
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
	}
	
//   Taking Screenshot
	public void takeScreenshot()
	{
		File screenshot=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(screenshot,new File(Common_Step_Definition.getScenarioName()+".png"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

//Highlighting the WebElement
	public void highLightElement(WebElement element)
	{
		JavascriptExecutor executor= (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid red')", element);
	}
}
