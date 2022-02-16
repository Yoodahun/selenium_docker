package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    static ChromeDriver driver;
    boolean defaultOption = true;



    public static ChromeDriver getDriver() {
      return  getDriver(new ChromeOptions());
    }

    public static ChromeDriver getDriver(ChromeOptions options){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
