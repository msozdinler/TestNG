package day01;

import org.testng.annotations.Test;

public class _01_Intro {
   // public static void main(String[] args) {
        @Test(priority = 1)
                public void test1(){
            System.out.println("Test 1 has passes");
        }
        @Test (priority = 2)
    public void addToCartTest(){
            System.out.println("Add to Cart test is successfully");
        }
        @Test (priority = 3)
    public void checkOutTest(){
            System.out.println("Checkout test is successfully");
        }
    }

