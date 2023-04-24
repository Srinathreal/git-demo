package Automation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {
/*
 * <input name='txtusername' id='txtusername' type='text'>	
 * 
 * input = TAGNAME
 * name , id , type = ATTRIBUTES
 * 'txtusername' , 'txtusername' , 'text' = VALUES
 * 
 */
 public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "../AutomationTesting/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		
		//class name (To find multiple elements(slides,banners,..) in the web page.)
		int sliders = driver.findElements(By.className("oxd-main-menu-item-wrapper")).size();
		System.out.println(sliders);
		
		//Tagname (To find multiple links(entire) in the web page.)
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
/*
 * CSS Selectors (cascading style sheets)  Note: Common method - By.cssSelector
 * Tag and id (or) #id
 * Tag and class (or) .class
 * Tag and attribute (or) [attribute=value]
 * Tag ,class, and attribute
 * 		
 */
		
		
		/*                                  
		 * <input type="text" class="inputtext _55r1 _6luy" name="email" id="email" 
		 * data-testid="royal_email" placeholder="Email address or phone number" 
		 * autofocus="1" aria-label="Email address or phone number">
		 * 
		 *                                          //Tag and Id   (# refers id )
		 *                                          
		 * 	driver.findElement(By.cssSelector("input#email")).sendKeys("Admin");   //Tag and Id 
		 *                                                 {OR}
		 * driver.findElement(By.cssSelector("#email")).sendKeys("Admin");                   
		 * 
		 *                                       //Tag and Class (. refers class)
		 *                    
		 * driver.findElement(By.cssSelector("input.inputtext")).sendKeys("Admin");    //Tag and Class
		 *                                                   {OR}
		 * driver.findElement(By.cssSelector(".inputtext")).sendKeys("Admin");                    
		 *                    
		 *                                          //Tag and attribute  ( [ refers Attribute)
		 *                    
		 * driver.findElement(By.cssSelector("input[name=email]")).sendKeys("Admin");          //Tag and attribute           
		 *                                                  {OR}
		 * driver.findElement(By.cssSelector("[name=email]")).sendKeys("Admin");                     
		 * 
		 *                                          //Tag ,class, and attribute
		 * 
		 * driver.findElement(By.cssSelector("input.inputtext[name=email]")).sendKeys("Admin");
		 * 
		 *                  (It is useful in the case of same tagname , class, ..so to differentiate the element we can this
		 *                  combination..)
		 * 
		 */
	
		
		
		driver.get("https://www.facebook.com/");
		//Tag and Id   (# refers id )
		driver.findElement(By.cssSelector("#email")).sendKeys("srinath");
		driver.findElement(By.cssSelector("input#email")).sendKeys("srinath");
	
		//Tag and Class (. refers class)
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("srinath");
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("srinath");
       /*
        * (Here, it'll matches 2 elements but we r using driver.findElement so it returns first element
        * 	which is present in the HTML)
        */
		 //Tag and attribute  ( [ refers Attribute)
		driver.findElement(By.cssSelector("[id=email]")).sendKeys("srinath");
		driver.findElement(By.cssSelector("input[id=email]")).sendKeys("srinath");
		
		 //Tag ,class, and attribute
		driver.findElement(By.cssSelector("input.inputtext[name=email]")).sendKeys("srinath");
		driver.findElement(By.cssSelector("input.inputtext[name=pass]")).sendKeys("srinath");
	 
		/*
		 * X-path - xpath is defined as xml path.  (an address of an element)
		 * Its a syntax or language for hitting any element on the web page using XML Path expression.
		 * Find any element in **HTML DOM**(Documents object module) Structure.
		 * 
		 * 
		 * DOM is an API interface provided by Browser,
		 * When an web page is loaded, the browser creates a document Object Module of the page.
		 * 
		 * 
		 * 
		 * Types:
		 * 1. Absolute xpath (fully xpath)
		 * 
		 *   /html/body/div[1]/div/div[3]/div[1]/img
		 *   Here, we have to navigate each and every single node to identify the element.
		 *   It starts from root node.
		 *   here, we don't use attributes. (note)
		 *   we use only tags/nodes only..
		 *   
		 * 2. Relative  xpath (partial xpath)
		 * 
		 *  //*[@id="divLogo"]/img
		 *    here, we directly hit the element on the DOM.
		 *    
		 *    //--> Entire DOM Structure. (Note)
		 *  here, we use attributes.
		 *  
		 *  Which xpath is preferred? and why?
		 *  Ans: Relative x-path
		 *  
		 *   If any changes in the dom structure (nodes) absolute x-path may not work properly,in that case relative 
		 *   x-path best.
		 *   
		 *   X-path Options: (Dynamically changes occurs in the elements)
		 *   
		 *   1. or  (atleast one should be true)
		 *                               A                             B
		 *   EX:  //input[@id='search' or @name='query']
		 *   
		 *   A true B true = returns the matching element,
		 *   A false B true =returns 
		 *   A true B false = returns 
		 *   A false B false = Not returns
		 *   
		 *  2. and (Both should be true)
		 *  
		 *  A true B true = returns the matching element..
		 *  
		 *  3. contains()  4. starts-with()
		 *  
		 *  normal -- //tagname[@attribute="value"]
		 *  
		 *  using contains -- //tagname[contains(@attribute,"value")]
		 *  
		 *  using starts-with -- //tagname[starts-with(@attribute,"value")]
		 *  
		 *  ex:  //input[@id="start"]
		 *        //input[@id="stop"]
		 *        
		 *        //input[contains(@id,'st')] ---> Dynamic xpath
		 *        //input[starts-with(@id,'st')] ---> Dynamic xpath
		 *        To overcome those cases,
		 *        we use contains method...,and starts-with method also use..
		 *        
		 *        //input[contains(@id,'stop')] ---> static xpath
		 *        //input[starts-with(@id,'start')] ---> static xpath
		 *      
		 *    5. text()
		 *   
		 *   normal -- //tagname[@attribute="value"]
		 *   
		 *   //tagname[text()="textvalue"]
		 *   Ex:
		 *   //a[text()="WOMEN"]
		 *   //a[text()="MEN"]
		 *   //a[text()="TRANS"]
		 *   
		 *  ------------------------------------
		 *  Chained X-path:
		 *  
		 *  ex:   //tagname[@attribute="value"]//tagname[index no.]
		 *         //form[@id='searchbox']//input[4]
		 *                                \or/
		 *         ////form[@id='searchbox']//input[id='apple']
		 *         
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 *  
		 */
		
		
		
		
}
}
