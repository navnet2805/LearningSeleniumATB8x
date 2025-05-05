package Rahul_Rohit_Session;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); //explicit wait
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert(); //switch the control to alert page.

//        alert.sendKeys("Naveen");
//        alert.accept(); //clicking on OK button.
        alert.dismiss(); //clicking on Cancel button

        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();

        //validation
        Assert.assertEquals(result,"You entered: null");

    }
}
