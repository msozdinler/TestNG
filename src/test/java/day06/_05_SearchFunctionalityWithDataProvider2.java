package day06;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _05_SearchFunctionalityWithDataProvider2 extends DriverClass {
    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        return new Object[][]{
                {"mac"},
                {"samsung"},
                {"ipod"}
        };
    }

    @Test(dataProvider = "searchData")
    @Parameters("searchKeyword")
    public void testSearch(String searchKeyword) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(searchKeyword);
        driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(searchKeyword), "Search result for " + searchKeyword + " not found");
    }
}


