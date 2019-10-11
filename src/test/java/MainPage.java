import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement market;

    void open() {
        webDriver.get("https://yandex.ru");
    }

    void goToMarket() {
        market.click();
    }

}


