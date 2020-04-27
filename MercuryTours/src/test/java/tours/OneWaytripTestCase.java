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

public class OneWaytripTestCase extends BaseClass{
	
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
	
	@Parameters({"userName","password"})
	@Test	
	public void login(String userName, String password)
	{
		HomePage hp = new HomePage(driver);
		
		WebElement un = hp.getUserName();
		sendValues(un, userName);
		
		WebElement pwd = hp.getPassword();
		sendValues(pwd, password);
		
		WebElement submit = hp.getSignIn();
		getClicked(submit);
	}
	
	@Test(dataProvider="getData",dependsOnMethods="login")
	public void oneWayTrip(String Passengers, String departingFrom, String on1, String on2, String arrivingIn, 
			String ServiceClass, String airLines)
	{
		FlightsPage fp = new FlightsPage(driver);
		
		WebElement oneWay = fp.getOneWay();
		getClicked(oneWay);
		
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
		
		WebElement economyClass = fp.getEcocnomyClass();
		getClicked(economyClass);
		
		WebElement airlines = fp.getAirline();
		getSelectByVisibleText(airlines, airLines);
		
		WebElement continueButton = fp.getContinueButton();
		getClicked(continueButton);
		
		WebElement signOff = fp.getSignOff();
		getClicked(signOff);
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		ArrayList<String> array = getExcelData("Flights", "OneWay");
		
		Object[][] data = new Object[1][7];
		
		data[0][0] = array.get(1);
		data[0][1] = array.get(2);
		data[0][2] = array.get(3);
		data[0][3] = array.get(4);
		data[0][4] = array.get(5);
		data[0][5] = array.get(8);
		data[0][6] = array.get(9);
		
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
