package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {

    @Test
    public void dragdropTest01() throws InterruptedException
    {
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

    @Test
    public void dragdropTest02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();

        Thread.sleep(5000);

        driver.quit();
    }
}
