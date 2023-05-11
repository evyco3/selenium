package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //js with 1 conformation button
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        //js with 2 button confirm/dismiss
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();

        //prompt
        driver.findElement(By.cssSelector("button[onclick*='jsP']")).click();
        driver.switchTo().alert().sendKeys("Hello world!");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
