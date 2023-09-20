package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPage {

    List<String> sizeList;
    WebDriver driver;

    public ItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        sizeList = getSizeList();
    }

    List <String> getSizeList(){
        List<String> sizeList = new ArrayList<>();
        List<WebElement> sizeBoxes = driver.findElements(By.cssSelector("[class='swatch-option text']"));
        for (WebElement i:sizeBoxes) {
            sizeList.add(i.getAttribute("textContent"));
        }
        return sizeList;
    }

    public void printSizeList(){
        System.out.println(Arrays.toString(sizeList.toArray()));
    }
}
