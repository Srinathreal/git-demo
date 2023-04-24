package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowDOM {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "../AutomationTesting/New Driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https:books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// here, usual methods won't work in shadow DOM
		driver.findElement(By.xpath("//input[@id='input")).sendKeys("hello");
		driver.findElement(By.cssSelector("input#input")).sendKeys("hola");
		WebElement shadowROOT = driver.findElement(By.tagName("book-app"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement ShadowDOM = (WebElement) executor.executeScript("return arguments[0].shadowRoot", shadowROOT);
		WebElement appheader = ShadowDOM.findElement(By.tagName("app-header"));
		WebElement apptoolbar = appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		WebElement bookinputdecorator = apptoolbar.findElement(By.tagName("book-input-decorator"));
		bookinputdecorator.findElement(By.cssSelector("input#input")).sendKeys("SRINATH");

		driver.get("https://shop.polymer-project.org/");

	}

};