package utils;

import io.qameta.allure.Step;

public class Utils {

    @Step("Convert string to double with delete '$'")
    public static double removeDollarSignFromString (String stringPrice) {
        return Double.valueOf(stringPrice.replace("$", ""));
    }
}
