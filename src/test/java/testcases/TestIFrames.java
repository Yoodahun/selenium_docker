package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestIFrames {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://w3schools.com/jsref/tryit.asp?filename=tryjsref_win_frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();

        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*[@id=\"nav_translate_btn\"]/i")).click();
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.close();
        driver.quit();



    }
}
