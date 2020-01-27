import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTests {

    WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\AlexK\\IdeaProjects\\decWebdriverTestNG\\src\\test\\resources\\geckodriver.exe");
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test001() {
        driver = new FirefoxDriver();

        String absXPath = "/html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String relativeXpath = "//form/div[1]/div/div[1]/div/div/input[1]";

        String fullXpath0 = "/html/body/div[2]/div/div/form/div[1]/div/input";
        String xpath0 = "//*[@id=\"username\"]";
        String xpath1 = "//input[@name='username']";

        String xpath2 = "//*[@name='username'][@id='username']";
        String xpath3 = "//*[@name='username' and @type='text']";
        String xpath4 = "//input[@name='username' or @type='text']";
        String xpath5 = "//input[contains(@name,'word')]";
        String xpath6 = "//*[starts-with(@name,'user')]";
        String xpath7 = "//*[text()='Log In']";
        String xpath8 = "//input[@type='text'][last()]";
        String xpath9 = "//input[@type='text'][1]";
        String xpath10= "//*[@name='username']/following::input[@type='password']";
        String xpath11= "//*[@type='password']//preceding::input[@name='username']";

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElements(By.xpath(xpath0));
    }
}
