package SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class Alerts {
    //Selenium can only handle Java script alerts below are the example program

    static WebDriver driver = new EdgeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @Description("Here we have a alert popup which has only ok button.")
    @Test(priority = 1)
    public void ClickForJSAlert()
    {
//        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSAlert.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept(); //clicking OK button on the alert popup

        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        assertThat(result.getText()).isNotNull().isNotBlank().isNotEmpty().isEqualTo("You successfully clicked an alert");

//        driver.quit();

    }

    @Description("Here we have a alert popup which has only ok and cancel button.")
    @Test(priority = 2)
    public void ClickForJSConfirm()
    {
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();

//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept(); //clicking OK button on the alert popup

        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        assertThat(result.getText()).isNotNull().isNotBlank().isNotEmpty().isEqualTo("You clicked: Ok");

        JSAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss(); //Clicking CANCEL button on the alert popup

        assertThat(result.getText()).isNotNull().isNotBlank().isNotEmpty().isEqualTo("You clicked: Cancel");

//        driver.quit();
    }

    @Description("OK: Here we have a alert popup which has userinput textbox, ok and cancel button.")
    @Test(priority = 3)
    public void ClickOKForJSPrompt()
    {
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPrompt.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Naveen");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        assertThat(result.getText()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("You entered: Naveen");

//        driver.quit();
    }

    @Description("Cancel: Here we have a alert popup which has userinput textbox, ok and cancel button.")
    @Test(priority = 4)
    public void ClickCencelForJSPrompt()
    {
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPrompt.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Naveen");
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        assertThat(result.getText()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("You entered: null");

        driver.quit();
    }




}
