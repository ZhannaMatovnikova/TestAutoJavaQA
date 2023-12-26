import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PochtaLogedInPage { //описание основной страницы после логина inbox
    private WebDriver driver;

    public PochtaLogedInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By draftLink = By.xpath("//div[text()='Черновики']");

    private By iconAvatar = By.cssSelector("img.ph-avatar-img.svelte-dfhuqc");
    private By linkEmailAvatar = By.xpath("(//div[@class='ph-text svelte-1popff4'])[1]//div[2]/div[1]"); // отображается почта личного кабинета
    private By newMessageButton = By.xpath("//span[text()='Написать письмо']");
    private By adddressField = By.xpath("//div[@class='input--3slxg']//input");
    private By themeField = By.xpath("//div[@class='subject__container--HWnat']//input");
    private By messageBodyField = By.xpath("(//div[@class='editable-container-2vsf']//div//br)[1]");
    private By saveMessageButton = By.xpath("//button[@data-test-id='save']");
    private By closeWindowNewMessageButton = By.xpath("(//button[@class='container--2lPGK type_base--rkphf color_base--hO-yz'])[3]");
    private By sendButton = By.xpath("//span[text()='Отправить']");
    private By closeTheFormAfterSending = By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[1]/span/span[2]");
    private By inboxMyselfButton = By.xpath("//div[text()='Письма себе']");
    public final static String addressEmailToWhomWriteMessage = "test@mail.ru";// задаем почту "Кому"
    public final static String themeMessage = "Тема";//задаем тему исходящего письма
    public final static String textMessage = "Текст12345";//задаем сообщение письма

    public PochtaLogedInPage clickAvatar() {
        driver.findElement(iconAvatar).click();
        return this;
    }

    public String getTextLinkEmail() {
       return driver.findElement(linkEmailAvatar).getText();
    }
    public PochtaLogedInPage writeNewMessage(String address, String theme, String message){
        driver.findElement(newMessageButton).click();
        driver.findElement(adddressField).sendKeys(address);
        driver.findElement(themeField).sendKeys(theme);
        String tab = Keys.chord(Keys.TAB);
        driver.findElement(themeField).sendKeys(tab, tab, message);
        return this;
    }
    public PochtaLogedInPage saveMessageClick(){
        driver.findElement(saveMessageButton).click();
        return this;
    }
    public PochtaLogedInPage closeFormMessage(){
        driver.findElement(closeWindowNewMessageButton).click();
        return this;
    }

    public PochtaLogedInPage writeNewMessageAndClickSave(){
        this.writeNewMessage(addressEmailToWhomWriteMessage, themeMessage, textMessage);
        this.saveMessageClick();
        this.closeFormMessage();
        return this;
    }

    public PochtaLogedInPage sendEmailToMyself(String theme, String text){
        driver.findElement(newMessageButton).click();
        driver.findElement(adddressField).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Письмо себе')]")).click();
        driver.findElement(themeField).sendKeys(theme);
        String tab = Keys.chord(Keys.TAB);
        driver.findElement(themeField).sendKeys(tab, tab, text);
        driver.findElement(sendButton).click();
        driver.findElement(closeTheFormAfterSending).click();
        return this;
    }


    public DraftFolderPage clickDrafts(){
        driver.findElement(draftLink).click();
        return new DraftFolderPage(driver);
    }

    public InboxPageMyself clickInboxPageMyself(){
        driver.findElement(inboxMyselfButton).click();
        return new InboxPageMyself(driver);
    }




}
