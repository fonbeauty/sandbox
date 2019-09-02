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
        openUrl("https://chlist.sitechco.ru");
        fillField("user_auth_email", "y23jppou2inx@mail.ru");
        fillField("user_auth_password", "10405020");
        buttonXpathClick("/html/body/div/fieldset/div[2]/form/div/input");
        Thread.sleep(2000);  // Let the user actually see something!
        buttonIdClick("span_add_ch_button");
        fillField("popup-cl-name", rndString);
        fillField("popup-cl-abbr", rndString);
        buttonXpathClick("//*[@id=\"add_checklist_form\"]/div/div[2]/div[6]/button");
        buttonXpathClick("//*[@id=\"status-panel\"]/span/a[2]");
    }

    private void buttonIdClick(String span_add_ch_button) {
        driver.findElement(By.id(span_add_ch_button)).click();
    }

    private void buttonXpathClick(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    private void fillField(String id, String value) {
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).sendKeys(value);
    }

    private void openUrl(String url) {
        driver.get(url);
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
