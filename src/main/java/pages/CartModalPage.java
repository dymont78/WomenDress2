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
    public static final By MODAL_FRAME = By.xpath("//*[@id = 'layer_cart']/div[@class = 'clearfix']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//span[@title = 'Continue shopping']");
    public static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@title = 'Proceed to checkout']");


    @Step("Click modal frame")
    public CartModalPage clickModalFrame(){
        driver.findElement(MODAL_FRAME).click();
        return this;
    }

    @Step("Verify product name '{productName}' before adding in cart")
    public boolean isProductNameCorrect(String productName) {
        clickModalFrame();
        return productName.equals(driver.findElement(MODAL_PRODUCT_NAME).getText());
    }

    @Step("Verify product size '{productSize}'before adding in cart")
    public boolean isProductSizeCorrect(String productSize) {
        clickModalFrame();
        return productSize.equals(driver.findElement(MODAL_PRODUCT_SIZE).getText());
    }

    @Step("Verify product Qti '{productQty}' before adding in cart")
    public boolean isProductQtyCorrect(String productQty) {
        clickModalFrame();
        return productQty.equals(driver.findElement(MODAL_PRODUCT_QTY).getText());
    }

    @Step("Click continue shopping button")
    public ProductCardPage clickContinueShoppingButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductCardPage(driver);
    }

    @Step("Click Proceed to checkout button")
    public CartPage clickProceedToCheckoutModalButton(){
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
        return new CartPage(driver);
    }
}
