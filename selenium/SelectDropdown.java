package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
        WebElement element=driver.findElement(By.name("country"));
        Select select=new Select(element);

        //selectByVisibleText
        select.selectByVisibleText("BELGIUM");
        Thread.sleep(1500);

        //selectByIndex
        select.selectByIndex(3);
        Thread.sleep(1500);

        //selectByValue
        select.selectByValue("HAITI");
        Thread.sleep(1500);

        //getOptions
        List<WebElement> countries=select.getOptions();
        for(WebElement element1:countries){
            if(element1.getText().equalsIgnoreCase("ISRAEL")){
                element1.click();
                break;
            }
        }
        Thread.sleep(1500);
        driver.quit();

    }
}
