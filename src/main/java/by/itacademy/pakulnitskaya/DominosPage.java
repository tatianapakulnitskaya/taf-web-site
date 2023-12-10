package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DominosPage {
    private WebDriver driver;
    private String buttonClosedAdveritisement = "//button[@class='custom-button custom-button--transparent custom-button--no-paddings custom-button--size-small custom-modal__close-button']";
    private String buttonToCart = "//*[@id=\"app-root\"]/div/div[1]/div[2]/div[6]/div/div/div[30]/div/div[6]/div[2]/button";
    private String textItemName = "//div[contains(text(),'Маргарита')]";
    private String buttonCart = "//span[@class='cart-button__button-text']";
    private String textOrderName = "//div[@class='product-card product-card--horizontal product-card--media-full product-card--mini-bag']//div[@class='product-card__title'][contains(text(),'Маргарита')]";

    public DominosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonClosedAdveritisement() {
        driver.findElement(By.xpath(buttonClosedAdveritisement)).click();
    }

    public void clickButtonToCart() {
        driver.findElement(By.xpath(buttonToCart)).click();
    }

    public String getTextItemName() {
        return driver.findElement(By.xpath((textItemName))).getText();
    }

    public void clickButtonCart() {
        driver.findElement(By.xpath(buttonCart)).click();
    }

    public String getTextOrderName() {
        return driver.findElement(By.xpath((textOrderName))).getText();
    }
}
