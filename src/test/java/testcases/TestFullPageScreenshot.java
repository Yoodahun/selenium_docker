package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class TestFullPageScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://way2automation.com");
        driver.manage().window().maximize();

        //maximize
        File pageScreenshot =  driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pageScreenshot, new File("./screenshot/page.jpg"));

        //Full Page
        File fullPageScreenshot = driver.getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullPageScreenshot, new File("./screenshot/page.jpg"));


    }
}
