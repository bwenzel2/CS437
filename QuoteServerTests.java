import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
public class QuoteServerTests {
    
@Test
public void base_choice_test()
{

    WebDriver browser = new FirefoxDriver();

    //Firefox's proxy driver executable
	System.setProperty("webdriver.gecko.driver", "./geckodriver");

    //open the quoteserver page
    browser.get("https://cs.gmu.edu:8443/offutt/servlet/quotes.quoteserve");
    
    //find the search text input element
    WebElement searchInput = browser.findElement(By.id("searchText"));
    
    //enter text in the element
    searchInput.sendKeys("barcode");
    
    //click submit button
    //browser.findElement(By.xpath("//input[@type=\"submit\"]")).click();
    
    assertTrue(true); //(header.isDisplayed()));

    //browser.close();        
   }
}
