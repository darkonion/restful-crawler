package config;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Log
public class WebDriverConfig {

    public static WebDriver getDriver(String remoteAddress) {

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(remoteAddress), new FirefoxOptions());
        } catch (MalformedURLException e) {
            log.warning(e.getMessage());
        }
        driver.manage().window().maximize();

        return driver;
    }
}
