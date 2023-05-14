package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");

        //clicking on date table
        driver.findElement(By.id("onward_cal")).click();


        //set month & year
        while(true){
            String monYear=driver.findElement(By.cssSelector(".monthTitle")).getText();
            String []array=monYear.split(" ");
            String month=array[0];
            String year=array[1];
            if(month.equalsIgnoreCase("Oct") && year.equalsIgnoreCase("2023")){
                break;
            }else{
                driver.findElement(By.cssSelector(".next")).click();

            }

        }
        //set day
        List<WebElement> days=driver.findElements(By.cssSelector("td.day"));
        for(WebElement element:days){
            if(element.getText().equalsIgnoreCase("15")){
                element.click();
                break;
            }
        }

        driver.quit();
    }
}
