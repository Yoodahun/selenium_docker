package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;

import java.util.Optional;

public class TestNetworkSpeed {
    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        //setting network tracking
        devTools.send(Network.enable(
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                2000,
                1000,
                Optional.of(ConnectionType.CELLULAR3G)
        ));

        driver.get("http://way2automation.com");

        driver.close();
        driver.quit();


    }
}
