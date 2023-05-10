package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoCompletePlaces {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.twoplugs.com/");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement location=driver.findElement(By.id("autocomplete"));
        location.clear();
        String text=null;
        do{
            location.sendKeys(Keys.ARROW_DOWN);
            text=location.getAttribute("value");
            if(text.equalsIgnoreCase("Israels Plads, Copenhagen Municipality, Denmark")){
                location.sendKeys(Keys.ENTER);
                break;
            }


        }while (!text.isEmpty());




        driver.quit();
    }
}
