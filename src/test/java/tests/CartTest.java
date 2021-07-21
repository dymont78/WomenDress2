package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Check: open cart")
    public void verifyOpenCartTest() {
        cartPage
                .openPage();
        Assert.assertTrue(cartPage.isOpenCartPage());
    }
}
