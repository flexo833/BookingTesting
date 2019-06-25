import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ResultPage {
    private WebDriver driver;
    private By sortBarButton = By.xpath("//li[@class=' sort_category   sort_price ']");


    public ResultPage(WebDriver driver) {
        this.driver = driver;

    }

    public void sortByPrice() throws NullPointerException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(sortBarButton));
        driver.findElement(sortBarButton).click();

    }

    public boolean verifyPrice() {
        List<Integer> price = new ArrayList<Integer>();
        List<String> attributes = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper ']"));

        for (WebElement element: elements) {
            attributes.add(element.getAttribute("innerText"));
        }

        for (String attribute : attributes) {
            price.add(Integer.parseInt(String.valueOf(Integer.parseInt(attribute.replaceAll("[\\D]", "")))));
        }

        List<Integer> expected = new ArrayList<Integer>(price);
        Collections.sort(expected);

        if (price.contains(expected.toArray())) {
            return true;
        }
        return false;
    }
}
