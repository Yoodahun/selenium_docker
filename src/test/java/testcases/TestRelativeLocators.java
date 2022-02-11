package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestRelativeLocators {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



        //above
        WebElement above = driver.findElement(RelativeLocator.with((By.tagName("input"))).above(By.tagName("select")));
        above.sendKeys("trainer@way2automation.com");
        File screenShot =  above.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("./screenshot/above.jpg"));



        //below
        WebElement below = driver.findElement(RelativeLocator.with((By.tagName("input"))).below(By.tagName("select")));
        below.sendKeys("New delhi");

        //rightof
        WebElement rightOf = driver.findElement(RelativeLocator.with(By.xpath("//input[@type='password']")).toRightOf(By.tagName("label")));
        rightOf.sendKeys("test");

//        //leftof
//        WebElement leftOf = driver.findElement(RelativeLocator.with(By.linkText("Signin")).toLeftOf(By.xpath("//*[@id=\"load_form\"]/div[1]/div[2]/input")));
//        System.out.println(leftOf.getText());


        //near
        WebElement near = driver.findElement(RelativeLocator.with(By.partialLinkText("THE")).near(By.linkText("Signin")));
        near.click();



//        //password
//        // 링크텍스트 signin을 가진 요소 위와 xpath를 가진 요소 아래. 두 개의 사이의 요소를 찾는 것.
//        driver.findElement(RelativeLocator.with(By.tagName("input"))
//                        .above(By.linkText("Signin"))
//                        .below(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input"))
//
//        ).sendKeys("ksdfkdskf");
//
//
//        //multiple element



        driver.close();
        driver.quit();



    }
}
