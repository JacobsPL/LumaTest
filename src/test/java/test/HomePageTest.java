package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.YogaPage;

public class HomePageTest extends BaseTest{


    @Test
    public void verifyYogaBannerRedirect(){

        HomePage homePage = new HomePage(driver);
        homePage.redirectFromBanner(homePage.getYogaBanner());

        String destinationURL = driver.getCurrentUrl();
        YogaPage yogaPage = new YogaPage(driver);

        //verifying that Yoga Collection page is open
        Assert.assertEquals(destinationURL,yogaPage.getYogaURL());
    }

    @Test
    public void yogaButtonRedirect(){

        HomePage homePage = new HomePage(driver);
       // homePage.clickOnYogaButton();

        String destinationURL = driver.getCurrentUrl();
        String expectedURL = "https://magento.softwaretestingboard.com/collections/yoga-new.html";

        //verifying that Yoga Collection page is open
        Assert.assertEquals(destinationURL,expectedURL);
    }



}
