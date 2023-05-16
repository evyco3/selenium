package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadFiles {
    static WebDriver driver;
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.get("https://www.foundit.in/seeker/registration");
        //uploadFileWithSendKeys(); //if element have a type input type='file'
        uploadFileWithRobot();
        driver.quit();

    }
    public static void uploadFileWithSendKeys(){
        driver.findElement(By.cssSelector("div.contentTitle+input")).sendKeys(System.getProperty("user.dir")+"/downloads/file-sample_100kB.doc");
        try{
            Thread.sleep(3500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void uploadFileWithRobot() throws AWTException {
        WebElement element=driver.findElement(By.cssSelector("div.contentTitle+input"));
        element.click();
        Robot robot=new Robot();
        robot.delay(2000);
        StringSelection s1=new StringSelection(System.getProperty("user.dir")+"/downloads/file-sample_100kB.doc");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1,null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);





    }
}
