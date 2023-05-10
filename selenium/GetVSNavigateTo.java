package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetVSNavigateTo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //accept only String as parameter
        driver.get("https://www.google.com/");

        //accept String and URL as parameters
        //restore cookies to navigate back and forward
        driver.navigate().to("https://www.amazon.com/");

        //navigate to previous page
        driver.navigate().back();
        System.out.println(driver.getTitle());

        //navigate to forward page
        driver.navigate().forward();
        System.out.println(driver.getTitle());

        //refresh page
        driver.navigate().refresh();

        driver.quit();
    }
}
