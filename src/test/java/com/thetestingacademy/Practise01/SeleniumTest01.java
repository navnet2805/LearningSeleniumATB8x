package com.thetestingacademy.Practise01;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class SeleniumTest01  {

    @Test
    public void Test01() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/").isNotEmpty().isNotNull();
        assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service").isNotEmpty().isNotBlank();

        if (driver.getPageSource().contains("CURA Healthcare Service"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            throw  new Exception("Page not found");
        }

        driver.quit();
    }



}
