package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBasicAuth {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //admin / admin

        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));

        driver.get("https://the-internet.herokuapp.com/basic_auth");




//        driver.close();
//        driver.quit();




    }
}
