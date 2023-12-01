package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrwTests extends BaseTest {
    private BrwPage brwPage;
    private String baseurl = "https://pass.rw.by/ru/";
    private String textAuthorization = "Авторизация";
    private String textInputFiled = "Заполните поле";
    private String alertUserNotFound = "Пользователь не найден";

    @BeforeEach
    public void loadBrwPage() throws InterruptedException {
        driver.get(baseurl);
        Thread.sleep(2000);

        brwPage = new BrwPage(driver);

        brwPage.clickTextAlert();
        brwPage.clickLinkLogin();
        Thread.sleep(2000);
    }

    @Test
    public void brwCheckWindowName() throws InterruptedException {
        String actualTextAuthorization = brwPage.getTextAuthorization();
        Assertions.assertEquals(textAuthorization, actualTextAuthorization);
    }

    @Test
    public void brwCheckEmptyEmailPassword() throws InterruptedException {
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyEmail = brwPage.getTextErrorEmptyEmail();
        Assertions.assertEquals(textInputFiled, actualTextErrorEmptyEmail);
        String actualTextErrorEmptyPassword = brwPage.getTextErrorEmptyPassword();
        Assertions.assertEquals(textInputFiled, actualTextErrorEmptyPassword);
    }

    @Test
    public void brwCheckEmptyPassword() throws InterruptedException {
        brwPage.sendKeysEmail("test@test.test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyPassword = brwPage.getTextErrorEmptyPassword();
        Assertions.assertEquals(textInputFiled, actualTextErrorEmptyPassword);
    }

    @Test
    public void brwCheckEmptyEmail() throws InterruptedException {
        brwPage.sendKeysPassword("test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorEmptyEmail = brwPage.getTextErrorEmptyEmail();
        Assertions.assertEquals(textInputFiled, actualTextErrorEmptyEmail);
    }

    @Test
    public void brwCheckIncorrectEmailPassword() throws InterruptedException {
        brwPage.sendKeysEmail("test@test.test");
        brwPage.sendKeysPassword("test");
        brwPage.clickButtonEnter();
        Thread.sleep(2000);
        String actualTextErrorIncorrectLogin = brwPage.getTextErrorIncorrectLogin();
        Assertions.assertEquals(alertUserNotFound, actualTextErrorIncorrectLogin);
    }
}
