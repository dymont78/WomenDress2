package tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static Pages.SignPage.ACCOUNT_NAME;
import static Pages.SignPage.SIGNIN_BUTTON;


public class SignTest extends BaseTest{

    @Test(description = "Check: enter login and password")
    public void signInTest() {
        signPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!");
        String accountName = driver.findElement(ACCOUNT_NAME).getText();
        Assert.assertEquals(accountName, "Ivan Ivanov");
    }

    @Test(description = "Check: enabled Sign In Button")
    public void signOutTest() {
        signPage
                .openPage()
                .signIn("td123@mailinator.com", "Ivanov24!")
                .signOut();
        List<WebElement> elementList = driver.findElements(SIGNIN_BUTTON);
        Assert.assertTrue(elementList.size() > 0);
    }
}
