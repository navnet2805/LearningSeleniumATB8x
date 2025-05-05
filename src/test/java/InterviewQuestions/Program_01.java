package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

//write a relative xpath for 'student' radio button in make my trip
public class Program_01 {

    @Test
    public void Test01()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //click on cancel for the login wizard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']"))).click();

        //find sudent radio button
        driver.findElement(By.xpath("(//div[@class='fareCardItem '])[2]/div/span")).click();
    }
}
