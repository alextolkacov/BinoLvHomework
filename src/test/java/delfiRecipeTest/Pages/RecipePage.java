package delfiRecipeTest.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RecipePage {
    private final By INREDIENTS = By.xpath(".//div[@class = 'ing-list']/div/a");
    private final By RECIPE_NAME = By.xpath(".//h1[@class = 'article-title']");
    private final By ADS = By.xpath(".//*[@id = 'ads']");
    private final By HEADER = By.xpath(".//div[@id = 'sticky-header']");
    BaseFunc baseFunc;

    public RecipePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no advertisment", baseFunc.isElementPresent(ADS));
        Assert.assertTrue("There is no header", baseFunc.isElementPresent(HEADER));
    }

    public String getRecipeText() {
        return baseFunc.getElement(RECIPE_NAME).getText();
    }

    public IngredientPage clickOnIngredient(int id) {
        baseFunc.getElements(INREDIENTS).get(id).click();
        return new IngredientPage(baseFunc);
    }

    public void checkIngredients() {
        List<WebElement> ingredients = baseFunc.getElements(INREDIENTS);
        List<String> links = new ArrayList<String>();
        for (int i = 0; i < ingredients.size(); i++) links.add(ingredients.get(i).getAttribute("href"));
    }
}
