package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestPrintToPDF {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        ChromeDriver driver = DriverFactory.getDriver(options);


        driver.get("https://selenium.dev/");


        Pdf pdf = driver.print(new PrintOptions());
        Files.write(Paths.get("./selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));

        driver.close();
        driver.quit();

    }
}
