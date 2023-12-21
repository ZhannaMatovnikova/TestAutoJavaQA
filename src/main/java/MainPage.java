//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class MainPage { //описание основной стр mail.ru
//    private WebDriver driver;
//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    private By loginMainButton = By.xpath("(//button[text()='Войти'])[1]"); //
//    private By loginForm = By.cssSelector("div.wrapper-0-2-5");
//    private By accountNameField = By.xpath("//div[@class='wrapper-0-2-5']//input[@name='Login']");
////    private By domenName = By.xpath("//input[@name='username']"); подумать о домене
//
//   private By addPasswordButton = By.xpath( "//button//span[text()='Ввести пароль']");
//    private By PasswordField = By.xpath("//input[@name='password']");
//    private By loginButtonForm = By.xpath("//button[@type='submit']");
//
//    public MainPage clickSignIn(){
//        driver.findElement(loginMainButton).click();
//        return this;
//    }
//
//
//    public  MainPage enterEmail(String email){
//        driver.findElement(accountNameField).sendKeys(email);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(addPasswordButton));
//        driver.findElement(addPasswordButton).click();
//        return this;
//
//    }
//
//
//
//    public MainPage enterAccountName(String email){
//        driver.findElement(accountNameField).sendKeys("email");
//        return new MainPage(driver);
//    }
//    public MainPage clickAddPasswordButton(){
//        driver.findElement(addPasswordButton).click();
//        return this;
//    }
//    public MainPage testLogin(){
//        this.clickSignIn();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Login']")));
////        String mainWindow = driver.getWindowHandle(); //задаем главное окно
////
////        for (String windowHandle:driver.getWindowHandles()){ //переключаемся на новое окно
////            driver.switchTo().window(windowHandle);
////        }
//        driver.findElement(accountNameField).sendKeys("12345");
////        this.clickAddPasswordButton();
//        return new MainPage(driver);
//    }
//
//
//
//
//
//
//
//
//}
