package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KvitkiPage {
    private WebDriver driver;
    private String iconEnterLocator = "/html/body/div[3]/div[2]/div/app-user-account-link/app-profile-link";
    private String buttonCookiesLocator = "//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]";
    private String buttonAdvertisementLocator = "/html/body/div[7]/div";
    private String textEnterLocator = "//*[@id=\"mat-tab-label-0-0\"]/span[2]/span[1]";
    private String inputEmailLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-form-builder/form/app-collapsible[1]/app-email-input/div/input";
    private String inputPasswordLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-form-builder/form/app-collapsible[2]/app-password-input/div/input";
    private String textEmptyPasswordLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-form-builder/form/app-collapsible[2]/app-password-input/app-field-error/app-collapsible";
    private String textEmptyEmailLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-form-builder/form/app-collapsible[1]/app-email-input/app-field-error/app-collapsible";
    private String textIncorrectEmailLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-form-builder/form/app-collapsible[1]/app-email-input/app-field-error/app-collapsible";
    private String textIncorrectLoginLocator = "//*[@id=\"mat-mdc-dialog-1\"]/div/div/app-info-dialog-content/div[3]";
    private String buttonEnterLocator = "/html/body/div[9]/div[2]/div/mat-dialog-container/div/div/app-user-auth-form/div[2]/mat-tab-group/div/mat-tab-body[1]/div/app-user-login-form/app-collapsible/div/app-ui-button/button";

    public KvitkiPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIconEnter() {
        driver.findElement(By.xpath(iconEnterLocator)).click();
    }

    public void clickButtonCookies() {
        driver.findElement(By.xpath(buttonCookiesLocator)).click();
    }

    public void clickButtonAdvertisement() {
        driver.findElement(By.xpath(buttonAdvertisementLocator)).click();
    }

    public String getTextEnter() {
        return driver.findElement(By.xpath((textEnterLocator))).getText();
    }

    public void sendKeysEmail(String newEmail) {
        driver.findElement(By.xpath(inputEmailLocator)).sendKeys(newEmail);

    }

    public void sendKeysPassword(String newPassword) {
        driver.findElement(By.xpath(inputPasswordLocator)).sendKeys(newPassword);

    }

    public void clickInputEmail() {
        driver.findElement(By.xpath(inputEmailLocator)).click();
    }

    public void clickInputPassword() {
        driver.findElement(By.xpath(inputPasswordLocator)).click();
    }

    public String getTextEmptyPassword() {
        return driver.findElement(By.xpath((textEmptyPasswordLocator))).getText();
    }

    public String getTextEmptyEmail() {
        return driver.findElement(By.xpath((textEmptyEmailLocator))).getText();
    }

    public String getTextIncorrectEmail() {
        return driver.findElement(By.xpath((textIncorrectEmailLocator))).getText();
    }

    public void clickButtonEnter() {
        driver.findElement(By.xpath(buttonEnterLocator)).click();
    }

    public String getTextIncorrectLogin() {
        return driver.findElement(By.xpath((textIncorrectLoginLocator))).getText();
    }
}
