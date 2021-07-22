package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Check: open cart")
    public void verifyOpenCartTest() {
        cartPage
                .openPage();
        Assert.assertTrue(cartPage.isCartPageOpened());
    }

    @Test(description = "Check: delete product from cart and compare total summ")
    public void deleteProductFromCartTest() {
        productSteps.addProductToCart(PRODUCT_NAME_1);
        cartModalPage.clickContinueShoppingButton();
        productSteps.addProductToCart(PRODUCT_NAME_2);
        double totalSummBeforeDelete = cartPage.getTotalSummFromCart();
        cartModalPage
                .clickProceedToCheckoutModalButton()
                .deleteProductFromCart(PRODUCT_NAME_2);
        double totalSummAfterDelete = cartPage.getTotalSummFromCart();
        Assert.assertEquals(totalSummBeforeDelete-totalSummAfterDelete, PRODUCT_PRICE_1);
    }

    @Test(description = "Check: change qty product on cart and compare total summ")
    public void changeQtyProductOnCartTest() {
        productSteps.addProductToCart(PRODUCT_NAME_1);
        cartModalPage.clickProceedToCheckoutModalButton();
        double totalSummBeforeChangeQty = cartPage.getTotalSummFromCart();
        cartPage.setQtyProductOnCart(PRODUCT_NAME_1, "2");
        double totalSummAfterChangeQty = cartPage.getTotalSummFromCart();
        Assert.assertEquals(totalSummAfterChangeQty,totalSummBeforeChangeQty*2);
    }

    @Test(description = "Check: compare total price from cart with total price from bank pay")
    public void PayByBankWireTest() {
        productSteps.addProductToCart(PRODUCT_NAME_1);
        cartModalPage
                .clickProceedToCheckoutModalButton()
                .clickProceedToCheckoutStep1Button()
                .signIn(USER_NAME, USER_PASSWORD);
        cartPage
                .clickProceedToCheckoutStep3Button()
                .clickCheckboxShippingOnStep4()
                .clickProceedToCheckoutStep4Button();
        double priceFromCart = cartPage.getTotalPriceForPayment();
        cartPage
                .clickPayByBankWireButton()
                .clickConfirmOrderButton();
        double priceFromOrder = cartPage.getFinalPriceFromOrder();
        Assert.assertEquals(priceFromCart, priceFromOrder);
    }

    @Test(description = "Check: compare total price from cart with total price from check")
    public void PayByCheckTest() {
        productSteps.addProductToCart(PRODUCT_NAME_1);
        cartModalPage
                .clickProceedToCheckoutModalButton()
                .clickProceedToCheckoutStep1Button()
                .signIn(USER_NAME, USER_PASSWORD);
        cartPage
                .clickProceedToCheckoutStep3Button()
                .clickCheckboxShippingOnStep4()
                .clickProceedToCheckoutStep4Button();
        double priceFromCart = cartPage.getTotalPriceForPayment();
        cartPage
                .clickPayByCheckButton()
                .clickConfirmOrderButton();
        double priceFromOrder = cartPage.getFinalPriceFromOrder();
        Assert.assertEquals(priceFromCart, priceFromOrder);
    }

}
