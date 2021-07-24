package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends HeaderPage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public static final By BUTTON_CART_PROCEED_TO_ADDRESS_PAGE = By.xpath("//button[@name= 'processAddress']");

    @Step("Click button PROCEED_TO_CHECKOUT on cart step 3")
    public ShippingPage clickProceedToCheckoutAddressPageButton(){
        driver.findElement(BUTTON_CART_PROCEED_TO_ADDRESS_PAGE).click();
        return new ShippingPage(driver);
    }
}
