package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.ItemPage;

import static java.lang.Thread.sleep;

public class ItemPageTest extends BaseTest{

    @BeforeMethod
    private void goToFirstItemOnFirstCategoryFromHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.getYogaBanner().click();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getItemList().get(0).click();
    }

    @Test
    public void verifyAddingItemToCart() throws InterruptedException {

        ItemPage itemPage = new ItemPage(driver);
        WebElement sizeButton = itemPage.getNewSizeButton(itemPage.getSizeList().get(0));
        sizeButton.click();

        WebElement colorButton = itemPage.getNewColorButton("Purple");
        colorButton.click();

        int addingQuantity = 3;
        itemPage.setItemsQuantity(addingQuantity);
        itemPage.addItemToCart();

        //Kinda works - need more elegant solution
        sleep(5000);
        int finalCartCount = itemPage.getCartCount();

        //Assert that added items to the empty cart are equal to the cart size
        Assert.assertEquals(addingQuantity,finalCartCount);
    }
}
