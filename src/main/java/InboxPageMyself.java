import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPageMyself {
    private WebDriver driver;

    public InboxPageMyself(WebDriver driver) {
        this.driver = driver;
    }
    public By emailLastMessage= By.xpath("(//span[contains(text(), 'Тест Тестов')])[1]");
    public By themeLastMessage= By.xpath("(//span[contains(text(), 'Тема1')])[1]");
    public By textLastMessage = By.xpath("(//span[contains(text(), 'Текст')])[1]");
    public By checkEmailLastMessage= By.xpath("(//span[contains(text(), 'Отправлено из Почты')])[1]");
    public By deleteMessage= By.xpath("//div[text()='Удалить']");
    public By basketFolderLink= By.xpath("(//div[text()='Корзина'])[1]");

    public String getTextEmailLastEmail(){
        return driver.findElement(emailLastMessage).getText();
    }
    public String getTextThemeLastEmail(){
        return driver.findElement(themeLastMessage).getText();
    }
    public String getTextTextLastEmail(){
        return driver.findElement(textLastMessage).getText();
    }
    public InboxPageMyself clickLastMessage(){
        driver.findElement(checkEmailLastMessage).click();
        return this;
    }

    public InboxPageMyself deleteMessage(){
        driver.findElement(deleteMessage).click();
        return this;
    }

    public BasketPage goToFolderBasket(){
        driver.findElement(basketFolderLink).click();
        return new BasketPage(driver);
    }
}
