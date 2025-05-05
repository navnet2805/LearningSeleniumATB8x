package Rahul_Rohit_Session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class WindowHandle {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("oppo mobile");
        driver.findElement(By.xpath("//*[name()='svg']")).click();

        String parenttab = driver.getWindowHandle();

        WebElement Mobile = driver.findElement(By.xpath("(//div[contains(text(),'OPPO')])[4]"));
        Mobile.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        for (String w : driver.getWindowHandles())
        {
            if (!(driver.getWindowHandle().equals(parenttab)))
            {
                driver.switchTo().window(w);
            }
        }

        String rating = driver.findElement(By.xpath("//span[@id='productRating_LSTMOBH2Q4PN6FWZCGVPMAT2I_MOBH2Q4PN6FWZCGV_']")).getText();
        System.out.println(rating);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.switchTo().window(parenttab); //switching back to parent tab.






    }
}
