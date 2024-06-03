package com.example.demo.chromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.hao123.com/?src=from_pc");
        String title = driver.getTitle();
        WebElement element = driver.findElement(By.name("word"));
        element.sendKeys("百度一下下 ");
        driver.findElement(By.className("g-cp")).click();
        System.out.print("tttt" + title);
    }
}
