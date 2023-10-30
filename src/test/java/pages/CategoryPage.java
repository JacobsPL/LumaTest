package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class CategoryPage {

    @FindAll(@FindBy( css = "[class='filter-options-title']"))
    private List<WebElement> shoppingOptionsList;
    @FindBy(xpath = "//ol[@class='products list items product-items']/li")
    private List<WebElement> itemList;

    @FindBy(xpath = "//ol[@class='products list items product-items']/li/div/div/strong/a")
    private List<WebElement> itemNamesList;
    @FindBy(xpath = "//select[@id='limiter']/option[@selected]")
    private WebElement listOfNumberPerPage;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div[1]/div[4]/div[3]/div/select")
    private WebElement selectOfNumberPerPage;
    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/select")
    private WebElement selectOfSortBy;

    @FindBy (css = "[class='counter-number']")
    private WebElement itemsAmountInCart;

    @FindBy (xpath ="/html/body/div[2]/main/div[3]/div[1]/div[4]/div[2]/ul/li[1]")
    private WebElement currentPageNumber;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div[1]/div[4]/div[2]/ul/li[4]/a")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[contains(text(), 'currently reading page')]/../span[2]")
    private WebElement spanWithPageNumber;

    @FindBy(id = "mode-grid")
    private WebElement gridButton;

    @FindBy(id = "mode-list")
    private WebElement listButton;

    @FindBy(css = "[class='modes-mode active mode-grid']")
    private WebElement gridConfirmation;

    @FindBy(css = "[class='modes-mode active mode-list']")
    private WebElement listConfirmation;



    WebDriver driver;
    Actions action;

    public CategoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

   //private Select numberPerPageSelector = new Select(selector);

    public List<WebElement> getItemList() {
        return itemList;
    }

    public List<WebElement> getItemNamesList(){
        return itemNamesList;
    }

    public List<WebElement> getShoppingOptionsList(){
        return shoppingOptionsList;
    }

    @Deprecated
    public WebElement getOptionsFromShoppingListElement(int shoppingListElementIndex){
        WebElement list = driver.findElement(By.xpath("\"//div[@class='filter-options-content']\")["
                +shoppingListElementIndex+"]"));
        return list;
    }

    public WebElement getSelectOfNumberPerPage() {
        return selectOfNumberPerPage;
    }

    public WebElement getSelectOfSortBy(){
        return selectOfSortBy;
    }

    public int getSelectedNumberPerPage() {
        return Integer.parseInt(listOfNumberPerPage.getAttribute("value"));
    }

    public WebElement getListOfNumberPerPage() {
        return listOfNumberPerPage;
    }

    public int getCurrentPageNumber(){
        return  Integer.parseInt(spanWithPageNumber.getAttribute("textContent"));
    }
    public void setValueInSelector(String value, WebElement selector) throws InterruptedException {
        Select selectSelector = new Select(selector);
        sleep(1000);
        selectSelector.selectByValue(value);
    }

    public void changeToNextPage(){
        nextPageButton.click();
    }
    public String getCategoryPageURL() {
        return driver.getCurrentUrl();
    }

    public WebElement getListButton(){
        return listButton;
    }
    public void changeViewToList(){
        listButton.click();
    }
    public void changeViewToGrid(){
        gridButton.click();
    }
    public WebElement getListConfirmation(){
        return listConfirmation;
    }

}
