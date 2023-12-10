package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TempoTest extends BaseTest {

    private TempoPage tempoPage;
    private String baseurl = "https://www.pizzatempo.by/";

    @BeforeEach
    public void loadTempoPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(baseurl);

        tempoPage = new TempoPage(driver);

        tempoPage.clickAItemList();
        Thread.sleep(1000);
    }

    @Order(1)
    @Test
    public void tempoCheckItemExist() throws InterruptedException {
        String actualHeaderItemName = tempoPage.getHeaderItemName();
        Assertions.assertEquals("Пицца \"Маргарита\"", actualHeaderItemName);
    }

    @Order(2)
    @Test
    public void tempoCheckItemOrder() throws InterruptedException {
        tempoPage.clickButtonOrder();
        Thread.sleep(1000);
        tempoPage.clickButtonOrderPopup();
        Thread.sleep(1000);
        tempoPage.clickAOrderChart();
        String actualTextItemName = tempoPage.getTextItemName();
        Assertions.assertEquals("Пицца \"Маргарита\" (21см)", actualTextItemName);
    }
}
