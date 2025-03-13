package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

    @Test
    public void RL_01() throws InterruptedException
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("India");

        Thread.sleep(2000);

        List<WebElement> city = driver.findElements(By.xpath("//div[@class=\"flex flex-col max-sm:gap-[0.5em]\"]//a/child::div/p"));

        int count = 0;
        for (WebElement i : city)
        {
            String city_name = city.get(count).getText();
            String city_AQI = driver.findElement(with(By.tagName("p")).toRightOf(i)).getText();
            String city_ranking = driver.findElement(with(By.tagName("p")).toLeftOf(i)).getText();

            System.out.println(city_ranking+"---"+city_name+"---"+city_AQI);
            System.out.println("==================================================================");
            count++;
        }

        driver.quit();
    }
}
