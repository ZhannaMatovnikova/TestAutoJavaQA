import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage { // страница отправленных писем
    private WebDriver driver;
    public SendMessagesPage(WebDriver driver) {
        this.driver = driver;
    }
    private By lastSentMessage = By.xpath("//div[@class='nmCQ1ev'][1]");
    private By checkAdressWhereSentMessage = By.xpath("(//span[@title='"+ PochtaLogedInPage.addressEmailToWhomWriteMessage+"'])[1]");//TODO доработка переменной
    private By checkThemeWhereSentMessage = By.xpath("(//span[text()='"+PochtaLogedInPage.themeMessage+"'])[1]");
    private By checkTextWhereSentMessage = By.xpath("(//span[contains(text(), '"+PochtaLogedInPage.textMessage+"')])[1]");

    private By iconAvatar = By.cssSelector("img.ph-avatar-img.svelte-dfhuqc");
    private By logOut = By.xpath("//div[text()='Выйти']");


    public String getTextEmail(){
        return driver.findElement(checkAdressWhereSentMessage).getText();
    }
    public String getTextMessageText(){
        return driver.findElement(checkTextWhereSentMessage).getText();
    }
    public String getTextTheme(){
        return driver.findElement(checkThemeWhereSentMessage).getText();
    }
    public SendMessagesPage logout(){
        driver.findElement(iconAvatar).click();
        driver.findElement(logOut).click();
        return this;
    }

}
