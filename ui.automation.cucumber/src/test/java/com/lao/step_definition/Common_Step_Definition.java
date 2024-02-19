package com.lao.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lao.constants.Constants;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definition 
{
	// launch browser
	public static  WebDriver driver;
	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Definition.class);
	
	private static String ScenarioName=null;
	
	
	
	public static String getScenarioName() {
		return ScenarioName;
	}



	@Before
	public void beforeScenario(Scenario scenario)
	{
		LOGGER.info("Execution Started");
		try
		{ 
			ScenarioName=scenario.getName();
			LOGGER.info("Instantiation the CommonUtils");
//			CommonUtils commonutils=new CommonUtils();
			LOGGER.info("Loading the Properties files");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Check the driver is null or not");
			if(DriverManager.getDriver()==null)
			{
				LOGGER.info("Driver is null.Initiate the Chrome Browser");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElements();
				login();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	private void login() {
		// TODO Auto-generated method stub
		
	}
	
	public void attachedscreenshot(Scenario ScenarioName)
	{
		if(ScenarioName.isFailed())
		{
			byte[] screenshotTaken=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			ScenarioName.attach(screenshotTaken, "image/png", "ErrorScreen");
		}
	}
}
