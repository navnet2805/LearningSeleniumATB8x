package com.thetestingacademy.Practise01;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class SeleniumBasics {

    @Test
    public void LaunchFireFoxBrowserTest01()
    {
        //to maximize , minimize, set windows size
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start maximized");

        //using Edge
        EdgeDriver driver = new EdgeDriver(edgeOptions);
        //to launch url in the browser
        driver.get("https://app.vwo.com/");

        //navigate backward arrow option in the browser
        driver.navigate().back();

        //navigate forward arrow option in the browser
        driver.navigate().forward();

        // get the title of the loaded page
        driver.get(driver.getTitle());

        //to close the current tab or current browser without ending the session.
        driver.close();

        //to close the current tab or current browser with ending the session.
        driver.quit();

    }
}
