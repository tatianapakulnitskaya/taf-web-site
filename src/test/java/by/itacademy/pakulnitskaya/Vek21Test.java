package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vek21Test {
    private WebDriver driver;
    private Vek21Page vek21Page;

    @BeforeEach
    public void loadPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.21vek.by/");
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
        Assertions.assertEquals("Электронная почта не указана", actualErrorMessageEmptyEmail);
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals("Пароль не указан", actualErrorMessageEmptyPassword);
    }

    @Test
    public void vek21TestEmptyEmail() {

        vek21Page.sendKeysPassword("TEST");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageEmptyEmail = vek21Page.getErrorMessageIncorrectEmail();
        boolean errorIconEmail = vek21Page.getIconEmail();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals("Электронная почта не указана", actualErrorMessageEmptyEmail);
    }

    @Test
    public void vek21TestIncorrectEmail() {

        vek21Page.sendKeysEmail("Test");
        vek21Page.sendKeysPassword("Test");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageIncorrectEmail = vek21Page.getErrorMessageIncorrectEmail();
        boolean errorIconEmail = vek21Page.getIconEmail();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals("Неправильный формат электронной почты", actualErrorMessageIncorrectEmail);
    }

    @Test
    public void vek21TestEmptyPassword() {

        vek21Page.sendKeysEmail("Test@test.test");
        vek21Page.clickButtonSubmit();
        String actualErrorMessageEmptyPassword = vek21Page.getErrorMessageEmptyPassword();
        boolean errorIconPassword = vek21Page.getIconPassword();
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals("Пароль не указан", actualErrorMessageEmptyPassword);
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
        Assertions.assertEquals("Неправильный пароль. \n" + "Сбросить пароль?", actualErrorMessageIncorrectPassword);

    }

    @AfterEach
    public void quitDriver() {

        driver.quit();
    }

}
