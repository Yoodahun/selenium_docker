package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;

import java.util.Optional;

public class TestFakeUserAgent {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        String userAgent = "Mozilla/5.0 (Macintoshl Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like, Gecko) Chrome/96.0.4664.55 Safari/537.36";


        devTools.send(Network.setUserAgentOverride(
                userAgent,
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        driver.get("https://www.whatismybrowser.com/detect/what-is-my-user-agent");

        Thread.sleep(5000);

        driver.close();
        driver.quit();

    }
}
