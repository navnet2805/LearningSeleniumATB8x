package InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Program_02_brokenlinks {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size()); //48 links

        for (WebElement element : links)
        {
            String hrefAttValue = element.getAttribute("href");

            if (hrefAttValue == null || hrefAttValue.isEmpty())
            {
                System.out.println("href value is empty and not possible to check the broken link");
                continue;
            }

            try {
                //to convert to url - connect - get response - verify
                URL url = new URL(hrefAttValue);
                HttpURLConnection urlconnect = (HttpURLConnection) url.openConnection();
                urlconnect.connect();
                int statusCode = urlconnect.getResponseCode();

                if (statusCode >= 400) {
                    System.out.println(url + "is a broken link");
                } else {
                    System.out.println(url + "is not a broken link");
                }
            }catch (Exception e)
            {
            }



        }



    }
}
