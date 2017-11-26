/**
 * 
 */
package com.FlightFinder.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import com.FlightFinder.page.BookFlight.BookFlightPage;
import com.FlightFinder.page.FlightConfirmation.FlightConfirmationPage;
import com.FlightFinder.page.FlightDetails.FlightDetailsPage;
import com.FlightFinder.page.SelectFlight.SelectFlightPage;
import com.FlightFinder.page.base.Page;
import com.FlightFinder.page.landing.LandingPage;
import com.FlightFinder.util.DataProvider;

public class TestGetFlightPrice extends Page  {
  @Test
  public void GetFlightPrice()throws InterruptedException {
	  
	  LandingPage Landingpg=PageFactory.initElements(driver, LandingPage.class);
	  //Entering Credentials to Landing Page	  
	  boolean CredentialsFlag=Landingpg.EnterCredentials((DataProvider.Username),(DataProvider.PassWord));	 
	  FlightDetailsPage FlightdetailsPg = Landingpg.LandingPage_loaded(); 
	  
	  if ((FlightdetailsPg ==null)||(!CredentialsFlag))
	  {	  
		  Assert.fail("Enter valid Credentials");
	  }
	  //Entering Flight details 
	  FlightdetailsPg.SelectTriptype((DataProvider.TripType));	 
	  boolean DeptFlag=FlightdetailsPg.SelectDepartingFrom((DataProvider.DeParture));	  	  
	  boolean ArvlFlag=FlightdetailsPg.SelectArrivingIn((DataProvider.ArriVal));
	  boolean ServiceClassFlag=FlightdetailsPg.SelectServiceClass((DataProvider.ServiceClass));	  
	  SelectFlightPage Selectflightpg = FlightdetailsPg.FlightPage_loaded();
	  	  
	  if (Selectflightpg==null)
	  {
		  if (!DeptFlag)
			  Assert.fail("Departure should be from Sydney");
		  if(!ArvlFlag)
			  Assert.fail("Arrival should be in London");
		  if(!ServiceClassFlag)
			  Assert.fail("Service class should be in First class");
		  
	  }
	  BookFlightPage Bookflightpg = Selectflightpg.ReserveFlightPage_loaded();	  
	  
	  boolean FNameFlag =Bookflightpg.EnterPassengerFName((DataProvider.FirstName));	 
	  boolean LNameFlag =Bookflightpg.EnterPassengerLName((DataProvider.LastName));	  
	  boolean CardFlag = Bookflightpg.EnterCreditCardNumber(DataProvider.CreditCardNumber);
	  Boolean CardNumberLengthFlag = Bookflightpg.CreditCardNumberLengthValidation(DataProvider.CreditCardNumber);
	  
	  Bookflightpg.SelectTicketLessTravel(DataProvider.TicketLess);
	  
	  FlightConfirmationPage TicketPrice =Bookflightpg.PassengerdetailsPage_loaded();
	  
	  if (TicketPrice==null)	 
	  {				 
		  if(!FNameFlag)
			  Assert.fail("FirstName should not be empty and should be alphabets");
		  if(!LNameFlag)
			  Assert.fail("LastName should not be empty and should be alphabets");		 
		  if (!CardNumberLengthFlag)
			  Assert.fail("Enter Valid Credit Card Number"); 
		  if(!CardFlag)
		      Assert.fail("Card Number should be not be empty");
		  
	  }
	 
  }
  

  @AfterTest
  public void Teardown()
	{	 
	  driver.close();
	}

}

