package day02;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class _02_UpdateNameTest extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     * <p>
     * Then update the name with the old name
     */

    @Test
    void editNameTest() {
        editName("TestNG3");
        editName("TestNG");
    }

    public void editName(String name) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//
//        WebElement emailInput = driver.findElement(By.id("input-email"));
//        emailInput.sendKeys("mert123@gmail.com");
//
//        WebElement password = driver.findElement(By.id("input-password"));
//        password.sendKeys("mert1234");
//
//        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
//        loginButton.click();

        WebElement editAccount = driver.findElement(By.xpath("//a[text()='Edit Account']"));
        editAccount.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.clear();
        firstname.sendKeys(name);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));
        Assert.assertEquals(successMessage.getText(), "Success: Your account has been successfully updated.");

    }
}


//    @Test
//    void UpdateName() {
//        // Create a new instance of the Chrome driver
//      //  WebDriver driver = new ChromeDriver();
//
//        // Navigate to the login page
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//
//        // Enter the login credentials and click on the login button
//        WebElement emailField = driver.findElement(By.id("input-email"));
//        emailField.sendKeys("mert123@gmail.com");
//        WebElement passwordField = driver.findElement(By.id("input-password"));
//        passwordField.sendKeys("mert1234");
//        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
//        loginButton.click();
//
//
//        WebElement editAccountLink = driver.findElement(By.linkText("Edit Account"));
//        editAccountLink.click();
//
//
//        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
//        firstNameField.clear();
//        firstNameField.sendKeys("Mich");
//        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
//        lastNameField.clear();
//        lastNameField.sendKeys("Dan");
//
//
//        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
//        continueButton.click();
//
//
//        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
//        String expectedMessage = "Success: Your account has been successfully updated.";
//        Assert.assertEquals(successMessage.getText(), expectedMessage);
//
//        WebElement editAccountLinkAgain = driver.findElement(By.linkText("Edit Account"));
//        editAccountLinkAgain.click();
//
//        WebElement firstNameFieldAgain = driver.findElement(By.id("input-firstname"));
//        firstNameFieldAgain.clear();
//        firstNameFieldAgain.sendKeys("Mert");
//
//
//        WebElement continueButtonAgain = driver.findElement(By.cssSelector("input[value='Continue']"));
//        continueButtonAgain.click();
//
//
//        successMessage = driver.findElement(By.cssSelector(".alert-success"));
//        Assert.assertEquals(successMessage.getText(), expectedMessage);
//
//
//        driver.quit();
//    }
//
//
//}


