package delfiRecipeTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class BaseFunc {

    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "C://QAGuru/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.contains("htts://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assert.assertFalse("Element is not found", getElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public boolean isElementPresent(By locator) {
        return getElements(locator).isEmpty();
    }

    public void waitLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements());
    }
}
