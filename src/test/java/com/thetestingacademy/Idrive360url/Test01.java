package com.thetestingacademy.Idrive360url;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test01 {

    @Test
    public void VerifyTheFreeTrialExpiredMessage() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(3000);

       // WebElement username = driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("augtest_040823@idrive.com");

      //  WebElement password = driver.findElement(By.id("password"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456");

        driver.findElement(By.id("frm-btn")).click();

        Thread.sleep(5000);


    }
}
