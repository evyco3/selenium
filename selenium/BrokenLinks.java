package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    static WebDriver driver;
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        checkBrokenLinks();
        driver.quit();
    }
    public static void checkBrokenLinks() throws IOException {
        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links=driver.findElements(By.tagName("a"));
        for(WebElement element:links){
            String url=element.getAttribute("href");
            if(url.isEmpty() ||url==null){
                System.out.println("URL is empty");
            }
            URL link=new URL(url);
            HttpURLConnection http= (HttpURLConnection) link.openConnection();
            http.connect();
            if(http.getResponseCode()>=400){
                System.out.println(http.getResponseCode()+"\t"+url+" is broken link");
            }
            else{
                System.out.println(http.getResponseCode()+"\t"+url+"\tis valid link");
            }





        }

    }
}
