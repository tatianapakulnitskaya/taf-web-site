package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OzTest {

    private OzPage ozPage;
    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.oz.by/");

        ozPage = new OzPage(driver);

        ozPage.clickEnterButton();
        ozPage.clickLinkEmailOption();
    }

    @Test
    public void ozCheckEnterMessage() throws InterruptedException {
        String actualErrorMessage = ozPage.getTextEnter();
        Assertions.assertEquals("Вход", actualErrorMessage);
    }

    @Test
    public void ozIncorrectCredentials() throws InterruptedException {
        ozPage.sendKeysEmail("test@testets.test");
        ozPage.sendKeysPassword("test");
        ozPage.clickButtonSubmit();
        Thread.sleep(2000);
        String actualErrorMessage = ozPage.getTextError();
        Assertions.assertEquals("Адрес электронной почты не зарегистрирован. Зарегистрироваться", actualErrorMessage);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
