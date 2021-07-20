package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Check: search product")
    public void searchProductTest() {
        String nameProduct = productPage
                .openPage()
                .searchProduct("Faded Short Sleeve T-shirts")
                .searchProductName();
        Assert.assertEquals(nameProduct, "Faded Short Sleeve T-shirts");
    }

    @Test(description = "Check: card product")
    public void productCardTest() {
        productCardPage
                .openProductPage("Faded Short Sleeve T-shirts");
        Assert.assertTrue(productCardPage.isBlockChecked("Faded Short Sleeve T-shirts", "$16.51"));
    }

    @Test(description = "Check: add product to cart")
    public void addProductToCartTest() {
        productCardPage
                .openProductPage("Faded Short Sleeve T-shirts")
                .setProductProperties("2", "M");
        Assert.assertTrue(cartModalPage.isVerifyProduct("Faded Short Sleeve T-shirts", "Orange, M","2"));

    }
}