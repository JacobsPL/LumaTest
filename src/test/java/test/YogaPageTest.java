package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YogaPage;

import java.util.Arrays;
import java.util.List;

public class YogaPageTest extends BaseTest{



    @Test
    public void verifyThatItemListLengthIsCorrect(){
        YogaPage yogaPage = new YogaPage(driver);
        int displayedItems = yogaPage.getItemList().size();
        int selectedShowItemsPerPage = Integer.parseInt(yogaPage.getSelectedNumberPerPage().getAttribute("value"));
        Assert.assertEquals(displayedItems,selectedShowItemsPerPage);
    }

    @Test
    public void verifyAddingItemToCart(){
        YogaPage yogaPage = new YogaPage(driver);
        WebElement signleItem = yogaPage.getItemList().get(0);
        signleItem.click();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.printSizeList();

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
