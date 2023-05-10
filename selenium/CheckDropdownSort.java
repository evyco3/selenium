package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckDropdownSort {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        Select select=new Select(driver.findElement(By.name("category_id")));
        List<WebElement> list=select.getOptions();
        ArrayList originalList=new ArrayList();
        ArrayList tempList=new ArrayList();

        for(WebElement element:list){
            originalList.add(element.getText());
            tempList.add(element.getText());
        }
        System.out.println("Original List:\t"+originalList);
        System.out.println("Temp list\t"+tempList);
        Collections.sort(tempList);
        System.out.println("Original List:\t"+originalList);
        System.out.println("Temp list\t"+tempList);
        if(originalList.equals(tempList)){
            System.out.println("Dropdown sorted..");
        }else{
            System.out.println("dropdown not sorted..");
        }
        driver.quit();
    }
}
