package delfiRecipeTest.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class FoodPage {
    private final By RECIPE = By.xpath(".//div[@class = 'col-content pull-left']/div/div/a");
    private final By ADS = By.xpath(".//*[@id = 'ads']");
    private final By HEADER = By.xpath(".//div[@id = 'sticky-header']");
    BaseFunc baseFunc;

    public FoodPage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no advertisment", baseFunc.isElementPresent(ADS));
        Assert.assertTrue("There is no header", baseFunc.isElementPresent(HEADER));
    }

    public RecipePage clickOnRecipe(int i){
        baseFunc.getElements(RECIPE).get(i).click();
        return new RecipePage(baseFunc);
    }
}
