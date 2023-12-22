import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSimple {//описываем форму регистрации
    private WebDriver driver;
    public MainPageSimple(WebDriver driver) {
        this.driver = driver;
    }

//    private By loginForm = By.cssSelector("div.wrapper-0-2-5");
    private By accountNameField = By.xpath("//input[@name='username']");
//    private By domenName = By.xpath("//input[@name='username']"); подумать о домене

    private By addPasswordButton = By.xpath( "//button//span[text()='Ввести пароль']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButtonForm = By.xpath("//button[@type='submit']");

    public PochtaLogedInPage enterLoginName(String name,String password){ //попадаем со страницы регистрации в папку почты
        driver.findElement(accountNameField).sendKeys(name); //вести логин-почту
        driver.findElement(addPasswordButton).click(); // клик на кнопку Ввести пароль
        driver.findElement(passwordField).sendKeys(password); // ввести пароль
        driver.findElement(loginButtonForm).click(); // войти
        return new PochtaLogedInPage(driver); // если успех, перейти на страницу


    }
}
