package tours;

import java.util.ArrayList;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.RegisterPage;
import resources.BaseClass;

public class RegisterTestCase extends BaseClass{
	
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
	
	@Test(dataProvider="getData")
	public void registerPage(String fname, String lname, String phone, String eId, String a1, String a2, String city, 
			String state, String pCode, String country, String uname, String password, String cpassword)
	{
		RegisterPage rp = new RegisterPage(driver);
		
		WebElement reg = rp.getRegister();
		getClicked(reg);
		log.info("Successfully clicked the register button");
		
		WebElement fn = rp.getFirstName();
		sendValues(fn,fname);
		log.info("Successfully entered the "+fname);
		
		WebElement ln = rp.getLastName();
		sendValues(ln,lname);
		log.info("Successfully entered the "+lname);
		
		WebElement pho = rp.getPhoneNumber();
		sendValues(pho, phone);
		log.info("Successfully entered the "+phone);
		
		WebElement email = rp.getEmailId();
		sendValues(email, eId);
		log.info("Successfully entered the "+eId);
		
		WebElement ad1 = rp.getAddress1();
		sendValues(ad1, a1);
		log.info("Successfully entered the "+a1);
		
		WebElement ad2 = rp.getAddress2();
		sendValues(ad2, a2);
		log.info("Successfully entered the "+a2);
		
		WebElement cities = rp.getCity();
		sendValues(cities, city);
		log.info("Successfully entered the "+city);
		
		WebElement states = rp.getState();
		sendValues(states, state);
		log.info("Successfully entered the "+state);
		
		WebElement pin = rp.getPostalCode();
		sendValues(pin, pCode);
		log.info("Successfully entered the "+pCode);
		
		WebElement countries = rp.getCountry();
		getSelectByVisibleText(countries,country);
		log.info("Successfully selected the "+country);
		
		WebElement userName = rp.getUserName();
		sendValues(userName, uname);
		log.info("Successfully entered the "+uname);
		
		WebElement Password = rp.getPassword();
		sendValues(Password, password);
		log.info("Successfully entered the "+password);
		
		WebElement cpass = rp.getConfirmPassword();
		sendValues(cpass, cpassword);
		log.info("Successfully entered the "+cpassword);
		
		WebElement submit = rp.getSubmitButton();
		getClicked(submit);
		log.info("Clicked on submit button");
		
		WebElement signOff = rp.getSignOff();
		getClicked(signOff);
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		ArrayList<String> array = getExcelData("register", "register");
		
		Object[][] data = new Object[3][13];
		
		data[0][0] = array.get(1);
		data[0][1] = array.get(2);
		data[0][2] = array.get(3);
		data[0][3] = array.get(4);
		data[0][4] = array.get(5);
		data[0][5] = array.get(6);
		data[0][6] = array.get(7);
		data[0][7] = array.get(8);
		data[0][8] = array.get(9);
		data[0][9] = array.get(10);
		data[0][10] = array.get(11);
		data[0][11] = array.get(12);
		data[0][12] = array.get(13);
		
		ArrayList<String> array1 = getExcelData("register", "register1");
		
		data[1][0] = array1.get(1);
		data[1][1] = array1.get(2);
		data[1][2] = array1.get(3);
		data[1][3] = array1.get(4);
		data[1][4] = array1.get(5);
		data[1][5] = array1.get(6);
		data[1][6] = array1.get(7);
		data[1][7] = array1.get(8);
		data[1][8] = array1.get(9);
		data[1][9] = array1.get(10);
		data[1][10] = array1.get(11);
		data[1][11] = array1.get(12);
		data[1][12] = array1.get(13);
		
		ArrayList<String> array2 = getExcelData("register", "register2");
		
		data[2][0] = array2.get(1);
		data[2][1] = array2.get(2);
		data[2][2] = array2.get(3);
		data[2][3] = array2.get(4);
		data[2][4] = array2.get(5);
		data[2][5] = array2.get(6);
		data[2][6] = array2.get(7);
		data[2][7] = array2.get(8);
		data[2][8] = array2.get(9);
		data[2][9] = array2.get(10);
		data[2][10] = array2.get(11);
		data[2][11] = array2.get(12);
		data[2][12] = array2.get(13);
		return data;
	}
	
	@AfterMethod
	public void driverQuit()
	{
		log.debug("Quitting the driver");
		quitDriver();
		log.info("Successfully quit the driver");
	}

}
