package tests;

import Pages.SignPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class BaseTest {

    WebDriver driver;
    SignPage signPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
//        String variable = "driver";
//        System.out.println("Setting driver into context with variable name " + variable);
//        context.setAttribute(variable, driver);
//        PageFactory.initElements(driver, this);
    }

    @AfterMethod
//    public void endTest(){
//        driver.quit();
//    }

    public void initPages(){
        signPage = new SignPage(driver);
    }
}
