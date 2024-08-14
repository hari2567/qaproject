package Tests;

import Pages.HeadersectionPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class headersectiontest {
    public WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    HeadersectionPage headerSection;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91850\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        headerSection=new HeadersectionPage(driver);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
    @Test(priority = 1)
    public void websitelogo(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.logoNavigation().isDisplayed());
        driver.close();
    }
    @Test(priority = 2)
    public void navigationpage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(headerSection.homeNavigation().isDisplayed(),"not dis");
        Assert.assertTrue(headerSection.popularNavigation().isDisplayed(),"not dis");
        driver.close();

    }
    @Test(priority = 3)
    public void testNavigationTOHomeAndPopularPage(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        headerSection.homeNavigation().click();
        String homeurl="https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(homeurl,driver.getCurrentUrl(),"homesection is not matching");
        headerSection.popularNavigation().click();
        String popularuel="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(popularuel,driver.getCurrentUrl(),"popular section is not matching");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement homepageLink=homePage.homeText();
      homepageLink.click();
      String expurl="https://qamoviesapp.ccbp.tech/";
      Assert.assertEquals(driver.getCurrentUrl(),expurl,"doesnot match");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement searchlink=homePage.getSearchlocator();
      searchlink.click();
      String expurl2="https://qamoviesapp.ccbp.tech/search";
      Assert.assertEquals(driver.getCurrentUrl(),expurl2,"didnot match");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      headerSection.avatarNaviagtion().click();
      String avatarurl="https://qamoviesapp.ccbp.tech/account";
      Assert.assertEquals(avatarurl,driver.getCurrentUrl(),"account section is not matching");
      driver.close();
    }

}

