package com.evy.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicWebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://demo.opencart.com/admin/");

        //login
        driver.findElement(By.name("username")).sendKeys("demo");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("button[type]")).click();

        //closing  security popup -waiting for element to be located and close
        new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-close"))).click();

        //clicking on main sidebar
        driver.findElement(By.xpath("//ul[@id='menu']//a[text()=' Sales']")).click();

        //clicking on sub sidebar
        driver.findElement(By.xpath("//ul[@class='collapse show']//a[text()='Orders']")).click();

        //getting web table total pages
        String pages=driver.findElement(By.cssSelector("div.row>div.text-end")).getText();
        int  total_pages=Integer.valueOf(pages.substring(pages.indexOf("(")+1,pages.indexOf(" Pages")));

        for(int i=1;i<=total_pages;i++){
           // Thread.sleep(1500);
            //String active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span")).getText();
            String active_page=new WebDriverWait(driver,Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='pagination']//li//span"))).getText();
            System.out.println("Active page:\t"+active_page);
            int rows=driver.findElements(By.xpath("//table//tbody//tr")).size();
            for(int r=1;r<=rows;r++){
                System.out.print("OrderID: "+driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[2]")).getText());
                System.out.println("\t"+"customerName: "+driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[4]")).getText());
            }
            String page_number=Integer.toString(i+1);
            if(Integer.valueOf(page_number)>total_pages){
                break;
            }
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+page_number+"']")).click();

        }

        driver.quit();
    }
}
