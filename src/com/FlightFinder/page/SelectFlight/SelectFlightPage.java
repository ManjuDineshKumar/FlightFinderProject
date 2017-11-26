/**
 * 
 */
package com.FlightFinder.page.SelectFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlightFinder.page.BookFlight.BookFlightPage;
import com.FlightFinder.util.Constants;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class SelectFlightPage {
	public WebDriver driver;
	@FindBy(name=Constants.ReserveFlights)
	public WebElement reserveflights;
	public SelectFlightPage(WebDriver dr)
	{
		driver=dr;
	}
	
	public BookFlightPage ReserveFlightPage_loaded() throws InterruptedException
	{
		 Thread.sleep(4000);
		if (reserveflights.isDisplayed())
		{
			reserveflights.click();
			 Thread.sleep(2000);
			 BookFlightPage EnterPassengerDetails=PageFactory.initElements(driver, BookFlightPage.class);		
			return EnterPassengerDetails;
		}
		else
			return null;
		
	}
	

}
