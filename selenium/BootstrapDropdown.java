package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html#");
        driver.manage().window().maximize();

        driver.findElement(By.id("menu1")).click();
        List<WebElement> list=driver.findElements(By.cssSelector("ul[role]>li"));
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("javascript")){
                element.click();
                break;
            }
        }
        driver.quit();




    }
}
