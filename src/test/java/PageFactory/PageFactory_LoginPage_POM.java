package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_LoginPage_POM {
    WebDriver driver;
    //constructor
    PageFactory_LoginPage_POM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//input[@name='username']") WebElement txt_username;
    @FindBy(xpath = "//input[@name='password']") WebElement txt_password;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']") WebElement btn_login;

    //actions
    public void setTxt_username(String username)
    {
        txt_username.sendKeys(username);
    }

    public void setTxt_password(String pwd)
    {
        txt_password.sendKeys(pwd);
    }

    public void clickLoginButton()
    {
        btn_login.click();
    }

}
