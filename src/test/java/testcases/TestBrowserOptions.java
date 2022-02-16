package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestBrowserOptions {
    public static void main(String[] args) {

        Map<String, String> mobileEm = new HashMap<>();
        mobileEm.put("deviceName", "iPhone X");


        ChromeOptions options = new ChromeOptions();
        //options.setAcceptInsecureCerts(true);
        //options.addArguments("disable-infobar");
        options.addArguments("incognito");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("mobileEmulation", mobileEm);
        ChromeDriver driver = DriverFactory.getDriver(options);

        driver.get("https://selenium.dev/");

        System.out.println(driver.getTitle());


        driver.close();
        driver.quit();


    }
}
