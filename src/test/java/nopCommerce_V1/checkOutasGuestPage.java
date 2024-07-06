package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkOutasGuestPage {

    static Logger log = Logger.getLogger(cellphonesPage.class.getName());

    public static WebDriver driver;
    By checkoutAsGuestBtn = By.xpath("//button[normalize-space()='Checkout as Guest']");
    public checkOutasGuestPage(WebDriver driver){
        this.driver = driver;
    }
    public checkOutBillingPage clickCheckoutasguestBtn() throws InterruptedException {
        driver.findElement(checkoutAsGuestBtn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new checkOutBillingPage(driver);
    }

}
