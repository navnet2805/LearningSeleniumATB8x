package SeleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimeoutException_testing {

    @Test
    public void TimeoutException_test(){
             WebDriver driver = null;
        try {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.flipkart.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Naveen")));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}
