package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.console.Console;
import org.openqa.selenium.devtools.v97.log.Log;

public class TestConsoleLogs {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.send(Console.enable());

        devTools.addListener(Log.entryAdded(), entry -> {
            System.out.println(entry.getTimestamp());
            System.out.println(entry.getLevel());
            System.out.println(entry.getText());
        });

        devTools.addListener(Console.messageAdded(), message -> {
            System.out.println(message.getLevel());
            System.out.println(message.getText());
        });


        driver.get("http://flipkart.com");


        ((JavascriptExecutor) driver).executeScript("console.log('This is a sample log')");

        Thread.sleep(5000);

        driver.close();
        driver.quit();

    }
}
