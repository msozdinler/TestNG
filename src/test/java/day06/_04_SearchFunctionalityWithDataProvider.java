package day06;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _04_SearchFunctionalityWithDataProvider extends DriverClass {

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        return new Object[][]{
                {"mac"},
                {"samsung"},
                {"ipod"}
        };
    }

    @Test(dataProvider = "searchData")
    public void testSearch(String keyword) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(keyword);
        driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(keyword), "Search result for " + keyword + " not found");
    }
}



