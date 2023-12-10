package by.itacademy.pakulnitskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TempoPage {

    private WebDriver driver;
    private String aItemList = "//a[@href='https://www.pizzatempo.by/menu/pizza.html']";
    private String buttonOrder = "(//span[contains(text(),'Заказ')])[29]";
    private String headerItemName = "//span[contains(text(),'Пицца \"Маргарита\"')]";
    private String buttonOrderPopup = "//button[contains(text(),'Заказ')]";
    private String aOrderChart = "//a[@href='https://www.pizzatempo.by/menu/order/']";
    private String textItemName = "//div[@class=\"content\"]//div[(contains(text(), \"Маргарита\"))]";

    public TempoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAItemList() {
        driver.findElement(By.xpath(aItemList)).click();
    }

    public void clickButtonOrder() {
        driver.findElement(By.xpath(buttonOrder)).click();
    }

    public String getHeaderItemName() {
        return driver.findElement(By.xpath((headerItemName))).getText();
    }

    public void clickButtonOrderPopup() {
        driver.findElement(By.xpath(buttonOrderPopup)).click();
    }

    public void clickAOrderChart() {
        driver.findElement(By.xpath(aOrderChart)).click();
    }

    public String getTextItemName() {
        return driver.findElement(By.xpath((textItemName))).getText();
    }
}
