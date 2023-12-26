import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
    public By emailLastMessage= By.xpath("(//span[contains(text(),'Тест Тестов')])[1]");//
    public By themeLastMessage= By.xpath("(//span[text()='" + PochtaLogedInPage.themeMessage + "'])[1]");//
    public By textLastMessage = By.xpath("(//span[contains(text(), '" + PochtaLogedInPage.textMessage + "')])[1]");//

    public String getTextEmailLastEmail(){
        return driver.findElement(emailLastMessage).getText();
    }
    public String getTextThemeLastEmail(){
        return driver.findElement(themeLastMessage).getText();
    }
    public String getTextTextLastEmail(){
        return driver.findElement(textLastMessage).getText();
    }
    private By iconAvatar = By.cssSelector("img.ph-avatar-img.svelte-dfhuqc");
    private By logOut = By.xpath("//div[text()='Выйти']");

    public BasketPage logout(){
        driver.findElement(iconAvatar).click();
        driver.findElement(logOut).click();
        return this;
    }

}
