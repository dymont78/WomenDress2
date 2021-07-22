package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final String DELETE_FROM_CART_BUTTON = "//*[text() = '%s']/ancestor::tr/*[@class = 'cart_delete text-center']";
    public static final By CART_TITLE = By.id("cart_title");
    public static final By ORDER_STEP = By.id("order_step");
    public static final By TOTAL_SUMM_FROM_CART = By.id("total_product");
    public static final String FIEAD_QTY = "//*[text() = '%s']/ancestor::tr//input[@type = 'text']";
    public static final By BUTTON_CART_PROCEED_TO_CHECKOUT_STEP1 = By.xpath("//a[@href = 'http://automationpractice.com/index.php?controller=order&step=1']");
    public static final By BUTTON_CART_PROCEED_TO_CHECKOUT_STEP3 = By.xpath("//button[@name= 'processAddress']");
    public static final By BUTTON_CART_PROCEED_TO_CHECKOUT_STEP4 = By.xpath("//button[@name= 'processCarrier']");
    public static final By SHIPPING_CHECKBOX = By.id("cgv");
    public static final By PAYMENT_TOTAL_PRICE = By.id("total_price");
    public static final By PAY_BY_BANK_BUTTON = By.xpath("//*[@class = 'bankwire']");
    public static final By PAY_BY_CHECK_BUTTON = By.xpath("//*[@class = 'cheque']");
    public static final By CONFIRM_ORDER_BUTTON = By.xpath("//*[text() = 'I confirm my order']");
    public static final By FINAL_PRICE = By.xpath("//span[@class = 'price']");

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
        return  this;
    }

    @Step("Get total summ from cart")
    public double getTotalSummFromCart(){
        return convertStringToDouble(driver.findElement(TOTAL_SUMM_FROM_CART).getText());
    }

    @Step("Set qty {qty} for product {productName} on cart")
    public void setQtyProductOnCart(String productName, String qty){
        WebElement qtyField = driver.findElement(By.xpath(String.format(FIEAD_QTY, productName)));
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 1")
    public SignInPage clickProceedToCheckoutStep1Button(){
        driver.findElement(BUTTON_CART_PROCEED_TO_CHECKOUT_STEP1).click();
        return new SignInPage(driver);
    }

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 3")
    public CartPage clickProceedToCheckoutStep3Button(){
        driver.findElement(BUTTON_CART_PROCEED_TO_CHECKOUT_STEP3).click();
        return this;
    }

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 4")
    public CartPage clickProceedToCheckoutStep4Button(){
        driver.findElement(BUTTON_CART_PROCEED_TO_CHECKOUT_STEP4).click();
        return this;
    }

    @Step("Check checkbox shipping on cart step 4")
    public CartPage clickCheckboxShippingOnStep4(){
        WebElement checkboxShipping = driver.findElement(SHIPPING_CHECKBOX);
        if (!checkboxShipping.isSelected()) {
            checkboxShipping.click();
        }
        return this;
    }

    @Step("Convert string to double with delete '$'")
    public double convertStringToDouble (String stringPrice) {
        return Double.valueOf(stringPrice.replace("$", ""));
    }

    @Step("Get total price for payment")
    public double getTotalPriceForPayment(){
        return convertStringToDouble(driver.findElement(PAYMENT_TOTAL_PRICE).getText());
    }

    @Step("Click button Pay by bank wire")
    public CartPage clickPayByBankWireButton(){
        driver.findElement(PAY_BY_BANK_BUTTON).click();
        return this;
    }

    @Step("Click button Pay by check")
    public CartPage clickPayByCheckButton(){
        driver.findElement(PAY_BY_CHECK_BUTTON).click();
        return this;
    }

    @Step("Click button Confirm order")
    public CartPage clickConfirmOrderButton(){
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }

    @Step("Get final price from order")
    public double getFinalPriceFromOrder(){
        return convertStringToDouble(driver.findElement(FINAL_PRICE).getText());
    }

}
