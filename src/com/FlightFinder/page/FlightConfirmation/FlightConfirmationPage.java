/**
 * 
 */
package com.FlightFinder.page.FlightConfirmation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.FlightFinder.util.Constants;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class FlightConfirmationPage {
	public WebDriver driver;
	@FindBy(xpath=Constants.TotalTicketPrice)
	public WebElement totalticketprice;
	public FlightConfirmationPage(WebDriver dr)
	{
		driver=dr;
	}
	public String GetTicketPrice()
	{
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Total_TicketPrice=totalticketprice.getText();
		System.out.println("Total Price of the Ticket is " +Total_TicketPrice);
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Total_TicketPrice;
	}
	

}
