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

import static java.lang.Thread.sleep;

public class ItemPageTest extends BaseTest{

    ItemPage itemPage;
    WebDriverWait wait;
    @BeforeMethod
    private void goToFirstItemOnFirstCategoryFromHomePage(){
        driver.manage().deleteAllCookies();
        HomePage homePage = new HomePage(driver);
        homePage.getYogaBanner().click();
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getItemList().get(0).click();
        itemPage = new ItemPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        wait.until(x->itemPage.getCartCounter().isEnabled());
        int finalCartCount = itemPage.getCartCount();

        //Assert that added items to the empty cart are equal to the cart size
        Assert.assertEquals(addingQuantity,finalCartCount);
    }

    @Test
    public void verifyErrorMessageIfSizeNotChosen() throws InterruptedException {
        wait.until(x->itemPage.getAddToCartButton().isEnabled());
        itemPage.addItemToCart();

        String sizeErrorMessage = itemPage.getErrorList().get(0);
        System.out.println(sizeErrorMessage);
        Assert.assertEquals(sizeErrorMessage,"This is a required field.");
    }
    @Test
    public void verifyErrorMessageIfColorNotChosen() throws InterruptedException {
        wait.until(x->itemPage.getAddToCartButton().isEnabled());
        itemPage.addItemToCart();

        String colorErrorMessage = itemPage.getErrorList().get(1);
        System.out.println(colorErrorMessage);
        Assert.assertEquals(colorErrorMessage,"This is a required field.");
    }
    @Test
    public void verifyErrorMessageIfAmountNotChosen() throws InterruptedException {

        itemPage.setEmptyQuantity();

        wait.until(x->itemPage.getAddToCartButton().isDisplayed());
        itemPage.addItemToCart();

        String noAmountErrorMessage = itemPage.getErrorList().get(2);
        System.out.println(noAmountErrorMessage);
        Assert.assertEquals(noAmountErrorMessage,"Please enter a valid number in this field.");
    }
    @Test
    public void verifyErrorMessageIfAmountMoreThen10000() throws InterruptedException {

        itemPage.setItemsQuantity(10001);
        itemPage.addItemToCart();

        String noAmountErrorMessage = itemPage.getErrorList().get(2);
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

        wait.until(x->itemPage.getAlertMessage().isDisplayed());
        Assert.assertEquals(itemPage.getAlertMessageText(),"You submitted your review for moderation.");
    }

    // DOES NOT WORK - DONT KNOW WHY.
    @Test
    public void verifyComparingProducts() throws InterruptedException {
        // THIS DOES NOT WORK
        driver.get("https://magento.softwaretestingboard.com/zeppelin-yoga-pant.html");
        itemPage.addItemToCompareFromList();
        String confirmationMessage = itemPage.getAlertMessageText();
        System.out.println(confirmationMessage);
        sleep(5000);
    }

}
