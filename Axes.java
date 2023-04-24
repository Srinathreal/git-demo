package Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Axes {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "../AutomationTesting/New Driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://money.rediff.com/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		String text = driver.findElement(By.xpath("//a[text()='YES Bank Ltd.']")).getText();
		// a[text()='YES Bank Ltd.']/self::a -- //self
		// a[contains(text(),'YES Bank Ltd.')]/parent::li
		System.out.println(text);

		// child
		List<WebElement> childelements = driver
				.findElements(By.xpath("//a[contains(text(),'YES Bank Ltd.')]/ancestor::div/child::ul"));
		int size = childelements.size();
		System.out.println(size);

		// parent
		String parentnode = driver.findElement(By.xpath("//a[contains(text(),'YES Bank Ltd.')]/parent::li")).getText();
		System.out.println(parentnode);

		// ancestor
		String ancestor = driver.findElement(By.xpath(
				"//a[contains(text(),'YES Bank Ltd.')]/ancestor::div/ul//li/following::a[text()='Vodafone Idea L']"))
				.getText();
		System.out.println(ancestor);

		// descendent
		String descendent = driver.findElement(By.xpath(
				"//a[contains(text(),'YES Bank Ltd.')]/ancestor::div/descendant::h2//b[text()='MOST TRADED COMPANIES']"))
				.getText();
		System.out.println(descendent);

		System.out.println("----------------------------------");
		// following elements

		driver.findElement(By.xpath(
				"(//div[@class=\"cell\"]/h2/b[text()='MOST TRADED COMPANIES']/following::p[@class=\"alignR\"]/a[text()=\"More \"])[2]"))
				.click();
		List<WebElement> followings = driver.findElements(
				By.xpath("//div[@class=\"f14\"]/following::table[@class=\"dataTable\"]/tbody/tr/td/child::a"));
		for (WebElement webElement : followings) {
			System.out.println(webElement.getText());
		}

		System.out.println(followings);
		// driver.close()

		/*
		 * Axes: Child - Get all **Child element** of the current HTML tag.
		 * 
		 * //*[attribute='value']/child::tagname
		 * 
		 * Parent - Get all **Parent element** of the current HTML tag.
		 * 
		 * //*[attribute='value']/parent::tagname
		 * 
		 * Following - Get all **Element** that comes after the current HTML tag.
		 * 
		 * //*[attribute='value']/following::tagname
		 * 
		 * Preceding - Get all **Nodes** that comes before the current HTML tag.
		 * 
		 * //*[attribute='value']/Preceding::tagname
		 * 
		 * Following-sibling - Traverse (jump) from current html tag to next sibling
		 * HTML tag.
		 * 
		 * //current html
		 * tag[attribute='value']/follwing-sibling::siblingtag[attribute='value']
		 * 
		 * Preceding-sibling - Traverse (jump) from current html tag to Previous sibling
		 * HTML tag.
		 * 
		 * //current html
		 * tag[attribute='value']/preceding-sibling::previoustag[attribute='value']
		 * 
		 * Ancestor - Get all**Ancestor elements**(grandparent,parent,etc..) of the
		 * current HTML tag.
		 * 
		 * //*[attribute='value']/ancestor::tagname
		 * 
		 * Descendent - Get all**Descendent elements**(childnode,grandchildnode,etc..)
		 * of the current HTML tag.
		 * 
		 * //*[attribute='value']/descendent::tagname
		 * 
		 */

	}
}
