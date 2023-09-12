package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // log in using a valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // add items to the cart
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click(); //first item
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click(); //second one
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click(); //third one
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click(); //fourth one
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();  //fifth one
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click(); //sixth

        //removing some items from the cart in the main page
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-backpack")).click(); //first item
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click(); //second one
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click(); //third one

        //open the cart
        driver.findElement(By.id("shopping_cart_container")).click();

        // remove an item from the cart in the cart page
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-onesie"));

        // back to the main page to add others items
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        driver.findElement(By.id("continue-shopping")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //back to the cart again to the checkout
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();

        // try to click on continue without any info
        driver.findElement(By.id("continue")).click(); //click on continue
        System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
        Thread.sleep(2000);

        //fil the planks in valid info
        driver.findElement(By.id("first-name")).sendKeys("ahemd ");
        driver.findElement(By.id("last-name")).sendKeys("elgebali");
        driver.findElement(By.id("postal-code")).sendKeys("22621");
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click(); //click on continue

        WebElement price = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        WebElement tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        System.out.println("the total price is : "+ price);
        System.out.println("the tax will be : "+ tax);
        System.out.println("the total cost will be : "+ price + tax);

        //finish
        driver.findElement(By.id("finish")).click();

        //print the messages
        System.out.println(driver.findElement(By.xpath("//h2[@class='complete-header']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='complete-text']")).getText());

        driver.findElement(By.id("back-to-products")).click(); //back to home

        driver.findElement(By.id("react-burger-menu-btn")).click(); //open the drop menu
        driver.findElement(By.id("about_sidebar_link")).click(); // open about section
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,350)", "");

        driver.navigate().back();
        driver.findElement(By.id("react-burger-menu-btn")).click();  //open the drop menu
        driver.findElement(By.id("logout_sidebar_link")).click();   //logout
        driver.quit();







        }
}