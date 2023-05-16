package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //How to take full Page screenshot
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src1=ts.getScreenshotAs(OutputType.FILE);
        File dst1=new File("screenshots\\homepage.png");
        FileUtils.copyFile(src1,dst1);

        //How to take section page screenshot
        WebElement navbar=driver.findElement(By.cssSelector(".top-menu.notmobile"));
        File src2=navbar.getScreenshotAs(OutputType.FILE);
        File dst2=new File("screenshots\\navbar.png");
        FileUtils.copyFile(src2,dst2);



        driver.quit();


    }
}
