package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SynchronizationProblems {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //implicit wait: global wait static wait for every element the same amount of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        //pageLoadTime: global wait : amount of time page to be load completely load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        List<WebElement>list=waitForElementWithWebDriverWaitWait(By.cssSelector("div#Alh6id ul li"),10);
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("Selenium chromedriver")){
                element.click();
                break;
            }
        }
        WebElement element=waitForElementWithFluentWait(By.xpath("//div[@id='search']//span[text()='ChromeDriver - WebDriver for Chrome']"),10);
        element.click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
    //explicit wait
    public static List<WebElement> waitForElementWithWebDriverWaitWait(By by, int time){
        return  new WebDriverWait(driver,Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //explicit wait
    public static WebElement waitForElementWithFluentWait(By by,int time){
        Wait<WebDriver>wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement foo=  wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(by);
            }
        });
        return foo;
    }
}
