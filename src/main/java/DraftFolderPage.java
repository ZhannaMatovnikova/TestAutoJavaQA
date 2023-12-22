import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftFolderPage { // описание страницы при переходе в черновики https://e.mail.ru/drafts/
    private WebDriver driver;
    public DraftFolderPage(WebDriver driver) {
        this.driver = driver;
    }
    private By draftMessageSavedLastInFolder = By.xpath("(//div[@class = 'nmCQ1Hm'])[1]");
    private By draftAddressMessage = By.xpath("(//div[@class = 'inputContainer--nsqFu'])[1]");// с главной страницы черновика см адресата
    private By draftThemeMessage = By.xpath("(//div[@class = 'inputContainer--nsqFu'])[2]");// с главной страницы черновика см Тему сообщения
    private By draftTextMessage = By.xpath("(//div[@class = 'cl_101814']/div)[1]");// с главной страницы черновика см текст Сообщения
    private By sendButton = By.xpath("");// кнопка отправить из черновика
    private By sendMessagesButton = By.xpath("//button//span[text()='Отправить']");// переход в папку отправленные из черновиков после отправки возможно подождать 20-21 с
    private By windowTheMessageIsSend = By.xpath("//div[text()='Отправленные']");// переход в папку отправленные из черновиков

    public DraftFolderPage clickLastMessage(){
        driver.findElement(draftMessageSavedLastInFolder).click();
        return this;
    }
    public String getTextAddress(){
        return driver.findElement(draftAddressMessage).getText();
    }
    public String getTextTheme(){
        return driver.findElement(draftThemeMessage).getText();
    }
    public String getTextTextMessage(){
        return driver.findElement(draftTextMessage).getText();
    }
    public DraftFolderPage findMessage(String textMessage){    //, String textAddress, String textTheme
        driver.findElement(By.tagName(textMessage)).click();
        return this;

    }


}
