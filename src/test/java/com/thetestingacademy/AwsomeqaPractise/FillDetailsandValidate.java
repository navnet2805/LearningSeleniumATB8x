package com.thetestingacademy.AwsomeqaPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FillDetailsandValidate {

    @Test
    public void fillDetailsTest01() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Naveen");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("kumar");

        WebElement gender_male_radiobutton = driver.findElement(By.id("sex-0"));
        gender_male_radiobutton.click();

        WebElement exp_radiobutton = driver.findElement(By.id("exp-4"));
        exp_radiobutton.click();

        WebElement date_textbox = driver.findElement(By.id("datepicker"));
        date_textbox.sendKeys("28/03/1995");

        WebElement profession_automation = driver.findElement(By.id("profession-1"));
        profession_automation.click();

        WebElement automation_tool_radiobutton = driver.findElement(By.id("tool-2"));
        automation_tool_radiobutton.click();

        WebElement submit_button  = driver.findElement(By.id("submit"));
        submit_button.click();

        Thread.sleep(2000);

        driver.quit();



    }
}
