import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PochtaLogedInPage { //описание основной страницы после логина
    private WebDriver driver;
    public PochtaLogedInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By draftLink = By.xpath("//div[text()='Черновики']");

    private By iconAvatar = By.cssSelector("img.ph-avatar-img.svelte-dfhuqc");
    private By linkEmailAvatar = By.cssSelector("div.ph-desc__email.svelte-1popff4");
    private By newMessageButton = By.xpath("//span[text()='Написать письмо']");
    private By adddressField = By.xpath("//div[@class='input--3slxg']//input");
    private By themeField = By.xpath("//div[@class='subject__container--HWnat']//input");
    private By messageBodyField = By.xpath("(//div[@class='editable-container-qvls']//div//br)[1]");
    private By saveMessageButton = By.xpath("//button[@data-test-id='save']");
    private By closeWindowNewMessageButton = By.xpath("(//button[@class='container--2lPGK type_base--rkphf color_base--hO-yz'])[3]");
}
