package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions=new Actions(driver);


        WebElement oslo=driver.findElement(By.id("box1"));
        WebElement norway=driver.findElement(By.id("box101"));
        actions.dragAndDrop(oslo,norway).perform();

        WebElement stockholm=driver.findElement(By.id("box2"));
        WebElement sweden=driver.findElement(By.id("box102"));
        actions.dragAndDrop(stockholm,sweden).perform();


        Thread.sleep(1500);
        driver.quit();
    }
}
