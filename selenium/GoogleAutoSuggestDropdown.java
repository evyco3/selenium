package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleAutoSuggestDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //static wait for every element , wait for 8 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.findElement(By.name("q")).sendKeys("Selenium");

        //WebDriverWait - dynamic wait for specific element/elements
        List<WebElement> list=new WebDriverWait(driver,Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#Alh6id ul>li")));
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("selenium chromedriver")){
                element.click();
                break;
            }
        }
        List<WebElement>list2=new WebDriverWait(driver,Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.v7W49e>div h3")));
        for(WebElement element2:list2){
            if(element2.getText().equalsIgnoreCase("ChromeDriver · SeleniumHQ/selenium Wiki - GitHub")){
                element2.click();
                break;
            }
        }
        System.out.println(driver.getTitle());


        driver.quit();
    }
}
