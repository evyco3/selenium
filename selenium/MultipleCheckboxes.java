package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MultipleCheckboxes {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        selectCheckboxes(driver.findElements(By.cssSelector("input[class='form-check-input'][type='checkbox']")),"monday","sunday");
        Thread.sleep(1500);
        driver.quit();
    }

    public static void selectCheckboxes(List<WebElement> list, String...value){
        if (!value[0].equalsIgnoreCase("all")) {
            for(WebElement element:list){
                String str=element.getAttribute("id");
                for(String s:value){
                    if(s.equalsIgnoreCase(str)){
                        element.click();
                        break;
                    }
                }
            }
        }else{
            for(WebElement element:list){
                element.click();
            }
        }
    }
}
