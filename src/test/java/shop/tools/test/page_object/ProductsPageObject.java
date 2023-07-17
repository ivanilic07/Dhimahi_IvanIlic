package shop.tools.test.page_object;

import org.openqa.selenium.By;

public class ProductsPageObject {

    public static By addToCartBtn = By.xpath("//button[@id='btn-add-to-cart']");
    public static By addToCartMessage = By.xpath("//div[contains(text(),'Product added to shopping cart.')]");
    public static By cartIcon = By.xpath("//span[@id='lblCartCount']");


}
