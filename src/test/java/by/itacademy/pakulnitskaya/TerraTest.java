package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TerraTest extends BaseTest{

    private TerraPage terraPage;
    private String baseurl = "https://terrapizza.by/";

    @BeforeEach
    public void loadTempoPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(baseurl);

        terraPage = new TerraPage(driver);
        terraPage.clickButtonCloseCookies();
        terraPage.clickLinkMenu();


    }
    @Order(1)
    @Test
    public void terraCheckItem1Exist() throws InterruptedException {
       terraPage.clickLinkMenuItem1();
        String actualTextItem1Name = terraPage.getTextItem1Name();
       Assertions.assertEquals("Пицца Маргарита", actualTextItem1Name);
    }

    @Order(2)
    @Test
    public void terraCheckItem2Exist() throws InterruptedException {
        terraPage.clickLinkMenuItem2();
        Thread.sleep(1000);
        String actualTextItem2Name = terraPage.getTextItem2Name();
        Assertions.assertEquals("Пряное яблоко", actualTextItem2Name);
    }

    @Order(3)
    @Test
    public void terraCheckItemsOrder() throws InterruptedException {
        terraPage.clickLinkMenuItem1();
        terraPage.clickButtonCart1();
        Thread.sleep(5000);
        terraPage.clickLinkMenuItem2();
        terraPage.clickButtonCart2();
    }


    }
