package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class Drivers {
    private static final String DRIVERPATH = "src/test/resources/";
    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {
        File file;

        switch (browser) {
            case CHROME:
                file = new File(DRIVERPATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                ChromeOptions optionsChrome = new ChromeOptions();
              //  optionsChrome.addArguments("--headless");

                driver = new ChromeDriver(optionsChrome);

                break;


            case FIREFOX:
                file = new File(DRIVERPATH + "geckodriver.exe");
                System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
                FirefoxOptions optionsFirefox = new FirefoxOptions();
               // optionsFirefox.addArguments("--headless");
                driver = new FirefoxDriver(optionsFirefox);
                break;

        }
        return driver;

    }
}
