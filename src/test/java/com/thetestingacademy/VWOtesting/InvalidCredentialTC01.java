package com.thetestingacademy.VWOtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidCredentialTC01 {


    @Test
    public void NegativeTestcase() throws Exception {
        WebDriver webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();

        //open link
        webDriver.get("https://app.vwo.com/");
        //verify current url
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://app.vwo.com/#/login");
//click on free trial link
        WebElement link_StartFreeTrial = webDriver.findElement(By.linkText("Start a free trial"));
        link_StartFreeTrial.click();
        
        //explicit wait
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2000));
       // wait.until(ExpectedConditions.textToBePresentInElement(webDriver,"Signup for a full-featured trial"));


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
