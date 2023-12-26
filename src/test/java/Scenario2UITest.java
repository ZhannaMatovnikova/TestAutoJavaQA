import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario2UITest {
    private WebDriver driver;
    //    private MainPage mainPage;
    private MainPageSimple mainPageSimple;
    private  PochtaLogedInPage pochtaLogedInPage;
    private InboxPageMyself inboxPageMyself;
    private SendMessagesPage sendMessagesPage;
    private BasketPage basketPage;
    private final static String emailToLogin = "test20122023@mail.ru";
    private final static String passwordToLogin = "20122023Tt!";
    private final static String themeMessage = PochtaLogedInPage.themeMessage;
    private final static String textMessage = PochtaLogedInPage.textMessage;


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
        PochtaLogedInPage login = mainPageSimple.enterLoginName(emailToLogin, passwordToLogin);// войти в почту
        PochtaLogedInPage check = pochtaLogedInPage.clickAvatar();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String email = pochtaLogedInPage.getTextLinkEmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//div[@aria-label='"+emailToLogin+ "'])[2]"))));
        Assert.assertEquals(emailToLogin, email);//проверить, что вход выполнен успешно
        PochtaLogedInPage writeNewMessage = pochtaLogedInPage.sendEmailToMyself(themeMessage, textMessage);//создать новое письмо себе(заполнить тему письма и тело)
        InboxPageMyself goToInboxMyself = pochtaLogedInPage.clickInboxPageMyself();//перейти в папку "Письма себе"
        String address = inboxPageMyself.getTextEmailLastEmail();
        String theme = inboxPageMyself.getTextThemeLastEmail();
        String text = inboxPageMyself.getTextTextLastEmail();
        if(address.equals(emailToLogin) && theme.equals(themeMessage) && text.equals(textMessage));{ //проверить тему письма и адресата
            InboxPageMyself lastMessage = inboxPageMyself.clickLastMessage();}
        InboxPageMyself deleteMessage = inboxPageMyself.deleteMessage();// удалить сообщение
        BasketPage goToFolderBasket = inboxPageMyself.goToFolderBasket();//переход в папку "Корзина"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        String address1 = basketPage.getTextEmailLastEmail();
        String theme1 = basketPage.getTextThemeLastEmail();
        String text1 = basketPage.getTextTextLastEmail();
        if(address1.equals(emailToLogin) && theme1.equals(themeMessage) && text1.equals(textMessage));{ //проверить тему письма и адресата
            BasketPage logout = basketPage.logout();}//выйти из аккаунта



    }


    @After
    public void tearDown(){
        driver.quit();}


}
