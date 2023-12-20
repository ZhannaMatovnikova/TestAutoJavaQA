import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage { // страница отправленных писем
    private WebDriver driver;
    public SendMessagesPage(WebDriver driver) {
        this.driver = driver;
    }
    private By lastSentMessage = By.xpath("//div[@class='nmCQ1ev'][1]");
    private By checkAdressWhereSentMessage = By.xpath("(//span[@class='letter-contact letter-contact_pony-mode'])[2]");
    private By checkThemeWhereSentMessage = By.xpath("//h2[@class='thread-subject thread-subject_pony-mode']");
    private By checkTextWhereSentMessage = By.xpath("(//div[@class='cl_101814_mr_css_attr']/div)[1]");

    private By iconAvatar = By.cssSelector("img.ph-avatar-img.svelte-dfhuqc");
    private By logOut = By.xpath("//div[text()='Выйти']");
}
