package testcases;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestEnhancement {
    public static void main(String[] args) {
        ChromeDriver driver = DriverFactory.getDriver();

        driver.get("https://www.google.com");

        Actions action = new Actions(driver);

        //move mouse to button using XY cood

        WebElement link = driver.findElement(By.linkText("Gmail"));
        int x = link.getRect().getX();
        int y = link.getRect().getY();

        action.moveByOffset(x,y).click().perform();

    }
}
