package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestDeviceMetrics {
    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();
        DevTools devTools = DriverFactory.createDevTools();
        devTools.createSession();

        devTools.send(
                Emulation.setDeviceMetricsOverride(
                        375, 812, 50, true,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );


        Map<String, Object> deviceMetrics = new HashMap<String, Object>() {
            {
                put("width", 375);
                put("height", 812);
                put("mobile", true);
                put("deviceScaleFactor", 50);
            }
        };

        driver.executeCdpCommand("Emulation.setDeivceMetricsOverride", deviceMetrics);

        driver.get("https://selenium.dev");
    }
}
