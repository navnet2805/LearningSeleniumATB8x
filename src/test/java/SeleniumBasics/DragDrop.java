package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Thread.sleep(3000);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions =  new Actions(driver);
        actions.dragAndDrop(from,to).perform();

        Thread.sleep(2000);

        driver.quit();
    }
}
