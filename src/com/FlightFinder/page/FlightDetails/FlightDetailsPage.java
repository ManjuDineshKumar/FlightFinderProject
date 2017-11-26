/**
 * 
 */
package com.FlightFinder.page.FlightDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FlightFinder.page.SelectFlight.SelectFlightPage;
import com.FlightFinder.util.Constants;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class FlightDetailsPage {
	public WebDriver driver;
	@FindBy(xpath=Constants.Oneway)	
	public WebElement oneway;
	@FindBy(name=Constants.Departure)
	public WebElement departure;
	@FindBy(name=Constants.Arrival)
	public WebElement arrival;
	@FindBy(xpath=Constants.First)	
	public WebElement first;
	@FindBy(name=Constants.FindFlights)
	public WebElement findflights;
	public boolean deptFlag=false;
	public boolean arvlFlag = false;
	public boolean serviceclassFlag=false;
	public FlightDetailsPage(WebDriver dr)
	{
		driver=dr;
	}
	public  void SelectTriptype(String TRIPTYPE)
	{
		if (TRIPTYPE.equalsIgnoreCase("oneway"))
		{			
			oneway.click();
			
		}
		
	}
	
	public Boolean SelectDepartingFrom(int DEPARTURE)
	{
		if (DEPARTURE == Constants.Departurevalue)
		{	
			deptFlag =true;
			Select Selection = new Select(departure);			
			Selection.selectByIndex(Integer.valueOf(DEPARTURE));
			return true;
		}
		else
			return false; 
			
	}
	
	public Boolean SelectArrivingIn(int ARRIVAL)
	{
		if (ARRIVAL == Constants.Arrivalvalue)
		{
			arvlFlag = true;
			Select Selection = new Select(arrival);			
			Selection.selectByIndex(Integer.valueOf(ARRIVAL));
			return true;
		}
		else
			return false; 
			
	}
	
	public Boolean SelectServiceClass(String CLASS) throws InterruptedException
	{		
		if (CLASS.equalsIgnoreCase("first"))
		{					
			serviceclassFlag = true;
			Thread.sleep(1000);
			first.click();
			return true;
			
		}
		else 
			return false; 
	}
	
	public SelectFlightPage FlightPage_loaded() throws InterruptedException
	{				
		 Thread.sleep(2000);
		if (findflights.isDisplayed()&&(deptFlag) && (arvlFlag) && (serviceclassFlag))
		{				
			findflights.click();
			  Thread.sleep(2000);
			  SelectFlightPage SelectFlightDetails=PageFactory.initElements(driver, SelectFlightPage.class);		
			return SelectFlightDetails;
		}
		else
			return null;
		
	}
	
}


