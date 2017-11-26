/**
 * 
 */
package com.FlightFinder.page.BookFlight;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FlightFinder.page.FlightConfirmation.FlightConfirmationPage;
import com.FlightFinder.util.Constants;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class BookFlightPage {
	public WebDriver driver;
	@FindBy(name=Constants.PassengerFname)	
	public WebElement firstname;
	@FindBy(name=Constants.PassengerLname)
	public WebElement lastname;
	@FindBy(name=Constants.Creditcardnumber)
	public WebElement cardnumber;
	@FindBy(name=Constants.TicketLessTravel)
	public WebElement ticketlesstravel;
	@FindBy(name=Constants.SecureTicket)
	public WebElement secureticket;
	public boolean passengerFNameValidation = false;
	public boolean passengerLNameValidation = false;
    public boolean cardemptyValidation=false;
    public boolean cardlengthvalidation=false;
	public int cardlength;
	public BookFlightPage(WebDriver dr)
	{
		driver=dr;
	}
public  boolean EnterPassengerFName(String FIRSTNAME)
{
	// only alphabets check
	if ((!FIRSTNAME.isEmpty())&& (Pattern.matches("[a-zA-Z]+",FIRSTNAME)))
	{			
			passengerFNameValidation=true;	
			firstname.clear();
			firstname.sendKeys(FIRSTNAME);
			return true;
		}		     
   else
     return false;
}
public  boolean EnterPassengerLName(String LASTNAME)
{
	if ((!LASTNAME.isEmpty())&& (Pattern.matches("[a-zA-Z]+",LASTNAME)))
	{	  
		passengerLNameValidation=true;
		lastname.clear();
        lastname.sendKeys(LASTNAME); 
		return true;
	  }	     

   else
     return false;
}
public  boolean EnterCreditCardNumber(String CARDNUMBER)
{
	
	if (!CARDNUMBER.isEmpty()) 
	{	
		cardemptyValidation =true;
		cardnumber.clear();
		cardnumber.sendKeys(CARDNUMBER);
        return true;
	}	
   else
     return false;
}
public boolean CreditCardNumberLengthValidation(String CARDNUMBER)
{
	cardlength=CARDNUMBER.length();
	if (cardlength==Constants.Creditcardlength)
	{
		cardlengthvalidation=true;
		return true;
	}
	else
		return false;
}
public  void SelectTicketLessTravel(String TICKETLESS) throws InterruptedException
{
	if (TICKETLESS.equalsIgnoreCase("yes"))
	{
	Thread.sleep(2000);
	ticketlesstravel.click();
	}

		
}

public FlightConfirmationPage PassengerdetailsPage_loaded() throws InterruptedException
{
	 Thread.sleep(3000);
	if ((secureticket.isDisplayed())&& (passengerFNameValidation)&& 
			(passengerLNameValidation)&& (cardemptyValidation) && (cardlengthvalidation))			
	{
		  secureticket.click();
		  Thread.sleep(2000);
		  FlightConfirmationPage ConfirmFlightDetails=PageFactory.initElements(driver, FlightConfirmationPage.class);		
		return ConfirmFlightDetails;
	}
	else
		return null;
	
}

}
