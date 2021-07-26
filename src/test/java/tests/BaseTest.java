package tests;

import constants.ITestConstants;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.ProductSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
@Test
public class BaseTest implements ITestConstants {

    WebDriver driver;
    SignInPage signInPage;
    AccountPage accountPage;
    ProductPage productPage;
    SearchPage searchPage;
    ProductCardPage productCardPage;
    CartModalPage cartModalPage;
    CartPage cartPage;
    HeaderPage headerPage;
    ProductSteps productSteps;
    AddressPage addressPage;
    PaymentPage paymentPage;
    ShippingPage shippingPage;

    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver();
        } catch (WebDriverException e) {
            System.out.println("!!!WebDriver is not started");
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }

    public void initPages(){
        signInPage = new SignInPage(driver);
        accountPage = new AccountPage(driver);
        productPage = new ProductPage(driver);
        searchPage = new SearchPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartModalPage = new CartModalPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        productSteps = new ProductSteps(driver);
        addressPage = new AddressPage(driver);
        paymentPage = new PaymentPage(driver);
        shippingPage = new ShippingPage(driver);

    }
}
