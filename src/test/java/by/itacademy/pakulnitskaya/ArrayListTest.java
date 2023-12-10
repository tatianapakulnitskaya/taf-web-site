package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest extends BaseTest {
    private String menuItemLocator = "//div[@class='mainmenu']/ul/li";

    @Test
    public void findMenuItem() {
        driver.get("https://pizzatempo.by/");
        List<WebElement> menuItems = driver.findElements(By.xpath(menuItemLocator));
        Assertions.assertEquals(9, menuItems.size());
        List<String> menuItemsString = new ArrayList<>();
        for (int i=0;i<menuItems.size();i++){
            menuItemsString.add(menuItems.get(i).getText());

        }
        List<String> expectedMenuItemsString =new ArrayList<>(Arrays.asList("ПИЦЦА", "АКЦИИ", "БУРГЕРЫ, ЗАКУСКИ, ФРИ", "САЛАТЫ, СУПЫ, ХЛЕБ", "ГОРЯЧИЕ БЛЮДА", "НАПИТКИ", "ДЕСЕРТЫ", "ДЕТСКОЕ МЕНЮ", "ПРИБОРЫ"));
        Assertions.assertEquals(expectedMenuItemsString,menuItemsString);

    }
}
