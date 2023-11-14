package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vek21Test {
    WebDriver driver;
    Vek21Page vek21Page;

    @BeforeEach
    public void loadPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.21vek.by/");
        Thread.sleep(2000);

        vek21Page = new Vek21Page();

        driver.findElement(By.xpath(vek21Page.buttonAcceptCookiesLocator)).click();
        driver.findElement(By.xpath(vek21Page.buttonAccountLocator)).click();
        driver.findElement(By.xpath(vek21Page.buttonEnterLocator)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(vek21Page.buttonAdvertisementCloseLocator)).click();
    }

    @Test
    public void vek21TestEmptyEmailPassword() {

        driver.findElement(By.xpath(vek21Page.buttonSubmitLocator)).click();
        String actualErrorMessageEmptyEmail = driver.findElement(By.xpath((vek21Page.errorMessageEmptyEmailLocator))).getText();
        String actualErrorMessageEmptyPassword = driver.findElement(By.xpath((vek21Page.errorMessageEmptyPasswordLocator))).getText();
        boolean errorIconEmail = driver.findElement(By.xpath(vek21Page.errorIconEmailLocator)).isDisplayed();
        boolean errorIconPassword = driver.findElement(By.xpath(vek21Page.errorIconPasswordLocator)).isDisplayed();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals("Электронная почта не указана", actualErrorMessageEmptyEmail);
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals("Пароль не указан", actualErrorMessageEmptyPassword);
    }

    @Test
    public void vek21TestEmptyEmail() {

        driver.findElement(By.xpath(vek21Page.inputPasswrodLocator)).sendKeys("Test");
        driver.findElement(By.xpath(vek21Page.buttonSubmitLocator)).click();
        String actualErrorMessageEmptyEmail = driver.findElement(By.xpath((vek21Page.errorMessageEmptyEmailLocator))).getText();
        boolean errorIconEmail = driver.findElement(By.xpath(vek21Page.errorIconEmailLocator)).isDisplayed();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals("Электронная почта не указана", actualErrorMessageEmptyEmail);
        driver.quit();
    }

    @Test
    public void vek21TestIncorrectEmail() {

        driver.findElement(By.xpath(vek21Page.inputEmailLocator)).sendKeys("Test");
        driver.findElement(By.xpath(vek21Page.inputPasswrodLocator)).sendKeys("Test");
        driver.findElement(By.xpath(vek21Page.buttonSubmitLocator)).click();
        String actualErrorMessageIncorrectEmail = driver.findElement(By.xpath((vek21Page.errorMessageIncorrectEmailLocator))).getText();
        boolean errorIconEmail = driver.findElement(By.xpath(vek21Page.errorIconEmailLocator)).isDisplayed();
        Assertions.assertTrue(errorIconEmail);
        Assertions.assertEquals("Неправильный формат электронной почты", actualErrorMessageIncorrectEmail);
        driver.quit();
    }

    @Test
    public void vek21TestEmptyPassword() {

        driver.findElement(By.xpath(vek21Page.inputEmailLocator)).sendKeys("Test@test.test");
        driver.findElement(By.xpath(vek21Page.buttonSubmitLocator)).click();
        String actualErrorMessageEmptyPassword = driver.findElement(By.xpath((vek21Page.errorMessageEmptyPasswordLocator))).getText();
        boolean errorIconPassword = driver.findElement(By.xpath(vek21Page.errorIconPasswordLocator)).isDisplayed();
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals("Пароль не указан", actualErrorMessageEmptyPassword);
        driver.quit();
    }

    @Test
    public void vek21TestIncorrectPassword() throws InterruptedException {

        driver.findElement(By.xpath(vek21Page.inputEmailLocator)).sendKeys("Test@test.test");
        driver.findElement(By.xpath(vek21Page.inputPasswrodLocator)).sendKeys("Test");
        driver.findElement(By.xpath(vek21Page.buttonSubmitLocator)).click();
        Thread.sleep(1000);
        String actualErrorMessageIncorrectPassword = driver.findElement(By.xpath((vek21Page.errorMessageIncorrectPasswordLocator))).getText();
        boolean errorIconPassword = driver.findElement(By.xpath(vek21Page.errorIconPasswordLocator)).isDisplayed();
        Assertions.assertTrue(errorIconPassword);
        Assertions.assertEquals("Неправильный пароль. \n" + "Сбросить пароль?", actualErrorMessageIncorrectPassword);
        driver.quit();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
