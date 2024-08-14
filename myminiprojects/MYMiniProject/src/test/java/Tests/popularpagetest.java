package Tests;

import Pages.HeadersectionPage;
import Pages.Homepage;
import Pages.LoginPage;
import Pages.PopularPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class popularpagetest {
    public WebDriver driver;
    LoginPage loginPage;
    Homepage homePage;
    HeadersectionPage headerSection;
    PopularPage popularPage;
    @BeforeMethod
    @Test
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91850\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");



        loginPage = new LoginPage(driver);
        homePage = new Homepage(driver);
        headerSection=new HeadersectionPage(driver);
        popularPage=new PopularPage(driver);

    }

    @Test(priority = 1)
    public void popularsearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        popularPage.popularnavi().click();
        String expectedurlp="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expectedurlp,driver.getCurrentUrl(),"not displayed");
        driver.close();
    }
    @Test(priority = 2)
    public void moviessearch(){
        loginPage.loginToApplication("rahul","rahul@2021");
        loginPage.submitLink2();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        popularPage.popularnavi().click();
        List<WebElement>popularmovies=popularPage.getPpopularmovieslocator();
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='movie-icon-item']")));
      for(WebElement movie:popularmovies){
         Assert.assertTrue(movie.isDisplayed(),"some movies are not displayed");
        }
        WebElement movielink=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/li[5]/a/img"));
        movielink.click();
        WebElement popularpage= driver.findElement(By.xpath("//h1[text()='The Amazing Spider-Man']"));
        Assert.assertTrue(popularpage.isDisplayed(),"both are not matching");
        driver.close();






    }
    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}






