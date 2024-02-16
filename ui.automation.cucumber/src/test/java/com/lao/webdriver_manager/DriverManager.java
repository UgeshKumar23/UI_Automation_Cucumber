package com.lao.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lao.constants.Constants;
import com.lao.step_definition.Common_Step_Definition;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager 
{
	private static WebDriver driver=null;
	private static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
	
	public static void launchBrowser()
	{
	
		try
		{
			switch(Constants.BROWSER_TO_Launch)
			{
				case "Chrome":
	//				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);  
					WebDriverManager.chromedriver().setup();
					LOGGER.info("Launching"+Constants.BROWSER_TO_Launch);
					driver = new ChromeDriver();
					break;
					
				case "Firefox":
	//				System.setProperty(Constants.FIREFOX_DRIVER,Constants.FIREFOX_DRIVER_LOCATION);
					WebDriverManager.firefoxdriver().setup();
					LOGGER.info("Launching"+Constants.BROWSER_TO_Launch);
					driver = new FirefoxDriver();
					break;
				
				case "Edge":
	//				System.setProperty(Constants.EDGE_DRIVER, Constants.EDGE_DRIVER_LOCATION);
					WebDriverManager.edgedriver().setup();
					LOGGER.info("Launching"+Constants.BROWSER_TO_Launch);
					driver = new EdgeDriver();
					break;
				default:
//					System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
					WebDriverManager.chromedriver().setup();
					LOGGER.info("Launching"+Constants.BROWSER_TO_Launch);
					driver = new ChromeDriver();
					break;	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		public static WebDriver getDriver() {
			return driver;
		}
		
}
