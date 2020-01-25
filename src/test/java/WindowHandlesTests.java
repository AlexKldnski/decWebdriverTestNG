import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlesTests {

    WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\AlexK\\IdeaProjects\\decWebdriverTestNG\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }


    //TODO: automate a different scenario
    @Test
    public void test002() {

    }

    @Test
    public void test001() throws InterruptedException {
        openMainPage("https://the-internet.herokuapp.com/windows");

        clickLink("Click Here");

        //TODO: change to explicit wait
        //Thread.sleep(5000);
        //waitForNewWindowAndSwitchToIt(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //TODO: Collections, HashSets, LinkedLists
        //http://cs.stmarys.ca/~porter/csc/341/notes/JavaCollections.html

        Set<String> windowHandles = driver.getWindowHandles();

        assertNumberOfWindows(windowHandles, 2);

        String[] winNamesArray = {"The Internet", "New Window"};

        verifyWindowNames(windowHandles, winNamesArray);

    }

    private void verifyWindowNames(Set<String> windowHandles, String[] winNamesArray) {

        Object[] arrayOfHandles = windowHandles.toArray();

        Assert.assertEquals(windowHandles.size(), winNamesArray.length, "Amount of windows is not equal to amount of window names");

        for (int i=0; i<windowHandles.size(); i++ ){
            driver.switchTo().window((String) arrayOfHandles[i]);
            Assert.assertEquals(driver.getTitle(), winNamesArray[i], "Window name doesn't match expected: " + winNamesArray[i]);
        }

    }

    private void assertNumberOfWindows(Set<String> windowHandles, int expectedNumberOfWindows) {

        int size = windowHandles.size();
        Assert.assertEquals(size, expectedNumberOfWindows, "Amount of windows is not " + expectedNumberOfWindows);
    }

    private void clickLink(String linkText) {
        driver.findElement(By.partialLinkText(linkText)).click();
    }

    private void openMainPage(String link) {
        driver.get(link);
        driver.manage().window().maximize();
    }
}
