package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignOnPage {
	
	public WebDriver driver;
	
	public SignOnPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By userName = By.name("userName");
	
	By password = By.name("password");
	
	By submitButton = By.name("login");
	
	By registrationForm = By.xpath("//a[@href = 'mercuryregister.php']");
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement getregistrationForm()
	{
		return driver.findElement(registrationForm);
	}

}
