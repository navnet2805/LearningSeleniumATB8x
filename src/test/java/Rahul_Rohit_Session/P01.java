package Rahul_Rohit_Session;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class P01 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver(); //intialize the driver ->  always create a session -> asisgned to a 1 thread.

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Logout
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/i")).click();
        driver.findElement(By.linkText("Logout")).click();



        //get the id from the user and click on the id -> id page should be launched.




        //driver.quit(); // -> closed the browser and quit the session - thread will be free
        //driver.close(); //-? close the browser.
    }
}
