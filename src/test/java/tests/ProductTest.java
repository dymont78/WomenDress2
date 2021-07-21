package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(description = "Check: search product")
    public void searchProductTest() {
        String productName = productPage
                .openPage()
                .searchProduct(PRODUCT_NAME_1)
                .getFirstProductNameFromSearchResult();
        Assert.assertEquals(productName, PRODUCT_NAME_1);
    }

    @Test(description = "Check: card product")
    public void productCardTest() {
        productCardPage
                .openProductPage(PRODUCT_NAME_1);
        Assert.assertTrue(productCardPage.isNameChecked(PRODUCT_NAME_1));
        Assert.assertTrue(productCardPage.isPriceChecked(PRODUCT_PRICE_1));

    }

    @Test(description = "Check: add product to cart")
    public void addProductToCartTest() {
        productCardPage
                .openProductPage(PRODUCT_NAME_1)
                .setProductProperties("2", "M");
        Assert.assertTrue(cartModalPage.isProductNameCorrect(PRODUCT_NAME_1));
        Assert.assertTrue(cartModalPage.isProductSizeCorrect(PRODUCT_SIZE_1));
        Assert.assertTrue(cartModalPage.isProductQtiCorrect(PRODUCT_QTI_1));
    }
}