package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OzPage {

    private WebDriver driver;

    public String buttonEnterLocator = "/html/body/div[1]/div/header/div[1]/div/div[1]/a/span[2]";
    public String linkEmailOptionLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/a";

    public String textEnterLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[1]/div/p";
    public String inputEmailLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/form/div[2]/div[1]/div[1]/input";
    public String inputPasswordLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/form/div[2]/div[1]/div[2]/input";
    public String buttonSubmitLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/form/button";
    public String textErrorLocator = "/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/form/div[2]/div[2]/div/div";

    public OzPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickEnterButton() {
        driver.findElement(By.xpath(buttonEnterLocator)).click();
    }

    public void clickLinkEmailOption() {
        driver.findElement(By.xpath(linkEmailOptionLocator)).click();
    }

    public void sendKeysEmail(String newEmail) {
        driver.findElement(By.xpath(inputEmailLocator)).sendKeys(newEmail);

    }
    public void sendKeysPassword(String newPassword) {
        driver.findElement(By.xpath(inputPasswordLocator)).sendKeys(newPassword);

    }

    public void clickButtonSubmit() {
        driver.findElement(By.xpath(buttonSubmitLocator)).click();
    }

    public String getTextEnter() {
        return driver.findElement(By.xpath((textEnterLocator))).getText();
    }
    public String getTextError() {
        return driver.findElement(By.xpath((textErrorLocator))).getText();
    }

}
