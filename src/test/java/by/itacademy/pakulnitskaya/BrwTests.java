package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.assertj.core.api.SoftAssertions;
import org.testng.asserts.SoftAssert;


public class BrwTests {

    private BrwPage brwPage;
    private WebDriver driver = new ChromeDriver();


    @BeforeEach
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://pass.rw.by/ru/");
        Thread.sleep(2000);

        brwPage = new BrwPage(driver);

        brwPage.clickTextAlert();
        brwPage.clickLinkLogin();
    }

    @Test
    public void brwCheckEmptyEmailPassword() throws InterruptedException {
        Thread.sleep(2000);
        String actualTextAuthorization = brwPage.getTextAuthorization();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Авторизация",actualTextAuthorization,"Title is not mathing");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyEmail = brwPage.getTextErrorEmptyEmail();
        Assertions.assertEquals("Заполните поле", actualTextErrorEmptyEmail);
        String actualTextErrorEmptyPassword = brwPage.getTextErrorEmptyPassword();
        Assertions.assertEquals("Заполните поле", actualTextErrorEmptyPassword);
    }

    @Test
    public void brwCheckEmptyPassword() throws InterruptedException {
        Thread.sleep(2000);
        String actualTextAuthorization = brwPage.getTextAuthorization();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Авторизация",actualTextAuthorization,"Title is not mathing");
        brwPage.sendKeysEmail("test@test.test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyPassword = brwPage.getTextErrorEmptyPassword();
        Assertions.assertEquals("Заполните поле", actualTextErrorEmptyPassword);
    }

    @Test
    public void brwCheckEmptyEmail() throws InterruptedException {
        Thread.sleep(2000);
        String actualTextAuthorization = brwPage.getTextAuthorization();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Авторизация",actualTextAuthorization,"Title is not mathing");
        brwPage.sendKeysPassword("test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyEmail = brwPage.getTextErrorEmptyEmail();
        Assertions.assertEquals("Заполните поле", actualTextErrorEmptyEmail);
    }

    @Test
    public void brwCheckIncorrectEmailPassword() throws InterruptedException {
        Thread.sleep(2000);
        String actualTextAuthorization = brwPage.getTextAuthorization();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Авторизация",actualTextAuthorization,"Title is not mathing");
        brwPage.sendKeysEmail("test@test.test");
        brwPage.sendKeysPassword("test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorIncorrectLogin = brwPage.getTextErrorIncorrectLogin();
        Assertions.assertEquals("Пользователь не найден", actualTextErrorIncorrectLogin);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
