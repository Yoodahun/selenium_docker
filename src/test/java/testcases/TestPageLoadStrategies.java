package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

public class TestPageLoadStrategies {
    public static void main(String[] args) {

        ChromeOptions opt = new ChromeOptions();
//        opt.setPageLoadStrategy(PageLoadStrategy.EAGER); 5024
//        opt.setPageLoadStrategy(PageLoadStrategy.NONE); 5106
//        opt.setPageLoadStrategy(PageLoadStrategy.NORMAL); 7747

        ChromeDriver driver = DriverFactory.getDriver(opt);

        long start = System.currentTimeMillis();
        driver.get("https://flipkart.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();


        driver.close();
        driver.quit();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
