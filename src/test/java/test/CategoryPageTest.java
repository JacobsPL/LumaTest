package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.ItemPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class CategoryPageTest extends BaseTest{

    CategoryPage categoryPage;
    @BeforeMethod
    private void goToFirstCategoryOnHomePage(){
        driver.manage().deleteAllCookies();
        HomePage homePage = new HomePage(driver);
        homePage.getYogaBanner().click();
        categoryPage = new CategoryPage(driver);
    }
    @Test
    public void verifyThatItemListLengthIsCorrect() throws InterruptedException {
        categoryPage = new CategoryPage(driver);
        int displayedItems = categoryPage.getItemList().size();
        int selectedShowItemsPerPage = categoryPage.getSelectedNumberPerPage();
        Assert.assertEquals(displayedItems,selectedShowItemsPerPage);
    }
    @Test
    public void verifyRedirectToItem() {
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

    //This wait methods needs to be enchanced - other than that - it works
    @Test
    public void verifyShoppingOptionCanBeExpanded() throws InterruptedException {
        WebElement shoppingOption = categoryPage.getShoppingOptionsList().get(0);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(x -> shoppingOption.());
        sleep(1000);

        shoppingOption.click();
        wait.until(x -> shoppingOption.isDisplayed());
        String textExpandable = shoppingOption.getAttribute("aria-expanded");
        Assert.assertEquals(textExpandable,"true");
    }
    @Test
    public void verifyChangeItemsPerPage() throws InterruptedException {
        categoryPage.setValueInSelector("24",categoryPage.getSelectOfNumberPerPage());
        int expectedItemsPerPage = categoryPage.getSelectedNumberPerPage();
        // Assert that number of items has changed in the select box
        Assert.assertEquals(categoryPage.getSelectedNumberPerPage(),expectedItemsPerPage);

        // Assert that actual number of displayed items has changed from default
        verifyThatItemListLengthIsCorrect();
    }
    @Test
    public void verifyPageChange(){
        int initPageNum = categoryPage.getCurrentPageNumber();
        categoryPage.changeToNextPage();
        int finalPageNum = categoryPage.getCurrentPageNumber();
        Assert.assertEquals(initPageNum + 1, finalPageNum);
    }

    //THAT ONE NEEDS TO BE UPDATED WITH CORRECT WAIT METHODS
    @Test
    public void verifyThatChangeViewToList() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(x->categoryPage.getListButton().isDisplayed());
        //wait above does not work... leaving sleep for now
        sleep(1000);
        categoryPage.changeViewToList();

        int existCheck = driver.findElements(By.cssSelector("[class='modes-mode active mode-grid']")).size();
        Assert.assertEquals(existCheck,0);

    }

    @Test
    public void verifySortingByName()throws InterruptedException{
        categoryPage.setValueInSelector("36",categoryPage.getSelectOfNumberPerPage());

        List<String> listBeforeSorting = new ArrayList<String>();
        for (WebElement x:categoryPage.getItemNamesList()) {
            listBeforeSorting.add(x.getAttribute("textContent"));
        }
        List<String> sortedNameList = listBeforeSorting.stream().sorted().collect(Collectors.toList());
        categoryPage.setValueInSelector("name",categoryPage.getSelectOfSortBy());

        List<String> sortedByNameItemList = new ArrayList<String>();
        for (WebElement x:categoryPage.getItemNamesList()) {
            sortedByNameItemList.add(x.getAttribute("textContent"));
        }
        Assert.assertTrue(sortedNameList.equals(sortedByNameItemList));
    }

}
