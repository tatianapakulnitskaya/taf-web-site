package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Vek21Page {
    private WebDriver driver;
    private String errorIconEmailLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[1]/div[3]/span[1]";
    private String errorMessageEmptyPasswordLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[2]/div[3]/span[2]";
    private String errorIconPasswordLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[2]/div[3]/span[1]";
    private String errorMessageIncorrectPasswordLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[2]/div[3]";
    private String errorMessageIncorrectEmailLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[1]/div[3]/span[2]";
    private String buttonAdvertisementCloseLocator = "//*[@id=\"popmechanic-form-64749\"]/div[2]";
    private String inputEmailLocator = "//*[@id=\"login-email\"]";
    private String inputPasswordLocator = "//*[@id=\"login-password\"]";
    private String buttonSubmitLocator = "//*[@id=\"default-:R2mm:-modal\"]/div/div/div[2]/div/div/form/div/div[3]/button";
    private String buttonEnterLocator = "//*[@id=\"userToolsDropDown\"]/div/div[1]/div[2]/button";
    private String buttonAccountLocator = "//*[@id=\"header\"]/div/div[5]/div/div[3]/div/div/div/button";
    private String buttonAcceptCookiesLocator = "//*[@id=\"modal-cookie\"]/div/div[2]/div/button[3]/div";

    public Vek21Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonEnter() {
        driver.findElement(By.xpath(buttonEnterLocator)).click();
    }


    public void clickButtonSubmit() {
        driver.findElement(By.xpath(buttonSubmitLocator)).click();
    }


    public void clickButtonAccount() {

        driver.findElement(By.xpath(buttonAccountLocator)).click();
    }


    public void clickButtonAcceptCookies() {
        driver.findElement(By.xpath(buttonAcceptCookiesLocator)).click();
    }


    public void clickAdvertisementClose() {
        driver.findElement(By.xpath(buttonAdvertisementCloseLocator)).click();
    }


    public void sendKeysEmail(String newEmail) {
        driver.findElement(By.xpath(inputEmailLocator)).sendKeys(newEmail);

    }

    public void sendKeysPassword(String newPassword) {
        driver.findElement(By.xpath(inputPasswordLocator)).sendKeys(newPassword);

    }

    public String getErrorMessageIncorrectEmail() {
        return driver.findElement(By.xpath((errorMessageIncorrectEmailLocator))).getText();
    }

    public String getErrorMessageIncorrectPassword() {
        return driver.findElement(By.xpath((errorMessageIncorrectPasswordLocator))).getText();
    }

    public String getErrorMessageEmptyPassword() {
        return driver.findElement(By.xpath((errorMessageEmptyPasswordLocator))).getText();
    }

    public boolean getIconEmail() {
        return driver.findElement(By.xpath(errorIconEmailLocator)).isDisplayed();
    }

    public boolean getIconPassword() {
        return driver.findElement(By.xpath(errorIconPasswordLocator)).isDisplayed();
    }
}
