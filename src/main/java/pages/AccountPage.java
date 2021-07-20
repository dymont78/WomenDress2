package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By ACCOUNT_MARKER = By.xpath("//*[@class = 'page-heading']");
    public static final By SIGNOUT_BUTTON = By.xpath("//*[@class = 'logout']");


    public void signOut(){

        waitForElementLocated(ACCOUNT_MARKER, 10);
        driver.findElement(SIGNOUT_BUTTON).click();
//        return this;
    }
}
