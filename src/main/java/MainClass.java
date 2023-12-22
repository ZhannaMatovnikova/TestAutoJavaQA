import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/login");

//        MainPage mainPage = new MainPage(driver);
        MainPageSimple mainPageSimple = new MainPageSimple(driver);
//        mainPage.clickSignIn();
//        String mainWindow = driver.getWindowHandle(); //задаем главное окно
//
//        for (String windowHandle:driver.getWindowHandles()){ //переключаемся на новое окно
//            driver.switchTo().window(windowHandle);
//        }
//        driver.findElement(By.xpath("//div[@class='wrapper-0-2-5']//input[@name='Login']")).sendKeys("12345");



        driver.quit();
    }
}
