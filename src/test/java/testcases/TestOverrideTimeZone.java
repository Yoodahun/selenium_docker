package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class TestOverrideTimeZone {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        driver.manage().window().maximize();
        driver.get("https://whatismytimezone.com/");

        Thread.sleep(5000);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setTimezoneOverride("EST"));
        driver.get("https://whatismytimezone.com/");

        Thread.sleep(5000);

        driver.close();
        driver.quit();


    }
}
