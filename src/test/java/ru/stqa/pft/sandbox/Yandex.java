package ru.stqa.pft.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
//import org.junit.Test;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Yandex {
    WebDriver driver;
//    ChromeDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver_76/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testAddProject() throws InterruptedException {
        driver.get("https://chlist.sitechco.ru");
        driver.findElement(By.id ("user_auth_email")).click();
        driver.findElement(By.id ("user_auth_email")).clear();
        driver.findElement(By.id ("user_auth_email")).sendKeys("y23jppou2inx@mail.ru");
        driver.findElement(By.id("user_auth_password")).click();
        driver.findElement(By.id("user_auth_password")).clear();
        driver.findElement(By.id("user_auth_password")).sendKeys("10405020");
        driver.findElement(By.xpath("/html/body/div/fieldset/div[2]/form/div/input")).click();
        Thread.sleep(5000);  // Let the user actually see something!
    }

        public void tierDown(){
            driver.quit();
        }

//    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver_76/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
