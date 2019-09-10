package ru.stqa.pft.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Random;


public class Yandex {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver_76/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testAddProject() throws InterruptedException {
        String rndString = getRandomString(6);
        driver.get("https://chlist.sitechco.ru");
        driver.findElement(By.id("user_auth_email")).click();
        driver.findElement(By.id("user_auth_email")).sendKeys("y23jppou2inx@mail.ru");
        driver.findElement(By.id("user_auth_password")).click();
        driver.findElement(By.id("user_auth_password")).sendKeys("10405020");
        driver.findElement(By.xpath("/html/body/div/fieldset/div[2]/form/div/input")).click();
        Thread.sleep(2000);  // Let the user actually see something!
        driver.findElement(By.id("span_add_ch_button")).click();
        driver.findElement(By.id("popup-cl-name")).click();
        driver.findElement(By.id("popup-cl-name")).sendKeys(rndString);
        driver.findElement(By.id("popup-cl-abbr")).click();
        driver.findElement(By.id("popup-cl-abbr")).sendKeys(rndString);
        driver.findElement(By.xpath("//*[@id=\"add_checklist_form\"]/div/div[2]/div[6]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"status-panel\"]/span/a[2]")).click();
    }


    //    @AfterMethod
    public void tierDown() throws InterruptedException {
//        driver.findElement(By.id("quit")).click();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }


    public static String getRandomString(int stringLength){
        String charSet = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++)
        {
            text[i] = charSet.charAt(rnd.nextInt(charSet.length()));
        }
        return new String(text);
    }
}
