/**
 * 
 */
package com.FlightFinder.page.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlightFinder.page.base.Page;
import com.FlightFinder.util.Constants;
import com.FlightFinder.page.FlightDetails.FlightDetailsPage;;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class LandingPage extends Page{

	public WebDriver driver;
	@FindBy(name=Constants.UserName)	
	public WebElement username;
	@FindBy(name=Constants.Password)	
	public WebElement password;
	@FindBy(name=Constants.Login)	
	public WebElement login;
	public boolean CredentialsValidation=false;
	
	public LandingPage(WebDriver dr)
	{
		driver=dr;
	}
	
	public Boolean EnterCredentials(String USERNAME,String PASSWORD)
	{
		if ((!USERNAME.isEmpty()) &&(!PASSWORD.isEmpty()))
		{
		   if ((USERNAME==Constants.Uname) && (PASSWORD==Constants.Pwd))
				{
			       username.clear();
			       username.sendKeys(USERNAME);
			       password.clear();
			       password.sendKeys(PASSWORD);
			       CredentialsValidation=true;			       
			       return true;
			       
				}
		   else
			   return false;
		}
		else
			return false;
			
	
	}
	
	public FlightDetailsPage LandingPage_loaded() throws InterruptedException
	{		
		 Thread.sleep(4000);
		if (login.isDisplayed()&& (CredentialsValidation))
		{			
			 login.click();
			  Thread.sleep(1000);
			  FlightDetailsPage EnterFlightDetails=PageFactory.initElements(driver, FlightDetailsPage.class);		
			return EnterFlightDetails;
		}
		else
			return null;
		
	}
	}
	

