package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Desktops']"))).perform();
        driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
