import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class puc {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://karresults.nic.in/slpufirst25_1.asp");

        for (int i=52669 ; i<=53669 ; i++ )
        {
            String com = "202594" + i;
            WebElement regnumber = driver.findElement(By.id("reg"));
            regnumber.sendKeys(String.valueOf(com));

            WebElement combination = driver.findElement(By.id("ddlsub"));
            Select select = new Select(combination);
            select.selectByVisibleText("Science");

            WebElement submit = driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]"));
            submit.click();

            Thread.sleep(3000);

            List<WebElement> errorMessages  = driver.findElements(By.xpath("//h3[contains(text(),'Registration number or Subject Combination not found.')]"));

            if (!errorMessages.isEmpty() && errorMessages.get(0).isDisplayed())
            {
                WebElement element = driver.findElement(By.xpath("//a[@class=\"btn btn-warning\"]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
            }
            else
            {
                WebElement name = driver.findElement(By.xpath("//td[contains(text(),'Name')]"));
                WebElement person_name = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(name));

                WebElement reg = driver.findElement(By.xpath("//td[contains(text(),'Reg. No.')]"));
                WebElement person_reg = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(reg));

                System.out.println(person_name.getText() + "-->" + person_reg.getText());

                WebElement element = driver.findElement(By.xpath("//a[@class=\"btn btn-warning\"]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);

                element.click();

            }


        }

    }
}
