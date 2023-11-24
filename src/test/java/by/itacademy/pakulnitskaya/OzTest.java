package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OzTest {

    private OzPage ozPage;
    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void loadPage() {
        driver.manage().window().maximize();
        driver.get("https://www.oz.by/");

        ozPage = new OzPage(driver);

        ozPage.clickEnterButton();
        ozPage.clickLinkEmailOption();
    }

    @Order(2)
    @Test
    public void ozCheckEnterMessage() {
        String actualErrorMessage = ozPage.getTextEnter();
        Assertions.assertEquals("Вход", actualErrorMessage);
    }

    @Order(1)
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
