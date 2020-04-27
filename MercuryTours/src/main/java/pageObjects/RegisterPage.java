package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By firstName = By.name("firstName");
	
	By lastName = By.name("lastName");
	
	By phoneNumber = By.name("phone");
	
	By emailId = By.id("userName");
	
	By address1 = By.name("address1");
	
	By address2 = By.name("address2");
	
	By city = By.name("city");
	
	By state = By.name("state");
	
	By postalCode = By.name("postalCode");
	
	By country = By.name("country");
	
	By userName = By.id("email");
	
	By password = By.name("password");
	
	By confirmPassword = By.name("confirmPassword");
	
	By submit = By.name("register");
	
	By signIn = By.linkText(" sign-in ");
	
	By homePage = By.linkText("Home");
	
	By flights = By.linkText("Flights");
	
	By hotels = By.linkText("Hotels");
	
	By carRentals = By.linkText("Car Rentals");
	
	By cruises = By.linkText("Cruises");
	
	By destinations = By.linkText("Destinations");
	
	By vacations = By.linkText("Vacations");
	
	By signOn = By.linkText("SIGN-ON");
	
	By register = By.xpath("//a[contains(text(),'REGISTER')]");
	
	By support = By.linkText("SUPPORT");
	
	By contact = By.linkText("CONTACT");
	
	By signOff = By.xpath("//a[contains(text(),'SIGN-OFF')]");
	
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement getPhoneNumber()
	{
		return driver.findElement(phoneNumber);
	}
	
	public WebElement getEmailId()
	{
		return driver.findElement(emailId);
	}

	public WebElement getAddress1()
	{
		return driver.findElement(address1);
	}
	
	public WebElement getAddress2()
	{
		return driver.findElement(address2);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	
	public WebElement getPostalCode()
	{
		return driver.findElement(postalCode);
	}
	
	public WebElement getCountry()
	{
		return driver.findElement(country);
	}
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getConfirmPassword()
	{
		return driver.findElement(confirmPassword);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submit);
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getHomePage()
	{
		return driver.findElement(homePage);
	}
	
	public WebElement getFlights()
	{
		return driver.findElement(flights);
	}
	
	public WebElement getHotels()
	{
		return driver.findElement(hotels);
	}
	
	public WebElement getCarRentals()
	{
		return driver.findElement(carRentals);
	}
	
	public WebElement getCruises()
	{
		return driver.findElement(cruises);
	}
	
	public WebElement getDestinations()
	{
		return driver.findElement(destinations);
	}
	
	public WebElement getvacations()
	{
		return driver.findElement(vacations);
	}
	
	public WebElement getSignOn()
	{
		return driver.findElement(signOn);
	}
	
	public WebElement getRegister()
	{
		return driver.findElement(register);
	}
	
	public WebElement getSupport()
	{
		return driver.findElement(support);
	}
	
	public WebElement getContact()
	{
		return driver.findElement(contact);
	}
	
	public WebElement getSignOff()
	{
		return driver.findElement(signOff);
	}
}
