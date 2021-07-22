package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignTest extends BaseTest{

    @Test(description = "Check: enter login and password")
    public void signInTest() {
        signInPage
                .openPage()
                .signIn(USER_NAME, USER_PASSWORD);
        Assert.assertEquals(signInPage.getAccountName(), "Ivan Ivanov");
    }

    @Test(description = "Check: enabled Sign In Button")
    public void signOutTest() {
        signInPage
                .openPage()
                .signIn(USER_NAME, USER_PASSWORD)
                .signOut();
        Assert.assertTrue(signInPage.isSignInButtonDisplayed());
    }
}