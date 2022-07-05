import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import utils.ValueProvider;

import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    static ValueProvider valueProvider;
    @BeforeSuite
    public void beforeSuit() throws IOException {
        WebDriverManager.chromedriver().setup();
        valueProvider = new ValueProvider();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BasePage.basePage(driver);
        driver.get(valueProvider.getUrlFromProperties());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
