package shop.tools.test.page_object;

import org.openqa.selenium.By;

public class CheckoutPageObject {

    public static By cartIcon = By.xpath("//span[@id='lblCartCount']");
    public static By proceedCheckoutBtn = By.xpath("//button[contains(@data-test,'proceed-1')]");
    public static By signInProceedBtn = By.xpath("//button[contains(@data-test,'proceed-2')]");
    public static By billingAddressProceedBtn = By.xpath("//button[contains(@data-test,'proceed-3')]");
    public static By paymentMethodOption = By.id("payment-method");
    public static By creditCardOption = By.xpath("//option[contains(text(),'Credit Card')]");
    public static By accountName = By.id("account-name");
    public static By accountNumber = By.id("account-number");
    public static By confirmBtn = By.xpath("//button[contains(text(),'Confirm')]");
    public static By PaymentWasSuccessfulMsg = By.xpath("//div[contains(text(),'Payment was successful')]");

}
