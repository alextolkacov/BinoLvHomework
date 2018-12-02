package delfiRecipeTest.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {
    private final By FOOD = By.xpath(".//a[contains (@class, 'nav-link text-pale-sky p-2') and @href = 'https://www.delfi.lv/eda/']");
    private final By COOKIE = By.xpath(".//a[@class = 'close cookie']");
    private final By HEADER = By.xpath(".//div[@id = 'sticky-header']");
    private final By TOP_INFO = By.xpath(".//div[@class = 'container d-flex align-items-center text-size-3']");
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no header", baseFunc.isElementPresent(HEADER));
        Assert.assertTrue("There is no top info field", baseFunc.isElementPresent(TOP_INFO));
    }

    public void isCookiePresent() {
        baseFunc.getElement(COOKIE);
        if (baseFunc.getElement(COOKIE).isEnabled()) {
            baseFunc.getElement(COOKIE).click();
        }
    }

    public FoodPage clickOnFood() {
        baseFunc.getElement(FOOD).click();
        return new FoodPage(baseFunc);
    }
}
