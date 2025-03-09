package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ScrollBar {

    @Test
    public void flipkart_scroll_Test01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        // to find the search textbox and type 'mobiles'
        WebElement search_textBox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        search_textBox.sendKeys("mobiles");

        //to click on search svg icon
        WebElement search_icon = driver.findElement(By.xpath("(//*[name()='svg'])[1]"));
        search_icon.click();

        //(//div[contains(@data-id,'MOB')])[14]/div/a/div[2]/div/div[1]
        //to scroll down till the element is found then click on it.
        WebElement scroll_to_element = driver.findElement(By.xpath("(//div[contains(@data-id,'MOB')])[14]/div/a/div[2]/div/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",scroll_to_element);

        scroll_to_element.click();


        driver.quit();





    }

}
