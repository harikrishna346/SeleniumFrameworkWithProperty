package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

import java.time.Duration;

public class BaseClass {

    protected  WebDriver driver;

    @BeforeMethod
    public void setup() {

        ConfigReader.loadProperties();

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            throw new RuntimeException(
                    "Unsupported browser: " + browser
            );
        }

        driver.manage().window().maximize();

        int wait = Integer.parseInt(
                ConfigReader.getProperty("implicitWait")
        );

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(wait));

        String url = ConfigReader.getProperty("url");

        driver.get(url);

        System.out.println("Application launched successfully");
    }

    @AfterMethod
    public void tearDown(
            org.testng.ITestResult result) {

        if (driver != null) {

            ScreenshotUtil.captureScreenshot(
                    driver,
                    result.getMethod().getMethodName()
            );

            driver.quit();
        }
    }
}






