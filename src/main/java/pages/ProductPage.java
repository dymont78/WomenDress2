package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductPage extends HeaderPage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public HeaderPage openPage(){
        super.openPage(BASE_URL);
        return new HeaderPage(driver);
    }
}
