package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YogaPage;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class YogaPageTest extends BaseTest{



    @Test
    public void verifyThatItemListLengthIsCorrect() throws InterruptedException {
        YogaPage yogaPage = new YogaPage(driver);
        int displayedItems = yogaPage.getItemList().size();
        int selectedShowItemsPerPage = Integer.parseInt(yogaPage.getSelectedNumberPerPage().getAttribute("value"));
        Assert.assertEquals(displayedItems,selectedShowItemsPerPage);
    }

    @Test
    public void verifyAddingItemToCart() throws InterruptedException {
        YogaPage yogaPage = new YogaPage(driver);
        WebElement singleItem = yogaPage.getItemList().get(0);
        singleItem.click();

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

   // Do usunięcia
    public void tylkoTestuje(){

        YogaPage yogaPage = new YogaPage(driver);
        driver.get(yogaPage.getYogaURL());
        List<WebElement> Test = yogaPage.getItemList();
        List <String> itemList = Test.stream().map(el->el.getAttribute("textContent")).toList();
        System.out.println(Arrays.toString(itemList.toArray()));
    }
}
