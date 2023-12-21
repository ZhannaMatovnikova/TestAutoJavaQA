import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest { //проверяю тесты модульно

    private WebDriver driver;
//    private MainPage mainPage;
    private MainPageSimple mainPageSimple;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Жанна\\IdeaProjects\\untitled2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/login/?mode=simple");
//        mainPage = new MainPage(driver);
        mainPageSimple = new MainPageSimple(driver);
    }

    @Test
    public void test1() {
        MainPageSimple mp = mainPageSimple.enterLoginName("test20122023", "20122023Tt!");
    }



    @After
    @Ignore
    public void tearDown () {
        driver.quit();
    }
}