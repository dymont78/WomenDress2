package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Utils.removeDollarSignFromString;

public class PaymentPage extends HeaderPage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public static final By PAY_BY_BANK_BUTTON = By.xpath("//*[@class = 'bankwire']");
    public static final By PAY_BY_CHECK_BUTTON = By.xpath("//*[@class = 'cheque']");
    public static final By CONFIRM_ORDER_BUTTON = By.xpath("//*[text() = 'I confirm my order']");
    public static final By FINAL_PRICE = By.xpath("//span[@class = 'price']");

    @Step("Click button Pay by bank wire")
    public PaymentPage clickPayByBankWireButton(){
        driver.findElement(PAY_BY_BANK_BUTTON).click();
        return this;
    }

    @Step("Click button Pay by check")
    public PaymentPage clickPayByCheckButton(){
        driver.findElement(PAY_BY_CHECK_BUTTON).click();
        return this;
    }

    @Step("Click button Confirm order")
    public PaymentPage clickConfirmOrderButton(){
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }

    @Step("Get final price from order")
    public double getFinalPriceFromOrder(){
        return removeDollarSignFromString(driver.findElement(FINAL_PRICE).getText());
    }

}
