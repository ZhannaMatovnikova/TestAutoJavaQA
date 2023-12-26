import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftFolderPage { // описание страницы при переходе в черновики https://e.mail.ru/drafts/
    private WebDriver driver;
    private final static String email = PochtaLogedInPage.addressEmailToWhomWriteMessage;
    public DraftFolderPage(WebDriver driver) {
        this.driver = driver;
    }
    private By draftMessageSavedLastInFolderEmail = By.xpath("(//span[@title='"+ PochtaLogedInPage.addressEmailToWhomWriteMessage+"'])[1]");
    private By draftMessageSavedLastInFolderTheme = By.xpath("(//span[text()='"+PochtaLogedInPage.themeMessage+"'])[1]");
    private By draftMessageSavedLastInFolderText = By.xpath("(//span[contains(text(), '"+PochtaLogedInPage.textMessage+"')])[1]");

//    private By draftAddressMessage = By.xpath("(//div[@class = 'inputContainer--nsqFu'])[1]");// с главной страницы черновика см адресата
//    private By draftThemeMessage = By.xpath("(//div[@class = 'inputContainer--nsqFu'])[2]");// с главной страницы черновика см Тему сообщения
//    private By draftTextMessage = By.xpath("(//div[@class = 'cl_101814']/div)[1]");// с главной страницы черновика см текст Сообщения
    private By sendButton = By.xpath("//span[text()='Отправить']");// кнопка отправить из черновика
    private By sendMessagesLink = By.xpath("//div[text()='Отправленные']");// переход в папку отправленные из черновиков после отправки возможно подождать 20-21 с
    private By closeWindowTheMessageIsSend = By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]/span/span[2]");// переход в папку отправленные из черновиков

    public DraftFolderPage clickLastMessage(){
        driver.findElement(draftMessageSavedLastInFolderText).click();
        return new DraftFolderPage(driver);
    }

    public String getTextAddress(){
        return driver.findElement(draftMessageSavedLastInFolderEmail).getText();
    }
    public String getTextTheme(){
        return driver.findElement(draftMessageSavedLastInFolderTheme).getText();
    }
    public String getTextTextMessage(){
        return driver.findElement(draftMessageSavedLastInFolderText).getText();
    }
    public DraftFolderPage sendTheMail(){
        driver.findElement(sendButton).click();
        return  this;
    }

    public DraftFolderPage clickFolderSendMessages(){
        driver.findElement(sendMessagesLink).click();
        return this;
    }
    public DraftFolderPage closeWindow(){
        driver.findElement(closeWindowTheMessageIsSend).click();
        return this;
    }


}
