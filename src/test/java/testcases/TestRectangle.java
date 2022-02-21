package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRectangle {
    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();
        driver.get("http://www.gmail.com");

        WebElement image = driver.findElement(By.id("logo"));

        Rectangle rect = image.getRect();

        System.out.println("Height : " + rect.getHeight());
        System.out.println("Width : " + rect.getWidth());
        System.out.println("X Coord : " + rect.getX());
        System.out.println("Y Coord : " + rect.getY());

        driver.close();
        driver.quit();

    }

}
