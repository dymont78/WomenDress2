package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductCardPage;
import pages.ProductPage;
import pages.SignInPage;

public class ProductSteps {

    private SignInPage signInPage;
    private ProductPage productPage;
    private ProductCardPage productCardPage;

    public ProductSteps(WebDriver driver) {
        signInPage = new SignInPage(driver);
        productPage = new ProductPage(driver);
        productCardPage = new ProductCardPage(driver);
    }

    @Step("Add product to cart")
    public ProductSteps addProductToCart(String productName){
        productCardPage
                .openPage()
                .clickProductCardButton(productName)
                .clickAddToCardButton()
                .clickModalFrame();
        return this;
    }
}
