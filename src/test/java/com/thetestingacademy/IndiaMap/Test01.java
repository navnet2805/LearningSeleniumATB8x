package com.thetestingacademy.IndiaMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Test01 {

    @Test
    public void FindTheStateTripuraAndClick()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        int count = 1;
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

}
