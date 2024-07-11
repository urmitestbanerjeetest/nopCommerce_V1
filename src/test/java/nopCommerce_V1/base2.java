package nopCommerce_V1;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class base2 {

    public static Properties prop = new Properties();

    private static WebDriver driver;

    //C:\Webdriver\webdriver\src\test\resources
    //C:\Users\Sri\Desktop\Selenium-Webdriver\webdriver
    //C:\Webdriver\webdriver\src\test\resources\AppConfig.properties
    //"\\src\\test\\resources\\WebDriverLesson1.properties";

  //  static String fp =System.getProperty("user.dir")+
     //       "\\src\\test\\resources\\NopCommerceConfig.properties";//declaring a variable fp and storing the file path of property file
    // creating instance of the property class

    public static WebDriver initEnvironment() throws IOException{
        String propfile = "./src/test/resources/NopCommerceConfig.properties";
        FileReader reader=new FileReader(propfile);
        prop.load(reader);
       // FileInputStream file = new FileInputStream(fp);// creating an object/instance of fileinputstream class to load the ropert file
      //  prop.load(file);// accessing the load method by using the object prop of property class to load the property file
        reader.close();
        // read data from prop file;
        String br = prop.getProperty("browser");
        String appURL = prop.getProperty("url");
        String implicitWait = prop.getProperty("implicitWaitTime");
        switch (br){
            case "chrome":
                // Set up Chrome driver using WebDriverManager
                WebDriverManager.chromedriver().setup();

                // Create a WebDriver instance for Chrome
                driver = new ChromeDriver();

                // Now you can use 'chrDriver' to interact with the Chrome browser
                // test1
             //   driver.get(appURL);
                break;

            case"edge":
                // Set up edge driver using WebDriverManager
                WebDriverManager.edgedriver().setup();

                // creating webDriver instance for edge
                driver = new EdgeDriver();

                // Now you can use 'edgeDriver' to interact with the
                //edge browser
               // driver.get(appURL);
                break;

            case"firefox":
                // Set up firefox driver using WebDriverManager
                WebDriverManager.firefoxdriver().setup();

                // create webDriver instance for firefox
                driver = new FirefoxDriver();

                // Now you can use 'fireFoxDriver' to interact with the
                //firefox browser
              //  driver.get(appURL);
                break;

            default:
                System.out.println("Unknown Browser type!");
        }// switch
        driver.get(appURL);

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait) ));// webdriver synchronation statement method instead of using java thread sleep.it is a part of the base always write before return driver.
        return driver;

    }// end of initEnv

    public WebDriver getDriver() {// method to get and return driver
        return driver;
    }

}// class




