package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By homePage = By.linkText("Home");
	
	By flights = By.xpath("//a[contains(text(),'Flights')]");
	
	By hotels = By.linkText("Hotels");
	
	By carRentals = By.linkText("Car Rentals");
	
	By cruises = By.linkText("Cruises");
	
	By destinations = By.linkText("Destinations");
	
	By vacations = By.linkText("Vacations");
	
	By signOn = By.linkText("SIGN-ON");
	
	By register = By.linkText("REGISTER");
	
	By support = By.linkText("SUPPORT");
	
	By contact = By.linkText("CONTACT");
	
	By userName = By.xpath("//input[@name='userName']");
	
	By password = By.name("password");
	
	By signIn = By.name("login");
	
	By text1 = By.xpath("//font[contains(text(),'Atlanta')]");
	
	By text2 = By.xpath("//font[contains(text(),'Los')]");
	
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
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSignIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getText1()
	{
		return driver.findElement(text1);
	}
	
	public WebElement getText2()
	{
		return driver.findElement(text2);
	}
}
