package delfiRecipeTest;

import delfiRecipeTest.Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class DelfiRecipeTest {
    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "https://rus.delfi.lv/";
    private final Logger LOGGER = LogManager.getLogger(DelfiRecipeTest.class);

    @Test
    public void checkRecipesPresent() {
        LOGGER.info("Opening home page");
        baseFunc.openPage(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);
        homePage.isCookiePresent();
        LOGGER.info("Clicking on a FOOD section");
        FoodPage foodPage = homePage.clickOnFood();
        baseFunc.waitLoad();

        LOGGER.info("Selecting recipe");
        RecipePage recipePage = foodPage.clickOnRecipe(1);

        LOGGER.info("Getting recipe name");
        recipePage.getRecipeText();
        LOGGER.info("Checking for ingredients");
        recipePage.checkIngredients();
        LOGGER.info("Clicking on first ingredient");
        IngredientPage ingredientPage = recipePage.clickOnIngredient(0);

        LOGGER.info("Checking for selected recipe name");
        ingredientPage.checkForSelectedRecipeName(recipePage.getRecipeText(), recipePage.checkIngredients());
    }
}
