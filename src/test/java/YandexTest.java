import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class YandexTest extends WebDriverSettings{


    By search = By.xpath("//span[contains(@class,'suggest2-autocomplete__entered')]");


    @Test
    public void firstTest() {

        MainPage mainPage = PageFactory.initElements(webDriver, MainPage.class);

        mainPage.open();

        mainPage.goToMarket();


        MarketPage marketPage = PageFactory.initElements(webDriver, MarketPage.class);

        marketPage.search("ноутбуки");

        Assertions.assertEquals(webDriver
                .findElement(search)
                .getAttribute("innerHTML"), "ноутбуки", "Упс, что-то пошло не так");

        marketPage.clickSearchButton();

        marketPage.setPriceFrom("100000");
        marketPage.setPriceTo("200000");

        marketPage.setCheckBoxes(new String[] {"Apple", "ASUS", "HP", "Xiaomi"});
        marketPage.assertCheckBoxes(new String[] {"Apple", "ASUS", "HP", "Xiaomi"});

        marketPage.clickCheckBox("Процессор Core i7");

        marketPage.assertPriceTable(100000, 200000);

        marketPage.search("Зеленый слоник");
        marketPage.clickSearchButton();


        marketPage.clickProduct("Худи");

        mainPage.open();
    }
}
