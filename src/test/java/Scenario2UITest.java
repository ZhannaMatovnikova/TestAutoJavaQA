import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Scenario2UITest {
    private WebDriver driver;
    //    private MainPage mainPage;
    private MainPageSimple mainPageSimple;
    private  PochtaLogedInPage pochtaLogedInPage;
    private InboxPageMyself inboxPageMyself;
    private SendMessagesPage sendMessagesPage;
    private BasketPage basketPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Жанна\\IdeaProjects\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/login/?mode=simple");
//        mainPage = new MainPage(driver);
        mainPageSimple = new MainPageSimple(driver);
        pochtaLogedInPage = new PochtaLogedInPage(driver);
        inboxPageMyself = new InboxPageMyself(driver);
        sendMessagesPage = new SendMessagesPage(driver);
        basketPage = new BasketPage(driver);

    }

    @Test
    public void csenario2() {
        PochtaLogedInPage login = mainPageSimple.enterLoginName("test20122023", "20122023Tt!");// войти в почту
        PochtaLogedInPage check = pochtaLogedInPage.clickAvatar();
        String email = pochtaLogedInPage.getTextLinkEmail();
        Assert.assertEquals("test20122023@mail.ru", email);//проверить, что вход выполнен успешно
        PochtaLogedInPage writeNewMessage = pochtaLogedInPage.sendEmailToMyself("Тема1", "Текст");//создать новое письмо себе(заполнить тему письма и тело)
        InboxPageMyself goToInboxMyself = pochtaLogedInPage.clickInboxPageMyself();
        String address = inboxPageMyself.getTextEmailLastEmail();
        String theme = inboxPageMyself.getTextThemeLastEmail();
        String text = inboxPageMyself.getTextTextLastEmail();
        if(address.equals("test20122023@mail.ru") && theme.equals("Тема") && text.equals("Текст"));{ //проверить  тему письма и адресата
            InboxPageMyself lastMessage = inboxPageMyself.clickLastMessage();}
        InboxPageMyself deleteMessage = inboxPageMyself.deleteMessage();
        BasketPage goToFolderBasket = inboxPageMyself.goToFolderBasket();
        String address1 = basketPage.getTextEmailLastEmail();
        String theme1 = basketPage.getTextThemeLastEmail();
        String text1 = basketPage.getTextTextLastEmail();
        if(address1.equals("test20122023@mail.ru") && theme1.equals("Тема") && text1.equals("Текст"));{ //проверить  тему письма и адресата
            BasketPage logout = basketPage.logout();}



    }


    @After
    public void tearDown(){
        driver.quit();}


}
