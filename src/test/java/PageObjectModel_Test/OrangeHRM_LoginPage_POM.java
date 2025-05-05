package PageObjectModel_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRM_LoginPage_POM {

    WebDriver driver;

    //constructor
    public OrangeHRM_LoginPage_POM(WebDriver driver)
    {
        this.driver = driver;
    }

    //locators
     By txt_username_loc = By.xpath("//input[@name='username']");
     By txt_password_loc = By.xpath("//input[@name='password']");
     By btn_login_loc = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

   //actions
    public void setUsername(String username) {
        WebElement user = driver.findElement(txt_username_loc);
        user.clear();
        user.sendKeys(username);
    }

    public void setPassword(String password)
    {
        WebElement pwd = driver.findElement(txt_password_loc);
        pwd.clear();
        pwd.sendKeys(password);
    }

    public void clickLoginButton()
    {
        driver.findElement(btn_login_loc).click();
    }


}
