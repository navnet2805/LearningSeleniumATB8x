package com.thetestingacademy.Ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test01 {

    @Test
    public void Get_Title_Price()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        WebElement search_product = driver.findElement(By.xpath("//input[@class='gh-search-input gh-tb ui-autocomplete-input']"));
        search_product.sendKeys("samsung galaxy mobiles 1000gb");

        //clicking the search button
        driver.findElement(By.xpath("//button[@id='gh-search-btn']")).click();

        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='s-item__title']"));
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        int size = Math.max(titles.size(), prices.size());

        for (int i=2 ; i< size ; i++)
        {

            System.out.println(i-1 +") " +titles.get(i).getText() + " " + "||" +" " +prices.get(i).getText());
        }

        driver.quit();








    }
}
