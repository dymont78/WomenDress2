package tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static pages.SignPage.ACCOUNT_NAME;
import static pages.SignPage.SIGNIN_BUTTON;


public class SignTest extends BaseTest{

    @Test(description = "Check: enter login and password")
    public void signInTest() {
        signPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!");
        Assert.assertEquals(signPage.getAccountName(), "Ivan Ivanov");
    }

    @Test(description = "Check: enabled Sign In Button")
    public void signOutTest() {
        signPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!")
                .signOut();
        Assert.assertTrue(signPage.isAccountLogout());
    }
}