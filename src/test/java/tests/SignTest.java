package tests;


import org.testng.annotations.Test;


public class SignTest extends BaseTest{

    @Test(description = "Check: enter login and password")
    public void signInTest() {
        signPage
                .openPage()
                .signIn("td78@mailinator.com", "Ivanov24!");
    }
}
