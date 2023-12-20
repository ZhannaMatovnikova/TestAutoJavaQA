import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

        MainPage mainPage = new MainPage(driver);

        driver.quit();
    }
}
