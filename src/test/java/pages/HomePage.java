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
    private String yogaUrl ="https://magento.softwaretestingboard.com/collections/yoga-new.html";

    @FindBy (css = "[class='block-promo home-pants']")
    private WebElement pantsBanner;
    private String pantsUrl= "https://magento.softwaretestingboard.com/promotions/pants-all.html";

    @FindBy (css = "[class='image']")
    private WebElement teesBanner;
    private String teesUrl="https://magento.softwaretestingboard.com/promotions/tees-all.html";

    @FindBy (css = "[class='block-promo home-erin']")
    private WebElement erinBanner;
    private String erinUrl="https://magento.softwaretestingboard.com/collections/erin-recommends.html";

    @FindBy (css = "[class='block-promo home-performance']")
    private WebElement performanceBanner;
    private String performanceUrl="https://magento.softwaretestingboard.com/collections/performance-fabrics.html";

    @FindBy (css = "[class='block-promo home-eco']")
    private WebElement ecoBanner;
    private String ecoUrl="https://magento.softwaretestingboard.com/collections/eco-friendly.html";

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

    public WebElement getSignInLink() {
        return signInLink;
    }

    public void setSignInLink(WebElement signInLink) {
        this.signInLink = signInLink;
    }

    public WebElement getCreateAnAccountLink() {
        return createAnAccountLink;
    }

    public void setCreateAnAccountLink(WebElement createAnAccountLink) {
        this.createAnAccountLink = createAnAccountLink;
    }

    public WebElement getLogo() {
        return logo;
    }

    public void setLogo(WebElement logo) {
        this.logo = logo;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(WebElement searchBar) {
        this.searchBar = searchBar;
    }

    public WebElement getCart() {
        return cart;
    }

    public void setCart(WebElement cart) {
        this.cart = cart;
    }

    public WebElement getWhatsNew() {
        return whatsNew;
    }

    public void setWhatsNew(WebElement whatsNew) {
        this.whatsNew = whatsNew;
    }

    public WebElement getWomen() {
        return women;
    }

    public void setWomen(WebElement women) {
        this.women = women;
    }

    public WebElement getMen() {
        return men;
    }

    public void setMen(WebElement men) {
        this.men = men;
    }

    public WebElement getGear() {
        return gear;
    }

    public void setGear(WebElement gear) {
        this.gear = gear;
    }

    public WebElement getTraining() {
        return training;
    }

    public void setTraining(WebElement training) {
        this.training = training;
    }

    public WebElement getSale() {
        return sale;
    }

    public void setSale(WebElement sale) {
        this.sale = sale;
    }

    public void setYogaBanner(WebElement yogaBanner) {
        this.yogaBanner = yogaBanner;
    }

    public WebElement getYogaButton() {
        return yogaButton;
    }

    public void setYogaButton(WebElement yogaButton) {
        this.yogaButton = yogaButton;
    }

    public String getYogaUrl() {
        return yogaUrl;
    }

    public void setYogaUrl(String yogaUrl) {
        this.yogaUrl = yogaUrl;
    }

    public WebElement getPantsBanner() {
        return pantsBanner;
    }

    public void setPantsBanner(WebElement pantsBanner) {
        this.pantsBanner = pantsBanner;
    }

    public String getPantsUrl() {
        return pantsUrl;
    }

    public void setPantsUrl(String pantsUrl) {
        this.pantsUrl = pantsUrl;
    }

    public WebElement getTeesBanner() {
        return teesBanner;
    }

    public void setTeesBanner(WebElement teesBanner) {
        this.teesBanner = teesBanner;
    }

    public String getTeesUrl() {
        return teesUrl;
    }

    public void setTeesUrl(String teesUrl) {
        this.teesUrl = teesUrl;
    }

    public WebElement getErinBanner() {
        return erinBanner;
    }

    public void setErinBanner(WebElement erinBanner) {
        this.erinBanner = erinBanner;
    }

    public String getErinUrl() {
        return erinUrl;
    }

    public void setErinUrl(String erinUrl) {
        this.erinUrl = erinUrl;
    }

    public WebElement getPerformanceBanner() {
        return performanceBanner;
    }

    public void setPerformanceBanner(WebElement performanceBanner) {
        this.performanceBanner = performanceBanner;
    }

    public String getPerformanceUrl() {
        return performanceUrl;
    }

    public void setPerformanceUrl(String performanceUrl) {
        this.performanceUrl = performanceUrl;
    }

    public WebElement getEcoBanner() {
        return ecoBanner;
    }

    public void setEcoBanner(WebElement ecoBanner) {
        this.ecoBanner = ecoBanner;
    }

    public String getEcoUrl() {
        return ecoUrl;
    }

    public void setEcoUrl(String ecoUrl) {
        this.ecoUrl = ecoUrl;
    }

    public List<WebElement> getHotSellersProductList() {
        return hotSellersProductList;
    }

    public void setHotSellersProductList(List<WebElement> hotSellersProductList) {
        this.hotSellersProductList = hotSellersProductList;
    }


    public String goToPromoPageAndGetURL(WebElement promo){
        promo.click();
        return driver.getCurrentUrl();
    }


}
