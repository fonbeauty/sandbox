package ru.stqa.pft.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class deleteCheckLists {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver_76/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://chlist.sitechco.ru");
        login("y23jppou2inx@mail.ru", "10405020");
    }

    @Test
    public void testDeleteCheckLists() throws InterruptedException {
        driver.findElement(By.id("global_ch")).click();
        driver.findElement(By.id("span_delete_button")).click();
//        Thread.sleep(2000);  // Let the user actually see something!
        driver.findElement(By.xpath("//*[@id=\"simple_delete_checklist_form\"]/div/div[2]/div[2]/input")).click();
    }

    //    @AfterMethod
    public void tierDown() throws InterruptedException {
//        driver.findElement(By.id("quit")).click();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    private void login(String userLogin, String userPassword) throws InterruptedException {
        driver.findElement(By.id("user_auth_email")).click();
        driver.findElement(By.id("user_auth_email")).sendKeys(userLogin);
        driver.findElement(By.id("user_auth_password")).click();
        driver.findElement(By.id("user_auth_password")).sendKeys(userPassword);
        driver.findElement(By.xpath("/html/body/div/fieldset/div[2]/form/div/input")).click();
        Thread.sleep(2000);  // Let the user actually see something!
    }

}
