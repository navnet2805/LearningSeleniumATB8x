package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class UploadFileTest {

    @Test
    public void UploadingFile_TC01() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        //find the element for upload file
        WebElement uploadfile = driver.findElement(By.xpath("//input[@id='fileToUpload']"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir); // C:\Users\naveen.rp\IdeaProjects\LearningSeleniumATB8x

        // full path of the text file is
        // C:\Users\naveen.rp\IdeaProjects\LearningSeleniumATB8x\src\test\java\SeleniumBasics\Hello.txt

        //complete path till text file is : dir+ "\src\test\java\SeleniumBasics\Hello.txt"

        uploadfile.sendKeys(dir+"\\src\\test\\java\\SeleniumBasics\\Hello.txt");

        Thread.sleep(3000);

        driver.findElement(By.name("submit"));



        driver.quit();


    }
}
