package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestRequestAndResponseHeader {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

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

            System.out.println("Response URL is : "+ responseReceived.getResponse().getUrl());
            System.out.println("Status code : " + responseReceived.getResponse().getStatus());

        });

        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("customHeaderName", "customHeaderValue");
        headers.put("Dahun", "Automation Tester");
        Headers head = new Headers(headers);

        devTools.send(Network.setExtraHTTPHeaders(head));

        driver.get("https://www.google.com");



        Thread.sleep(5000);

        driver.close();
        driver.quit();




    }
}
