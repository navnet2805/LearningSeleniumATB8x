package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsTabHandles {

    @Test
    public void Test01()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parent_tab = driver.getWindowHandle();
        System.out.println(parent_tab);

        WebElement linkText = driver.findElement(By.linkText("Click Here"));
        linkText.click();

        Set<String> multiple_tabs = driver.getWindowHandles();
        System.out.println(multiple_tabs);


        for (String handle : multiple_tabs)
        {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window"))
            {
                System.out.println("Test case is passed");
            }
        }
        driver.quit();
    }
}
