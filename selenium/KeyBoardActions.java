package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyBoardActions {
    public static void main(String[] args) {
        //perform copy & paste

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://text-compare.com/");

        //input box 1
        WebElement input1 = driver.findElement(By.name("text1"));
        input1.sendKeys("Hello World!");

        //input box 2
        WebElement input2 = driver.findElement(By.name("text2"));


        Actions actions = new Actions(driver);
        //CTRL+A
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //CTRL+C
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //TAB-shift to input2 box
        actions.sendKeys(Keys.TAB);
        actions.perform();

        //CTRL+V
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

       driver.findElement(By.id("compareButtonSpinner")).click();
       String textCompare=driver.findElement(By.cssSelector(".messageForUser")).getText();
       if(textCompare.contains("The two texts are identical")){
           System.out.println("Test pass");
       }else{
           System.out.println("Test failed");
       }


    }
}
