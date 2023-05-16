package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadFiles {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        chromeDownloadFiles();
        driver.quit();

    }

    public static void chromeDownloadFiles(){
        String location=System.getProperty("user.dir")+"\\downloads\\";
        System.out.println(location);
        HashMap map=new HashMap();
        map.put("download.default_directory",location);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",map);
        driver.findElement(By.cssSelector("table[id]>tbody>tr:first-of-type>td.text-right>a")).click();
        try{
            Thread.sleep(15000);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
