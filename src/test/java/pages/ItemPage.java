package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ItemPage {

    WebDriver driver;

    @FindAll(@FindBy( css = "[class='swatch-option text']"))
    private List<WebElement> sizeBoxesList;

    @FindAll(@FindBy( css = "[class='swatch-option color']"))
    private List<WebElement> colorBoxesList;

    @FindAll(@FindBy( css = "[class='data switch']"))
    private List<WebElement> descriptionTabsList;

    @FindAll(@FindBy( css = "[class='mage-error']"))
    private List<WebElement> errorList;

    @FindAll(@FindBy( xpath = "//input[contains(@id,'Rating')]"))
    private List<WebElement> starsList;

    @FindBy( xpath = "//a[@class='action tocompare']/span")
    private WebElement compareToButtonsList;

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

    @FindBy (id = "nickname_field")
    private WebElement nickNameField;

    @FindBy (id = "summary_field")
    private WebElement summaryField;

    @FindBy (id = "review_field")
    private WebElement reviewField;

    @FindBy (css = "button[class='action submit primary']")
    private WebElement submitReviewButton;

    @FindBy (css = "[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement alertMessage;

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

    public List<String> getErrorList(){
        List<String> errorStringsList = errorList
                .stream()
                .map(el->el.getAttribute("textContent"))
                .toList();
        return errorStringsList;
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

    public void setEmptyQuantity(){
        quantityInputBox.click();
        quantityInputBox.clear();
    }


    public void addItemToCart(){
        addToCartButton.click();
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    // TO BE DONE - Works only if there is already item in cart and the cart is not loading new item \/
    public int getCartCount(){
        cartIcon.click();
        System.out.println(cartCounter.getText());
        return Integer.parseInt(cartCounter.getText());
    }

    public WebElement getCartCounter(){
        return cartCounter;
    }
    public int getNumberOfReviews(){
        int num = Integer.parseInt(numberOfReviews.getAttribute("textContent"));
        return num;
    }

    public void openReviewTab(){
        descriptionTabsList.get(2).click();
    }

    public void setStarReview(int rate) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",starsList.get(rate-1));
    }

    public void setNickname(String name){
        nickNameField.sendKeys(name);
    }

    public void setSummary(String summary){
        summaryField.sendKeys(summary);
    }

    public void setReview(String review){
        reviewField.sendKeys(review);
    }

    public void clickSubmitReviewButton(){
        submitReviewButton.click();
    }

    public String getAlertMessageText(){
        return alertMessage.getAttribute("textContent");
    }

    public WebElement getAlertMessage(){
        return alertMessage;
    }

    public void addItemToCompareFromList(){
        Actions action = new Actions(driver);
        action.moveToElement(compareToButtonsList);
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareToButtonsList);
        compareToButtonsList.click();
    }
}
