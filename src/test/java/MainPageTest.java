//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class MainPageTest {
//
//    private WebDriver driver;
//    private PochtaLogedInPage pochtaLogedInPage;
//
//
//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Жанна\\IdeaProjects\\untitled2\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://account.mail.ru/login/?mode=simple");
////        mainPage = new MainPage(driver);
//        pochtaLogedInPage = new PochtaLogedInPage(driver);
//    }
//
//    @Test
//    public void test1() {
//
//    }
//
//
//
//    @After
//    @Ignore
//    public void tearDown () {
//        driver.quit();
//    }
//}
//
