package delfiRecipeTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IngredientPage {
    private final By SELECTED_RECIPE = By.xpath(".//*[@class = 'row article-collection']/div/a/h1");
    private final By ADS = By.xpath(".//*[@id = 'ads']");
    private final By HEADER = By.xpath(".//div[@id = 'sticky-header']");
    BaseFunc baseFunc;

    public IngredientPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no advertisment", baseFunc.isElementPresent(ADS));
        Assert.assertTrue("There is no header", baseFunc.isElementPresent(HEADER));
    }

    public void checkForSelectedRecipeName(String name, List<String> links) {
        for (int id = 0; id < links.size(); id++){
            baseFunc.driver.get(links.get(id));
        }
        List<WebElement> recipes = baseFunc.getElements(SELECTED_RECIPE);
        boolean isRecipeFound = false;
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getText().equals(name)) {
                isRecipeFound = true;
            }
            Assert.assertTrue("No recipe found", isRecipeFound);
        }
    }
}


