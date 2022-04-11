package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRemote {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(true);
        WebDriver driver = new RemoteWebDriver(new URL("{REMOTE HUB URL}"), opt);


    }
}
