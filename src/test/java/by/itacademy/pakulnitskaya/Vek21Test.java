package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Vek21Test extends BaseTest {
    private Vek21Page vek21Page;
    private String baseurl = "https://www.21vek.by/";
    private String alertEmptyEmail = "Электронная почта не указана";
    private String alertEmptyPassword = "Пароль не указан";
    private String alertIncorrectEmail = "Неправильный формат электронной почты";
    private String alertIncorrectPassword = "Неправильный пароль. \n" + "Сбросить пароль?";

    @BeforeEach
    public void loadVek21Page() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(baseurl);
        Thread.sleep(2000);

        vek21Page = new Vek21Page(driver);

        vek21Page.clickButtonAcceptCookies();
        vek21Page.clickButtonAccount();
        vek21Page.clickButtonEnter();
        Thread.sleep(9000);
        vek21Page.clickAdvertisementClose();
    }

    @Test
    public void vek21TestEmptyEmailPassword() {
        vek21Page.clickButtonSubmit();
        String actualErrorMessageEmptyEmail = vek21Page.getErrorMessageIncorrectEmail();
        String actualErrorMessageEmptyPassword = vek21Page.getErrorMessageEmptyPassword();
        boolean errorIconEmail = vek21Page.getIconEmail();
        boolean errorIconPassword = vek21Page.getIconPassword();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals(alertEmptyEmail, actualErrorMessageEmptyEmail);
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals(alertEmptyPassword, actualErrorMessageEmptyPassword);
    }

    @Test
    public void vek21TestEmptyEmail() {
        vek21Page.sendKeysPassword("TEST");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageEmptyEmail = vek21Page.getErrorMessageIncorrectEmail();
        boolean errorIconEmail = vek21Page.getIconEmail();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals(alertEmptyEmail, actualErrorMessageEmptyEmail);
    }

    @Test
    public void vek21TestIncorrectEmail() {
        vek21Page.sendKeysEmail("Test");
        vek21Page.sendKeysPassword("Test");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageIncorrectEmail = vek21Page.getErrorMessageIncorrectEmail();
        boolean errorIconEmail = vek21Page.getIconEmail();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals(alertIncorrectEmail, actualErrorMessageIncorrectEmail);
    }

    @Test
    public void vek21TestEmptyPassword() {
        vek21Page.sendKeysEmail("Test@test.test");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageEmptyPassword = vek21Page.getErrorMessageEmptyPassword();
        boolean errorIconPassword = vek21Page.getIconPassword();
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals(alertEmptyPassword, actualErrorMessageEmptyPassword);
    }

    @Test
    public void vek21TestIncorrectPassword() throws InterruptedException {
        vek21Page.sendKeysEmail("Test@test.test");
        vek21Page.sendKeysPassword("Test");
        vek21Page.clickButtonSubmit();
        Thread.sleep(1000);
        String actualErrorMessageIncorrectPassword = vek21Page.getErrorMessageIncorrectPassword();
        boolean errorIconPassword = vek21Page.getIconPassword();
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals(alertIncorrectPassword, actualErrorMessageIncorrectPassword);

    }
}
