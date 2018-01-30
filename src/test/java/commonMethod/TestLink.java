package commonMethod;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
 
import java.net.URL;
 
import java.util.ArrayList;
 
import java.util.HashSet;
 
import java.util.Iterator;
 
import java.util.NoSuchElementException;
 
import java.util.Set;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.JavascriptExecutor;
 
import org.openqa.selenium.Keys;
 
 
import org.openqa.selenium.WebDriver.Navigation;
 
import org.openqa.selenium.WebDriver.Options;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.firefox.FirefoxProfile;
 
import org.openqa.selenium.support.ui.*;
 


public class TestLink {

	public  List<WebElement> findAllLinks(WebDriver driver)
	 
	  {
	 
		  List<WebElement> elementList = new ArrayList();
	 
		  elementList = driver.findElements(By.tagName("a"));
	 
		  elementList.addAll(driver.findElements(By.tagName("a")));
	 
		  List finalList = new ArrayList(); 
	 
		  for (WebElement element : elementList)
	 
		  {
	 
			  if(element.getAttribute("href") != null)
	 
			  {
	 
				  finalList.add(element);
	 
			  }		  
	 
		  }	
	 
		  return finalList;
	 
	  }
	 
		public static String isLinkBroken(URL url) throws Exception
	 
		{
	 
			//url = new URL("http://yahoo.com");
	 
			String response = "";
	 
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 
			try
	 
			{
	 
			    connection.connect();
	 
			    response = connection.getResponseMessage();	        
	 
			    connection.disconnect();
	 
			    return response;
	 
			}
	 
			catch(Exception exp)
	 
			{
	 
				return exp.getMessage();
	 
			}  				
	 
		}
		
		public void verifyAllLink(WebDriver driver)
		{
		List<WebElement> allLink= findAllLinks(driver);
		int linkPassed=0;
		int linkFailed=0;
		List failedList = new ArrayList(); 
		 for( WebElement element : allLink){
			 
		    	try

		    	{

			        System.out.println("URL: " + element.getAttribute("href")+ " "+ element.getText()+ " "+ isLinkBroken(new URL(element.getAttribute("href"))));
			        linkPassed++;

		    	}

		    	catch(Exception exp)

		    	{

		    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured " + exp.getMessage());	    		
		    		linkFailed++;
		    		failedList.add(element);
		    	}

		    }
		
		 System.out.println("Total number of links found " + allLink.size());
		 System.out.println("Link is working: " + linkPassed);
		 System.out.println("Link not working: " + linkFailed);
	
		 List<WebElement> failedElements =failedList;
		 for(WebElement e : failedElements) {
			 
			 System.out.println(e.getAttribute("innerHTML"));
		 }
		 
		 System.out.println();
		}
	
}
