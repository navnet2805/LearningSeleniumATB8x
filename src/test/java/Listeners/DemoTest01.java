package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest01 {
    WebDriver driver;

    @BeforeClass
    public void init() throws InterruptedException {
        switch ("chrome")
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser "); return;
        }
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void VerifyLogo()
    {
        Assert.assertEquals(driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed(),true);
    }

    @Test(priority = 3 , dependsOnMethods = {"VerifyURL"})
    public void VerifyTitle()
    {
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @Test(priority = 2)
    public void VerifyURL()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.m/hr/web/index.php/auth/login");
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}

