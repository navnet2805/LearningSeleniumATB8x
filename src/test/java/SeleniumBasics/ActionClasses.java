package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClasses {

    @Test
    public void Test01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstname).click().keyDown(Keys.SHIFT).sendKeys("naveen").keyUp(Keys.SHIFT).build().perform();

        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        actions.moveToElement(lastname).click().keyDown(Keys.SHIFT).sendKeys("KUMAR").build().perform();

        Thread.sleep(5000);

        WebElement male_gender = driver.findElement(By.id("sex-0"));
        actions.moveToElement(male_gender).click().perform();

        WebElement exp_5 = driver.findElement(By.id("exp-4"));
        actions.moveToElement(exp_5).click().perform();




    }
}
