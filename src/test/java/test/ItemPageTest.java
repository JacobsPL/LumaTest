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

    ItemPage itemPage;
    @BeforeMethod
    private void goToFirstItemOnFirstCategoryFromHomePage(){
        driver.manage().deleteAllCookies();
        HomePage homePage = new HomePage(driver);
        homePage.getYogaBanner().click();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getItemList().get(0).click();
        itemPage = new ItemPage(driver);
    }

    @Test
    public void verifyAddingItemToCart() throws InterruptedException {

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

    @Test
    public void verifyErrorMessageIfSizeNotChosen() throws InterruptedException {
        sleep(2000);
        itemPage.addItemToCart();

        String sizeErrorMessage = itemPage.getErrorList().get(0);
        System.out.println(sizeErrorMessage);
        Assert.assertEquals(sizeErrorMessage,"This is a required field.");
    }
    @Test
    public void verifyErrorMessageIfColorNotChosen() throws InterruptedException {
        sleep(2000);
        itemPage.addItemToCart();

        String colorErrorMessage = itemPage.getErrorList().get(1);
        System.out.println(colorErrorMessage);
        Assert.assertEquals(colorErrorMessage,"This is a required field.");
    }
    @Test
    public void verifyErrorMessageIfAmountNotChosen() throws InterruptedException {

        itemPage.setEmptyQuantity();
        sleep(2000);
        itemPage.addItemToCart();

        String noAmountErrorMessage = itemPage.getErrorList().get(2);
        System.out.println(noAmountErrorMessage);
        Assert.assertEquals(noAmountErrorMessage,"Please enter a valid number in this field.");
    }
    @Test
    public void verifyErrorMessageIfAmountMoreThen10000() throws InterruptedException {

        itemPage.setItemsQuantity(10001);
        sleep(2000);
        itemPage.addItemToCart();

        String noAmountErrorMessage = itemPage.getErrorList().get(2);
        System.out.println(noAmountErrorMessage);
        Assert.assertEquals(noAmountErrorMessage,"The maximum you may purchase is 10000.");
    }

    @Test
    public void verifyAddingReview() throws InterruptedException {
        itemPage.openReviewTab();
        itemPage.setStarReview(5);
        itemPage.setNickname("Jeff");
        itemPage.setSummary("My name is");
        itemPage.setReview("And his name is John Cenaaaaa!!!!!");
        itemPage.clickSubmitReviewButton();

        sleep(5000);
        Assert.assertEquals(itemPage.getAlertMessage(),"You submitted your review for moderation.");
    }

    // DOES NOT WORK - DONT KNOW WHY.
    @Test
    public void verifyComparingProducts() throws InterruptedException {
        itemPage.addItemToCompareFromList(1);
        String confirmationMessage = itemPage.getAlertMessage();
        System.out.println(confirmationMessage);
        sleep(5000);
    }

}
