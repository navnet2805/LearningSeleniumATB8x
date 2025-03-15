package SeleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class StaleElementReferenceException_testing {

    @Test
    public void StaleElementReferenceException_Test()
    {
            WebDriver driver = null;
        try {
            driver = new EdgeDriver();
            driver.get("https://www.flipkart.com/");

            WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
            driver.navigate().refresh();
            searchbox.sendKeys("macmini");
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}
