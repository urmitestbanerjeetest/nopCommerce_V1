package nopCommerce_V1;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class base {
    public static WebDriver driver;

    public static WebDriver initEnvironment(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();

                driver.get( "https://demo.nopcommerce.com/");
                break;
            case "edge":

                WebDriverManager.edgedriver().setup();

                driver = new EdgeDriver();

                driver.get( "https://www.amazon.com");
                break;

            case "Firefox":

                WebDriverManager.firefoxdriver();

                driver = new FirefoxDriver();

                driver.get("https://www.ebay.com" );
                break;

            default:
                System.out.println("Unknown browser type");
        }// switch end

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }// end of init Environ

    public WebDriver getDriver() {// creating method to get driver to be called from the main
        return driver;
    }// class

}

