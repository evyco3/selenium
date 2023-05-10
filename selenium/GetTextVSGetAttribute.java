package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVSGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();


        //locate email and password elements
        WebElement email=driver.findElement(By.id("Email"));
        WebElement password=driver.findElement(By.id("Password"));

        //how to getAttribute value from element
        System.out.println("email value:\t"+email.getAttribute("value"));
        System.out.println("password value:\t"+password.getAttribute("value"));

        //how to clear suggested text from element
        email.clear();
        password.clear();

        //how to send keys to element
        email.sendKeys("myEmail@walla.com");
        password.sendKeys("123456");

        //How to getText from element
        String pageHeader=driver.findElement(By.cssSelector(".page-title>h1")).getText();
        System.out.println("Page Header text:\t"+pageHeader);

        //getText-return the inner String of the element
        //getAttribute('value')-return 1 of the character of element


        driver.quit();

    }
}
