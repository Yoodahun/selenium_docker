package chromedevtools;

import driverFactory.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.performance.Performance;
import org.openqa.selenium.devtools.v97.performance.model.Metric;

import java.util.List;
import java.util.Optional;

public class TestEnablePerformanceMonitoring {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = DriverFactory.getDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Performance.enable(Optional.of(
                Performance.EnableTimeDomain.TIMETICKS
        )));
        driver.get("https://www.google.com");

        List<Metric> metrics = devTools.send(Performance.getMetrics());

        metrics.forEach(metric -> System.out.println(metric.getName() + " : " + metric.getValue()));

        Thread.sleep(5000);

        driver.close();
        driver.quit();

    }
}
