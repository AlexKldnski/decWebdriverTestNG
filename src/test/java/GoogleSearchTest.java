import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\AlexK\\IdeaProjects\\decWebdriverTestNG\\src\\test\\resources\\geckodriver.exe");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Parameters({ "queryTextParameter" })
    @Test
    public void test0001(String parameter) {
        String queryText = parameter;

        openBrowser();
        navigateToMainPage();
        typeQuery(queryText);
        submitSearch();
        waitForResultsPage();
        assertResultsPage();
    }

    private void waitForResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
    }

    private void assertResultsPage() {
        boolean isResultStatsDisplayed = driver.findElement(By.id("resultStats")).isDisplayed();
        Assert.assertTrue(isResultStatsDisplayed);
    }

    private void submitSearch() {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.submit();
    }

    private void typeQuery(String textToType) {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys(textToType);
    }

    private void navigateToMainPage() {
        driver.get("https://google.com");
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}