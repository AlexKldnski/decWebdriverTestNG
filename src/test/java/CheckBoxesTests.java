import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTests {

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

    //TODO: find a different way of checking checkbox state (checked/unchecked)
    //DONE isSelected method is applied in AssertCheckbox() method


    //TODO: automate a different flow
    @Test
    public void test002() {
        openMainPage();
        By by = By.xpath("//*[@id=\"content\"]/div/h3");
        String headertext = "Checkboxes";
        findHeadermethod(by, headertext);

    }

    private void findHeadermethod(By by, String headertext) {
        WebElement element = driver.findElement(by);
        Assert.assertEquals(headertext, element.getText());
    }

    //TODO: refactor it
    @Test
    public void test001() {
        openMainPage();

        By by = By.tagName("input");
        int qtyOfCheckBoxes = 2;
        boolean[] initialCheckBoxesStateArr = {false, true};

        List<WebElement> listOfInputs = locateCheckBoxes(by);

        checkQtyOfCheckBoxes(listOfInputs, qtyOfCheckBoxes);

        for (int i=0; i<listOfInputs.size(); i++){
            AssertCheckbox(listOfInputs.get(i), initialCheckBoxesStateArr[i]);
        }

    }

    private void checkQtyOfCheckBoxes(List listOfInputs, int qtyOfCheckBoxes) {
        Assert.assertTrue(listOfInputs.size() == qtyOfCheckBoxes, "List of Checkboxes is not equal to " + qtyOfCheckBoxes);
    }

    private void AssertCheckbox(WebElement Element, boolean isBoxChecked) {
        boolean isElementChecked = Element.isSelected();
        Assert.assertEquals(isBoxChecked, isElementChecked, "Initial Checkbox State is not" + isBoxChecked);

        Element.click();

        Assert.assertEquals(Element.isSelected(), !isElementChecked);

        Element.click();
    }

    private List locateCheckBoxes(By by){
        List<WebElement> listOfInputs = driver.findElements(by);
        return listOfInputs;
    };

    private void openMainPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
}