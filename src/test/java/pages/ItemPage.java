package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ItemPage {

   // List<String> sizeList;
    WebDriver driver;

    @FindAll(@FindBy( css = "[class='swatch-option text']"))
    private List<WebElement> sizeBoxesList;

    @FindAll(@FindBy( css = "[class='swatch-option color']"))
    private List<WebElement> colorBoxesList;

    @FindAll(@FindBy( css = "[class='data switch']"))
    private List<WebElement> descriptionTabsList;


    @FindBy(id = "qty")
    private WebElement quantityInputBox;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy( css = "[class='count']")
    private WebElement cartCounter;
    @FindBy (css = "[class='action showcart']")
    private WebElement cartIcon;

    @FindBy (css = "[class='counter']")
    private WebElement numberOfReviews;

    private void goToFirstItemOnYogaPage(){
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getItemList().get(0).click();
    }
    public ItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public List <String> getSizeList(){
        List<String> sizeList = sizeBoxesList
                .stream()
                .map(el->el.getAttribute("textContent"))
                .toList();

        return sizeList;
    }

    public List<String> getColorList(){
        List<String> colorList = colorBoxesList
                .stream()
                .map(el->el.getAttribute("textContent"))
                .toList();
        return colorList;
    }

    public List<String> getDescriptionTabList(){
        List<String> descriptionTabList = descriptionTabsList
                .stream()
                .map(el->el.getAttribute("textContent"))
                .toList();
        return descriptionTabList;
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

    public int getNumberOfReviews(){
        int num = Integer.parseInt(numberOfReviews.getAttribute("textContent"));
        return num;
    }

}
