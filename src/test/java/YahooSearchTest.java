import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class YahooSearchTest {
    WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testName() {

        openBrowser();
        navigateToMainPage();
        typeQuery();
        submitSearch();
        waitForResultsPage();
        assertResultsPage();
    }

    private void assertResultsPage() {
        boolean isResultDisplayed = driver.findElement(By.className("compPagination")).isDisplayed();
        Assert.assertTrue(isResultDisplayed, "Result is displayed");
    }

    private void waitForResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compPagination")));
    }

    private void submitSearch() {
        WebElement element = driver.findElement(By.cssSelector("#header-desktop-search-button"));
        element.submit();
    }

    private void typeQuery() {
        WebElement element = driver.findElement(By.id("header-search-input"));
        element.sendKeys("Portnov Computer School");
    }

    private void navigateToMainPage() {
        driver.get("https://www.yahoo.com");
    }

    private void openBrowser() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}