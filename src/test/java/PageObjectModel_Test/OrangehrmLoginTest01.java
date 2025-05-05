package PageObjectModel_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangehrmLoginTest01 {

    WebDriver driver;

    @BeforeClass
    public void init()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
    }

    @Test
    public void LoginTest()
    {
        OrangeHRM_LoginPage_POM obj = new OrangeHRM_LoginPage_POM(driver);
        obj.setPassword("Admin");
        obj.setPassword("admin123");
        obj.clickLoginButton();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
