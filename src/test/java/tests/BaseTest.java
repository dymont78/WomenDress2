package tests;

import constants.ITestConstants;
import pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    @AfterMethod
//    public void endTest(){
//        driver.quit();
//    }

    public void initPages(){
        signInPage = new SignInPage(driver);
        accountPage = new AccountPage(driver);
        productPage = new ProductPage(driver);
        searchPage = new SearchPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartModalPage = new CartModalPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
    }
}
