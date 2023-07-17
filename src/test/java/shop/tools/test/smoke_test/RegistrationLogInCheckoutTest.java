package shop.tools.test.smoke_test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import shop.tools.test.fun.CustomerFun;
import shop.tools.test.page_object.CheckoutPageObject;
import shop.tools.test.utility.BeforeAll;


public class RegistrationLogInCheckoutTest extends BeforeAll {

    @Test(priority = 1, description = "Customer Registration Test")
    public void customerRegistration() {

        CustomerFun.customerRegistration(driver, wait, waitAnd);

    }

    @Test(priority = 2, description = "LogIn")
    public void logIn() throws InterruptedException {

        CustomerFun.logInNewAccount(driver, waitAnd, wait);

    }

    @Test(priority = 3, description = "Checkout")
    public void checkout() throws InterruptedException {

        //Add Products to Cart
        driver.get(baseURL);
        CustomerFun.addTwoProductsToCart(driver, waitAnd, wait);
        //Proceed to Checkout
        waitAnd.click(CheckoutPageObject.cartIcon);
        waitAnd.click(CheckoutPageObject.proceedCheckoutBtn);
        //Sign In Proceed
        waitAnd.click(CheckoutPageObject.signInProceedBtn);
        //Billing Address Checkout Proceed
        waitAnd.click(CheckoutPageObject.billingAddressProceedBtn);
        //Payment Method Option
        waitAnd.click(CheckoutPageObject.paymentMethodOption);
        waitAnd.click(CheckoutPageObject.creditCardOption);
        driver.findElement(CheckoutPageObject.accountName).sendKeys("MyNameForAccount");
        driver.findElement(CheckoutPageObject.accountNumber).sendKeys("44443333555544441111");
        waitAnd.click(CheckoutPageObject.confirmBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageObject.PaymentWasSuccessfulMsg));
    }
}