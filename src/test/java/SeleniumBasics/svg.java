package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class svg {

    @Test
    public void FindTheStateTripuraAndClick()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));


        for (WebElement state : states)
        {
            System.out.println(state.getAttribute("aria-label"));

            if (state.getAttribute("aria-label").contains("Tripura"))
                state.click();
        }

//        driver.quit();
    }

    @Test
    public void FindTheStateDelhiAndClick()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for (WebElement i : states)
        {
//            System.out.println(i.getAttribute("aria-label"));
            if (i.getAttribute("aria-label").contains("Delhi"))
                i.click();
        }

//        driver.quit();

    }

    @Test
    public void FindListOfAllElements()
    {
        //find the search textbox and click on it.
        //enter the word "macmini"
        //search for svg search icon and click on it.
        //get the list of all the titles

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        searchbox.sendKeys("macmini");

        //search icon svg
        driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();

        List<WebElement> ListOfElements = driver.findElements(By.xpath("//Div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement i : ListOfElements)
        {
            System.out.println(i.getText());
        }

        driver.quit();
    }

}
