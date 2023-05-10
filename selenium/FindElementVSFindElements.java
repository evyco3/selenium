package com.evy.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVSFindElements {
    public static void main(String[] args) {

        WebDriver driver;
     /*
        findElement():
        scenario :for a single WebElement exist in  html doc
        return type: Will return a single element
        access: directly

      */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        WebElement maleGender=driver.findElement(By.id("male"));
        maleGender.click();
        driver.quit();

        /*
        findElement():
        scenario: for a multiple WebElement exists i  html doc.
        return type:Single webElement (the first 1 that appear in html doc)
        access:directly
         */

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        WebElement gender=driver.findElement(By.cssSelector("input[name=optionsRadios]"));
        gender.click();
        driver.quit();

        /*
        findElement()
        scenario:element is not exist in  html doc.
        return type: 'noSuchElementException' error
         */



        /*
        findElements()
        scenario:a single element is existed in html doc.
        return type:List
        access:iterate the list
         */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        List<WebElement> list1=driver.findElements(By.id("female"));
        list1.get(0).click();
        driver.quit();

        /*
        findElements()
        scenario:multiple element is exited in html doc
        return type:list
        access:iterate the list
         */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        List<WebElement>list2=driver.findElements(By.cssSelector("input[class='form-check-input'][type='checkbox']"));
        System.out.println("list2 size: "+list2.size());
        for(WebElement element:list2){
            System.out.println(element.getAttribute("id"));
        }
        driver.quit();

        /*
        findElements()
        scenario:not exist elements in html doc.
        return type:0 ,doest throw an error return zero elements
         */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        List<WebElement>list3=driver.findElements(By.cssSelector("not exist"));
        System.out.println("list3 size: "+list3.size());
        driver.quit();


    }
}
