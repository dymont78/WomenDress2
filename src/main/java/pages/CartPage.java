package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_TITLE = By.id("cart_title");
    public static final By ORDER_STEP = By.id("order_step");

    @Step("Open cart page")
    public CartPage openPage(){
        super.openPage(CART_URL);
        return this;
    }

    @Step("Open cart page")
    public boolean isCartPageOpened(){
        return driver.findElement(CART_TITLE).isDisplayed() && driver.findElement(ORDER_STEP).isDisplayed();
    }
}
