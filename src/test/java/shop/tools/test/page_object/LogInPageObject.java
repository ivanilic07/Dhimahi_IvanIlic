package shop.tools.test.page_object;

import org.openqa.selenium.By;

public class LogInPageObject {

    public static By logInText = By.xpath("//h3[contains(text(),'Login')]");
    public static By email = By.id("email");
    public static By password = By.id("password");
    public static By logInBtn = By.cssSelector("*[data-test=\"login-submit\"");



}
