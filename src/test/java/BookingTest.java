import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BookingTest {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void verifySort() throws InterruptedException {

        driver.get("http://www.booking.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn("testselenium_flexo@ukr.net", "Abcd12345");
        mainPage.selectOffers();
        ResultPage resultPage = new ResultPage(driver);
        resultPage.sortByPrice();


        Assert.assertTrue(resultPage.verifyPrice());


    }

    @AfterTest
    public void stop() {

        driver.quit();
    }


}
