package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage extends HeaderPage{

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public static final By BUTTON_CART_PROCEED_TO_CHECKOUT_SHIPPING_PAGE = By.xpath("//button[@name= 'processCarrier']");
    public static final By SHIPPING_CHECKBOX = By.id("cgv");

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 4")
    public ShippingPage clickProceedToCheckoutShippingPageButton(){
        driver.findElement(BUTTON_CART_PROCEED_TO_CHECKOUT_SHIPPING_PAGE).click();
        return this;
    }

    @Step("Check checkbox shipping on cart step 4")
    public ShippingPage clickCheckboxShipping(){
        WebElement checkboxShipping = driver.findElement(SHIPPING_CHECKBOX);
        if (!checkboxShipping.isSelected()) {
            checkboxShipping.click();
        }
        return this;
    }
}
