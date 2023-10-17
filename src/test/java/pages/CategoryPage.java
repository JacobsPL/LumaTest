package pages;

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

    @FindBy(xpath = "//select[@id='limiter']/option[@selected]")
    private WebElement listOfNumberPerPage;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div[1]/div[4]/div[3]/div/select")
    private WebElement selectOfNumberPerPage;

    @FindBy (css = "[class='counter-number']")
    private WebElement itemsAmountInCart;

    @FindBy (xpath ="/html/body/div[2]/main/div[3]/div[1]/div[4]/div[2]/ul/li[1]")
    private WebElement currentPageNumber;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div[1]/div[4]/div[2]/ul/li[4]/a")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[contains(text(), 'currently reading page')]/../span[2]")
    WebElement spanWithPageNumber;

    //private String yogaURL = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
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

    public List<WebElement> getShoppingOptionsList(){
        return shoppingOptionsList;
    }

    public WebElement getSelectOfNumberPerPage() {
        return selectOfNumberPerPage;
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
    public void setNumberOfItemsPerPage(String numberPerPage, WebElement pageSelector) throws InterruptedException {
        Select selectSelector = new Select(pageSelector);
        sleep(5000);
        selectSelector.selectByValue(numberPerPage);
    }

    public void changeToNextPage(){
        nextPageButton.click();
    }
    public String getCategoryPageURL() {
        return driver.getCurrentUrl();
    }



}
