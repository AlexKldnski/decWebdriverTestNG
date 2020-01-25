import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class MicEdgeSearch {

    @Test
    public void testMESearch() throws InterruptedException {
        //System.setProperty("webdriver.edge.driver", "C:\\Windows\\WinSxS\\wow64_microsoft-webdriver-server-components_31bf3856ad364e35_10.0.18362.1_none_cf827c8a6da82156\\MicrosoftWebDriver.exe"); //put actual location
            WebDriver driver = new EdgeDriver();
            driver.get("http://www.google.com/");
            Thread.sleep(5000);  // Let the user actually see something!
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("ChromeDriver");
            searchBox.submit();
            Thread.sleep(5000);  // Let the user actually see something!
            driver.quit();
        }
    }
