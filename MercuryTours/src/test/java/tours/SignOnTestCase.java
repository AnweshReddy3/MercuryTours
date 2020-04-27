package tours;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.SignOnPage;
import resources.BaseClass;

public class SignOnTestCase extends BaseClass {
	
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
	public void signOnPage(String uname, String pwds)
	{
		SignOnPage so = new SignOnPage(driver);
		
		log.debug("Getting username textbox");
		WebElement un = so.getUserName();
		sendValues(un, uname);
		log.info("Entered the username "+uname);
		
		log.debug("Getting password textbox");
		WebElement pwd = so.getPassword();
		sendValues(pwd, pwds);
		log.info("Entered the username "+pwds);
		
		log.debug("Getting submit button");
		WebElement submit = so.getSubmitButton();
		getClicked(submit);
		log.info("Clicked on submit button");
		
	}
	
	@DataProvider
	public Object[][] getData() throws Exception
	{	
		ArrayList<String> array = getExcelData("SignIn", "register");
		Object[][] data = new Object[3][2];
		
		data[0][0] = array.get(1);
		data[0][1] = array.get(2);
		
		ArrayList<String> array1 = getExcelData("SignIn", "register1");
		
		data[1][0] = array1.get(1);
		data[1][1] = array1.get(2);
		
		ArrayList<String> array2 = getExcelData("SignIn", "register2");
		
		data[2][0] = array2.get(1);
		data[2][1] = array2.get(2);
		
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
