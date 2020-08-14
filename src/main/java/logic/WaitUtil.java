package logic;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitUtil {

    public static void waitUntil(ExpectedCondition<WebElement> condition, WebDriver webDriver) {
        FluentWait<WebDriver> wait = new FluentWait<>(webDriver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofNanos(500L));
        wait.withTimeout(Duration.ofSeconds(10L));
        wait.until(condition);
    }
}
