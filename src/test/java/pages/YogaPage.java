package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class YogaPage {

    @FindBy(xpath = "//ol[@class='products list items product-items']/li")
    private List<WebElement> itemList;

    @FindBy(xpath = "//select[@id='limiter']/option[@selected]")
    private WebElement selectedNumberPerPage;


    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div[1]/div[4]/div[3]/div/select")
    private WebElement selector;

    @FindBy (css = "[class='counter-number']")
    private WebElement itemsNumberCart;

    private String yogaURL = "https://magento.softwaretestingboard.com/collections/yoga-new.html";
    WebDriver driver;
    Actions action;

    public YogaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get(yogaURL);
        action = new Actions(driver);
    }

   //private Select numberPerPageSelector = new Select(selector);

    public List<WebElement> getItemList() {
        return itemList;
    }

    public WebElement getSelectedNumberPerPage() {
        return selectedNumberPerPage;
    }

    public WebElement getSelector() {
        return selector;
    }

    public void setNumberPerPage(String numberPerPage, WebElement pageSelector){
        Select selectSelector = new Select(pageSelector);
        selectSelector.selectByValue(numberPerPage);
    }
    public String getYogaURL() {
        return yogaURL;
    }
}
