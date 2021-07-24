package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By ACCOUNT_MARKER = By.xpath("//*[@class = 'page-heading']");
    public static final By SIGNOUT_BUTTON = By.xpath("//*[@class = 'logout']");
    public static final By SEARCH_INPUT = By.id("search_query_top");
    public static final By SEARCH_BUTTON = By.xpath("//*[@name = 'submit_search']");


    public void signOut(){
        waitForElementLocated(ACCOUNT_MARKER, 10);
        driver.findElement(SIGNOUT_BUTTON).click();
    }

    @Step("Search product '{productName}'")
    public SearchPage searchProduct(String productName){
        driver.findElement(SEARCH_INPUT).sendKeys(productName);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }
}
