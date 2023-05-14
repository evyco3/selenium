package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");

        driver.switchTo().frame("iframeResult");
        new Actions(driver).doubleClick(driver.findElement(By.cssSelector("button[ondblClick]"))).perform();
        System.out.println(driver.findElement(By.id("demo")).getText());
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
