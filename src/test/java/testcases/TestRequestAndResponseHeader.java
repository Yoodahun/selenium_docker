package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.Headers;

import java.util.Optional;

public class TestRequestAndResponseHeader {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://www.google.com");

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            Headers header = requestWillBeSent.getRequest().getHeaders();

            if (!header.isEmpty()) {
                System.out.println("Request headers : ");
                header.forEach((key, value) -> {
                    System.out.println(" " + key+ " = " + value);
                });
            }
        });

        System.out.println("---------------------");


        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Headers header = responseReceived.getResponse().getHeaders();

            if (!header.isEmpty()) {
                System.out.println("Response headers : ");
                header.forEach((key, value) -> {
                    System.out.println(" " + key+ " = " + value);
                });
            }

        });



        Thread.sleep(5000);

        driver.close();
        driver.quit();




    }
}
