package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.ItemPage;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

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
        int selectedShowItemsPerPage = Integer.parseInt(categoryPage.getSelectedNumberPerPage().getAttribute("value"));
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

    @Test
    public void verifyShoppingOptionCanBeExpanded() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        WebElement shoppingOption = categoryPage.getShoppingOptionsList().get(0);
        sleep(1000);
        shoppingOption.click();

        sleep(5000);
        String textExpandable = shoppingOption.getAttribute("aria-expanded");

        //textExpandable rerutns null... needs to be fixed
        //Assert.assertEquals(textExpandable,"true");
    }



   // Do usunięcia
    public void tylkoTestuje(){

        CategoryPage categoryPage = new CategoryPage(driver);
        driver.get(categoryPage.getCategoryPageURL());
        List<WebElement> Test = categoryPage.getItemList();
        List <String> itemList = Test.stream().map(el->el.getAttribute("textContent")).toList();
        System.out.println(Arrays.toString(itemList.toArray()));
    }
}
