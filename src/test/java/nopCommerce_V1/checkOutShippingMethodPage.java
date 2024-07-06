package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class checkOutShippingMethodPage {
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    public static WebDriver driver;
    By continue2Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button");
    public checkOutShippingMethodPage(WebDriver driver){
        this.driver = driver;
    }

    public checkOutPaymentMethodPage clickContinue2AndReturnCheckOutPaymentMethodPage() throws InterruptedException {
        driver.findElement(continue2Btn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new checkOutPaymentMethodPage(driver);
    }

}
