package resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public static WebDriver driverInitialize() throws Exception 
	{
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src/main/java//utils//data1.properties");
		
		prop.load(fis);
		System.out.println("property file loaded");
		
		String browserName = prop.getProperty("browserName");

		if (browserName.equalsIgnoreCase("chrome")) 
		{
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src/main/java//utils//chromedriver");
			
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//src/main/java//utils//geckodriver");
			
			driver = new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("IE")) 
		{

		}
		return driver;
	}
	
	public static ArrayList<String> getExcelData(String sheetName,String testcaseName) throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/main/java//utils//data.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		int sheets = wb.getNumberOfSheets();

		ArrayList<String> array = new ArrayList<String>();
		
		for(int i=0;i<sheets;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
			{
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int j=0;
				int column=0;
				while(cell.hasNext())
				{
					String value = cell.next().getStringCellValue();
					if(value.equalsIgnoreCase("testcases"))
					{
						column = j;
					}
					j++;
				}
				while(rows.hasNext())
				{
					Row row = rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						Iterator<Cell> cells = row.cellIterator();
						while(cells.hasNext())
						{
							Cell cellValue = cells.next();
							if(cellValue.getCellTypeEnum()==CellType.STRING)
							{
								array.add(cellValue.getStringCellValue());
							}
							else
							{
								array.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
							}
						}
					}
				}
				
			}
			
			wb.close();
		}
		return array;
	}

	public static void getUrl()
	{
		driver.get(prop.getProperty("url"));
	}

	public static String getCurrentUrl() 
	{
		log.debug("Getting the current url");
		String currentUrl = driver.getCurrentUrl();
		log.info("Successfuly got the current url");
		return currentUrl;
	}

	public static void getTitle()
	{
		
		driver.getTitle();
	}

	public static void getPageSource() 
	{
		driver.getPageSource();
	}

	public static void closeDriver() 
	{
		driver.close();
	}

	public static void quitDriver()
	{
		driver.quit();
	}

	public static void getClicked(WebElement element)
	{
		element.click();
	}

	public static void sendValues(WebElement element, String Value) 
	{
		element.sendKeys(Value);
	}
	
	public static void clearValues(WebElement element) 
	{
		element.clear();
	}

	public static String getVisibleText(WebElement element)
	{
		String text = element.getText();
		return text;
	}

	public static String getTagName(WebElement element) 
	{
		String text = element.getTagName();
		return text;
	}

	public static String getAttributeValue(WebElement element, String nameOfLocator) 
	{
		String value = element.getAttribute(nameOfLocator);
		return value;
	}

	public static String getCssValue(WebElement element, String propertyName) 
	{
		String value = element.getCssValue(propertyName);
		return value;
	}

	public static Point getWebElementLocation(WebElement element) 
	{
		Point point = element.getLocation();
		return point;
	}

	public static Dimension getWebElementSize(WebElement element)
	{
		Dimension dimension = element.getSize();
		return dimension;
	}

	public static boolean isElementDisplayed(WebElement element) 
	{
		boolean value = element.isDisplayed();
		return value;
	}

	public static boolean isElementEnabled(WebElement element)
	{
		boolean value = element.isEnabled();
		return value;
	}

	public static boolean isElementSelected(WebElement element)
	{
		boolean value = element.isSelected();
		return value;
	}

	public static void navigateToUrl()
	{
		driver.navigate().to("");
	}

	public static void navigateTo(String url) 
	{
		driver.navigate().to(url);
	}

	public static void navigateBack() 
	{
		driver.navigate().back();
	}

	public static void navigateForward()
	{
		driver.navigate().forward();
	}

	public static void refreshpage() 
	{
		driver.navigate().refresh();
	}

	public static WebElement findElementById(String Id) 
	{
		return driver.findElement(By.id(Id));
	}

	public static WebElement findElementByName(String Name)
	{
		return driver.findElement(By.name(Name));
	}

	public static WebElement findElementByLinkText(String LinkText) 
	{
		return driver.findElement(By.linkText(LinkText));
	}

	public static WebElement findElementByPartialLinkText(String PartialLinkText)
	{
		return driver.findElement(By.partialLinkText(PartialLinkText));
	}

	public static WebElement findElementByTagName(String TagName) 
	{
		return driver.findElement(By.tagName(TagName));
	}

	public static WebElement findElementByClassName(String ClassName) 
	{
		return driver.findElement(By.className(ClassName));
	}

	public static WebElement findElementByCssSelector(String CssSelector)
	{
		return driver.findElement(By.cssSelector(CssSelector));
	}

	public static WebElement findElementXPath(String XPath)
	{
		return driver.findElement(By.xpath(XPath));
	}

	public static List<WebElement> findElementsById(String Id)
	{
		List<WebElement> list = driver.findElements(By.id(Id));
		return list;
	}

	public static List<WebElement> findElementsByName(String Name) 
	{
		List<WebElement> list = driver.findElements(By.name(Name));
		return list;
	}

	public static List<WebElement> findElementsByLinkText(String Linktext)
	{
		List<WebElement> list = driver.findElements(By.linkText(Linktext));
		return list;
	}

	public static List<WebElement> findElementsByPartialLinktext(String PartialLinktext)
	{
		List<WebElement> list = driver.findElements(By.partialLinkText(PartialLinktext));
		return list;
	}

	public static List<WebElement> findElementsByTagName(String TagName)
	{
		List<WebElement> list = driver.findElements(By.tagName(TagName));
		return list;
	}

	public static List<WebElement> findElementsByClassName(String ClassName) 
	{
		List<WebElement> list = driver.findElements(By.className(ClassName));
		return list;
	}

	public static List<WebElement> findElementsByCssSelector(String CssSelector) 
	{
		List<WebElement> list = driver.findElements(By.cssSelector(CssSelector));
		return list;
	}

	public static List<WebElement> findElementsByXPath(String XPath)
	{
		List<WebElement> list = driver.findElements(By.xpath(XPath));
		return list;
	}

	public static void sleepCommand(int time) 
	{
		// halts the execution of script for a specific amount of time in milliseconds
		try {
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.getMessage();
		}
		// this method is discouraged even if the page/web element is loaded, it
		// instructs
		// the browser to wait unnecessarily for the specific amount of time
	}

	public static void pageLoadTimeOut(int time) 
	{
		// we can set the amount of time to wait for a page to load to complete before
		// throwing an error

		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

		// once added in the script, the webdriver instance waits for certain time for
		// every page to get loaded
		// before throwing an exception
	}

	public static void scriptTimeOut(int time) 
	{
		// once added in the script the web driver waits for certain time for every
		// asynchronous script to get
		// executed on the web page before throwing an exception

		driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
	}

	public static void implicitWait(int time) 
	{
		// used to notify the web driver instance to wait for specific time, if any
		// element is readily not
		// available on the webpage

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

		// once added at the beginning of the script, the webdriver will wait for
		// certain time for any element
		// on the web page to be loaded before throwing any exception.
		// once set, the timing will be set for the life of the webdriver instance
		// unless it is changed again
	}

	public static void elementToBeClickable(int time, String XpathLocator)
	{
		// it is a technique used to advise the webDriver instance to stand by the
		// execution till the certain
		// condition is met

		WebDriverWait wait = new WebDriverWait(driver, time);
		// the above line sets the maximum time the webdriver instance will wait for the
		// condition to become true

		wait.until(ExpectedConditions.elementToBeClickable(BaseClass.findElementXPath(XpathLocator)));
		// the above line asks the webdriver instance to wait untill the element is to
		// be clickable on the web page
	}

	public static void elementToBeSelected(int time, String XpathLocator) 
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeSelected(BaseClass.findElementXPath(XpathLocator)));
	}

	public static void frameToBeAvailableAndSwitchTo(int time, String NameLocator)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(BaseClass.findElementXPath(NameLocator)));
	}

	public static void alertIsPresent(int time) 
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/*
	 * public static void fluentWait(int time) 
	 * { 
	 * //it defines the maximum amount of time to wait for a specific condition and 
	 * //frequency with which to check the condition before throwning an exception (or) /
	 * /In other way it tries to find the web element repeatedly at regular intervals of 
	 * time untill the timeout or till the object gets found
	 * Wait wait = new FluentWait(driver).withTimeout(time,
	 * TimeUnit.SECONDS).pollingEvery(time, TimeUnit.SECONDS); 
	 * }
	 */

	public static WebDriver maximizeWindow() 
	{
		driver.manage().window().maximize();
		return driver;
	}

	public static Dimension getSizeOfWindow() 
	{
		Dimension dimension = driver.manage().window().getSize();
		return dimension;
	}

	public static Point getPositionOfWindow() 
	{
		Point point = driver.manage().window().getPosition();
		return point;
	}

	public static void setSizeOfWindow(int size1, int size2) 
	{
		Dimension newDimension = new Dimension(size1, size2);
		driver.manage().window().setSize(newDimension);
	}

	public static void setPositionOfWindow(int point1, int point2) 
	{
		Point newPoint = new Point(point1, point2);
		driver.manage().window().setPosition(newPoint);
	}

	public static void deleteAllCookies() 
	{
		driver.manage().deleteAllCookies();
	}

	public static List<WebElement> getListOfCheckBoxesByXPath(String Xpath)
	{
		List<WebElement> list = BaseClass.findElementsByXPath(Xpath);
		return list;
	}

	public static int getTotalCheckBoxes(String Xpath) 
	{
		List<WebElement> list = BaseClass.findElementsByXPath(Xpath);
		return list.size();
	}

	public static WebElement getCheckBoxByIndexByXPath(String XPath, int index) 
	{
		List<WebElement> list = BaseClass.findElementsByXPath(XPath);
		return list.get(index);
	}

	public static WebElement getCheckBoxByValueByXPath(WebElement button, String XPath, String value)
	{
		List<WebElement> list = BaseClass.findElementsByXPath(XPath);
		
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getAttribute("value").equalsIgnoreCase(value))
			{
				button = list.get(i);
				break;
			}
		}
		return button;
	}

	public static WebElement CheckBoxByValueByXPath(WebElement button, String XPath, String value)
	{
		List<WebElement> list = BaseClass.findElementsByXPath(XPath);
		
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getAttribute("valuee").equalsIgnoreCase(value))
			{
				button = list.get(i);
				break;
			}
		}
		return button;
	}

	public static void getStatusOfCheckBoxes(String Xpath) 
	{
		List<WebElement> list = BaseClass.findElementsByXPath(Xpath);
		
		for (WebElement checkbox : list)
		{
			System.out.println("checkbox " + checkbox.getAttribute("value") + " is selected " + checkbox.isSelected());
		}
	}

	public static void SelectCheckBoxByIndex(String Xpath, int index) 
	{
		List<WebElement> list = BaseClass.findElementsByXPath(Xpath);
		list.get(index).click();
	}

	public static Select createSelectInstance(WebElement element) 
	{
		Select categories = new Select(element);
		return categories;
	}
	
	public static void getSelectByVisibleText(WebElement element, String visibleText)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public static void getSelectByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void getSelectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void getDeSelectByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	public static void getDeSelectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	public static void getDeSelectByVisibleText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public static void getDeSelectAll(WebElement element)
	{
		Select select = new Select(element);
		select.deselectAll();
	}

	public static Alert createInstanceOfAlert() 
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public static void acceptAlert() 
	{
		Alert alert = createInstanceOfAlert();
		alert.accept();
	}

	public static void dismisstAlert() 
	{
		Alert alert = createInstanceOfAlert();
		alert.dismiss();
	}

	public static void getTextOfAlertAlert() 
	{
		Alert alert = createInstanceOfAlert();
		alert.getText();
	}

	public static void enterValuesInPromptBox(String value) 
	{
		Alert alert = createInstanceOfAlert();
		alert.sendKeys(value);
	}

	public static void switchToFrameByIndex(int index) 
	{
		driver.switchTo().frame(index);
	}

	public static void switchToFrameByNameOrId(String NameOrId) 
	{
		driver.switchTo().frame(NameOrId);
	}

	public static void switchtoFrameByWebElement(String XpathLocator) 
	{
		driver.switchTo().frame(driver.findElement(By.xpath(XpathLocator)));
	}

	public static void switchToDefaultContent() 
	{
		driver.switchTo().defaultContent();
	}

	

	public static Actions createActionsInstance() 
	{
		Actions action = new Actions(driver);
		return action;
	}

	public static Action getBuild(WebElement element) 
	{
		Actions action = createActionsInstance();
		Action builder = action.moveToElement(element).click().build();
		return builder;
	}

	public static void getPerform(WebElement element) 
	{
		Actions action = createActionsInstance();
		action.moveToElement(element).click().perform();
	}

	public static void getDoubleClick(WebElement element) 
	{
		Actions action = createActionsInstance();
		action.doubleClick().build().perform();
	}

	public static void getContextClick(WebElement element) 
	{
		Actions action = createActionsInstance();
		action.contextClick(element).perform();
	}

	public static void getDragAndDrop(WebElement element, WebElement source, WebElement target) 
	{
		Actions action = createActionsInstance();
		action.dragAndDrop(source, target);
	}

	public void getScreenShots(String result) throws IOException 
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "//Screenshots//" + result + " " + "screenshot.png");
		FileHandler.copy(scrFile, DestFile);
	}

	public static Robot getRobotClassInstance() throws AWTException 
	{
		Robot robot = new Robot();
		return robot;
	}

	public static void getKeyPressShift(String key) throws AWTException 
	{
		Robot robot = getRobotClassInstance();
		robot.keyPress(KeyEvent.VK_SHIFT);
	}

	public static void getKeyReleaseShift(String key) throws AWTException 
	{
		Robot robot = getRobotClassInstance();
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	public static void getMouseLeftButtonPress(String key) throws AWTException 
	{
		Robot robot = getRobotClassInstance();
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	}

	public static void getMouseLeftButtonRelease(String key) throws AWTException 
	{
		Robot robot = getRobotClassInstance();
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public static void getMouseMove() throws AWTException 
	{
		Robot robot = getRobotClassInstance();
		robot.mouseMove(100, 50);
	}

	public static Set<String> getWindowHandles() 
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
		return allWindowHandles;
	}
	

}
