package tours;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightsPage;
import pageObjects.HomePage;
import resources.BaseClass;

public class RoundTripTestCase extends BaseClass {
	
public static Logger log = LogManager.getLogger(RegisterTestCase.class.getName());
	
	@BeforeClass
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
	
	@Parameters({"userName1","password1"})
	@Test	
	public void login(String userName1, String password1)
	{
		HomePage hp = new HomePage(driver);
		
		WebElement un = hp.getUserName();
		sendValues(un, userName1);
		
		WebElement pwd = hp.getPassword();
		sendValues(pwd, password1);
		
		WebElement submit = hp.getSignIn();
		getClicked(submit);
	}
	@Test(dataProvider="getData1",dependsOnMethods="login")
	public void RoundTrip(String Passengers, String departingFrom, String on1, String on2, String arrivingIn, 
			String toMonth, String toDay, String ServiceClass, String airLines)
	{
		FlightsPage fp = new FlightsPage(driver);
		
		WebElement roundTrip = fp.getRoundTrip();
		getClicked(roundTrip);
		
		WebElement pass = fp.getPassengers();
		getSelectByVisibleText(pass, Passengers);
		
		WebElement departing = fp.getDepartingFrom();
		getSelectByVisibleText(departing, departingFrom);
		
		WebElement onMonth = fp.getFromMonth();
		getSelectByVisibleText(onMonth, on1);
		
		WebElement onDate = fp.getFromDay();
		getSelectByVisibleText(onDate, on2);
		
		WebElement arriveIn = fp.getArrivingIn();
		getSelectByVisibleText(arriveIn, arrivingIn);
		
		WebElement returnMonth = fp.getToMonth();
		getSelectByVisibleText(returnMonth, toMonth);
		
		WebElement returnDate = fp.getToDay();
		getSelectByVisibleText(returnDate, toDay);
		
		WebElement firstClass = fp.getFirstClass();
		getClicked(firstClass);
		
		WebElement airlines = fp.getAirline();
		getSelectByVisibleText(airlines, airLines);
		
		WebElement continueButton = fp.getContinueButton();
		getClicked(continueButton);
		
		WebElement signOff = fp.getSignOff();
		getClicked(signOff);
	}
	
	@DataProvider
	public Object[][] getData1() throws Exception
	{
		ArrayList<String> array1 = getExcelData("Flights", "RoundTrip");
		
		Object[][] data = new Object[1][9];
		
		data[0][0] = array1.get(1);
		data[0][1] = array1.get(2);
		data[0][2] = array1.get(3);
		data[0][3] = array1.get(4);
		data[0][4] = array1.get(5);
		data[0][5] = array1.get(6);
		data[0][6] = array1.get(7);
		data[0][7] = array1.get(8);
		data[0][8] = array1.get(9);
		return data;
	}
	
	@AfterClass
	public void driverQuit()
	{
		log.debug("Quitting the driver");
		quitDriver();
		log.info("Successfully quit the driver");
	}

}
