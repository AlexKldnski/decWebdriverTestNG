import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.*;
        import org.testng.annotations.Test;


public class GettingStarted {
    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        //WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div/div[5]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchBox.sendKeys("ChromeDriver");
        //searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}