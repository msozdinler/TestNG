package day07;

import org.testng.annotations.Test;

public class _04_WishListTest {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for ipod (send "ipod" from xml file)
     * add one of the elements to the wish list randomly
     * Click on Wish List button
     * Check if the name of the element is the same with the name of the element you added.
     *
     * Use POM and ParameterDriver
     * Perform non-parallel cross browser test
     * */

    @Test
    void wishListTest(String searchWord){
        _02_PlaceOrderFunctionalityElements elements1 = new _02_PlaceOrderFunctionalityElements();
        _05_WishListElements wishListElements = new _05_WishListElements();

        elements1.searchBox.sendKeys(searchWord);
        elements1.searchButton.click();

        int randomIndex = (int)(Math.random()*wishListElements.getProductsList().size());
        String productName = wishListElements.getProductNameList().get(randomIndex).getText();
        wishListElements.getProductsList().get(randomIndex).click();

        // TODO: finish this task


    }
}