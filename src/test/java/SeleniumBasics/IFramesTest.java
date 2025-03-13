package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IFramesTest {

    @Test
    public void iframe_test01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/iframes/");

//        Thread.sleep(3000);

        driver.switchTo().frame("iframe-1"); //switches the control to frame

        WebElement  frame1_search = driver.findElement(By.xpath("//span[@class='DocSearch-Button-Placeholder' and contains(text(),'Search')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(frame1_search).click().perform();

        driver.switchTo().defaultContent(); //switches the control back to main page.

        driver.quit();
    }

}
