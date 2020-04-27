package tours;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import resources.BaseClass;

public class HomePageTestCase extends BaseClass{
	
	public static Logger log = LogManager.getLogger(RegisterTestCase.class.getName());
	
	@BeforeMethod
	public void initializeDriver() throws Exception
	{
		log.debug("Initializing the driver");
		driverInitialize();
		log.info("Initialized the driver");
		
		log.debug("Invoking the url");
		getUrl();
		log.info("Invoked the url");
		
		log.debug("Maximizing the window");
		maximizeWindow();
		log.info("Successfully maximized the window");
	}
	
	@Test
	public void HomePageTest()
	{
		HomePage hp = new HomePage(driver);
		
		log.debug("Refreshing the Home page");
		refreshpage();
		log.info("Refreshed the Home page");
		
		log.debug("Getting the flights element");
		WebElement flight = hp.getFlights();
		log.info("Successfully invoked the flights element");
		
		getClicked(flight);
		log.info("Clicked on "+flight);
		
		log.debug("Getting the hotels element");
		WebElement hotels = hp.getHotels();
		getClicked(hotels);
		log.info("Clicked on "+hotels);
		
		log.debug("Getting the carRentals element");
		WebElement carRentals = hp.getCarRentals();
		getClicked(carRentals);
		log.info("Clicked on "+carRentals);
		
		log.debug("Getting the cruises element");
		WebElement cruises = hp.getCruises();
		getClicked(cruises);
		log.info("Clicked on "+cruises);
		
		log.debug("Getting the destinations element");
		WebElement dest = hp.getDestinations();
		getClicked(dest);
		log.info("Clicked on "+dest);
		
		log.debug("Getting the destinations element");
		WebElement vac = hp.getvacations();
		getClicked(vac);
		log.info("Clicked on "+vac);
		
	}
	
	@Test
	public void validatingText()
	{
		
		HomePage hp = new HomePage(driver);
		
		WebElement exp = hp.getText2();
		String expected = getVisibleText(exp);
		String actual = "Los Angeles to Chicago";
		Assert.assertEquals(actual, expected);
		
		
		WebElement exp2 = hp.getText1();
		String expected2 = getVisibleText(exp2);
		String actual2 = "Atlanta to Las Vegas";
		Assert.assertEquals(actual2, expected2);
	}
	
	@Test
	public void validatingText2()
	{
		SoftAssert softAssert = new SoftAssert();
		
		HomePage hp = new HomePage(driver);
		
		WebElement exp = hp.getText2();
		String expected = getVisibleText(exp);
		String actual = "Los Angeles to Chicago i dont know";
		softAssert.assertEquals(actual, expected);
	}
	
	@Test
	public void validatingText3()
	{
		HomePage hp = new HomePage(driver);
		
		WebElement exp2 = hp.getText1();
		String expected2 = getVisibleText(exp2);
		String actual2 = "Atlanta to Las Vegas i know what to do";
		Assert.assertEquals(actual2, expected2);
	}
	
	@AfterMethod
	public void driverQuit()
	{
		log.debug("Quitting the driver");
		quitDriver();
		log.info("Successfully quit the driver");
	}
	

}
