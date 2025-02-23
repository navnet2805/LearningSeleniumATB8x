package com.thetestingacademy.TestCasePractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidCredentialTC01 {


    @Test
    public void NegativeTestcase() throws Exception {
        WebDriver webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://app.vwo.com/");
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement link_StartFreeTrial = webDriver.findElement(By.linkText("Start a free trial"));
        link_StartFreeTrial.click();

        Thread.sleep(2000);

        webDriver.navigate().back();

        WebElement input_email = webDriver.findElement(By.id("login-username"));
        input_email.sendKeys("asdf@gmail.com");

        WebElement input_password = webDriver.findElement(By.id("login-password"));
        input_password.sendKeys("invalidpassword");

        WebElement sign_in_button = webDriver.findElement(By.id("js-login-btn"));
        sign_in_button.click();

        Thread.sleep(3000);

        WebElement error_message = webDriver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");


        webDriver.quit();


    }
}
