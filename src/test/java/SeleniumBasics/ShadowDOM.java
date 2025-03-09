package SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ShadowDOM {

    @Description("Test case to find shadow dom element")
    @Test
    public void Find_ShadowDOM_Element()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://dev.automationtesting.in/shadow-dom");

        //find the Shadow Element
        SearchContext shadow_element = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        shadow_element.findElement(By.cssSelector("#shadow-element"));

    }

    @Description("Test case to find Nested shadow element")
    @Test
    public void Find_Nested_Shadow_Element()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://dev.automationtesting.in/shadow-dom");

        //find the Nested Shadow Element
        //Step1: Find the Shadow Element
        SearchContext shadow_element_01 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        //Step2: Find the 'Nested Shadow Element' using the 'Shadow element'
        SearchContext shadow_element_02 = shadow_element_01.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        shadow_element_02.findElement(By.cssSelector("#nested-shadow-element"));

    }

    @Description("Test case to find Multi-nested shadow element")
    @Test
    public void Find_Multi_Nested_Shadow_Element()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://dev.automationtesting.in/shadow-dom");

        //find the Multi-nested Shadow Element
        //Step1: Find the Shadow Element
        SearchContext shadow_element_01 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        //Step2: Find the 'Nested Shadow Element' using the 'Shadow element'
        SearchContext shadow_element_02 = shadow_element_01.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        //Step3: Find the 'Multi Nested shadow element' using 'Nested shadow element'
        SearchContext shadow_element_03 = shadow_element_02.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        shadow_element_03.findElement(By.cssSelector("multi-nested-shadow-element"));

    }


    @Description("Test case to find ShadowDOM element for username")
    @Test
    public void Find_username_Shadow_Element() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        //Since the username textbox is down we need to write the code for scrolldown until the element is found.


        //to find the username element which is under shadow-root
        driver.get("https://selectorshub.com/xpath-practice-page/");
        SearchContext username_dom = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
        WebElement username_textbox = username_dom.findElement(By.cssSelector("#user name field"));
        username_textbox.sendKeys("Naveen Kumar RP");

        Thread.sleep(5000);



    }



}
