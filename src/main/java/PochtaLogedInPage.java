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
        this.writeNewMessage("test@mail.ru", "Тема", "Сообщение");
        this.saveMessageClick();
        this.closeFormMessage();
        return this;
    }
    public DraftFolderPage clickDrafts(){
        driver.findElement(draftLink).click();
        return new DraftFolderPage(driver);
    }




}
