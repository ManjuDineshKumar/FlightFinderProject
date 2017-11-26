/**
 * 
 */
package com.FlightFinder.page.base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Manju Dinesh Kumar
 *
 */
public class Page {
	
	public static WebDriver driver=null;
		
	public Page() 
	{
		if(driver==null)
		{		
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\Chrome\\chromedriver.exe");			
				driver = new ChromeDriver();
								    	
		    	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			}
	}			 
	public void quit()
	{
		driver.close();
	}

		}


