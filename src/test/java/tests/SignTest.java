package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignTest extends BaseTest{

    @Test(description = "Check: enter login and password")
    public void signInTest() {
        signInPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!");
        Assert.assertEquals(signInPage.getAccountName(), "Ivan Ivanov");
    }

    @Test(description = "Check: enabled Sign In Button")
    public void signOutTest() {
        signInPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!")
                .signOut();
        Assert.assertTrue(signInPage.isSignInButtonDisplayed());
    }
}