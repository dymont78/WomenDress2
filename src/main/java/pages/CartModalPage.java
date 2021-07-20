package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartModalPage extends BasePage{

    public CartModalPage(WebDriver driver) {
        super(driver);
    }

    public static final By MODAL_PRODUCT_NAME = By.id("layer_cart_product_title");
    public static final By MODAL_PRODUCT_SIZE = By.id("layer_cart_product_attributes");
    public static final By MODAL_PRODUCT_QTY = By.id("layer_cart_product_quantity");

    @Step("Verify product before adding in cart")
    public boolean isVerifyProduct(String productName, String productSize, String productQty) {
        return
                (productName == driver.findElement(MODAL_PRODUCT_NAME).getText()) &&
                        (productSize == driver.findElement(MODAL_PRODUCT_SIZE).getText()) &&
                        (productQty == driver.findElement(MODAL_PRODUCT_QTY).getText()) ;
    }
}
