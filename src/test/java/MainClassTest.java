import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest { //проверяю тесты модульно

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Жанна\\IdeaProjects\\untitled2\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void sighIn() {
        MainPage newmainpage = mainPage.testLogin();
//        MainPage mainPage1 = driver.findElement(MainPage.enterAccountName("123"));

    }



    @After
    public void tearDown () {
        driver.quit();
    }
}