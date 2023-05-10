package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementStatus {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");

        //maximize window
        driver.manage().window().maximize();

        //isDisplay-check if element is display (exist) in  html doc.
        WebElement pageHeader=driver.findElement(By.cssSelector(".display-3"));
        System.out.println("pageHeader display status: "+pageHeader.isDisplayed());

        //isEnabled-check if element is enabled/disabled in  html doc.
        //by default all element in html doc is enabled, otherwise its should be mention as disabled.
        WebElement otherGender=driver.findElement(By.id("other"));
        System.out.println("other gender enable status: "+otherGender.isEnabled());

        //isSelected=check if element is selected or not(clicked)
        WebElement maleGender=driver.findElement(By.id("male"));
        System.out.println("male gender selected status : "+maleGender.isSelected());

        //click on male gender and check is selected status
        maleGender.click();
        System.out.println("male gender selected status after clicking: "+maleGender.isSelected());

        //all 3 methods :isEnabled,isDisplayed,isSelected :will throw 'noSuchElementException' if element not exist in  html doc

        driver.quit();

    }
}


