package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OzTest extends BaseTest {
    private OzPage ozPage;
    private String baseurl = "https://www.oz.by/";

    @BeforeEach
    public void loadOzPage() {
        driver.manage().window().maximize();
        driver.get(baseurl);

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
}
