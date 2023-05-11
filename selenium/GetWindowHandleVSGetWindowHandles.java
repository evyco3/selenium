package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetWindowHandleVSGetWindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String windowID=driver.getWindowHandle();
        System.out.println("windowID\t"+windowID);

        //open second window
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        List<String> windowIDS=new ArrayList<>(driver.getWindowHandles());
        System.out.println("Parent id: "+windowIDS.get(0));
        System.out.println("child id: "+windowIDS.get(1));

        //switch to parent window
        driver.switchTo().window(windowIDS.get(0));
        System.out.println(driver.getTitle());

        //switch to child window
        driver.switchTo().window(windowIDS.get(1));
        System.out.println(driver.getTitle());

        //closing 1 of the window's by his title
        for(String win:windowIDS){
            String title=driver.switchTo().window(win).getTitle();
            if(title.equalsIgnoreCase("ORANGEHRM")){
                driver.close();
            }
        }
        driver.quit();
    }
}
