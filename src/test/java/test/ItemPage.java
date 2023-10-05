package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPage {

   // List<String> sizeList;
    WebDriver driver;

    @FindAll(@FindBy( css = "[class='swatch-option text']"))
    private List<WebElement> sizeBoxes;
    @FindAll(@FindBy( css = "[class='swatch-option color']"))
    private List<WebElement> colorBoxes;

    @FindBy(id = "qty")
    private WebElement quantityInputBox;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy( css = "[class='count']")
    public WebElement cartCounter;

    @FindBy (css = "[class='action showcart']")
    public WebElement cartIcon;
    public ItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    List <String> getSizeList(){
        List<String> sizeList = new ArrayList<>();
        for (WebElement i:sizeBoxes) {
            sizeList.add(i.getAttribute("textContent"));
        }
        return sizeList;
    }

    List<String> getColorList(){
        List<String> colorList = new ArrayList<>();
        for (WebElement i:colorBoxes) {
            colorList.add(i.getAttribute("textContent"));
        }
        return colorList;

    }

    public void printSizeList(){
        System.out.println(Arrays.toString(getSizeList().toArray()));
    }
    public void printColorList(){
        System.out.println(Arrays.toString(getColorList().toArray()));
    }

    public WebElement getNewSizeButton(String size){

        WebElement sizeButton = driver.findElement(By.cssSelector("[aria-label='"+size+"']"));
        return  sizeButton;
    }
    public WebElement getNewColorButton(String color){

        WebElement sizeButton = driver.findElement(By.cssSelector("[aria-label='"+color+"']"));
        return  sizeButton;
    }
    public void setItemsQuantity(int quantity){
        quantityInputBox.click();
        quantityInputBox.clear();
        quantityInputBox.sendKeys(String.valueOf(quantity));
    }

    public void addItemToCart(){
        addToCartButton.click();
    }

    // TO BE DONE - Works only if there is already item in cart and the cart is not loading new item \/
    public int getCartCount(){
        cartIcon.click();
        System.out.println(cartCounter.getText());
        return Integer.parseInt(cartCounter.getText());
    }

}
