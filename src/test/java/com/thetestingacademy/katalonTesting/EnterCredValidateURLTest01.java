package com.thetestingacademy.katalonTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterCredValidateURLTest01 {

    @Test
    /*
    open the https://katalon-demo-cura.herokuapp.com/
    Click on the make appointment button
    Find username,password - enter them  , John Doe, ThisIsNotAPassword
    Click on the submit button
    Verify the driver. currentUrl == https://katalon-demo-cura.herokuapp.com/#appointment
    Push the code to github.com
     */
    public void Test01()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_aapointment_button = driver.findElement(By.id("btn-make-appointment"));
        make_aapointment_button.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement make_appointment_username = driver.findElement(By.id("txt-username"));
        make_appointment_username.sendKeys("John Doe");

        WebElement make_appointment_password = driver.findElement(By.id("txt-password"));
        make_appointment_password.sendKeys("ThisIsNotAPassword");

        WebElement make_appointment_login_button = driver.findElement(By.id("btn-login"));
        make_appointment_login_button.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();

    }
}
