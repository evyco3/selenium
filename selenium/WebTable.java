package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        int rows=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int cols=driver.findElements(By.xpath("//table[@id='customers']//tr[2]//td")).size();
        System.out.println("rows:\t"+rows);
        System.out.println("cols:\t"+cols);

        for(int i=2;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                String val=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]")).getText();
                System.out.print(val+"\t");
            }
            System.out.println();
        }
        driver.quit();

    }
}
