package shop.tools.test.page_object;

import org.openqa.selenium.By;

public class CustomerRegistrationPageObject {

    //a[contains(text(),'Sign in')]

    public static By signIn = By.xpath("//a[contains(text(),'Sign in')]");
    public static By registerYourAccount = By.xpath("//a[contains(text(),'Register your account')]");
    public static By customerRegistrationTitle = By.xpath("//h3[contains(text(),'Customer registration')]");
    public static By firstNameField = By.id("first_name");
    public static By lastNameField = By.id("last_name");
    public static By dateOfBirth = By.cssSelector("*[data-test=\"dob\"]");
    public static By address = By.id("address");
    public static By postcode = By.id("postcode");
    public static By myCountryOption = By.cssSelector("*[data-test=\"country\"]");
    public static By myCountry = By.xpath("//option[. = 'American Samoa']");
    public static By city = By.id("city");
    public static By state = By.id("state");
    public static By phone = By.id("phone");
    public static By email = By.id("email");
    public static By password = By.id("password");
    public static By registerBtn = By.xpath("//button[contains(text(),'Register')]");



}
