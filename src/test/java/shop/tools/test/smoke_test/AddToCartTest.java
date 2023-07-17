package shop.tools.test.smoke_test;

import org.testng.annotations.Test;
import shop.tools.test.fun.CustomerFun;
import shop.tools.test.utility.BeforeAll;


public class AddToCartTest extends BeforeAll {

    @Test(priority = 1, description = "Add to Cart Test")
    public void addToCartTest() throws InterruptedException {

        CustomerFun.addTwoProductsToCart(driver, waitAnd, wait);

    }
}
