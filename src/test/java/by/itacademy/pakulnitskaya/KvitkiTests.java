package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KvitkiTests {

    private KvitkiPage kvitkiPage;
    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.kvitki.by/");

        kvitkiPage = new KvitkiPage(driver);

        kvitkiPage.clickIconEnter();
        kvitkiPage.getTextEnter();
        kvitkiPage.clickButtonCookies();
        kvitkiPage.clickButtonAdvertisement();
        Thread.sleep(2000);
    }

    @Test
    public void kvitkiCheckEmptyPassword() throws InterruptedException {
        kvitkiPage.sendKeysEmail("test@testets.test");
        kvitkiPage.clickInputPassword();
        kvitkiPage.clickInputEmail();
        Thread.sleep(2000);
        String actualTextEmptyPassword =  kvitkiPage.getTextEmptyPassword();
        Assertions.assertEquals("Пожалуйста, заполните поле (Пароль)", actualTextEmptyPassword);
    }

    @Test
    public void kvitkiCheckEmptyEmail() throws InterruptedException {
        kvitkiPage.sendKeysPassword("test");
        kvitkiPage.clickInputEmail();
        kvitkiPage.clickInputPassword();
        Thread.sleep(2000);
        String actualTextEmptyEmail =  kvitkiPage.getTextEmptyEmail();
        Assertions.assertEquals("Пожалуйста, заполните поле (Эл. почта)", actualTextEmptyEmail);
    }

    @Test
    public void kvitkiCheckIncorrectEmail() throws InterruptedException {
        kvitkiPage.sendKeysEmail("test");
        kvitkiPage.clickInputPassword();
        Thread.sleep(2000);
        String actualTextIncorrectEmail =  kvitkiPage.getTextIncorrectEmail();
        Assertions.assertEquals("Пожалуйста, введите адрес электронной почты в правильном формате: name@example.com", actualTextIncorrectEmail);
    }

    @Test
    public void kvitkiCheckIncorrectLogin() throws InterruptedException {
        kvitkiPage.sendKeysEmail("test@test.test");
        kvitkiPage.sendKeysPassword("test");
        kvitkiPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextIncorrectLogin =  kvitkiPage.getTextIncorrectLogin();
        Assertions.assertEquals("Электронная почта или пароль недействительны. Система была обновлена, и в связи с этим мы перешли на вход по электронной почте.", actualTextIncorrectLogin);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
