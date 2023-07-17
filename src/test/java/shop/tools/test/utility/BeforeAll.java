package shop.tools.test.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BeforeAll {

    public WebDriver driver;
    public WebDriverWait wait;
    public WaitAnd waitAnd;
    public String baseURL;
    ChromeOptions options = new ChromeOptions();

    @BeforeTest
    public void setUp() {

       // options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitAnd = new WaitAnd(wait);
        baseURL = ConfigEnv.config.baseURL();
        driver.get(baseURL);

    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

        String prefix = "error_";
        String errorOnTest = prefix + RandomStringUtils.randomAlphanumeric(5).toLowerCase();

        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(scrFile, new File("./src/test/resources/ScreenshotsFailure/" + errorOnTest + ".png"));
        }
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
