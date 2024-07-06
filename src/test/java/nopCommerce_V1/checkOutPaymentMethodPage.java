package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class checkOutPaymentMethodPage {
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    public static WebDriver driver;
    By continue3Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button");

    public checkOutPaymentMethodPage(WebDriver driver){
        this.driver = driver;
    }

    public checkOutPaymentInfoPage clickContinue3AndReturnPaymentInfoPage() throws InterruptedException {
        driver.findElement(continue3Btn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new checkOutPaymentInfoPage(driver);

    }
}
