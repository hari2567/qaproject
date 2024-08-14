package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
  public WebDriver driver;
  public WebDriverWait wait;
  @FindBy(id = "search")
  WebElement searchLocarot;
  @FindBy(className = "search-empty-button")
  WebElement serachiconslocator;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  }

  public WebElement  searchel( ) {
     return searchLocarot;
  }

  public WebElement searchiconLocat() {
    return serachiconslocator;
  }
  public void seraching(String name3) {
    searchLocarot.sendKeys("Titanic");
  }

}




