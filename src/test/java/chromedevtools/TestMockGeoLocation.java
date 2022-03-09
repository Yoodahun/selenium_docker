package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;


import java.util.Optional;

public class TestMockGeoLocation {

    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = DriverFactory.createDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(
                        Optional.of(51.509865),
                        Optional.of(-0.118092),
                        Optional.of(100)
                )
        );

        driver.get("https://mycurrentlocation.net/");

        driver.quit();
        driver.close();

    }

}
