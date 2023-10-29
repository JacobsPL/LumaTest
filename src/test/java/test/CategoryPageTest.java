package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.ItemPage;

import java.time.Duration;

public class CategoryPageTest extends BaseTest{

    @BeforeMethod
    private void goToFirstCategoryOnHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.getYogaBanner().click();
    }
    @Test
    public void verifyThatItemListLengthIsCorrect() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        int displayedItems = categoryPage.getItemList().size();
        int selectedShowItemsPerPage = categoryPage.getSelectedNumberPerPage();
        Assert.assertEquals(displayedItems,selectedShowItemsPerPage);
    }
    @Test
    public void verifyRedirectToItem() {
        CategoryPage categoryPage = new CategoryPage(driver);
        WebElement singleItem = categoryPage.getItemList().get(0);
        singleItem.click();

        ItemPage itemPage = new ItemPage(driver);

        // Make sure that you are on Item page by assert that all tab from item page are visible
        Assert.assertEquals(itemPage.getDescriptionTabList().get(0),"\n" +
                "Details ");
        Assert.assertEquals(itemPage.getDescriptionTabList().get(1),"\n" +
               "More Information ");
        Assert.assertEquals(itemPage.getDescriptionTabList().get(2),"\n" +
                "Reviews "+itemPage.getNumberOfReviews() + " ");
    }

    //This wait methods needs to be fixed
    @Test
    public void verifyShoppingOptionCanBeExpanded() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        WebElement shoppingOption = categoryPage.getShoppingOptionsList().get(0);

        //sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(x -> shoppingOption.isEnabled());
        shoppingOption.click();

        //sleep(5000)
        wait.until(x -> shoppingOption.isSelected());
        String textExpandable = shoppingOption.getAttribute("aria-expanded");
        Assert.assertEquals(textExpandable,"true");
    }
    @Test
    public void verifyChangeItemsPerPage() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.setNumberOfItemsPerPage("24",categoryPage.getSelectOfNumberPerPage());
        int expectedItemsPerPage = categoryPage.getSelectedNumberPerPage();
        // Assert that number of items has changed in the select box
        Assert.assertEquals(categoryPage.getSelectedNumberPerPage(),expectedItemsPerPage);

        // Assert that actual number of displayed items has changed from default
        verifyThatItemListLengthIsCorrect();
    }
    @Test
    public void verifyPageChange(){
        CategoryPage categoryPage = new CategoryPage(driver);
        int initPageNum = categoryPage.getCurrentPageNumber();
        categoryPage.changeToNextPage();
        int finalPageNum = categoryPage.getCurrentPageNumber();
        Assert.assertEquals(initPageNum + 1, finalPageNum);
    }
}
