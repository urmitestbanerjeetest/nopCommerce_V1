package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class checkOutPaymentInfoPage {
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    public static WebDriver driver;
    By continue4Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button");
    public checkOutPaymentInfoPage( WebDriver driver){
        this.driver = driver;
    }

    public checkOutConfirmOrderPage clickContinue4AndReturnCheckOutConfirmOrderPage(){
        driver.findElement(continue4Btn).click();
        return new checkOutConfirmOrderPage(driver);
    }
}
