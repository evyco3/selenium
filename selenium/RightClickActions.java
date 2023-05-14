package com.evy.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RightClickActions {
    static WebDriver driver;
    static Actions actions;
    public static void performRightClick(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        actions.contextClick(driver.findElement(By.cssSelector(".context-menu-one.btn"))).perform();
        List<WebElement> list=driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root>li"));
        for(WebElement element:list){
            if(element.getText().equalsIgnoreCase("Cut")){
                element.click();
                break;
            }
        }
        driver.switchTo().alert().accept();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        actions=new Actions(driver);
        performRightClick();
        driver.quit();
    }
}



