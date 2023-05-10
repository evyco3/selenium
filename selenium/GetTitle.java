package com.evy.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        if (title.equalsIgnoreCase("google")) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}