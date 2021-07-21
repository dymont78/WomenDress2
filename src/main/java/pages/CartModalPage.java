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

    @Step("Click modal frame")
    public void clickModalFrame(){
        driver.findElement(MODAL_FRAME).click();
    }

    @Step("Verify product name before adding in cart")
    public boolean isProductNameCorrect(String productName) {
        clickModalFrame();
        String s1 = driver.findElement(MODAL_PRODUCT_NAME).getText();
        return productName.equals(s1);
    }

    @Step("Verify product size before adding in cart")
    public boolean isProductSizeCorrect(String productSize) {
        clickModalFrame();
        String s1 = driver.findElement(MODAL_PRODUCT_SIZE).getText();
        return productSize.equals(s1);
    }

    @Step("Verify product Qti before adding in cart")
    public boolean isProductQtiCorrect(String productQti) {
        clickModalFrame();
        String s1 = driver.findElement(MODAL_PRODUCT_QTY).getText();
        return productQti.equals(s1);
    }

}
