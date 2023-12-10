package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class DominosTest extends BaseTest {
    private DominosPage dominosPage;
    private String baseurl = "https://dominos.by/";

    private String itemName = "Маргарита";

    @BeforeEach
    public void loadDominosPage() throws InterruptedException {
        driver.get(baseurl);
        Thread.sleep(2000);

        dominosPage = new DominosPage(driver);

        dominosPage.clickButtonClosedAdveritisement();
        Thread.sleep(2000);
    }

    @Order(1)
    @Test
    public void dominosCheckItemExist() throws InterruptedException {
        String actualHeaderItemName = dominosPage.getTextItemName();
        Assertions.assertEquals(itemName, actualHeaderItemName);
    }

    @Order(2)
    @Test
    public void dominosItemOrder() throws InterruptedException {
        dominosPage.clickButtonToCart();
        dominosPage.clickButtonCart();
        String actualTextItemName = dominosPage.getTextOrderName();
        Assertions.assertEquals(itemName, actualTextItemName);
    }
}
