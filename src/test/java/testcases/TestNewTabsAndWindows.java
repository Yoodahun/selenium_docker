package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestNewTabsAndWindows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.way2automation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Hello Selenium 4");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://gmail.com");
        System.out.println(driver.getTitle());

        Set<String> winids = driver.getWindowHandles();
        Iterator<String> it = winids.iterator();
        List<String> winIndex = new ArrayList<String>();

        System.out.println(winids.size());

        while (it.hasNext()) {
            winIndex.add(it.next());
        }
        driver.switchTo().window(winIndex.get(1));


//        driver.close();
//        driver.quit();


    }
}
