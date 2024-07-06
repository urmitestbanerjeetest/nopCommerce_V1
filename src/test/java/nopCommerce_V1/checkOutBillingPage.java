package nopCommerce_V1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkOutBillingPage {
    public static WebDriver driver;
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    By firstname = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    By lastname = By.xpath("//input[@id='BillingNewAddress_LastName']");
    By email = By.xpath("//input[@id='BillingNewAddress_Email']");
    By company = By.xpath("//input[@id='BillingNewAddress_Company']");
    By country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By province = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
    By city = By.xpath("//input[@id='BillingNewAddress_City']");
    By address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By postalCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By faxNumber = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
    //   By continue1btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[2]");
    By continue1btn = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']");

    public checkOutBillingPage(WebDriver driver) {
        this.driver = driver;
    }

    public checkOutShippingMethodPage clickContinue1AndReturnShippingPage() throws InterruptedException {
        driver.findElement(firstname).sendKeys("Urmi");
        driver.findElement(lastname).sendKeys("Banerjee");
        driver.findElement(email).sendKeys("urmitestbanerjeetest@gmail.com");
        driver.findElement(company).sendKeys("rogers");
        driver.findElement(country).sendKeys("Burundi");
        driver.findElement(province).sendKeys("Other");
        driver.findElement(city).sendKeys("Brossard");
        driver.findElement(address1).sendKeys("7735 rambat Jvx2y4");
        driver.findElement(postalCode).sendKeys("j5x2y4");
        driver.findElement(phoneNumber).sendKeys("4384459699");
        driver.findElement(faxNumber).sendKeys("4389339699");
        driver.findElement(continue1btn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new checkOutShippingMethodPage(driver);
    }

    }


