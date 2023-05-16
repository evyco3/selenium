package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        //location & size of min slider element
        WebElement min_slider=driver.findElement(By.cssSelector("div#slider-range>span:first-of-type"));
        System.out.println("min slider location:\t"+min_slider.getLocation());
        System.out.println("min slider size:\t"+min_slider.getSize());

        //location & size of max slider element
        WebElement max_slider=driver.findElement(By.cssSelector("div#slider-range>span:last-of-type"));
        System.out.println("max slider location:\t"+max_slider.getLocation());
        System.out.println("max slider size:\t"+max_slider.getSize());

        Actions actions=new Actions(driver);
        actions.dragAndDropBy(min_slider,190,0).perform();
        actions.dragAndDropBy(max_slider,-240,0).perform();
        System.out.println("min slider current location\t"+min_slider.getLocation());
        System.out.println("max slider current location\t"+max_slider.getLocation());

        driver.quit();
    }
}
