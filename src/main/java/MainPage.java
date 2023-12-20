import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage { //описание основной стр mail.ru
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginMainButton = By.xpath("(//button[text()='Войти'])[1]"); //
    private By accountNameField = By.xpath("//input[@name='username']");
//    private By domenName = By.xpath("//input[@name='username']"); подумать о домене

    private By addPasswordButton = By.xpath("//button//span[text()='Ввести пароль']");
    private By PasswordField = By.xpath("//input[@name='password']");
    private By loginButtonForm = By.xpath("//button[@type='submit']");








}
