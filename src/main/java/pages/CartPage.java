package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static utils.Utils.removeDollarSignFromString;

@Log4j2
public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final String DELETE_FROM_CART_BUTTON = "//*[text() = '%s']/ancestor::tr/*[contains(@class, 'cart_delete')]//a";
    public static final By CART_TITLE = By.id("cart_title");
    public static final By ORDER_STEP = By.id("order_step");
    public static final By TOTAL_SUMM_FROM_CART = By.id("total_product");
    public static final String FIELD_QTY = "//*[text() = '%s']/ancestor::tr//input[@type = 'text']";
    public static final By BUTTON_CART_PROCEED_TO_CHECKOUT = By.xpath("//a[@href = 'http://automationpractice.com/index.php?controller=order&step=1']");
    public static final By PAYMENT_TOTAL_PRICE = By.id("total_price");

    @Step("Open cart page")
    public CartPage openPage(){
        super.openPage(CART_URL);
        return this;
    }

    @Step("Open cart page")
    public boolean isCartPageOpened(){
        return driver.findElement(CART_TITLE).isDisplayed() && driver.findElement(ORDER_STEP).isDisplayed();
    }

    @Step("Delete product '{productName}' from cart")
    public CartPage deleteProductFromCart(String productName){
        driver.findElement(By.xpath(String.format(DELETE_FROM_CART_BUTTON, productName))).click();
        return this;
    }

    @Step("Get total summ from cart")
    public double getTotalSummFromCart(){
        //Добавляем sleep, так как нет другой возможности сделать
        //ожидание для обновления данных в таблице. При отсутствии данной команды,
        //считываются необновленные данные
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return removeDollarSignFromString(driver.findElement(TOTAL_SUMM_FROM_CART).getText());
    }

    @Step("Set qty {qty} for product {productName} on cart")
    public void setQtyProductOnCart(String productName, String qty){
        WebElement qtyField = driver.findElement(By.xpath(String.format(FIELD_QTY, productName)));
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 1")
    public SignInPage clickProceedToCheckoutStep1Button(){
        driver.findElement(BUTTON_CART_PROCEED_TO_CHECKOUT).click();
        return new SignInPage(driver);
    }

    @Step("Get total price for payment")
    public double getTotalPriceForPayment(){
        return removeDollarSignFromString(driver.findElement(PAYMENT_TOTAL_PRICE).getText());
    }
}
