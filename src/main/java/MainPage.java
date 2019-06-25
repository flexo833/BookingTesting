import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;
    private By signInButton = By.xpath("//li[@id='current_account']//div");
    private By destinationInput = By.xpath("//input[@name='ss']");
    private By dateCalendar = By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']");
    private By checkIn = By.xpath("//td[@data-date='2019-07-10']");
    private By checkOut = By.xpath("//td[@data-date='2019-07-15']");
    private By searchButton = By.xpath("//button[@class='sb-searchbox__button  ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public ResultPage selectOffers() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationInput));
        driver.findElement(destinationInput).click();
        driver.findElement(destinationInput).clear();
        driver.findElement(destinationInput).sendKeys("Odesa");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(dateCalendar));
        driver.findElement(dateCalendar).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(checkIn));
        driver.findElement(checkIn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOut));
        driver.findElement(checkOut).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        return new ResultPage(driver);

    }


}
