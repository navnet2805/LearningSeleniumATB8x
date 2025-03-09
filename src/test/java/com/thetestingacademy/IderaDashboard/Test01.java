package com.thetestingacademy.IderaDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test01 {

    @Test (priority = 1)
    //launch the URL and login
    public void VerifyIderaDashboardVersionFromManageProducts() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://10.220.200.71:9291/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connection_private_message = driver.findElement(By.xpath("//div[@id='main-message']/h1"));
        wait.until(ExpectedConditions.visibilityOf(connection_private_message));

        WebElement Advanced_button = driver.findElement(By.xpath("//button[@id='details-button']"));
        Advanced_button.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='proceed-link']")));
        WebElement proceed_link = driver.findElement(By.xpath("//a[@id='proceed-link']"));
        proceed_link.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-logo z-div']")));
        WebElement username = driver.findElement(By.xpath("//input[@class='login-textbox idera-textbox' and @placeholder='Password']/preceding::input"));
        username.sendKeys("Simpsons\\accolite-suprajeet");

        WebElement password = driver.findElement(By.xpath("//input[@class='login-textbox idera-textbox' and @placeholder='Password']"));
        password.sendKeys("control*88");

        WebElement login_button = driver.findElement(By.xpath("//button[@class='login-button idera-button-primary' and @type='button']"));
        login_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='modal-dialog-title z-label' and contains(text(),'OVERVIEW')]")));

        WebElement Administration = driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(text(),'Administration')]"));
        Administration.click();

        WebElement manage_products = driver.findElement(By.xpath("//a[@class='z-menuitem-cnt'  and contains(text(),'Manage Products')]"));
        manage_products.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='modal-dialog-title  cwf-manageProducts-title z-label'  and contains(text(),'MANAGE PRODUCTS')]")));

        WebElement dashboard = driver.findElement(By.xpath("//div[@class='z-listcell-cnt z-overflow-hidden'  and contains(text(),'IderaDashboard')]"));

        if (dashboard.getText().equals("IderaDashboard"))
        {
            System.out.println("IderaDashboard is installed successfully");
        }

        WebElement dashboard_version = driver.findElement(By.xpath("//div[@class='z-listcell-cnt z-overflow-hidden'  and contains(text(),'IderaDashboard')]/parent::td/following-sibling::td[1]"));
        if (dashboard_version.getText().equals("4.8.3.5"))
        {
            System.out.println("Idera dashboard version is 4.8.3.5");
        }

        driver.quit();

    }

    @Test(priority = 2)
    public void VerifyIderaDashboardVersionFromAbout()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://10.220.200.71:9291/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connection_private_message = driver.findElement(By.xpath("//div[@id='main-message']/h1"));
        wait.until(ExpectedConditions.visibilityOf(connection_private_message));

        WebElement Advanced_button = driver.findElement(By.xpath("//button[@id='details-button']"));
        Advanced_button.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='proceed-link']")));
        WebElement proceed_link = driver.findElement(By.xpath("//a[@id='proceed-link']"));
        proceed_link.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-logo z-div']")));
        WebElement username = driver.findElement(By.xpath("//input[@class='login-textbox idera-textbox' and @placeholder='Password']/preceding::input"));
        username.sendKeys("Simpsons\\accolite-suprajeet");

        WebElement password = driver.findElement(By.xpath("//input[@class='login-textbox idera-textbox' and @placeholder='Password']"));
        password.sendKeys("control*88");

        WebElement login_button = driver.findElement(By.xpath("//button[@type='button' and @class='login-button idera-button-primary' and contains(text(),'LOG IN')]"));
        login_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='modal-dialog-title z-label' and contains(text(),'OVERVIEW')]")));

        WebElement help = driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(text(),'Help')]"));
        help.click();

        WebElement about = driver.findElement(By.xpath("//a[@class='z-menuitem-cnt' and contains(text(),'About')]"));
        about.click();

        WebElement about_version = driver.findElement(By.xpath("(//span[@class='z-label'])[6]"));
        System.out.println(about_version.getText());

        WebElement about_close_button = driver.findElement(By.xpath("//button[@class=\"idera-button-primary\" and contains(text(),'CLOSE')]"));
        about_close_button.click();

        WebElement loggedinUser = driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(text(),'Simpsons')]"));
        loggedinUser.click();

        WebElement logout = driver.findElement(By.xpath("(//a[@class=\"z-menuitem-cnt\"])[16]"));
        logout.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-logo z-div']")));

        driver.quit();



    }

}
