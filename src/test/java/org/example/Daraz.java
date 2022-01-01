package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Daraz extends DriverSetup{

    public static String base_url = "https://www.daraz.com.bd/#";

    @Test
    public static void runBrowser() throws InterruptedException {
        driver.get(base_url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterTest
    public static void Validation() throws InterruptedException{
        String actualText = "Online Shopping in Bangladesh: Order Now from Daraz.com.bd";
        String titleTest = driver.getTitle();
        System.out.println(titleTest);

        Assert.assertEquals(titleTest, actualText);

        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("01631846218");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demo1234");
        System.out.println("Data Putted");

        //Login

        String loginText= driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).getText();
        String actualLoginText = "LOGIN";

        Assert.assertEquals(actualLoginText,loginText);

        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        Thread.sleep(2000);
        System.out.println("Logged In");

        //Logout

        driver.findElement(By.xpath("//div[@id='topActionUserAccont']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='account-icon test logout']")).click();
        System.out.println("Logged Out");
        Thread.sleep(1000);

    }

}
