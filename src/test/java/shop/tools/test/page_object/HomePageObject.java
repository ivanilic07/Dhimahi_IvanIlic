package shop.tools.test.page_object;

import org.openqa.selenium.By;

import java.util.HashMap;

public class HomePageObject {

    public static By signIn = By.xpath("//a[contains(text(),'Sign in')]");
    public static By searchFiled = By.xpath("//input[contains(@data-test,'search-query')]");
    public static By searchBtn = By.xpath("//button[contains(@data-test,'search-submit')]");
    public static By clearSearchBtn = By.xpath("//button[contains(text(),'X')]");
    public static By hammerResult = By.xpath("//h5[contains(text(),'Hammer')]");
    public static By  screwdriverOption = By.cssSelector(" *[data-test=\"category-6\"]");
    public static By screwdriverResult = By.xpath("//h5[contains(text(),'Screwdriver')]");
    public static By slider = By.xpath("//body/app-root[1]/div[1]/app-overview[1]/div[3]/div[1]/div[1]/ngx-slider[1]/span[6]");
    public static By sortDropDown = By.cssSelector("*[data-test=\"sort\"]");
    public static By optionNameZtoA = By.xpath("//option[. = 'Name (Z - A)']");
    public static By allNamesInPLP = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-overview[1]/div/div/div/a/div[2]/h5");

}
