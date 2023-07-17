package shop.tools.test.fun;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import shop.tools.test.page_object.CustomerRegistrationPageObject;
import shop.tools.test.page_object.LogInPageObject;
import shop.tools.test.page_object.MyAccountPageObject;
import shop.tools.test.page_object.ProductsPageObject;
import shop.tools.test.utility.ConfigEnv;
import shop.tools.test.utility.WaitAnd;
import java.util.*;

public class CustomerFun {

    public static String prefixFirstName = "myName_";
    public static String prefixLastName = "myLastName_";
    public static String prefixMyEmail = "myEmail_";
    public static String firstName = prefixFirstName + RandomStringUtils.randomAlphanumeric(5).toLowerCase();
    public static String lastName = prefixLastName + RandomStringUtils.randomAlphanumeric(5).toLowerCase();
    public static String myEmail = prefixMyEmail + RandomStringUtils.randomAlphanumeric(7).toLowerCase();

    public static void customerRegistration (WebDriver driver, WebDriverWait wait, WaitAnd waitAnd) {

        waitAnd.click(CustomerRegistrationPageObject.signIn);
        waitAnd.click(CustomerRegistrationPageObject.registerYourAccount);

        wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerRegistrationPageObject.customerRegistrationTitle));
        driver.findElement(CustomerRegistrationPageObject.firstNameField).sendKeys((firstName));
        driver.findElement(CustomerRegistrationPageObject.lastNameField).sendKeys(lastName);
        driver.findElement(CustomerRegistrationPageObject.dateOfBirth).sendKeys("891992");
        driver.findElement(CustomerRegistrationPageObject.address).sendKeys("Best Green 22/A");
        driver.findElement(CustomerRegistrationPageObject.postcode).sendKeys("11000");
        WebElement dropdown = driver.findElement(CustomerRegistrationPageObject.myCountryOption);
        dropdown.findElement(CustomerRegistrationPageObject.myCountry).click();
        driver.findElement(CustomerRegistrationPageObject.city).sendKeys("New York");
        driver.findElement(CustomerRegistrationPageObject.state).sendKeys("NY");
        driver.findElement(CustomerRegistrationPageObject.phone).sendKeys("089334564");
        driver.findElement(CustomerRegistrationPageObject.email).sendKeys(myEmail + "@yopmail.com");
        driver.findElement(CustomerRegistrationPageObject.password).sendKeys(ConfigEnv.config.myPassword());
        waitAnd.click(CustomerRegistrationPageObject.registerBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogInPageObject.logInText));

    }
        public static void logInNewAccount(WebDriver driver, WaitAnd waitAnd, WebDriverWait wait) throws InterruptedException {

            driver.findElement(LogInPageObject.email).sendKeys((myEmail + "@yopmail.com"));
            driver.findElement(LogInPageObject.password).sendKeys(ConfigEnv.config.myPassword());
            waitAnd.click(LogInPageObject.logInBtn);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MyAccountPageObject.myAccountText));

        }

    public static void logInOldAccount(WebDriver driver, WaitAnd waitAnd, WebDriverWait wait) throws InterruptedException {

        driver.findElement(LogInPageObject.email).sendKeys((ConfigEnv.config.myAccount()));
        driver.findElement(LogInPageObject.password).sendKeys(ConfigEnv.config.myOldPassword());
        waitAnd.click(LogInPageObject.logInBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyAccountPageObject.myAccountText));

    }

    public static void addTwoProductsToCart (WebDriver driver, WaitAnd waitAnd, WebDriverWait wait) throws InterruptedException {

        // Create a HashMap
        HashMap<String, String> toolsToSelect = new java.util.HashMap<>();
        toolsToSelect.put("ThorHammer", "//h5[contains(text(),'Thor Hammer')]");
        toolsToSelect.put("SlipJointPliers", "//h5[contains(text(),'Slip Joint Pliers')]");

        //Add First Product
        waitAnd.click(By.xpath(toolsToSelect.get("ThorHammer")));
        waitAnd.click(ProductsPageObject.addToCartBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPageObject.addToCartMessage));

        Thread.sleep(2000);
        driver.get(ConfigEnv.config.baseURL());

        //Add Second Product
        waitAnd.click(By.xpath(toolsToSelect.get("SlipJointPliers")));
        waitAnd.click(ProductsPageObject.addToCartBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPageObject.addToCartMessage));
        Thread.sleep(2000);

        //Assert the Cart Num.
        String myProductsNum = driver.findElement(ProductsPageObject.cartIcon).getText();
        Assert.assertEquals(myProductsNum, "2");

    }
}
