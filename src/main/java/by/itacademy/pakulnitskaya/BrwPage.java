package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrwPage {

    private WebDriver driver;
    private String textAlertLocator = "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/main/div[9]/div/div/div[1]/button";
    private String linkLoginLocator = "/html/body/div[1]/div[1]/div[1]/div/header/div/div[3]/div[3]/ul/li[2]/a/span[2]";
    private String textAuthorizationLocator = "//div[@class='auth-modal__title h3' and contains(., 'Авторизация')]";
    private String inputEmailLocator = "/html/body/div[1]/div[1]/div[7]/div/div/div[2]/form/fieldset/div[1]/label/div[2]/input";
    private String inputPasswordLocator = "/html/body/div[1]/div[1]/div[7]/div/div/div[2]/form/fieldset/div[2]/div[1]/div/label/div[2]/input";
    private String buttonEnterLocator = "/html/body/div[1]/div[1]/div[7]/div/div/div[2]/form/fieldset/div[3]/input";
    private String textErrorEmptyEmailLocator = "//*[@id=\"login-error\"]";
    private String textErrorEmptyPasswordLocator = "/html/body/div[1]/div[1]/div[7]/div/div/div[2]/form/fieldset/div[2]/div[1]/div/div/label";
    private String textErrorIncorrectLoginLocator = "//*[@id=\"auth-popup\"]/div/div/div[2]/div[2]/div";


    public BrwPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTextAlert() {
        driver.findElement(By.xpath(textAlertLocator)).click();
    }

    public void clickLinkLogin() {
        driver.findElement(By.xpath(linkLoginLocator)).click();
    }

    public String getTextAuthorization() {
        return driver.findElement(By.xpath((textAuthorizationLocator))).getText();
    }

    public void sendKeysEmail(String newEmail) {
        driver.findElement(By.xpath(inputEmailLocator)).sendKeys(newEmail);

    }

    public void sendKeysPassword(String newPassword) {
        driver.findElement(By.xpath(inputPasswordLocator)).sendKeys(newPassword);

    }

    public void clickButtonEnter() {
        driver.findElement(By.xpath(buttonEnterLocator)).click();
    }

    public String getTextErrorEmptyEmail() {
        return driver.findElement(By.xpath((textErrorEmptyEmailLocator))).getText();
    }

    public String getTextErrorEmptyPassword() {
        return driver.findElement(By.xpath((textErrorEmptyPasswordLocator))).getText();
    }

    public String getTextErrorIncorrectLogin() {
        return driver.findElement(By.xpath((textErrorIncorrectLoginLocator))).getText();
    }
}
