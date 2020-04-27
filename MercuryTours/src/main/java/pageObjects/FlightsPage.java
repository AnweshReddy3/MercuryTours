package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	
	public WebDriver driver;
	
	public FlightsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By roundTrip = By.xpath("//input[@value='roundtrip']");
	
	By oneWay = By.xpath("//input[@value='oneway']");
	
	By passengers = By.name("passCount");
	
	By departingFrom = By.name("fromPort");
	
	By fromMonth = By.name("fromMonth");
	
	By fromDay = By.name("fromDay");
	
	By arrivingIn = By.name("toPort");
	
	By toMonth = By.name("toMonth");
	
	By toDay = By.name("toDay");
	
	By economyClass = By.xpath("//input[@value='Coach']");
	
	By businessClass = By.xpath("//input[@value='Business']");
	
	By firstClass = By.xpath("//input[@value='First']");
	
	By airline = By.name("airline");
	
	By continueButton = By.xpath("//input[@name='findFlights']");
	
	By signOff = By.xpath("//a[contains(text(),'SIGN-OFF')]");
	
	public WebElement getRoundTrip()
	{
		return driver.findElement(roundTrip);
	}
	
	public WebElement getOneWay()
	{
		return driver.findElement(oneWay);
	}
	
	public WebElement getPassengers()
	{
		return driver.findElement(passengers);
	}
	
	public WebElement getDepartingFrom()
	{
		return driver.findElement(departingFrom);
	}
	
	public WebElement getFromMonth()
	{
		return driver.findElement(fromMonth);
	}
	
	public WebElement getFromDay()
	{
		return driver.findElement(fromDay);
	}
	
	public WebElement getArrivingIn()
	{
		return driver.findElement(arrivingIn);
	}

	public WebElement getToMonth()
	{
		return driver.findElement(toMonth);
	}
	
	public WebElement getToDay()
	{
		return driver.findElement(toDay);
	}
	
	public WebElement getBusinessClass()
	{
		return driver.findElement(businessClass);
	}
	
	public WebElement getEcocnomyClass()
	{
		return driver.findElement(economyClass);
	}
	
	public WebElement getFirstClass()
	{
		return driver.findElement(firstClass);
	}
	
	public WebElement getAirline()
	{
		return driver.findElement(airline);
	}
	
	public WebElement getContinueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public WebElement getSignOff()
	{
		return driver.findElement(signOff);
	}
}
