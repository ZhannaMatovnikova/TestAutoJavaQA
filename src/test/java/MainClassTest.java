import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest { //проверяю тесты модульно

    private WebDriver driver;
//    private MainPage mainPage;
    private MainPageSimple mainPageSimple;
    private  PochtaLogedInPage pochtaLogedInPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Жанна\\IdeaProjects\\untitled2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/login/?mode=simple");
//        mainPage = new MainPage(driver);
        mainPageSimple = new MainPageSimple(driver);
        pochtaLogedInPage = new PochtaLogedInPage(driver);

    }

    @Test
    public void csenario1() {
        PochtaLogedInPage mp = mainPageSimple.enterLoginName("test20122023", "20122023Tt!");
        PochtaLogedInPage check = pochtaLogedInPage.clickAvatar();
        String email = pochtaLogedInPage.getTextLinkEmail();
        Assert.assertEquals("test20122023@mail.ru", email);
        PochtaLogedInPage writeNewMessage = pochtaLogedInPage.writeNewMessageAndClick();
        DraftFolderPage goToDrafts = pochtaLogedInPage.clickDrafts();
    }



//    @After
//    public void tearDown () {
//        driver.quit();
//    }
}