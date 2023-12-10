package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TerraPage {
    private WebDriver driver;

    private String buttonCloseCookies = "//button[@class='close-icon']";
    private String linkMenu = "//a[@href='https://terrapizza.by/menu']";
    private String linkMenuItem1 = "//span[contains(.,'Пицца')]";
    private String textItem1Name = "//div[@title='Пицца Маргарита']";
    private String buttonCart1 = "//div[@id='menu-card-364']//button[@class='menu-card__footer-btn add-basket-btn'][contains(text(),'В корзину')]";
    private String linkMenuItem2 = "//span[contains(.,'Бар')]";
    private String textItem2Name = "//div[@title='Пряное яблоко']";
    private String buttonCart2 = "//div[@id='menu-card-2222']//button[@class='menu-card__footer-btn add-basket-btn'][contains(text(),'В корзину')]";

    public TerraPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonCloseCookies() {
        driver.findElement(By.xpath(buttonCloseCookies)).click();
    }

    public void clickLinkMenu() {
        driver.findElement(By.xpath(linkMenu)).click();
    }

    public void clickLinkMenuItem1() {
        driver.findElement(By.xpath(linkMenuItem1)).click();
    }

    public String getTextItem1Name() {
        return driver.findElement(By.xpath((textItem1Name))).getText();
    }

    public void clickLinkMenuItem2() {
        driver.findElement(By.xpath(linkMenuItem2)).click();
    }

    public String getTextItem2Name() {
        return driver.findElement(By.xpath((textItem2Name))).getText();
    }

   public void clickButtonCart1() {
        driver.findElement(By.xpath((buttonCart1))).click();
    }

    public void clickButtonCart2() {
        driver.findElement(By.xpath((buttonCart2))).click();
    }

}
