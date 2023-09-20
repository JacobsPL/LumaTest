package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage  {

    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    private WebElement signInLink;

    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    private WebElement createAnAccountLink;

    @FindBy (xpath = "//a[@class='logo']")
    private WebElement logo;

    @FindBy (id = "search")
    private WebElement searchBar;

    @FindBy (xpath = "//div[@data-block='minicart']")
    private WebElement cart;

    @FindBy (xpath = "//span[contains(text(),'What')]")
    private WebElement whatsNew;

    @FindBy (xpath = "//span[text()='Women']")
    private WebElement women;

    @FindBy (xpath = "//span[text()='Man']")
    private WebElement men;

    @FindBy (xpath = "//span[text()='Man']")
    private WebElement gear;

    @FindBy (xpath = "//span[text()='Training']")
    private WebElement training;

    @FindBy (xpath = "//span[text()='Sale']")
    private WebElement sale;

    @FindBy (css = "[class='block-promo home-main']")
    private WebElement yogaBanner;

    @FindBy (css = "[class='action more button']")
    private WebElement yogaButton;

    @FindBy (css = "[class='block-promo home-pants']")
    private WebElement pantsBanner;

    @FindBy (css = "[class='block-promo home-t-shirt']")
    private WebElement teesBanner;

    @FindBy (css = "[class='block-promo home-erin']")
    private WebElement erinBanner;

    @FindBy (css = "[class='block-promo home-performance']")
    private WebElement performanceBanner;

    @FindBy (css = "[class='block-promo home-eco']")
    private WebElement ecoBanner;

    @FindBy (xpath ="//ol[@class='product-items widget-product-grid']/li")
    private List<WebElement> hotSellersProductList;


    WebDriver driver;
    Actions action;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }


    public WebElement getYogaBanner(){
        return this.yogaBanner;
    }


    public void hoverOverElement(WebElement element){
        action.moveToElement(element).perform();
    }

    public void redirectFromBanner(WebElement Banner){
        Banner.click();
    }


}
