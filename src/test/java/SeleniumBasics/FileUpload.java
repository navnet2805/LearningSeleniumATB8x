package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {

    @Test
    public void FileUploadTest01()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='item-text' and text()='Sign in']")));

        WebElement signin = driver.findElement(By.xpath("//span[@class='item-text' and text()='Sign in']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signin).click().perform();

        WebElement username = driver.findElement(By.id("user_email_login"));
        username.sendKeys("naveen.rp.2805@gmail.com");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("12345678");

        WebElement login_submit_button = driver.findElement(By.id("user_submit"));
        login_submit_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file")));
        WebElement upload_file = driver.findElement(By.id("file"));
        upload_file.sendKeys("C:\\Users\\naveen.rp\\Downloads\\BitBarSampleApp.apk");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-container']")));
        WebElement uploaded_confirmation = driver.findElement(By.xpath("//div[@class='text-container']"));
        Assert.assertEquals(uploaded_confirmation.getText(), "BitBarSampleApp.apk");

        WebElement token = driver.findElement(By.xpath("//div[@class=\"prism-snippet__container\"]/pre"));

        Assert.assertEquals(token.getText(),"64e99a748d433103f9f758dcd889543a6ef88984");

    }


    @Test
    public void FileUploadTest02()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement fileupload = driver.findElement(By.id("file-upload"));
        fileupload.sendKeys("C:\\Users\\naveen.rp\\Documents\\Demo.txt");

        WebElement upload_button = driver.findElement(By.id("file-submit"));
        upload_button.click();

        WebElement uploaded_filename = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploaded_filename.getText(), "Demo.txt");

        driver.quit();
    }
}
