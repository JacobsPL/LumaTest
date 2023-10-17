package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest{


    @Test
    public void verifyYogaBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Yoga Collection page is open
        Assert.assertEquals(homePage.getYogaUrl(),homePage.goToPromoPageAndGetURL(homePage.getYogaBanner()));
    }
    @Test
    public void yogaButtonRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Yoga Collection page is open
        Assert.assertEquals(homePage.getYogaUrl(),homePage.goToPromoPageAndGetURL(homePage.getYogaButton()));
    }
    @Test
    public void verifyTeesBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that T-shirts Collection page is open
        Assert.assertEquals(homePage.getTeesUrl(),homePage.goToPromoPageAndGetURL(homePage.getTeesBanner()));
    }
    @Test
    public void verifyPantsBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Pants Collection page is open
        Assert.assertEquals(homePage.getPantsUrl(),homePage.goToPromoPageAndGetURL(homePage.getPantsBanner()));
    }
    @Test
    public void verifyErinBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Erin Collection page is open
        Assert.assertEquals(homePage.getErinUrl(),homePage.goToPromoPageAndGetURL(homePage.getErinBanner()));
    }
    @Test
    public void verifyPerformanceBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Performance Collection page is open
        Assert.assertEquals(homePage.getPerformanceUrl(),homePage.goToPromoPageAndGetURL(homePage.getPerformanceBanner()));
    }
    @Test
    public void verifyEcoBannerRedirect(){
        HomePage homePage = new HomePage(driver);
        //verifying that Eco Collection page is open
        Assert.assertEquals(homePage.getEcoUrl(),homePage.goToPromoPageAndGetURL(homePage.getEcoBanner()));
    }
}
