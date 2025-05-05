package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangehrmLoginTest02 {

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
        PageFactory_LoginPage_POM obj = new PageFactory_LoginPage_POM(driver);
        obj.setTxt_username("Admin");
        obj.setTxt_username("admin123");
        obj.clickLoginButton();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }


}
