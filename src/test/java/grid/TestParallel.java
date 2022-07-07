package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestParallel {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public Capabilities cap;

    public WebDriver getDriver() {
        return driver.get();
    }

    @Parameters({"browser"})
    @Test
    public void doSearch(String browser) throws MalformedURLException, InterruptedException {

        if (browser.equals("firefox")) {
            cap = new FirefoxOptions();
        } else if (browser.equals("chrome")) {
            cap = new ChromeOptions();
        }

        driver.set(new RemoteWebDriver(new URL("http://3.115.106.35:8282/"), cap));

        getDriver().get("http://www.google.com");
        getDriver().findElement(By.name("q")).sendKeys("Hello Grid !!" + browser);
        System.out.println(getDriver().getTitle() + "------ on browser " + browser);
        Thread.sleep(5000);

        getDriver().quit();




    }
}
