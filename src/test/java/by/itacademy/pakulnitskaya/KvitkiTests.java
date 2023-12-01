package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KvitkiTests extends BaseTest {
    private KvitkiPage kvitkiPage;
    private String baseurl = "https://www.kvitki.by/";
    private String alertEmptyPassword = "Пожалуйста, заполните поле (Пароль)";
    private String alertEmptyEmail = "Пожалуйста, заполните поле (Эл. почта)";
    private String alertIncorrectEmail = "Пожалуйста, введите адрес электронной почты в правильном формате: name@example.com";
    private String alertExpiredCredentials = "Электронная почта или пароль недействительны. Система была обновлена, и в связи с этим мы перешли на вход по электронной почте.";

    @BeforeEach
    public void loadKvitkiPage() throws InterruptedException {
        driver.get(baseurl);
        Thread.sleep(2000);

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
        String actualAlertEmptyPassword = kvitkiPage.getTextEmptyPassword();
        Assertions.assertEquals(alertEmptyPassword, actualAlertEmptyPassword);
    }

    @Test
    public void kvitkiCheckEmptyEmail() throws InterruptedException {
        kvitkiPage.sendKeysPassword("test");
        kvitkiPage.clickInputEmail();
        kvitkiPage.clickInputPassword();
        Thread.sleep(2000);
        String actualAlertEmptyEmail = kvitkiPage.getTextEmptyEmail();
        Assertions.assertEquals(alertEmptyEmail, actualAlertEmptyEmail);
    }

    @Test
    public void kvitkiCheckIncorrectEmail() throws InterruptedException {
        kvitkiPage.sendKeysEmail("test");
        kvitkiPage.clickInputPassword();
        Thread.sleep(2000);
        String actualTextIncorrectEmail = kvitkiPage.getTextIncorrectEmail();
        Assertions.assertEquals(alertIncorrectEmail, actualTextIncorrectEmail);
    }

    @Test
    public void kvitkiCheckIncorrectLogin() throws InterruptedException {
        kvitkiPage.sendKeysEmail("test@test.test");
        kvitkiPage.sendKeysPassword("test");
        kvitkiPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextIncorrectLogin = kvitkiPage.getTextIncorrectLogin();
        Assertions.assertEquals(alertExpiredCredentials, actualTextIncorrectLogin);
    }
}
