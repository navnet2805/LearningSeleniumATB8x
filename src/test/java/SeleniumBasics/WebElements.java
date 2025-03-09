package SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebElements {

    @Description("Print all the values present in the web table")
    @Test
    public void WebTable_Test01()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        //find the row size
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        System.out.println(row);

        //find the column size
        int column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        System.out.println(column);

        //create a pattern of xpath
        String first_part = "//table[@id='customers']/tbody/tr[";
        //i
        String second_part = "]/td[";
        //j
        String last_part = "]";

        //to print all the data from the table
        for (int i=2 ; i<=row ; i++)
        {
            for (int j=1 ; j<=column ; j++)
            {
                String dynamic_xpath = first_part+i+second_part+j+last_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.print(data+"---");
            }
            System.out.println("");
        }

        driver.quit();
    }


    @Description("find_the_1st_terminated_employee_click_on_delete_icon")
    @Test
    public void find_the_1st_terminated_employee_click_on_delete_icon()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        //find username element and send keys
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");

        //find password element and send keys
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");

        //find the submit button and click on it
        WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
        login_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")));

        int row = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size();
        System.out.println(row);

        String first_part = "//div[@class='oxd-table-card'][";
        //i
        String second_part = "]/div/div[@class='oxd-table-cell oxd-padding-cell'][6]";

        for (int i=1 ; i<=row ; i++)
        {
            String employee = first_part+i+second_part;
            WebElement employee_xpath = driver.findElement(By.xpath(employee));
            if (employee_xpath.getText().contains("Terminated"))
            {
                js.executeScript("arguments[0].scrollIntoView(true);",employee_xpath);
                String del_icon = "(//div[@class='oxd-table-cell-actions'])["+i+"]/button/i[@class='oxd-icon bi-trash']";
                WebElement delete_icon = driver.findElement(By.xpath(del_icon));
//              delete_icon.click();
                js.executeScript("arguments[0].click();", delete_icon);
                break;
            }

        }
        driver.quit();

    }


    @Description("program to find what structure was built before 2009 and after 2009")
    @Test
    public void Dynamic_WebTable_Test01()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> row = table.findElements(By.tagName("tr"));


        for (int i=0 ; i<row.size() ; i++)
        {
          List<WebElement>  column = row.get(i).findElements(By.tagName("td"));
         String year = column.get(3).getText();

         if(Integer.parseInt(year)<2009)
         {
             System.out.println("The structures built before 2009 is : " + row.get(i).findElement(By.tagName("th")).getText());
         }
         if(Integer.parseInt(year)>2009)
         {
             System.out.println("The structures built after 2009 is : " + row.get(i).findElement(By.tagName("th")).getText());
         }
        }
        driver.quit();
    }




}
