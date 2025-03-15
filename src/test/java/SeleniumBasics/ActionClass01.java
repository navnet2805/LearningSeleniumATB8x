package SeleniumBasics;

import io.qameta.allure.Description;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v129.network.model.WebTransportConnectionEstablished;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass01 {

    EdgeDriver driver;
    @BeforeTest
    public void OpenBrowser()
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Description("Verify the dropdown and select the 1st option using action classes")
    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
        WebElement close_login_popup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(close_login_popup).click().perform();

        WebElement from_source = driver.findElement(By.id("fromCity"));
        actions.moveToElement(from_source).click().perform();
        actions.sendKeys("del").perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.ARROW_DOWN).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("toCity")));
        WebElement to_destination = driver.findElement(By.id("toCity"));
        actions.moveToElement(to_destination).click().perform();
        actions.sendKeys("bkk").perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"dateInnerCell\"])[16]")));
        WebElement date_16th = driver.findElement(By.xpath("(//div[@class=\"dateInnerCell\"])[16]"));
        actions.moveToElement(date_16th).click().perform();

        WebElement search_button = driver.findElement(By.xpath("//p[@data-cy=\"submit\"]/a"));
        actions.moveToElement(search_button).click().perform();

        Thread.sleep(4000);

        if (driver.findElement(By.xpath("//span[@class='bgProperties overlayCrossIcon icon20']")).isDisplayed())
        {
            actions.moveToElement(driver.findElement(By.xpath("//span[@class='bgProperties overlayCrossIcon icon20']"))).click().perform();
        }

    }

    @AfterTest
    public void CloseBrowser()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
