package main.com.anz.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.com.anz.helpers.ReadConfigData;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;
import java.util.Properties;

public class BaseMethods {
    private static final Logger LOG = Logger.getLogger(BaseMethods.class);

    public static ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();
    public static ThreadLocal<String> browserName = new InheritableThreadLocal<>();

    public static Properties CONFIG = null;

    public static void getBrowserInstance(String browserValue) {

        CONFIG = loadConfigFileData();

        if (browserValue.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            WEB_DRIVER_THREAD_LOCAL.set(new ChromeDriver(options));
            WEB_DRIVER_THREAD_LOCAL.get().manage().window().maximize();

        } else if (browserValue.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            WEB_DRIVER_THREAD_LOCAL.set(new FirefoxDriver(options));
            WEB_DRIVER_THREAD_LOCAL.get().manage().window().maximize();

        } else if (browserValue.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            options.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

            WEB_DRIVER_THREAD_LOCAL.set(new EdgeDriver(options));
            WEB_DRIVER_THREAD_LOCAL.get().manage().window().maximize();
        }

    }

    public static void applicationURL() {

        String baseURL = CONFIG.getProperty("siteURL");

        WEB_DRIVER_THREAD_LOCAL.get().get(baseURL);
        LOG.debug("Navigating to url " + baseURL);
        WEB_DRIVER_THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static Properties loadConfigFileData() {
        return ReadConfigData.loadConfigFile();
    }

}
