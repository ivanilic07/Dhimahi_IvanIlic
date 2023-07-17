package shop.tools.test.smoke_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.tools.test.page_object.HomePageObject;
import shop.tools.test.utility.BeforeAll;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchAndFilterTest extends BeforeAll {

    @Test(priority = 1, description = "Search And Filter Test")
    public void searchAndFilterTest() throws InterruptedException {

        //Search
        waitAnd.click(HomePageObject.searchFiled);
        driver.findElement(HomePageObject.searchFiled).sendKeys("Hammer");
        waitAnd.click(HomePageObject.searchBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageObject.hammerResult));
        waitAnd.click(HomePageObject.clearSearchBtn);
        Thread.sleep(2000);

        //By Category
        waitAnd.click(HomePageObject.screwdriverOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageObject.screwdriverResult));
        waitAnd.click(HomePageObject.screwdriverOption);

        //Price Range
        WebElement slider = driver.findElement(HomePageObject.slider);
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 30, 0).build();
        action.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'122')]")));
        Thread.sleep(2000);

        //Sort (Name (Z - A)'])
        WebElement dropdown = driver.findElement(HomePageObject.sortDropDown);
        dropdown.findElement(HomePageObject.optionNameZtoA).click();
        Thread.sleep(2000);

        ArrayList<String> FirstList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(HomePageObject.allNamesInPLP);
        //Assert that list is not empty
        Assert.assertTrue(elementList.size() > 0);
        System.out.println("Name from the Toolshop");
        for (WebElement first : elementList) {

            FirstList.add(first.getText());
            System.out.println(first.getText());
        }

        ArrayList<String> SortedList = new ArrayList<>(FirstList);
        Collections.sort(SortedList);
        Collections.reverse(SortedList);
        System.out.println("Sorted list in Ascending order");
        for (String first : SortedList) {
            System.out.println(first);
        }
        Assert.assertEquals(FirstList, SortedList);

    }
}