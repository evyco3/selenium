package com.evy.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LunchBrowsers {
    public static void main(String[] args) {
        WebDriver driver;


        //lunch Chrome browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();

        //lunch firefox browser
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.quit();

        //lunch edge browser
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.quit();



    }
}


