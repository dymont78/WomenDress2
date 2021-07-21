package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static final By PRODUCT_NAME = By.xpath("//ul[@class = 'product_list grid row']//a[@class = 'product-name']");

    @Step("Get product name from first position")
    public String getFirstProductNameFromSearchResult() {
        List<WebElement> productList = driver.findElements(PRODUCT_NAME);
        return productList.get(0).getText();
    }
}
