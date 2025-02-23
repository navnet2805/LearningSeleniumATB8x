package com.thetestingacademy.VWOtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ListenerComparator;
import org.testng.annotations.Test;

import java.util.List;

public class StartFreeTrial {

    @Test
    public void invalid_Cred_FreeTrial() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/");

        WebElement link_free_trial = driver.findElement(By.linkText("Start a free trial"));
        link_free_trial.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");

        WebElement free_trial_id = driver.findElement(By.id("page-v1-step1-email"));
        free_trial_id.sendKeys("invalidgmailid");

        WebElement checkbox_i_agree = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_i_agree.click();

        List<WebElement> create_free_trial_account_button = driver.findElements(By.tagName("button"));
        create_free_trial_account_button.get(0).click();

        WebElement trial_error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(trial_error_message.getText(),"The email address you entered is incorrect.");


        Thread.sleep(2000);

        driver.quit();


    }
}
