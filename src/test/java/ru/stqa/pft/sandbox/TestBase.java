package ru.stqa.pft.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class TestBase {
    WebDriver driver;

    public static String getRandomString(int stringLength) {
        String charSet = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            text[i] = charSet.charAt(rnd.nextInt(charSet.length()));
        }
        return new String(text);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver_76/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://chlist.sitechco.ru");
        login("y23jppou2inx@mail.ru", "10405020");
    }

    @AfterMethod
    public void tierDown() throws InterruptedException {
//        driver.findElement(By.id("quit")).click();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }


    protected void returnListCheckList() {
        driver.findElement(By.xpath("//*[@id=\"status-panel\"]/span/a[2]")).click();
    }

    protected void submitCheckListCreation() {
        driver.findElement(By.xpath("//*[@id=\"add_checklist_form\"]/div/div[2]/div[6]/button")).click();
    }

    protected void fillAddCheckListForm(String checkListName, String checkListAbbr) {
        driver.findElement(By.id("popup-cl-name")).click();
        driver.findElement(By.id("popup-cl-name")).sendKeys(checkListName);
        driver.findElement(By.id("popup-cl-abbr")).click();
        driver.findElement(By.id("popup-cl-abbr")).sendKeys(checkListAbbr);
    }

    protected void clickAddCheckList() {
        driver.findElement(By.id("span_add_ch_button")).click();
    }

    private void login(String userLogin, String userPassword) throws InterruptedException {
        driver.findElement(By.id("user_auth_email")).click();
        driver.findElement(By.id("user_auth_email")).sendKeys(userLogin);
        driver.findElement(By.id("user_auth_password")).click();
        driver.findElement(By.id("user_auth_password")).sendKeys(userPassword);
        driver.findElement(By.xpath("/html/body/div/fieldset/div[2]/form/div/input")).click();
        Thread.sleep(2000);  // Let the user actually see something!
    }

    protected void deleteSelectedCheckList() {
        driver.findElement(By.id("span_delete_button")).click();
        driver.findElement(By.xpath("//*[@id=\"simple_delete_checklist_form\"]/div/div[2]/div[2]/input")).click();
    }

    protected void selectCheckList() {
        driver.findElement(By.id("global_ch")).click();
    }
}
