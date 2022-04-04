package testcases;

import com.google.common.collect.ImmutableList;
import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;

import java.util.Optional;

public class TestBlockingNetworkRequests {

    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.png", "*.jpeg")));

        driver.get("http://makemytrip.com");

        driver.quit();
        driver.close();


    }
}
