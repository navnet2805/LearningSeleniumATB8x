package SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Actions_WindowHandles_IFrame {

    @Description("Search for the mobiles -> click on the 1st mobile from the link -> navigate to second tab and print the rating")
    @Test
    public  void Test01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        String ParentWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Flipkart']")));

        //search for mobiles
        WebElement search_textbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(search_textbox).click().sendKeys("OPPO mobiles").perform();

        WebElement search_icon = driver.findElement(By.xpath("//*[name()='svg']"));
        actions.moveToElement(search_icon).click().perform();

        //1st element
        WebElement element01 = driver.findElement(By.xpath("(//div[contains(@data-id,'MOB')])[1]/descendant::div[contains(text(),'OPPO')]"));
        String mobile_name = element01.getText();
        System.out.println("1st element name is: " +mobile_name);
        actions.moveToElement(element01).click().perform();

        Thread.sleep(5000);

        Set<String> multiple_window = driver.getWindowHandles();
        for (String handle : multiple_window)
        {
            if (!handle.equals(ParentWindow))
            {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                String element_clicked = "//span[contains(text(),'"+mobile_name+"')]";
                WebElement element01_page = driver.findElement(By.xpath(element_clicked));
                wait.until(ExpectedConditions.elementToBeClickable(element01_page));
                System.out.println("2nd tab title name is : " +driver.getTitle());

                //find the rating and print it
                WebElement rating = element01_page.findElement(By.xpath("//span[contains(@id,'productRating')]"));
                System.out.println("Rating of the product is: " +rating.getText());
            }
        }
        driver.quit();
    }


}
