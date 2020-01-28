import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class w3schoolsXpathTest {
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
    public void test0001() {
        String xpathlink = "//*[@id=\"mySidenav\"]/div/a[38]";
        String linkName = "Learn XPath";
        String winTitle = "XPath Tutorial";
        openBrowser();
        navigateToMainPage();
        checkXpathLink(xpathlink, linkName, winTitle);
    }

    @Test
    public void test0002() {
        String xpath = "//*[@id=\"navbtn_tutorials\"]";
        String name = "TUTORIALS";
        openBrowser();
        navigateToMainPage();
        checkElement(xpath, name);
    }

    private void checkElement(String xpath, String name) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(element.getText(), name, "WebElement name is different from expected "+name);
    }

    private void checkXpathLink(String link, String linkName, String winTitle) {
        WebElement element = driver.findElement(By.xpath(link));
        Assert.assertEquals(element.getText(), linkName, "Link name is not equal to expected: " + linkName);
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(winTitle));
        Assert.assertEquals(driver.getTitle(), winTitle);


    }

    private void navigateToMainPage() {
        driver.get("https://www.w3schools.com/");
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
