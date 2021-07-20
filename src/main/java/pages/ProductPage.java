package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final By SEARCH_INPUT = By.id("search_query_top");
    public static final By SEARCH_BUTTON = By.xpath("//*[@name = 'submit_search']");

    @Step("Open login page")
    public ProductPage openPage(){
        log.info("Open login page, URL " + LOGIN_URL);
        super.openPage(LOGIN_URL);
        return this;
    }

    @Step("Search product")
    public SearchPage searchProduct(String productName){
        driver.findElement(SEARCH_INPUT).sendKeys(productName);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchPage(driver);
    }
}
