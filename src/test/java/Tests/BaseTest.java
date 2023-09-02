package Tests;

import Utils.Browser;
import Utils.Drivers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest extends Assert {
    String url;
    String pathParameters = "src/test/resources/testParameter.xlsx";

    public BaseTest(String url) {
        this.url = url;
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {

        driver = Drivers.getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(url);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
