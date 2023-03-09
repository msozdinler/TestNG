package day03;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class _02_AddressFunctionality extends DriverClass {

    @BeforeMethod
    public void setup() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

    }

    //@AfterClass
    //public void teardown() {
        //driver.quit();
    //}

    @Test
    public void testAddressBook() throws InterruptedException {

//        WebElement emailInput = driver.findElement(By.id("input-email"));
//        emailInput.sendKeys("mert123@gmail.com");
//
//        WebElement passwordInput = driver.findElement(By.name("password"));
//        passwordInput.sendKeys("mert1234");

//        WebElement loginButton = driver.findElement(By.xpath("(//input[@value='Login'])[1]"));
//        loginButton.click();

//        Thread.sleep(2000);

      //  WebElement EditAccountButton = driver.findElement(new By.ByLinkText("Edit Account"));
       // EditAccountButton.click();

        WebElement addressBookLink = driver.findElement(By.linkText("Address Book"));
        addressBookLink.click();

        Thread.sleep(2000);

        WebElement addNewAddressButton = driver.findElement(By.linkText("New Address"));
        addNewAddressButton.click();

        Thread.sleep(2000);

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("Doe");

        WebElement address1Input = driver.findElement(By.name("address_1"));
        address1Input.sendKeys("123 Main St");

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys("Toronto");

        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        postcodeInput.sendKeys("M6A1C2");

        WebElement selectCountry = driver.findElement(By.id("input-country"));

        Select countrySelect = new Select(selectCountry);
        int randomCountryIndex = (int) (Math.random()*253)+1;

        countrySelect.selectByIndex(randomCountryIndex);

        WebElement selectRegion = driver.findElement(By.id("input-zone"));

        Select regionSelect = new Select(selectRegion);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.
                not(ExpectedConditions.numberOfElementsToBe(By.xpath("//select[@id='input-zone']//option"),
                        driver.findElements(By.xpath("//select[@id='input-zone']//option")).size())));

        List<WebElement> listOfRegions = driver.findElements(By.xpath("//select[@id='input-zone']//option"));
        int randomRegionIndex = ((int) (Math.random()*listOfRegions.size()-1))+1;

        regionSelect.selectByIndex(randomRegionIndex);

        WebElement saveAddressButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        saveAddressButton.click();

        Thread.sleep(2000);

        WebElement editAddressButton = driver.findElement(By.xpath("//a[contains(text(), 'Edit')]"));
        editAddressButton.click();

        Thread.sleep(2000);

        WebElement editFirstNameInput = driver.findElement(By.name("firstname"));
        editFirstNameInput.clear();
        editFirstNameInput.sendKeys("Jane");

        WebElement editLastNameInput = driver.findElement(By.name("lastname"));
        editLastNameInput.clear();
        editLastNameInput.sendKeys("Doe");

        WebElement saveChangesButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        saveChangesButton.click();

        Thread.sleep(2000);

        WebElement deleteAddressButton = driver.findElement(By.xpath("//a[contains(text(), 'Delete')]"));
        deleteAddressButton.click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);



    }
}
