package SeleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NoSuchElementExceptions {

    @Test
    public void NoSuchElementException_Test()
    {
        WebDriver driver = null;
        try {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.flipkart.com/");

            WebElement searchbox = driver.findElement(By.id("Naveen"));
            searchbox.sendKeys("macmini");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}
