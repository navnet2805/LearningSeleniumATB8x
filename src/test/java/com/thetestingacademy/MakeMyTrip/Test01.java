package com.thetestingacademy.MakeMyTrip;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test01 {

    @Test
    public void HandlePopUp() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement popup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        popup.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search')]")));
        WebElement from_journey = driver.findElement(By.xpath("//input[@id='fromCity']"));
        from_journey.click();
      WebElement from_journey_text = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from_journey_text.sendKeys("Delhi");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'New Delhi')]")));
        WebElement from_journey_list = driver.findElement(By.xpath("//span[contains(text(),'New Delhi')]"));
        from_journey_list.click();

        WebElement to_journey = driver.findElement(By.xpath("//input[@id='toCity']"));
        to_journey.click();
        WebElement to_journey_text = driver.findElement(By.xpath("//input[@placeholder='To']"));
        to_journey_text.sendKeys("Bengaluru");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']")));
        WebElement to_journey_list = driver.findElement(By.xpath("//span[@class='makeFlex flexOne spaceBetween appendRight10']"));
        to_journey_list.click();

        //select from date
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Mon Mar 03 2025']")));
        WebElement from_date = driver.findElement(By.xpath("//div[@aria-label='Mon Mar 03 2025']"));
        from_date.click();

        //Search button
       WebElement search_button = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        search_button.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'GOT IT')]")));
        WebElement got_it_popup = driver.findElement(By.xpath("//span[contains(text(),'GOT IT')]"));
        if (got_it_popup.isDisplayed()){
            got_it_popup.click();
        }

        List <WebElement> flight_names = driver.findElements(By.xpath("//span[@class='singleairline']"));

        for (int i=1 ; i<= flight_names.size() ; i++)
        {
            System.out.println(i +": " +flight_names.get(i).getText());
        }

        driver.quit();









    }
}