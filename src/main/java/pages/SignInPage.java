package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.HeaderPage.ACCOUNT_MARKER;

@Log4j2
public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.id("email");
    public static final By PASSWORD_INPUT = By.id("passwd");
    public static final By SIGNIN_BUTTON_HEADER = By.xpath("//*[@class = 'header_user_info']");
    public static final By SIGNIN_BUTTON = By.id("SubmitLogin");
    public static final By ACCOUNT_NAME = By.xpath("//*[@class = 'account']");

    @Step("Fill in {username} and {password}")
    public HeaderPage signIn(String username, String password){
        waitForElementLocated(USERNAME_INPUT, 10);
        log.info(String.format("Fill in username: %s in Login field.", username));
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info(String.format("Fill in password: %s in Login field.", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Click login button");
        driver.findElement(SIGNIN_BUTTON).click();
        waitForElementLocated(ACCOUNT_MARKER, 10);
        return new HeaderPage(driver);
    }

    @Step("Open login page")
    public SignInPage openPage(){
        log.info("Open base page, URL " + BASE_URL);
        super.openPage(BASE_URL);
        driver.findElement(SIGNIN_BUTTON_HEADER).click();
        return this;
    }

    @Step("Get account name")
    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    @Step("Account logout check")
    public boolean isSignInButtonDisplayed() {
        return driver.findElement(SIGNIN_BUTTON).isDisplayed();
    }
}
