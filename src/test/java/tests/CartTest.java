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
        cartModalPage.clickProceedToCheckoutModalButton();
        double totalSummBeforeDelete = cartPage.getTotalSummFromCart();
        cartPage.deleteProductFromCart(PRODUCT_NAME_2);
        double totalSummAfterDelete = cartPage.getTotalSummFromCart();
        Assert.assertTrue(totalSummAfterDelete != totalSummBeforeDelete);
        Assert.assertTrue(PRODUCT_PRICE_1.equals("$" + Double.toString(totalSummAfterDelete)));
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
        addressPage
                .clickProceedToCheckoutAddressPageButton()
                .clickCheckboxShipping()
                .clickProceedToCheckoutShippingPageButton();
        double priceFromCart = cartPage.getTotalPriceForPayment();
        paymentPage
                .clickPayByBankWireButton()
                .clickConfirmOrderButton();
        double priceFromOrder = paymentPage.getFinalPriceFromOrder();
        Assert.assertEquals(priceFromCart, priceFromOrder);
    }

    @Test(description = "Check: compare total price from cart with total price from check")
    public void PayByCheckTest() {
        productSteps.addProductToCart(PRODUCT_NAME_1);
        cartModalPage
                .clickProceedToCheckoutModalButton()
                .clickProceedToCheckoutStep1Button()
                .signIn(USER_NAME, USER_PASSWORD);
        addressPage
                .clickProceedToCheckoutAddressPageButton()
                .clickCheckboxShipping()
                .clickProceedToCheckoutShippingPageButton();
        double priceFromCart = cartPage.getTotalPriceForPayment();
        paymentPage
                .clickPayByCheckButton()
                .clickConfirmOrderButton();
        double priceFromOrder = paymentPage.getFinalPriceFromOrder();
        Assert.assertEquals(priceFromCart, priceFromOrder);
    }
}
