package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Cookies {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //How to capture All Cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of cookies:\t" + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "\t" + cookie.getValue());
        }
        //add a cookie
        Cookie c1=new Cookie("c1","123");
        driver.manage().addCookie(c1);
        cookies=driver.manage().getCookies();
        System.out.println("Cookies size after adding 1 cookie:\t"+cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "\t" + cookie.getValue());
        }
        //delete a cookie
        driver.manage().deleteCookie(c1);
        cookies=driver.manage().getCookies();
        System.out.println("cookies size after delete 1 cookie:\t"+cookies.size());

        //how to delete all cookies
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("Cookies size: after deleting all coockies "+cookies.size());


        driver.quit();
    }





}
