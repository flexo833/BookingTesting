import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath("//input[@id='username']");
    private By submitButton = By.xpath("//span[@class='bui-button__text']");
    private By passwordField = By.xpath("//input[@id='password']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void signIn(String email, String password)  {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }


}
