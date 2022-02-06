package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestWebElements {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /*
        implicitly wait.
         */
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://www.gmail.com");


        WebElement email =  driver.findElement(By.id("identifierId"));
        email.sendKeys("tty4032@likelion.org");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

        /*
        explicitly wait
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")))
                .sendKeys("1234");


//        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("1234");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"))).click();
//        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

        WebElement warningText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span")));

//        driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"));
        System.out.println(warningText.getText());

        driver.close();
        driver.quit();






    }
}
