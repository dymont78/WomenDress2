package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ProductCardPage extends BasePage {

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_CARD = "//ul[@id = 'homefeatured']//*[contains(text(), '%s')]";
    public static final By NAME_PRODUCT = By.xpath("//h1");
    public static final By PRICE_PRODUCT = By.id("our_price_display");
    public static final By PRODUCT_QUANTITY = By.id("quantity_wanted");
    public static final By PRODUCT_SIZE = By.id("group_1");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//span[text() = 'Add to cart']");

    @Step("Open product card")
    public ProductCardPage openProductPage(String productName) {
        openPage(LOGIN_URL);
        driver.findElement(By.xpath(String.format(PRODUCT_CARD, productName))).click();
        return this;
    }

    @Step("Product card name block checking")
    public boolean isNameChecked(String productName) {
        return productName.equals(driver.findElement(NAME_PRODUCT).getText());
    }

    @Step("Product card price block checking")
    public boolean isPriceChecked(String productPrice) {
        return productPrice.equals(driver.findElement(PRICE_PRODUCT).getText());
    }


    @Step("Set product properties")
    public CartModalPage setProductProperties(String quantity, String size) {
        WebElement qty = driver.findElement(PRODUCT_QUANTITY);
        qty.clear();
        qty.sendKeys(quantity);
        Select dropdownSize = new Select(driver.findElement(PRODUCT_SIZE));
        dropdownSize.selectByVisibleText(size);
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new CartModalPage(driver);
    }
}
