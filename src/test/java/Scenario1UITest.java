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

public class Scenario1UITest {

    private WebDriver driver;
//    private MainPage mainPage;
    private MainPageSimple mainPageSimple;
    private  PochtaLogedInPage pochtaLogedInPage;
    private DraftFolderPage draftFolderPage;
    private SendMessagesPage sendMessagesPage;
    private final static String emailToLogin = "test20122023@mail.ru";// задаем почту для login - отправитель
    private final static String passwordToLogin = "20122023Tt!";// пароль почты отправителя
    private final static String addressEmailToWhomWriteMessage = PochtaLogedInPage.addressEmailToWhomWriteMessage;
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
        draftFolderPage = new DraftFolderPage(driver);
        sendMessagesPage = new SendMessagesPage(driver);

    }

    @Test
    public void csenario1() {
        PochtaLogedInPage login = mainPageSimple.enterLoginName(emailToLogin, passwordToLogin);// войти в почту
        PochtaLogedInPage check = pochtaLogedInPage.clickAvatar();
        String email = pochtaLogedInPage.getTextLinkEmail();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@aria-label='"+emailToLogin+ "'])[2]")));
        Assert.assertEquals(emailToLogin, email);//проверить, что вход выполнен успешно
        PochtaLogedInPage writeNewMessage = pochtaLogedInPage.writeNewMessageAndClickSave();//создать новое письмо (заполнить адресата, тему письма и тело), сохранить как черновик
        DraftFolderPage goToDrafts = pochtaLogedInPage.clickDrafts();// Проверить сохранение в черновиках
        String address = draftFolderPage.getTextAddress();
        String theme = draftFolderPage.getTextTheme();
        if(address.equals(addressEmailToWhomWriteMessage) && theme.equals(themeMessage));{ //проверить  тему письма и адресата
        DraftFolderPage lastMessage = draftFolderPage.clickLastMessage();} //если предыдущие условия ок, то переход на ссылку с письмом, содержащей текст письма, так закрываем 3ю проверку
        DraftFolderPage sendMessage = draftFolderPage.sendTheMail(); //Отправить письмо в черновиках
        DraftFolderPage closeWindow = draftFolderPage.closeWindow(); //закрыть окно после отправки письма из черновиков
//      if (!address.equals("test@mail.ru") && !theme.equals("Тема")&&);{ //TODO проверить, что письмо отправлено из черновиков
        DraftFolderPage clickFolderSendMessages = draftFolderPage.clickFolderSendMessages(); //переход в папку Отправленные
       String address1 = sendMessagesPage.getTextEmail();
       String theme1 = sendMessage.getTextTheme();
       if(address1.equals(addressEmailToWhomWriteMessage) && theme1.equals(themeMessage));{ // проверка последней темы письма и адреса отправки
           SendMessagesPage logout = sendMessagesPage.logout(); //выход из учетной записи
        }

    }


    @After
    public void tearDown(){
        driver.quit();}

}